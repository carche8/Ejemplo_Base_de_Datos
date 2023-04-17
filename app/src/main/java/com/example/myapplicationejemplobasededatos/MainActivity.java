package com.example.myapplicationejemplobasededatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText et_codigo, et_nombre, et_autor, et_isbn, et_editorial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_codigo = (EditText) findViewById(R.id.et_codigo);
        et_nombre = (EditText) findViewById(R.id.et_nombre);
        et_autor = (EditText) findViewById(R.id.et_autor);
        et_isbn = (EditText) findViewById(R.id.et_isbn);
        et_editorial = (EditText) findViewById(R.id.et_editorial);
    }

    // Método para Registrar //

    public void Registrar (View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String codigo = et_codigo.getText().toString();
        String nombre = et_nombre.getText().toString();
        String autor = et_autor.getText().toString();
        String isbn = et_isbn.getText().toString();
        String editorial = et_editorial.getText().toString();

        if (!codigo.isEmpty() && !nombre.isEmpty() && !autor.isEmpty()) {
            ContentValues registro = new ContentValues();

            registro.put("codigo", codigo);
            registro.put("nombre", nombre);
            registro.put("autor", autor);
            registro.put("isbn", isbn);
            registro.put("editorial", editorial);

            BaseDeDatos.insert("articulos", null, registro);
            BaseDeDatos.close();

            et_codigo.setText("");
            et_nombre.setText("");
            et_autor.setText("");
            et_isbn.setText("");
            et_editorial.setText("");

            Toast.makeText(this, "El producto se ha grabado de forma correcta", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Debes rellenar todos los campos", Toast.LENGTH_SHORT).show();
        }

        }





}