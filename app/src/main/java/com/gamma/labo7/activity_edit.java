package com.gamma.labo7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gamma.labo7.Beans.Persona;
import com.gamma.labo7.Entity.DBHelper;

public class activity_edit extends AppCompatActivity {

    EditText txtId, txtName;
    Button btnBuscar, btnEliminar, btnActualizar, btnLimpiar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        setViews();

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Persona p = DBHelper.myDB.findUser(txtId.getText().toString());
                if(p==null) {
                    Toast.makeText(getApplicationContext(), "Usuario no encontrado", Toast.LENGTH_SHORT);
                    limpiar();
                }else {
                    txtName.setText(p.getNombre());
                }
            }
        });

        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper.myDB.editUser(new Persona(txtId.getText().toString(),
                        txtName.getText().toString()));
            }
        });

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper.myDB.deleteUser(txtId.getText().toString());
                limpiar();
            }
        });

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpiar();
            }
        });
    }

    void setViews(){
        txtId = findViewById(R.id.txt_id);
        txtName = findViewById(R.id.txt_nombre);
        btnBuscar = findViewById(R.id.btn_buscar);
        btnEliminar = findViewById(R.id.btn_eliminar);
        btnActualizar = findViewById(R.id.btn_actualizar);
        btnLimpiar = findViewById(R.id.btn_limpiar);
    }

    public void limpiar(){
        txtId.setText("");
        txtName.setText("");
    }
}
