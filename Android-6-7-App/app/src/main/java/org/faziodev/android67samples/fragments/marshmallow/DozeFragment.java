package org.faziodev.android67samples.fragments.marshmallow;


import android.app.Fragment;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.faziodev.android67samples.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DozeFragment extends Fragment {


    public DozeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_doze, container, false);

        final TextView description = (TextView) view.findViewById(R.id.doze_description);
        description.setText(Html.fromHtml(this.getString(R.string.testing_doze_app_standby)));

        return view;
    }

}
