package br.com.imcfantasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class IMCActivity extends AppCompatActivity {
    public TextView txtResultado;
    private ImageView imgResultado;
    double peso;
    double altura;
    int sexo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);
        this.txtResultado = findViewById(R.id.txtResultado);
        this.imgResultado = findViewById(R.id.imgResultado);
        Intent it = getIntent();
        Bundle bundle = it.getExtras();
        if(bundle != null){
            peso = bundle.getDouble("peso");
            altura = bundle.getDouble("altura");
            sexo = bundle.getInt("sexo");
            this.calcular();
        }

    }

    public void calcular(){
        double resultadoConta = 0;

        resultadoConta = peso / (altura * altura);

        if(resultadoConta < 18.5){
            this.txtResultado.setText("Magro ou Baixo do Peso");
            if(sexo==0){
                this.imgResultado.setImageResource(R.drawable.magro);
            }else if(sexo==1){
                this.imgResultado.setImageResource(R.drawable.magro2);
            }else if(sexo==2){
                this.imgResultado.setImageResource(R.drawable.erro);
            }

        }else if(resultadoConta >= 18.5 && resultadoConta < 24.9){
            this.txtResultado.setText("Normal ou Eutrófico");
            if(sexo==0){
                this.imgResultado.setImageResource(R.drawable.normal);
            }else if(sexo==1){
                this.imgResultado.setImageResource(R.drawable.normal2);
            }else if(sexo==2){
                this.imgResultado.setImageResource(R.drawable.erro);
            }

        }else if(resultadoConta >= 25 && resultadoConta < 29.9){
            this.txtResultado.setText("Sobrepeso ou Pré-Obeso");
            if(sexo==0){
                this.imgResultado.setImageResource(R.drawable.sobrepeso);
            }else if(sexo==1){
                this.imgResultado.setImageResource(R.drawable.sobrepeso2);
            }else if(sexo==2){
                this.imgResultado.setImageResource(R.drawable.erro);
            }


        }else if(resultadoConta > 30){
            this.txtResultado.setText("Obesidade");
            if(sexo==0){
                this.imgResultado.setImageResource(R.drawable.obeso);
            }else if(sexo==1){
                this.imgResultado.setImageResource(R.drawable.obeso2);
            }else if(sexo==2){
                this.imgResultado.setImageResource(R.drawable.erro);
            }

        }
    }
}