package za.co.gdgcapetown.safelyhome.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import za.co.gdgcapetown.safelyhome.R;

/**
 * Created by maia on 2014/04/26.
 */
public class PersonalDetailFragment extends Fragment {

    private OnDetailsComplete activityCallback;

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
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            activityCallback = (OnDetailsComplete) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnDetailsComplete");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_personal,
            container, false);
        Button ok = (Button) view.findViewById(R.id.button_detail_ok);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (detailsValid()) {
                    activityCallback.onDetailsOk();
                }
            }
        });
        return view;
    }

    private boolean detailsValid() {
        return true;
    }

    public interface OnDetailsComplete {
        void onDetailsOk();
    }
}
