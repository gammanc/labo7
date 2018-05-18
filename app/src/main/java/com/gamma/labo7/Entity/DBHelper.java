package com.gamma.labo7.Entity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.gamma.labo7.Beans.Persona;

/**
 * Created by UCA on 17/05/2018.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static String DB_NAME = "bd_usuarios";
    public static String TABLE_USER = "Persona";
    public static String ROW_ID = "dui";
    public static String ROW_USER_NAME = "nombre";
    public static String CREATE_TB_USERS = "CREATE TABLE "+TABLE_USER+"("+ROW_ID+" TEXT, "+ROW_USER_NAME+" TEXT)";

    public static DBHelper myDB = null;
    private Context context;
    SQLiteDatabase db;


    public DBHelper(Context context) {
        super(context, DB_NAME, null, 1);
        this.context = context;
        db=this.getWritableDatabase();
    }

    public static DBHelper getInstance(Context c){
        if (myDB == null) myDB = new DBHelper(c.getApplicationContext());
        return myDB;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TB_USERS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ROW_USER_NAME);
    }

    public boolean add(Persona p){
        ContentValues values = new ContentValues();
        values.put(ROW_ID, p.getDui());
        values.put(ROW_USER_NAME, p.getNombre());

        db.insert(TABLE_USER, null, values);
        Toast.makeText(context, "Insertado con exito", Toast.LENGTH_SHORT).show();
        return true;
    }

    public Persona findUser(String dui){
        Persona p;

        String[] parametros ={dui};
        String[] campos ={ROW_USER_NAME};

        try {
            Cursor cursor = db.query(TABLE_USER, campos, ROW_ID+"=?",parametros,
                    null, null, null);
            cursor.moveToFirst();
            p = new Persona(dui, cursor.getString(0));
        }catch (Exception e){
            p=null;
        }

        return p;
    }

    public boolean editUser(Persona p){
        String[] parametros = {p.getDui()};
        String[] campos = {ROW_USER_NAME};
        ContentValues values = new ContentValues();
        values.put(ROW_USER_NAME, p.getNombre());
        db.update(TABLE_USER, values, ROW_ID+"=?", parametros);
        Toast.makeText(context, "Actualizado con exito", Toast.LENGTH_SHORT).show();
        return true;
    }

    public boolean deleteUser(String dui){
        String[] args = {dui};
        db.delete(TABLE_USER, ROW_ID+"=?",args);
        Toast.makeText(context, "Eliminado con exito", Toast.LENGTH_SHORT).show();
        return true;
    }
}




























