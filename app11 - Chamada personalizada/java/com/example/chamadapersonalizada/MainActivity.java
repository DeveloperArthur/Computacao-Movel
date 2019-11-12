package com.example.chamadapersonalizada;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.chamadapersonalizada.adapters.AlunoAdapter;
import com.example.chamadapersonalizada.controllers.AlunoBancoController;
import com.example.chamadapersonalizada.entities.Aluno;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private ArrayList<Aluno> listaDeAlunos;
    private ListView lvAlunos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.button = findViewById(R.id.button);
        this.lvAlunos = findViewById(R.id.lvAlunos);
        this.listaDeAlunos = new ArrayList<>();
        this.atualizarLista();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        this.atualizarLista();
    }

    public void abrirTela(View view) {
        Intent intent = new Intent(this, add.class);
        startActivity(intent);
    }

    public void atualizarLista() {
        AlunoAdapter adapter = new AlunoAdapter(this, listaDeAlunos);
        lvAlunos.setAdapter(adapter);
        Cursor cursor = new AlunoBancoController(this).getAll();
        listaDeAlunos.clear();
        while (cursor.moveToNext()) {
            Aluno aluno = new Aluno(
                    cursor.getInt(cursor.getColumnIndex("id")),
                    cursor.getString(cursor.getColumnIndex("nome")),
                    cursor.getString(cursor.getColumnIndex("foto")));
            listaDeAlunos.add(aluno);
        }
        lvAlunos.deferNotifyDataSetChanged();
    }
}