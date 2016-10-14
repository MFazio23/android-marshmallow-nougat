package org.faziodev.android67samples.fragments.nougat;


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
public class MultiWindowFragment extends Fragment {


    public MultiWindowFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_multi_window, container, false);

        final TextView description = (TextView) view.findViewById(R.id.multi_window_description);
        description.setText(Html.fromHtml(this.getString(R.string.multi_window_description)));

        return view;
    }

}
