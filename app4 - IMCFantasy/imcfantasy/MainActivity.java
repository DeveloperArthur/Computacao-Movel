package br.com.imcfantasy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public EditText etAltura;
    public EditText etPeso;
    public TextView txtResultado;
    private ImageView imgResultado;
    private Spinner spSexo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.etAltura = findViewById(R.id.etAltura);
        this.etPeso = findViewById(R.id.etPeso);
        this.txtResultado = findViewById(R.id.txtResultado);
        this.imgResultado = findViewById(R.id.imgResultado);
        this.spSexo = findViewById(R.id.spSexo);
    }

    public void calcular(View view){
        double altura = 0;
        double peso = 0;
        double resultadoConta = 0;
        int sexo = 0;
        if(this.spSexo.getSelectedItemPosition()==0){
            sexo = 0;
        }else if(this.spSexo.getSelectedItemPosition()==1){
            sexo = 1;
        }else{
            sexo = 2;
        }

        peso = Double.parseDouble(this.etPeso.getText().toString());
        altura = Double.parseDouble(this.etAltura.getText().toString());
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