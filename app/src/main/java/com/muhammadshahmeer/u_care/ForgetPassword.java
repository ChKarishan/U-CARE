package com.muhammadshahmeer.u_care;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgetPassword extends AppCompatActivity {

    Button passBtn;
    EditText TxtEmail;
    String em;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        mAuth = FirebaseAuth.getInstance();
        TxtEmail = findViewById(R.id.email);
        passBtn = findViewById(R.id.passBtn);


        passBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateData();
            }
        });

    }

    public void validateData(){

        em = TxtEmail.getText().toString();
        if(em.isEmpty())
        {
            TxtEmail.setError("Required");
        }
        else
        {
            forgetPassword();
        }
    }

    public void forgetPassword()
    {
        mAuth.sendPasswordResetEmail(em)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(ForgetPassword.this, "Check Your SPAM Messages in Email!!!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(ForgetPassword.this,Login.class));
                            finish();
                        }
                        else
                        {
                            Toast.makeText(ForgetPassword.this, "Error : "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }
                });

    }


}