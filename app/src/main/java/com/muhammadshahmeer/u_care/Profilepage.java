package com.muhammadshahmeer.u_care;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.util.Calendar;

public class Profilepage extends AppCompatActivity {
    ImageView todo,main;
    TextView username,logout;
    String id,NAME;
    ImageView dp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profilepage);
        Intent intent = getIntent();
        logout = findViewById(R.id.logout);
        todo = findViewById(R.id.todo);
        main = findViewById(R.id.main);
        id = intent.getStringExtra("id");
        NAME = intent.getStringExtra("name");
        dp = findViewById(R.id.dp);
        username =(TextView) findViewById(R.id.username);
        username.setText(NAME);

        todo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent intent = new Intent(Profilepage.this, TodoList.class);
                startActivity(intent);
                finish();
            }
        });

        main.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent intent = new Intent(Profilepage.this, Mainpage.class);
                startActivity(intent);
                finish();
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Profilepage.this,Login.class);
                startActivity(intent);
            }
        });

        dp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent,20);
            }
        });




    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 20 && resultCode == RESULT_OK) ;
        {
            Calendar calendar= Calendar.getInstance();
            Uri image = data.getData();
//            dp.setImageURI(image);
            FirebaseStorage storage = FirebaseStorage.getInstance();
            StorageReference ref = storage.getReference().child("Users").child(id).child("dp/"+ calendar.getTimeInMillis() + ".jpg");
//            database.getReference().child("Users").child(id).setValue(user);
            ref.putFile(image)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>()
                    {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot)
                        {
                            Task<Uri> task=taskSnapshot.getStorage().getDownloadUrl();
                            task.addOnSuccessListener(new OnSuccessListener<Uri>()
                            {
                                @Override
                                public void onSuccess(Uri uri)
                                {
//                                        tv.setText(uri.toString());
                                    Picasso.get().load(uri.toString()).into(dp);
//                            Picasso.get().load().
//                            Log.d("imageurl",uri.toString());
                                }
                            });
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(Profilepage.this, "", Toast.LENGTH_SHORT).show();
                        }
                    });
        }
    }

}