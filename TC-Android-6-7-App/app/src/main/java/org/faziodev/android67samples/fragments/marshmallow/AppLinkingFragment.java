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
public class AppLinkingFragment extends Fragment {


    public AppLinkingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_app_linking, container, false);

        final TextView description = (TextView) view.findViewById(R.id.app_linking_description);
        description.setText(Html.fromHtml(this.getString(R.string.app_linking_info)));

        return view;
    }

}
