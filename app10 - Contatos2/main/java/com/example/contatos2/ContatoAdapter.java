package com.example.contatos2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ContatoAdapter extends BaseAdapter {
    Context context;
    ArrayList<Contato> lstContato;

    public ContatoAdapter(Context context, ArrayList<Contato> lstContato) {
        this.context = context;
        this.lstContato = lstContato;
    }

    @Override
    public int getCount() {
        return this.lstContato.size();
    }

    @Override
    public Object getItem(int position) {
        return this.lstContato.get(position);
    }

    @Override
    public long getItemId(int position) {
        return this.lstContato.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(this.context).inflate(R.layout.contato_item, parent, false);
        }
        TextView txtNome = convertView.findViewById(R.id.txtNome);
        TextView txtNumero = convertView.findViewById(R.id.txtNumero);
        ImageView imgFoto = convertView.findViewById(R.id.imgFoto);
        Contato contato = this.lstContato.get(position);
        txtNome.setText(contato.getNome());
        txtNumero.setText(contato.getTelefone());
        imgFoto.setImageResource(contato.getFoto());
        return convertView;
    }
}
