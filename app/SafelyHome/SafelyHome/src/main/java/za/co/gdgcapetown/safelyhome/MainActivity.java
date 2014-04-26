package za.co.gdgcapetown.safelyhome;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import za.co.gdgcapetown.safelyhome.ui.IncidentFragment;
import za.co.gdgcapetown.safelyhome.ui.PersonalDetailFragment;


public class MainActivity extends ActionBarActivity  implements PersonalDetailFragment.OnDetailsComplete{

    private static final String TAG = MainActivity.class.toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (checkDetailsExist()) {
            switchToIncidentReport();
        } else {
            switchToPersonalDetails();
        }
    }

    private boolean checkDetailsExist() {
        SharedPreferences settings = getSharedPreferences(PersonalDetailFragment.PREFS_NAME, 0);
        String emailPref = settings.getString(PersonalDetailFragment.KEY_EMAIL, "");
        if (TextUtils.isEmpty(emailPref)) {
            return false;
        }
        return true;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specifyswitchToPersonalDetails a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            switchToPersonalDetails();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void switchToPersonalDetails() {
        Fragment fragment = PersonalDetailFragment.newInstance();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.contentFragment, fragment);
        transaction.commit();
    }

    @Override
    public void onDetailsOk() {
        Log.d(TAG, "The fragment pressed ok");
        switchToIncidentReport();
    }

    private void switchToIncidentReport() {
        Fragment fragment = IncidentFragment.newInstance();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.contentFragment, fragment);
        transaction.commit();
    }
}
