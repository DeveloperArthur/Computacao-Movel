package com.example.chamadapersonalizada.controllers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.chamadapersonalizada.entities.Aluno;
import com.example.chamadapersonalizada.helpers.AlunoBancoHelper;

public class AlunoBancoController {
    private SQLiteDatabase bd;
    private AlunoBancoHelper alunoBancoHelper;

    public AlunoBancoController(Context context){
        this.alunoBancoHelper = new AlunoBancoHelper(context);
    }

    public boolean add(Aluno aluno){
        ContentValues values;
        long resultado;
        this.bd = alunoBancoHelper.getWritableDatabase();
        values = new ContentValues();
        values.put(AlunoBancoHelper.FIELD_NOME, aluno.getNome());
        values.put(AlunoBancoHelper.FIELD_FOTO, aluno.getFoto());
        resultado = bd.insert(AlunoBancoHelper.TABELA, null, values);
        bd.close();
        if(resultado == -1)
            return false;
        else return true;
    }

    public Cursor getAll(){
        Cursor cursor;
        String[] campos = {
            alunoBancoHelper.ID,
            alunoBancoHelper.FIELD_NOME,
            alunoBancoHelper.FIELD_FOTO
        };
        bd = alunoBancoHelper.getReadableDatabase();
        cursor = bd.query(alunoBancoHelper.TABELA, campos, null,null,null,null,null,null);
        if (cursor != null){
            cursor.moveToFirst();
        }
        bd.close();
        return cursor;
    }
}
