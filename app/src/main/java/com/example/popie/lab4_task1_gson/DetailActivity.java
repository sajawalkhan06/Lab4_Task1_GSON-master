package com.example.popie.lab4_task1_gson;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.popie.lab4_task1_gson.Model.Person;
import com.google.gson.Gson;

public class DetailActivity extends AppCompatActivity {

    TextView tvId, tvName, tvAge, tvGender, tvPhone;
    Button btnCall;
    Person p;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        final String json = intent.getStringExtra("person");

        Gson gson = new Gson();
        p = gson.fromJson(json, Person.class);


        tvId = (TextView) findViewById(R.id.id);
        tvName = (TextView) findViewById(R.id.name);
        tvAge = (TextView) findViewById(R.id.age);
        tvGender = (TextView) findViewById(R.id.gender);
        tvPhone = (TextView) findViewById(R.id.phone);


        tvId.setText(p.getId() + "");
        tvName.setText(p.getName());
        tvAge.setText(p.getAge());
        tvGender.setText(p.getGender());
        tvPhone.setText(p.getPhone());

        btnCall = (Button) findViewById(R.id.call);
        btnCall.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Intent.ACTION_DIAL);
                        intent.setData(Uri.parse("tel: " + tvPhone.getText().toString()));
                        startActivity(intent);

                    }
                }
    
        );

    }
}
