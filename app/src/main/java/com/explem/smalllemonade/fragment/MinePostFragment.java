package com.explem.smalllemonade.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.explem.smalllemonade.R;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

/**
 * Created by ${薛亚南}
 * on 2016/12/29 18：18.
 */

public class MinePostFragment extends Fragment {

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.minepost_fragment, null);
        return view;
    }
}
