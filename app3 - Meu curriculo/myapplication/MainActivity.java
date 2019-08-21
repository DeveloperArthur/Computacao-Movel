package br.uninove.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void abrirDadosPessoais(View view){
        Intent it = new Intent(this, DadosPessoaisActivity.class);
        startActivity(it);
    }

    public void abrirDadosProfissionais(View view){
        Intent it = new Intent(this, DadosProfissionaisActivity.class);
        startActivity(it);
    }

    public void abrirContato(View view){
        Intent it = new Intent(this, ContatoActivity.class);
        startActivity(it);
    }
}
