package com.muhammadshahmeer.u_care;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    Button button;
    TextView signup;
    TextView sh, forgetbtn;
    EditText password, name;
    int click = 0;

    FirebaseAuth mAuth;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        button = findViewById(R.id.login);
        signup = findViewById(R.id.signup);
        sh = findViewById(R.id.sh);
        password = findViewById(R.id.password);
        forgetbtn = findViewById(R.id.forgetBtn);
        name = findViewById(R.id.name);

        forgetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this,ForgetPassword.class);
                startActivity(intent);
            }
        });




        mAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(Login.this);
        progressDialog.setTitle("Logged In");
        progressDialog.setMessage("Logging in your Account");


//        forgetbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Login.this,ForgetPassword.class);
//                startActivity(intent);
//            }
//        });

//        button.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view){
//                Intent intent = new Intent(Login.this, Mainpage.class);
//                startActivity(intent);
//            }
//        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (
                        name.getText().toString().length() < 5 ||
                                password.getText().toString().length() < 5
                ) {
                    Toast.makeText(Login.this, "Invalid Input!!", Toast.LENGTH_SHORT).show();
                    return;
                }

                progressDialog.show();
                mAuth.signInWithEmailAndPassword(
                        name.getText().toString(),
                        password.getText().toString()
                ).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                           @Override
                                           public void onSuccess(AuthResult authResult) {
                                               String id = authResult.getUser().getUid();
                                               String name = authResult.getUser().getDisplayName();

                                               progressDialog.dismiss();
//                        Toast.makeText(Activity3.this, authResult.getUser().getUid(), Toast.LENGTH_SHORT).show();
                                               Toast.makeText(Login.this, "Logged in Successfully.", Toast.LENGTH_SHORT).show();
                                               Intent intent = new Intent(Login.this, Profilepage.class);
                                               intent.putExtra("id", id);
                                               intent.putExtra("name", name);

                                               startActivity(intent);
//                                               startActivity(new Intent(Login.this, Mainpage.class));
                                           }   }
                ).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        progressDialog.dismiss();
                        Toast.makeText(Login.this, "Logged in Failed.", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
//        signup.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view){
//                finish();
//            }
//        });
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


        signup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent intent = new Intent(Login.this, Signup.class);
                startActivity(intent);
            }
        });



    }
}