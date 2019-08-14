package br.com.app2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public EditText txtNum1;
    public EditText txtNum2;
    public TextView resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.txtNum1 = findViewById(R.id.txtNum1);
        this.txtNum2 = findViewById(R.id.txtNum2);
        this.resultado = findViewById(R.id.resultado);
    }

    public void somar(View view){
        double num1 = 0.0;
        double num2 = 0.0;
        double resultado = 0.0;
        num1 = Double.parseDouble(this.txtNum1.getText().toString());
        num2 = Double.parseDouble(this.txtNum2.getText().toString());
        resultado = num1 + num2;
        this.resultado.setText(String.valueOf(resultado));
    }
}
