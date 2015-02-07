package co.mobilemakers.todo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by root on 6/02/15.
 */
public class SignalDataAdapter extends ArrayAdapter<SignalTaskData> {

    Context context;
    List<SignalTaskData> signaltaskData;
    public SignalDataAdapter(Context context,List<SignalTaskData> signaltaskData ){
        super(context, R.layout.templete_layout,signaltaskData);
        this.context=context;
        this.signaltaskData=signaltaskData;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView;
        if(convertView != null)
            rowView = convertView;
        else{
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.templete_layout,parent, false);
        }
        displayContentInRowiew(position,rowView);
        return  rowView;
    }

    private void displayContentInRowiew(int position, View rowView) {
        if(rowView != null){
            TextView textViewStar = (TextView)rowView.findViewById(R.id.text_view_list_task);
            textViewStar.setText(signaltaskData.get(position).getTarkName());

        }
    }
}
