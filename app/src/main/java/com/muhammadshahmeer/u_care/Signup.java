package com.muhammadshahmeer.u_care;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Signup extends AppCompatActivity {

    ImageView male,female,others;
    Button btnSignup;
    TextView signin, sh;
    EditText password, name,email;
    FirebaseAuth mAuth;
    FirebaseDatabase database;
    ProgressDialog progressDialog;
    CheckBox box;
    String gender ="";
    int click = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        btnSignup = findViewById(R.id.signup);
        signin = findViewById(R.id.signin);
        password = findViewById(R.id.password);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        box = findViewById(R.id.box);
        sh = findViewById(R.id.sh);

        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        progressDialog = new ProgressDialog(Signup.this);
        progressDialog.setTitle("Creating Account");
        progressDialog.setMessage("Creating your Account");

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (
                        name.getText().toString().length() < 5 ||
                                email.getText().toString().length() < 5 ||
                                password.getText().toString().length() < 5
                ) {
                    Toast.makeText(Signup.this, "Invalid Input!!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (box.isChecked())
                {
                    progressDialog.show();
                    mAuth.createUserWithEmailAndPassword(
                            email.getText().toString(),
                            password.getText().toString()

                    ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            progressDialog.dismiss();

                            if (task.isSuccessful()) {
                                Users user = new Users(
                                        name.getText().toString(),
                                        email.getText().toString(),
                                        password.getText().toString()

                                );
                                String id = task.getResult().getUser().getUid();
                                String n = name.getText().toString();
//                                String id = email.getText().toString();
//                                Toast.makeText(Activity2.this,  id, Toast.LENGTH_SHORT).show();
                                database.getReference().child("Users").child(id).setValue(user);

                                Toast.makeText(Signup.this, "User Created Succesfully", Toast.LENGTH_SHORT).show();
//                                Toast.makeText(Activity2.this, id, Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(Signup.this, Profilepage.class);
                                intent.putExtra("id", id);
                                intent.putExtra("name", n);
                                startActivity(intent);
                            } else
                                Toast.makeText(Signup.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });

                }
                else
                {
                    Toast.makeText(Signup.this, "Please agree with check condition to continue!!", Toast.LENGTH_SHORT).show();
                }
            }

        });



        sh.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                if(click%2 == 0){
                    password.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    sh.setText("Hide");
                    click++;
                }
                else{
                    password.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    sh.setText("Show");
                    click++;
                }
            }
        });



        signin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent intent = new Intent(Signup.this, Login.class);
                startActivity(intent);
            }
        });

        if(mAuth.getCurrentUser() != null){
            startActivity(new Intent(Signup.this, Profilepage.class));
        }
//

    }
}