package com.example.popie.lab4_task1_gson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.popie.lab4_task1_gson.Model.Person;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Person> person;
    PersonCustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ListView

        listView = (ListView) findViewById(R.id.listView);

        //DataSource
        person = new ArrayList<>();
        person.add(new Person(1, "Umer", "24", "Male", "03451522997"));
        person.add(new Person(2, "Badar", "25", "Male", "03004760818"));
        person.add(new Person(3, "Omair", "36", "Male", "03224540447"));
        person.add(new Person(4, "Nazim", "29", "Male", "+16472811673"));
        person.add(new Person(5, "Faisal", "25", "Male", "03347979465"));

        for (int i = 6; i <= 1000; i++) {
            person.add(new Person(i, "Name", "Age", "Male", "xxxxxxxxxxx"));
        }

        //Adapter

        adapter = new PersonCustomAdapter(this, person);
        listView.setAdapter(adapter);
    }
}
