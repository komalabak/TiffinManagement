package com.example.pandadesktop4.loginscreen.screen;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pandadesktop4.loginscreen.R;
import com.example.pandadesktop4.loginscreen.repo.PreferenceAPI;
import com.example.pandadesktop4.loginscreen.repo.RestClient;
import com.example.pandadesktop4.loginscreen.ro.EmptyResponse;
import com.example.pandadesktop4.loginscreen.ro.LoginResponse;
import com.example.pandadesktop4.loginscreen.ro.PreferenceRequest;
import com.example.pandadesktop4.loginscreen.vo.Preference;
import com.google.android.gms.common.api.Result;

import java.text.SimpleDateFormat;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

import static com.example.pandadesktop4.loginscreen.R.id.checkBox;
import static com.example.pandadesktop4.loginscreen.R.id.txtname;

/**
 * Created by pandadesktop4 on 24/7/17.
 */
public class CustomAdapter extends ArrayAdapter {


    Context context;
    private List dataSet;


    public CustomAdapter(List data, Context context) {
        super(context, R.layout.row_item, data);

        this.dataSet = data;
        this.context = context;

    }

    @Override

    public int getCount() {
        return dataSet.size();
    }

    @Override
    public Preference getItem(int position) {
        return (Preference) dataSet.get(position);
    }

    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        ViewHolder viewHolder;
        final View result;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);
            viewHolder.txtname = (TextView) convertView.findViewById(txtname);
            viewHolder.checkBox = (CheckBox) convertView.findViewById(checkBox);
            final TextView textNameListView = (TextView) convertView.findViewById(txtname);
            final CheckBox checkBoxListView = (CheckBox) convertView.findViewById(checkBox);


            viewHolder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {


                    PreferenceAPI preferenceAPI = RestClient.getAuthenticationRestAdapter().create(PreferenceAPI.class);

                    preferenceAPI.saveTiffinPreference(new PreferenceRequest(textNameListView.getText().toString(), checkBoxListView.isChecked()), new Callback<EmptyResponse>() {

                        @Override
                        public void success(EmptyResponse loginResponse, Response response) {
                            Toast.makeText(getContext(), "Sending....", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void failure(RetrofitError error) {
                            Log.e("error", error.toString());
                           // Toast.makeText(getContext(), "Something is wrong.", Toast.LENGTH_SHORT).show();
                        }
                    });


                }
            });
            result = convertView;
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        Preference item = getItem(position);


        viewHolder.txtname.setText(new SimpleDateFormat("dd MMM yyyy,  EEE").format(item.date));
        viewHolder.checkBox.setChecked(item.lunch);


        return result;
    }

    private static class ViewHolder {
        TextView txtname;
        CheckBox checkBox;


    }
}
