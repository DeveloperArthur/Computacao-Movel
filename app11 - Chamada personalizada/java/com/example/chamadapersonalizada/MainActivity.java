package com.example.chamadapersonalizada;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.button = findViewById(R.id.button);
    }

    public void abrirTela(View view){
        Intent intent = new Intent(this, add.class);
        startActivity(intent);
    }
}
