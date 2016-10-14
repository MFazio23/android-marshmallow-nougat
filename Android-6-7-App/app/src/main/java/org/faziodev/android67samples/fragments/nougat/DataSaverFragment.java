package org.faziodev.android67samples.fragments.nougat;


import android.annotation.TargetApi;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.faziodev.android67samples.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DataSaverFragment extends Fragment {

    private ConnectivityManager connMan;
    private View view;

    public DataSaverFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        this.connMan = (ConnectivityManager) this.getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        this.view = inflater.inflate(R.layout.fragment_data_saver, container, false);

        final Button refreshButton = (Button) this.view.findViewById(R.id.refresh_statuses);
        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                refreshStatuses();
            }
        });

        this.refreshStatuses();

        return view;
    }

    @TargetApi(Build.VERSION_CODES.N)
    private void refreshStatuses() {
        final TextView meteredConnectionView = (TextView) view.findViewById(R.id.metered_connection_status);
        meteredConnectionView.setText(connMan.isActiveNetworkMetered() ? "Connection is METERED." : "Connection is NOT METERED.");

        final TextView restrictBackgroundStatusView = (TextView) view.findViewById(R.id.restrict_background_status);
        String dataSaverStatus = "";

        switch(connMan.getRestrictBackgroundStatus()) {
            case ConnectivityManager.RESTRICT_BACKGROUND_STATUS_DISABLED:
                dataSaverStatus = "enabled";
                break;
            case ConnectivityManager.RESTRICT_BACKGROUND_STATUS_ENABLED:
                dataSaverStatus = "disabled";
                break;
            case ConnectivityManager.RESTRICT_BACKGROUND_STATUS_WHITELISTED:
                dataSaverStatus = "disabled, but the current app is whitelisted.";
                break;
        }
        restrictBackgroundStatusView.setText(this.getString(R.string.data_saver_status, dataSaverStatus));
    }

}
