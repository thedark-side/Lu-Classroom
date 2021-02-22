package com.example.luclassroom;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class JoinActivity extends AppCompatActivity {

    private EditText InputName, InputPhone, InputPassword;
    private ProgressDialog loadingBar;

    private DatePickerDialog.OnDateSetListener mDateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        Button createAccountButton = (Button) findViewById(R.id.register_btn);
        InputName = (EditText) findViewById(R.id.register_username_input);
        InputPhone = (EditText) findViewById(R.id.register_phone_input);
        InputPassword = (EditText) findViewById(R.id.register_password_input);

        loadingBar = new ProgressDialog(this);


        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                CreateAccount();
            }
        });



    }

    @SuppressLint("ShowToast")
    private void CreateAccount() {
        String name = InputName.getText().toString();
        String phone = InputPhone.getText().toString();
        String password = InputPassword.getText().toString();


        if (TextUtils.isEmpty(name)){
            Toast.makeText(this, "Please enter your name ", Toast.LENGTH_SHORT);
        }

        else if (TextUtils.isEmpty(phone)){
            Toast.makeText(this, "Please enter your phone number ", Toast.LENGTH_SHORT);
        }

        else if (TextUtils.isEmpty(password)){
            Toast.makeText(this, "Please enter your password ", Toast.LENGTH_SHORT);
        }

        else {
            loadingBar.setTitle("Create Account");
            loadingBar.setMessage("Please wait, while we are checking");
            loadingBar.setCanceledOnTouchOutside(false);
            loadingBar.show();


            Validemail(name,phone,password);
        }
    }

    private void Validemail(final String name,final String phone,final String password) {
        final DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance().getReference();
        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (!(snapshot.child("Users").child(phone).exists()))
                {
                    HashMap<String, Object> userdataMap= new HashMap<>();
                    userdataMap.put("phone", phone);
                    userdataMap.put("password", password);
                    userdataMap.put("name", name);

                    RootRef.child("users").child(phone).updateChildren(userdataMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(JoinActivity.this,"Congratulation",Toast.LENGTH_SHORT).show();
                                loadingBar.dismiss();
                                Intent intent = new Intent(JoinActivity.this, HomeActivity.class);
                                startActivity(intent);
                            }
                            else {
                                loadingBar.dismiss();
                                Toast.makeText(JoinActivity.this, "Network error, try again",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }

                else {
                    Toast.makeText(JoinActivity.this, "This" + phone + "already token",Toast.LENGTH_SHORT).show();
                    loadingBar.dismiss();

                    Intent intent=new Intent(JoinActivity.this,MainActivity.class);
                    startActivity(intent);
                }
                        }



            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}
