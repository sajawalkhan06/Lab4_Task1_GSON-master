package com.example.popie.lab4_task1_gson;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.popie.lab4_task1_gson.Model.Person;
import com.google.gson.Gson;

import java.util.ArrayList;

/**
 * Created by popie on 10/10/2017.
 */

public class PersonCustomAdapter extends BaseAdapter {

    Context context;
    ArrayList<Person> persons;

    public PersonCustomAdapter(Context context, ArrayList<Person> persons) {
        this.context = context;
        this.persons = persons;
    }


    @Override
    public int getCount() {                    //returns total number of items to be diplayed in a list
        return persons.size();
    }

    @Override
    public Object getItem(int i) {            //returns the data item associated with the specific position
        return getItemId(i);
    }

    @Override
    public long getItemId(int i) {            //returns the item position to the adapter
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        final Person p = persons.get(i);

        View rootView = view;

        ViewHolder holder;

        if (rootView == null) {
            rootView = LayoutInflater.from(context).inflate(R.layout.list_view_persons, null);

            holder = new ViewHolder();

            holder.tvName = rootView.findViewById(R.id.name);

            holder.btnDetail = rootView.findViewById(R.id.showdetail);
            holder.btnDetail.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            Gson gson = new Gson();
                            String json = gson.toJson(p);
                            Intent intent = new Intent(context, DetailActivity.class);
                            intent.putExtra("person", json);
                            context.startActivity(intent);
                        }
                    }
            );

            rootView.setTag(holder);

        } else {
            holder = (ViewHolder) rootView.getTag();
        }

        holder.tvName.setText(p.getName());

        return rootView;
    }

    class ViewHolder {

        TextView tvName;
        Button btnDetail;

    }
}
