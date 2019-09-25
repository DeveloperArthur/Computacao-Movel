package com.example.ifode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void chamarTelaComida(View view){
        Intent it = new Intent(this, Comida.class);
        startActivity(it);
    }

    public void chamarTelaBebida(View view){
        Intent it = new Intent(this, Bebida.class);
        startActivity(it);
    }

    public void chamarTelaSobremesa(View view){
        Intent it = new Intent(this, Sobremesa.class);
        startActivity(it);
    }
}
