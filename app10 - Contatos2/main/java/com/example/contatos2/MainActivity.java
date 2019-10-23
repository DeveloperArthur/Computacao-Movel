package com.example.contatos2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvContatos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.lvContatos = findViewById(R.id.lvContatos);
        ArrayList<Contato> lstContatos = new ArrayList<>();
        lstContatos.add(new Contato(1, "Batman", "1478-9854", R.drawable.batman));
        lstContatos.add(new Contato(2, "Duke", "6547-8513", R.drawable.duke));
        lstContatos.add(new Contato(3, "Eduardo", "6236-5434", R.drawable.eduardo));
        lstContatos.add(new Contato(4, "Hulk", "8914-3212", R.drawable.hulk));
        lstContatos.add(new Contato(5, "Jesus", "1486-3251", R.drawable.jesus));
        lstContatos.add(new Contato(6, "Link", "6711-6871", R.drawable.link));
        lstContatos.add(new Contato(7, "Linux", "5256-3472", R.drawable.linux));
        lstContatos.add(new Contato(8, "Orc", "4517-4526", R.drawable.orc));
        lstContatos.add(new Contato(9, "Guerreirinho timão", "8712-9566", R.drawable.timao));
        ContatoAdapter adapter = new ContatoAdapter(this, lstContatos);
        this.lvContatos.setAdapter(adapter);
    }
}
