package org.faziodev.android67samples.fragments.nougat;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.TextViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import org.faziodev.android67samples.R;

public class NotificationsFragment extends Fragment {

    public NotificationsFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_notifications, container, false);

        final TextView textView = (TextView) view.findViewById(R.id.test_text_view);

        //TODO: Add something, please.
        textView.setText("This has been changed.");


        return view;

    }
}
