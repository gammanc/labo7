package com.gamma.labo7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gamma.labo7.Beans.Persona;
import com.gamma.labo7.Entity.DBHelper;

public class activity_add extends AppCompatActivity {

    EditText txtId, txtName;
    Button btnEnviar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        setViews();

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean flag = DBHelper.myDB.add(
                        new Persona(txtId.getText().toString(),
                                txtName.getText().toString()));
                if (flag){
                    Log.d("Edit", txtName.getText().toString());
                    Toast.makeText(getApplicationContext(),"Agregado con exito", Toast.LENGTH_SHORT).show();
                    clean();
                }
            }
        });
    }

    void clean(){
        txtId.setText("");
        txtName.setText("");
    }
    void setViews(){
        btnEnviar = findViewById(R.id.btn_registrar);
        txtId = findViewById(R.id.txt_id);
        txtName = findViewById(R.id.txt_nombre);
    }
}
