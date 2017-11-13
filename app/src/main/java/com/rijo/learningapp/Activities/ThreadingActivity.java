package com.rijo.learningapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.rijo.learningapp.R;

public class ThreadingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_threading);
        Button threadingButton=(Button)findViewById(R.id.asyncTaskLoaderbutton);
        threadingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ThreadingActivity.this,AsyncTaskLoaderActivity.class));
            }
        });
    }
}
