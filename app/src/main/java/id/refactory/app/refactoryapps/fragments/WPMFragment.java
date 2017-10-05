package id.refactory.app.refactoryapps.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.refactory.app.refactoryapps.R;

/**
 * Created by prana on 04/10/17.
 */

public class WPMFragment extends Fragment {
    public WPMFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_wpm, container, false);
    }

    public interface OnFragmentInteractionListener {
    }
}
