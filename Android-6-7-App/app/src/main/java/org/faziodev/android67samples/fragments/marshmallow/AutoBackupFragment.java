package org.faziodev.android67samples.fragments.marshmallow;


import android.os.Bundle;
import android.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.faziodev.android67samples.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AutoBackupFragment extends Fragment {


    public AutoBackupFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_auto_backup, container, false);

        final TextView description = (TextView) view.findViewById(R.id.auto_backup_description);
        description.setText(Html.fromHtml(this.getString(R.string.auto_backup_info)));

        return view;
    }

}
