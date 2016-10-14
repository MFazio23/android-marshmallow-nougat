package org.faziodev.android67samples.fragments.nougat;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.faziodev.android67samples.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuickSettingsTileFragment extends Fragment {


    public QuickSettingsTileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quick_settings_tile, container, false);
    }

}
