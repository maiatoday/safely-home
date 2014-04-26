package za.co.gdgcapetown.safelyhome;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import za.co.gdgcapetown.safelyhome.ui.PersonalDetailFragment;


public class MainActivity extends ActionBarActivity  implements PersonalDetailFragment.OnDetailsComplete{

    private static final String TAG = MainActivity.class.toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            // TODO switch to the personal details fragment
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDetailsOk() {
        Log.d(TAG, "The fragment pressed ok");
        // TODO switch to the incident fragment
    }
}
