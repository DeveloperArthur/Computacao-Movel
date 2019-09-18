package br.uninove.app5_gasolalcool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    public EditText etGasolina;
    public EditText etAlcool;
    public ImageView imgResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.etAlcool = findViewById(R.id.etAlcool);
        this.etGasolina = findViewById(R.id.etGasolina);
        this.imgResultado = findViewById(R.id.imgResultado);
        this.imgResultado.setImageResource(R.drawable.inicio);
    }

    public void abrirProximaTela(View view){
        Intent it = new Intent(this, calcActivity.class);
        double gasolina = 0;
        double alcool = 0;

        gasolina = Double.parseDouble(this.etGasolina.getText().toString());
        alcool = Double.parseDouble(this.etAlcool.getText().toString());
        it.putExtra("gasolina", gasolina);
        it.putExtra("alcool", alcool);

        startActivity(it);
    }
}
