package com.example.apptreinamento;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements HomeFragment.OnFragmentInteractionListener, TreinoFragment.OnFragmentInteractionListener, AlimentacaoFragment.OnFragmentInteractionListener, BlankFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


    public void MostrarHome(View view) {
        HomeFragment hf = new HomeFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainer, hf);
        transaction.commit();
    }

    public void MostrarTreino(View view){
        TreinoFragment tf = new TreinoFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainer, tf);
        transaction.commit();
    }

    public void MostrarAlimentacao(View view){
        AlimentacaoFragment af = new AlimentacaoFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainer, af);
        transaction.commit();
    }
}
