package za.co.gdgcapetown.safelyhome.ui;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import za.co.gdgcapetown.safelyhome.R;

/**
 * Created by maia on 2014/04/26.
 */
public class PersonalDetailFragment extends Fragment {

    public static final String KEY_NAME = "key_name";
    public static final String KEY_EMAIL = "key_email";
    private OnDetailsComplete activityCallback;
    private EditText name;
    private EditText email;
    private CheckBox checkbox;

    public static final String PREFS_NAME = "SafeHomePrefs";

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
                    saveDetails();
                    activityCallback.onDetailsOk();
                }
            }
        });
        name = (EditText) view.findViewById(R.id.edit_name);
        email = (EditText) view.findViewById(R.id.edit_email);
        checkbox = (CheckBox) view.findViewById(R.id.agree_checkBox);
        // Restore preferences
        SharedPreferences settings = getActivity().getSharedPreferences(PREFS_NAME, 0);
        String namePref = settings.getString(KEY_NAME, "");
        String emailPref = settings.getString(KEY_EMAIL, "");
        name.setText(namePref);
        email.setText(emailPref);
        return view;
    }

    private void saveDetails() {
        SharedPreferences settings = getActivity().getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(KEY_NAME, name.getText().toString());
        editor.putString(KEY_EMAIL, email.getText().toString());
        // Commit the edits!
        editor.commit();
    }

    private boolean detailsValid() {
        boolean retFlag = true;
        String nameString = name.getText().toString();
        String emailString = email.getText().toString();
        if (TextUtils.isEmpty(nameString)) {
            name.setError(getString(R.string.name_error));
            retFlag = false;
        } else {
            name.setError(null);
        }
        if (TextUtils.isEmpty(emailString)) {
            email.setError(getString(R.string.email_error));
            retFlag = false;
        } else {
            email.setError(null);
        }
        if (!checkbox.isChecked()) {
            retFlag = false;
        }
        return retFlag;
    }

    public interface OnDetailsComplete {
        void onDetailsOk();
    }
}
