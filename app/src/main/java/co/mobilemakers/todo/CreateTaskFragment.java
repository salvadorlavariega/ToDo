package co.mobilemakers.todo;


import android.content.Intent;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CreateTaskFragment extends Fragment {

    public static final String KEY_TASK = "key_task";
    EditText editTextTask;
    Button buttonAddTask;

    public CreateTaskFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.task_fragment,container,false);
        getTask(rootView);
        prepareButton(rootView);
        return rootView;
    }

    private void getTask(View rootView) {
        editTextTask = (EditText)rootView.findViewById(R.id.edit_text_new_task);
    }

    private void prepareButton(View rootView) {
        buttonAddTask = (Button)rootView.findViewById(R.id.button_add_task);
        buttonAddTask.setOnClickListener(new View.OnClickListener(){
              @Override
               public void onClick(View v) {

                  ListTasksFragment listTasksFragment = new ListTasksFragment();
                  Bundle bundle = new Bundle();
                  bundle.putString(KEY_TASK,editTextTask.getText().toString().trim() );
                  listTasksFragment.setArguments(bundle);
                  Log.i("CreateTaskActivity", "Antes del clic" );
                  getActivity().
                  getSupportFragmentManager().beginTransaction()
                          .replace(R.id.container,listTasksFragment)
                          .commit();
               }
           }

        );
    }


}
