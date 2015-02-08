package co.mobilemakers.todo;

 import android.support.v7.app.ActionBarActivity;

import android.os.Bundle;
import android.util.Log;

import android.view.Menu;
import android.view.MenuItem;



public class   MainActivity extends ActionBarActivity {
   public final static String TAG_LIST="listTask";
   public final static String LOG_TAG=MainActivity.class.getSimpleName();
    ListTasksFragment listTasksFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            listTasksFragment = new ListTasksFragment();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, listTasksFragment)
                .commit();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
