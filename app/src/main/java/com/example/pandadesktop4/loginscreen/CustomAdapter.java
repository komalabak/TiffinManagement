package com.example.pandadesktop4.loginscreen;

import android.content.Context;

import java.util.ArrayList;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
/**
 * Created by pandadesktop4 on 24/7/17.
 */
public class CustomAdapter extends  ArrayAdapter {


    private ArrayList dataSet;
    Context mContext;


    private static class ViewHolder {
        TextView txtname;
        CheckBox checkBox;

    }
    public CustomAdapter(ArrayList data, Context context) {
        super(context,R.layout.row_item1,data);

        this.dataSet=data;
        this.mContext=context;

    }
    @Override

    public int getCount()
    {
        return dataSet.size();
    }

    @Override
    public DataModel getItem(int position)
    {
        return (DataModel) dataSet.get(position);
    }


    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        ViewHolder viewHolder;
        final View result;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item1, parent, false);
            viewHolder.txtname = (TextView) convertView.findViewById(R.id.txtname);
            viewHolder.checkBox = (CheckBox) convertView.findViewById(R.id.checkBox);

            result=convertView;
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        DataModel item = getItem(position);


        viewHolder.txtname.setText(item.date);
        viewHolder.checkBox.setChecked(item.checked);


        return result;
    }
}
