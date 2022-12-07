package com.muhammadshahmeer.u_care;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Mainpage extends AppCompatActivity {
    ImageView profile,todo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);

        profile = findViewById(R.id.profile);
        todo = findViewById(R.id.todo);

        profile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent intent = new Intent(Mainpage.this,Profilepage.class);
                startActivity(intent);
                finish();


            }
        });
        todo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent intent = new Intent(Mainpage.this,TodoList.class);
                startActivity(intent);
                finish();


            }
        });
    }

}