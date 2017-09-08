package com.emedinaa.infosoft.kotlintemplate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        app();
    }

    private void app() {
        findViewById(R.id.imageViewJava).setOnClickListener(this);
        findViewById(R.id.imageViewKotlin).setOnClickListener(this);
        //startActivity(new Intent(this,JavaActivity.class));
        //startActivity(new Intent(this,KotlinActivity.class));
    }

    private void  goToActivity(Class activity){
        startActivity(new Intent(this,activity));
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imageViewJava:
                    goToActivity(JavaActivity.class);
                break;
            case R.id.imageViewKotlin:
                    goToActivity(KotlinActivity.class);
                break;
        }
    }
}
