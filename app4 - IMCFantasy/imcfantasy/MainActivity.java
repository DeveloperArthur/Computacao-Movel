package br.com.imcfantasy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public EditText etIdade;
    public EditText etAltura;
    public EditText etPeso;
    public TextView txtResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.etAltura = findViewById(R.id.etAltura);
        this.etIdade = findViewById(R.id.etIdade);
        this.etPeso = findViewById(R.id.etPeso);
        this.txtResultado = findViewById(R.id.txtResultado);
    }

    public void calcular(View view){
        double altura = 0;
        double peso = 0;
        double resultadoConta = 0;

        peso = Double.parseDouble(this.etPeso.getText().toString());
        altura = Double.parseDouble(this.etAltura.getText().toString());
        resultadoConta = peso / (altura * altura);

        if(resultadoConta < 18.5){
            this.txtResultado.setText(String.valueOf("Magro ou Baixo do Peso"));

        }else if(resultadoConta >= 18.5 && resultadoConta < 24.9){
            this.txtResultado.setText(String.valueOf("Normal ou Eutrófico"));

        }else if(resultadoConta >= 25 && resultadoConta < 29.9){
            this.txtResultado.setText(String.valueOf("Sobrepeso ou Pré-Obeso"));

        }else if(resultadoConta > 30){
            this.txtResultado.setText(String.valueOf("Obesidade"));
        }
    }
}
