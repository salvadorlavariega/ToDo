package co.mobilemakers.todo;


import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;


/**
 * Created by salvador on 07/02/15.
 */
public class CreateTaskActivity extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_task_activity);
        CreateTaskFragment createTaskFragment = new CreateTaskFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.container_task, createTaskFragment).commit();

    }



}
