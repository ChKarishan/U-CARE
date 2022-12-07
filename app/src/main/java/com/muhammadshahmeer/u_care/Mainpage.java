package com.muhammadshahmeer.u_care;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;

public class Mainpage extends AppCompatActivity implements SelectListner {
    ImageView profile, todo;
    RecyclerView recyclerView;
    EditText etSearch;
    ArrayList<Day_Model> list = new ArrayList<>();
    Day_Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);

        profile = findViewById(R.id.profile);
        todo = findViewById(R.id.todo);
        recyclerView = findViewById(R.id.recyclerview);
        etSearch = findViewById(R.id.etSearch);


        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                filter(editable.toString());
            }
        });



        list.add(new Day_Model("Day 1"));
        list.add(new Day_Model("Day 2"));
        list.add(new Day_Model("Day 3"));
        list.add(new Day_Model("Day 4"));
        list.add(new Day_Model("Day 5"));
        list.add(new Day_Model("Day 6"));
        list.add(new Day_Model("Day 7"));
        list.add(new Day_Model("Day 8"));
        list.add(new Day_Model("Day 9"));
        list.add(new Day_Model("Day 10"));
        list.add(new Day_Model("Day 11"));
        list.add(new Day_Model("Day 12"));
        list.add(new Day_Model("Day 13"));
        list.add(new Day_Model("Day 14"));
        list.add(new Day_Model("Day 15"));
        list.add(new Day_Model("Day 16"));
        list.add(new Day_Model("Day 17"));
        list.add(new Day_Model("Day 18"));
        list.add(new Day_Model("Day 19"));
        list.add(new Day_Model("Day 20"));
        list.add(new Day_Model("Day 21"));
        list.add(new Day_Model("Day 22"));
        list.add(new Day_Model("Day 23"));
        list.add(new Day_Model("Day 24"));
        list.add(new Day_Model("Day 25"));
        list.add(new Day_Model("Day 26"));
        list.add(new Day_Model("Day 27"));
        list.add(new Day_Model("Day 28"));
        list.add(new Day_Model("Day 29"));
        list.add(new Day_Model("Day 30"));


        adapter = new Day_Adapter(list, this, this);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        profile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(Mainpage.this, Profilepage.class);
                startActivity(intent);
                finish();


            }
        });
        todo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(Mainpage.this, TodoList.class);
                startActivity(intent);
                finish();


            }
        });
    }

    @Override
    public void onItemClicked(Day_Model Model) {
        String txt = Model.getText();
        if (txt == "Day 1") {
            Intent i = new Intent(Mainpage.this, Chest_Day.class);
            startActivity(i);
        }
        if (txt == "Day 2") {
            Intent i = new Intent(Mainpage.this, Arms_Day.class);
            startActivity(i);
        }
        if (txt == "Day 3") {
            Intent i = new Intent(Mainpage.this, Back_and_Abs_Day.class);
            startActivity(i);
        }
        if (txt == "Day 4") {
            Intent i = new Intent(Mainpage.this, Leg_day.class);
            startActivity(i);
        }
        if (txt == "Day 5") {
            Intent i = new Intent(Mainpage.this, Shoulder_Day.class);
            startActivity(i);
        }
        if (txt == "Day 6") {
            Intent i = new Intent(Mainpage.this, Rest_Day.class);
            startActivity(i);
        }
        if (txt == "Day 7") {
            Intent i = new Intent(Mainpage.this, Chest_Day.class);
            startActivity(i);
        }
        if (txt == "Day 8") {
            Intent i = new Intent(Mainpage.this, Chest_Day.class);
            startActivity(i);
        }
        if (txt == "Day 9") {
            Intent i = new Intent(Mainpage.this, Arms_Day.class);
            startActivity(i);
        }
        if (txt == "Day 10") {
            Intent i = new Intent(Mainpage.this, Back_and_Abs_Day.class);
            startActivity(i);
        }
        if (txt == "Day 11") {
            Intent i = new Intent(Mainpage.this, Leg_day.class);
            startActivity(i);
        }
        if (txt == "Day 12") {
            Intent i = new Intent(Mainpage.this, Shoulder_Day.class);
            startActivity(i);
        }
        if (txt == "Day 13") {
            Intent i = new Intent(Mainpage.this, Rest_Day.class);
            startActivity(i);
        }
        if (txt == "Day 14") {
            Intent i = new Intent(Mainpage.this, Chest_Day.class);
            startActivity(i);
        }
        if (txt == "Day 15") {
            Intent i = new Intent(Mainpage.this, Chest_Day.class);
            startActivity(i);
        }
        if (txt == "Day 16") {
            Intent i = new Intent(Mainpage.this, Arms_Day.class);
            startActivity(i);
        }
        if (txt == "Day 17") {
            Intent i = new Intent(Mainpage.this, Back_and_Abs_Day.class);
            startActivity(i);
        }
        if (txt == "Day 18") {
            Intent i = new Intent(Mainpage.this, Leg_day.class);
            startActivity(i);
        }
        if (txt == "Day 19") {
            Intent i = new Intent(Mainpage.this, Shoulder_Day.class);
            startActivity(i);
        }
        if (txt == "Day 20") {
            Intent i = new Intent(Mainpage.this, Rest_Day.class);
            startActivity(i);
        }
        if (txt == "Day 21") {
            Intent i = new Intent(Mainpage.this, Chest_Day.class);
            startActivity(i);
        }
        if (txt == "Day 22") {
            Intent i = new Intent(Mainpage.this, Arms_Day.class);
            startActivity(i);
        }
        if (txt == "Day 23") {
            Intent i = new Intent(Mainpage.this, Back_and_Abs_Day.class);
            startActivity(i);
        }
        if (txt == "Day 24") {
            Intent i = new Intent(Mainpage.this, Leg_day.class);
            startActivity(i);
        }
        if (txt == "Day 25") {
            Intent i = new Intent(Mainpage.this, Shoulder_Day.class);
            startActivity(i);
        }
        if (txt == "Day 26") {
            Intent i = new Intent(Mainpage.this, Rest_Day.class);
            startActivity(i);
        }
        if (txt == "Day 27") {
            Intent i = new Intent(Mainpage.this, Chest_Day.class);
            startActivity(i);
        }
        if (txt == "Day 28") {
            Intent i = new Intent(Mainpage.this, Chest_Day.class);
            startActivity(i);
        }
        if (txt == "Day 29") {
            Intent i = new Intent(Mainpage.this, Arms_Day.class);
            startActivity(i);
        }
        if (txt == "Day 30") {
            Intent i = new Intent(Mainpage.this, Back_and_Abs_Day.class);
            startActivity(i);
        }


    }

    private void filter(String text) {
        ArrayList<Day_Model> filteredList = new ArrayList<>();
        for(Day_Model item : list){
            if(item.getText().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(item);
            }
        }
        adapter.filterList(filteredList);
    }
}