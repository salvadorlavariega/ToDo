package co.mobilemakers.todo;


import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListTasksFragment extends ListFragment implements SwipeRefreshLayout.OnRefreshListener{


    private SignalDataAdapter adapter;
    SwipeRefreshLayout swipeRefreshLayout;


    public ListTasksFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        if(getArguments()!=null && getArguments().containsKey(CreateTaskFragment.KEY_TASK)){
           // addSignalData(getArguments().getString(CreateTaskFragment.KEY_TASK));
        }
        swipeRefreshLayout = (SwipeRefreshLayout)rootView.findViewById(R.id.swipe_container);
        swipeRefreshLayout.setOnRefreshListener(this);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        prepareListView();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_fragment_list, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int menuId = item.getItemId();
        Boolean handled = false;
        switch (menuId){
            case R.id.action_add:
              getActivity().getSupportFragmentManager().beginTransaction().replace(
                      R.id.container, new CreateTaskFragment()
              ).commit();
                handled=true;
                break;
        }
        if(!handled){
            handled= super.onOptionsItemSelected(item);
        }
        return handled;

    }

    private void addSignalData(String taskName) {
        Log.i("señales","agregando texto="+taskName);
        SignalTaskData signalData = new SignalTaskData();
        signalData.setTarkName(taskName);
        adapter.add(signalData);
    }


    @Override
    public void onRefresh() {
        swipeRefreshLayout.setRefreshing(true);
         addSignalData("Señal refresing");
        swipeRefreshLayout.setRefreshing(false);

    }


    private void prepareListView() {


        List<SignalTaskData> entries = new ArrayList<>();
        adapter = new SignalDataAdapter(getActivity(),  entries);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String task = parent.getItemAtPosition(position).toString();
                String message = String.format("The task is: %s ", task);
                Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
            }
        });
    }



}
