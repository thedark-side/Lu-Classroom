package com.example.luclassroom;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class FacultyActivity extends AppCompatActivity {
    private Button cse,eee,cv,arch,english,law,ph,bangla,thm,bba,is;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty);

        arch = (Button) findViewById(R.id.Architecture);
        english = (Button) findViewById(R.id.english);
        cse = (Button) findViewById(R.id.cse);
        law = (Button) findViewById(R.id.law);
        eee = (Button) findViewById(R.id.eee);
        cv = (Button) findViewById(R.id.cv);
        bba = (Button) findViewById(R.id.bba);
        ph = (Button) findViewById(R.id.ph);
        is = (Button) findViewById(R.id.is);
        bangla = (Button) findViewById(R.id.bangla);
        thm = (Button) findViewById(R.id.thm);


        arch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.lus.ac.bd/faculty-of-architecture/");
            }
        });

        english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.lus.ac.bd/faculty-of-english/");
            }
        });

        cse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.lus.ac.bd/faculty-of-cse/");
            }
        });

        law.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.lus.ac.bd/faculty-of-law/");
            }
        });

        eee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.lus.ac.bd/faculty-of-eee/");
            }
        });


        bba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.lus.ac.bd/faculty-of-bua/");
            }
        });

        thm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.lus.ac.bd/faculty-of-hotel-management/");
            }
        });

        bangla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.lus.ac.bd/faculty-members-of-bangla/");
            }
        });

        ph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.lus.ac.bd/faculty-of-public-health/");
            }
        });

        is.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.lus.ac.bd/faculty-of-islamic-studies/");
            }
        });

        cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.lus.ac.bd/faculty-list-of-civil/");
            }
        });


    }

    private void gotoUrl(String s) {
        Uri uri=Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}