package za.co.gdgcapetown.safelyhome.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import za.co.gdgcapetown.safelyhome.R;

/**
 * Created by maia on 2014/04/26.
 */
public class PersonalDetailFragment extends Fragment {

    /**
     * Create a new instance of DetailsFragment, initialized to
     * show the text at 'index'.
     */
    public static PersonalDetailFragment newInstance() {
        PersonalDetailFragment f = new PersonalDetailFragment();

        // Supply index input as an argument.
        Bundle args = new Bundle();
//        args.putInt("index", index);
        f.setArguments(args);

        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_personal,
            container, false);
        return view;
    }
}
