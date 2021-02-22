package com.example.luclassroom;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CreateClassActivity extends AppCompatActivity {

    private EditText className;
    private Button class_done;
    private ProgressDialog loadingBar;



    public CreateClassActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_class);

        className= (EditText) findViewById(R.id.create_class_name);
        class_done=(Button) findViewById(R.id.create_Class_create_button);

        class_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateClass();
            }
        });


    }

    private void CreateClass() {

        String classN = className.getText().toString();

        if (TextUtils.isEmpty(classN)){
            Toast.makeText(this, "Please enter class name ", Toast.LENGTH_SHORT);
        }

        else {
            loadingBar.setTitle("Create Account");
            loadingBar.setMessage("Please wait, while we are checking");
            loadingBar.setCanceledOnTouchOutside(false);
            loadingBar.show();

        }
    }
}