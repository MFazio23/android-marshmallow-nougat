package org.faziodev.android67samples.fragments.marshmallow;

import android.Manifest;
import android.app.Fragment;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.CallLog;
import android.provider.ContactsContract;
import android.provider.Telephony;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TabHost;

import org.faziodev.android67samples.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PermissionsFragment extends Fragment {

    public static final int MY_PERMISSIONS_REQUEST_READ_CALL_LOG = 2301;
    public static final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 2302;
    public static final int MY_PERMISSIONS_REQUEST_READ_SMS_MESSAGES = 2303;

    private ArrayAdapter<String> callLogAdapter;
    private ArrayAdapter<String> contactsAdapter;
    private ArrayAdapter<String> smsMessagesAdapter;

    public PermissionsFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_permissions, container, false);

        final TabHost tabHost = (TabHost) view.findViewById(R.id.permissions_tab_host);
        tabHost.setup();

        TabHost.TabSpec spec = tabHost.newTabSpec("Call Log");
        spec.setContent(R.id.call_log);
        spec.setIndicator("Call Log");
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("Contacts");
        spec.setContent(R.id.contacts);
        spec.setIndicator("Contacts");
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("SMS Messages");
        spec.setContent(R.id.sms);
        spec.setIndicator("SMS Messages");
        tabHost.addTab(spec);

        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {
                switch (s) {
                    case "Call Log":
                        getCallLog();
                        break;
                    case "Contacts":
                        getListOfContacts();
                        break;
                    case "SMS Messages":
                        getSMSMessages();
                        break;
                }
            }
        });

        this.callLogAdapter = new ArrayAdapter<>(
            this.getContext(),
            android.R.layout.simple_list_item_1,
            new ArrayList<String>()
        );

        final ListView callLogList = (ListView) view.findViewById(R.id.call_log_list);
        callLogList.setAdapter(this.callLogAdapter);

        this.contactsAdapter = new ArrayAdapter<>(
            this.getContext(),
            android.R.layout.simple_list_item_1,
            new ArrayList<String>()
        );

        final ListView contactList = (ListView) view.findViewById(R.id.contacts_list);
        contactList.setAdapter(this.contactsAdapter);

        this.smsMessagesAdapter = new ArrayAdapter<>(
            this.getContext(),
            android.R.layout.simple_list_item_1,
            new ArrayList<String>()
        );

        final ListView smsMessagesList = (ListView) view.findViewById(R.id.sms_list);
        smsMessagesList.setAdapter(this.smsMessagesAdapter);

        //Load the first tab.
        this.getCallLog();

        return view;
    }

    private void getCallLog() {
        final int callLogPerm = ContextCompat.checkSelfPermission(this.getContext(), Manifest.permission.READ_CALL_LOG);

        if (callLogPerm == PackageManager.PERMISSION_GRANTED) {
            this.updateCallLogList();
        } else {
            //Permission has not yet been granted, so we should ask.
            this.requestPermissions(
                new String[]{Manifest.permission.READ_CALL_LOG},
                MY_PERMISSIONS_REQUEST_READ_CALL_LOG);
        }
    }

    private void getListOfContacts() {
        final int contactPerm = ContextCompat.checkSelfPermission(this.getContext(), Manifest.permission.READ_CONTACTS);

        if (contactPerm == PackageManager.PERMISSION_GRANTED) {
            this.updateContactsList();
        } else {
            //Permission has not yet been granted, so we should ask.
            this.requestPermissions(
                new String[]{Manifest.permission.READ_CONTACTS},
                MY_PERMISSIONS_REQUEST_READ_CONTACTS);
        }
    }

    private void getSMSMessages() {

        final int smsPerm = ContextCompat.checkSelfPermission(this.getContext(), Manifest.permission.READ_SMS);

        if (smsPerm == PackageManager.PERMISSION_GRANTED) {
            this.updateSmsList();
        } else {
            //Permission has not yet been granted, so we should ask.
            this.requestPermissions(
                new String[]{Manifest.permission.READ_SMS},
                MY_PERMISSIONS_REQUEST_READ_SMS_MESSAGES);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_READ_CALL_LOG:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    this.updateCallLogList();
                } else {
                    this.markAdapterAsPermissionDenied(this.callLogAdapter);
                }
                break;
            case MY_PERMISSIONS_REQUEST_READ_CONTACTS:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    this.updateContactsList();
                } else {
                    this.markAdapterAsPermissionDenied(this.contactsAdapter);
                }
                break;
            case MY_PERMISSIONS_REQUEST_READ_SMS_MESSAGES:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    this.updateSmsList();
                } else {
                    this.markAdapterAsPermissionDenied(this.smsMessagesAdapter);
                }
                break;
        }
    }

    private void updateCallLogList() {
        final List<String> calls = new ArrayList<>();

        try {
            final Cursor cursor = this.getActivity().getContentResolver().query(
                CallLog.Calls.CONTENT_URI,
                null,
                null,
                null,
                null
            );

            if (cursor != null) {
                cursor.moveToFirst();

                while (!cursor.isAfterLast()) {
                    final int numberIndex = cursor.getColumnIndex(CallLog.Calls.NUMBER);
                    final int dateIndex = cursor.getColumnIndex(CallLog.Calls.DATE);

                    final Date date = new Date(cursor.getLong(dateIndex));

                    calls.add("Call from " + cursor.getString(numberIndex) + " at " + date);
                    cursor.moveToNext();
                }

                cursor.close();
            }

            this.updateAdapter(this.callLogAdapter, calls);
        } catch(SecurityException e) {
            this.markAdapterAsPermissionDenied(this.callLogAdapter);
        }
    }

    private void updateContactsList() {

        final List<String> names = new ArrayList<>();

        final Cursor cursor = this.getActivity().getContentResolver().query(
            ContactsContract.Contacts.CONTENT_URI,
            new String[]{ContactsContract.Contacts._ID, ContactsContract.Contacts.LOOKUP_KEY, ContactsContract.Contacts.DISPLAY_NAME_PRIMARY},
            ContactsContract.Contacts.DISPLAY_NAME_PRIMARY + " IS NOT NULL",
            null,
            null
        );

        if (cursor != null) {
            cursor.moveToFirst();

            while (!cursor.isAfterLast()) {
                final int nameIndex = cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME_PRIMARY);

                names.add(cursor.getString(nameIndex));
                cursor.moveToNext();
            }

            cursor.close();
        }

        this.updateAdapter(this.contactsAdapter, names);
    }

    private void updateSmsList() {

        final List<String> messages = new ArrayList<>();

        final Cursor cursor = this.getActivity().getContentResolver().query(
            Telephony.Sms.CONTENT_URI,
            null,
            null,
            null,
            null
        );

        if (cursor != null) {
            cursor.moveToFirst();

            while (!cursor.isAfterLast()) {
                final int addressIndex = cursor.getColumnIndex(Telephony.Sms.ADDRESS);
                final int bodyIndex = cursor.getColumnIndex(Telephony.Sms.BODY);

                messages.add(cursor.getString(bodyIndex) + "(" + cursor.getString(addressIndex) + ")");
                cursor.moveToNext();
            }

            cursor.close();
        }

        this.updateAdapter(this.smsMessagesAdapter, messages);
    }

    private void updateAdapter(final ArrayAdapter<String> adapter, final List<String> data) {
        adapter.clear();

        adapter.addAll(data);

        adapter.notifyDataSetChanged();
    }

    private void markAdapterAsPermissionDenied(final ArrayAdapter<String> adapter) {
        adapter.add("Permission has been denied");
    }
}
