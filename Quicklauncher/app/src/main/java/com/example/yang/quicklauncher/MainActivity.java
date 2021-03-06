package com.example.yang.quicklauncher;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Attempts to launch an activity within our own app
        Button secondActivityBtn = (Button) findViewById(R.id.secondActivityBtn);
        secondActivityBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), SecondActivity.class);
                // Show how to pass information to another activity
                startIntent.putExtra("com.example.yang.quicklauncher.SOMETHING", "Hello world");
                startActivity(startIntent);
                
            }
        });

        // Attempt to launch an activity outside our app
        Button googleBtn = (Button) findViewById(R.id.googleBtn);
        googleBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String google = "http://www.google.com";
                Uri webadddress = Uri.parse(google);

                Intent gotoGoogle = new Intent(Intent.ACTION_VIEW, webadddress);
                if (gotoGoogle.resolveActivity(getPackageManager()) != null)
                {
                    startActivity(gotoGoogle);

                }


            }
        });
    }
}
