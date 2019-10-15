package br.com.uninove.contatos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView lvContatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.lvContatos = findViewById(R.id.lvContatos);
        String[] contatos = new String[]{
                "Arthur",
                "Gabriela",
                "Ilza",
                "Raul",
                "Wallace",
                "Wesley"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, android.R.id.text1, contatos);
        this.lvContatos.setAdapter(adapter);
    }
}