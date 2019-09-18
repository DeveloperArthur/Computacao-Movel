package br.uninove.app5_gasolalcool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class calcActivity extends AppCompatActivity {
    public TextView txtResultado;
    private ImageView imgResultado;
    double gasolina, alcool;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        this.txtResultado = findViewById(R.id.txtResultado);
        this.imgResultado = findViewById(R.id.imgResultado);
        Intent it = getIntent();
        Bundle bundle = it.getExtras();
        if(bundle != null){
            gasolina = bundle.getDouble("gasolina");
            alcool = bundle.getDouble("alcool");
            this.calcular();
        }

    }

    public void calcular(){
        double aux_gasolina = gasolina*0.3;
        if(aux_gasolina < alcool){
            this.txtResultado.setText("A melhor opção é GASOLINA!");
            this.imgResultado.setImageResource(R.drawable.gasolina);
        }else{
            this.txtResultado.setText("A melhor opção é ALCOOL!");
            this.imgResultado.setImageResource(R.drawable.alcool);
        }
    }
}
