package com.example.guardarimagen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.guardarimagen.utilidades.Utilidades;

import org.apache.commons.codec.binary.Base64;

public class MainActivity extends AppCompatActivity {

    String imagen;
    Button btn;
    ImageView imagenNueva1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ConexionSqliteHelper conn=new ConexionSqliteHelper(this,"bd_usuarios",null,1);

        btn = findViewById(R.id.btn1);
        imagenNueva1 = findViewById(R.id.imagenNueva);
        imagen = "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";
       // byte[] sFoto = Base64.decodeBase64(item.getFoto());
        byte[] sFoto = Base64.decodeBase64(imagen);
        imagenNueva1.setImageBitmap(setImage(sFoto));
    }

   private Bitmap setImage(byte[] data) {
        Bitmap aux = null;
        try {
            return BitmapFactory.decodeByteArray(data, 0, data.length);
        } catch (Exception e) {

        }
        return aux;
    }


    public void onClick(View view) {
        registrarusuarios();
    }

    private void registrarusuarios() {
        String id = "15";
        String nombre = "Santiago";
        String telefono = "04145252636";
       // id.getText().toString();
        ConexionSqliteHelper conn=new ConexionSqliteHelper(this,"bd_usuarios",null,1);
        SQLiteDatabase db = conn.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Utilidades.CAMPO_ID, id);
        values.put(Utilidades.CAMPO_NOMBRE, id);
        values.put(Utilidades.CAMPO_TELEFONO, id);

        Long idResultante = db.insert(Utilidades.TABLA_USUARIO, Utilidades.CAMPO_ID, values);
        Toast.makeText(getApplicationContext(), "Id Registro"+idResultante, Toast.LENGTH_LONG).show();
    }
}