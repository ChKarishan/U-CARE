package com.muhammadshahmeer.u_care;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TodoList extends AppCompatActivity {
    ImageView profile,exercise;
    RecyclerView rv;
    MyAdapter adapter;
    ImageView add;
    EditText etSearch;
    List<MyModel> lss;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list);
        profile = findViewById(R.id.profile);
        exercise = findViewById(R.id.exercise);
        rv=findViewById(R.id.rv);
        add=findViewById(R.id.add);
        etSearch = findViewById(R.id.etSearch);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(TodoList.this,Add.class);
                startActivity(intent);
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent intent = new Intent(TodoList.this,Profilepage.class);
                startActivity(intent);
                finish();
            }
        });

        exercise.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent intent = new Intent(TodoList.this,Mainpage.class);
                startActivity(intent);
                finish();
            }
        });

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



    }







    @Override
    protected void onResume() {
        super.onResume();
        adapter=new MyAdapter(getData(),TodoList.this);
        RecyclerView.LayoutManager lm=new LinearLayoutManager(TodoList.this);
        rv.setLayoutManager(lm);
        rv.setAdapter(adapter);
    }

    @SuppressLint("Range")
    public List<MyModel> getData(){
         lss=new ArrayList<>();
        MyDBHelper helper=new MyDBHelper(TodoList.this);
        SQLiteDatabase db=helper.getReadableDatabase();
        String[] cols={MyTasks.MyTask._ID,
                MyTasks.MyTask._EXE};
        Cursor c=db.query(
                MyTasks.MyTask.TABLE_NAME,
                cols,
                null,
                null,
                null,
                null,
                MyTasks.MyTask._EXE+" ASC"
        );
        while (c.moveToNext())
        {
            lss.add(
                    new MyModel(
                            c.getString(c.getColumnIndex(MyTasks.MyTask._EXE))
                    )
            );
        }
        db.close();
        helper.close();
        return lss;

    }

    private void filter(String text) {
        ArrayList<MyModel> filteredList = new ArrayList<>();
        for(MyModel item : lss){
            if(item.getExe().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(item);
            }
        }
        adapter.filterList(filteredList);
    }
}