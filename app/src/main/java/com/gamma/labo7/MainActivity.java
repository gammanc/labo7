package com.gamma.labo7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.gamma.labo7.Entity.DBHelper;

public class MainActivity extends AppCompatActivity {

    private Button btnRegistrar, btnConsultar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setViews();
        DBHelper.getInstance(this);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), activity_add.class);
                startActivity(intent);
            }
        });
        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), activity_edit.class);
                startActivity(intent);
            }
        });
    }

    void setViews(){
        btnRegistrar = findViewById(R.id.btn_registrar);
        btnConsultar = findViewById(R.id.btn_consultar);
    }
}
