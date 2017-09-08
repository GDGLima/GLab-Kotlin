package com.emedinaa.infosoft.kotlintemplate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.Toast;

public class JavaActivity extends AppCompatActivity {

    private AppCompatTextView textViewHello;
    private AppCompatImageView imageViewJava;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java);

        app();
    }

    private void showMessage(){
        Toast.makeText(this,"Hello Java",Toast.LENGTH_LONG).show();
    }
    private void app() {
        textViewHello= (AppCompatTextView)findViewById(R.id.textViewHello);
        imageViewJava= (AppCompatImageView) findViewById(R.id.imageViewJava);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //events
        imageViewJava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMessage();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
