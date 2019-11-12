package com.example.chamadapersonalizada.controllers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.chamadapersonalizada.entities.Aluno;
import com.example.chamadapersonalizada.helpers.AlunoBancoHelper;

public class AlunoBancoController {
    private SQLiteDatabase db;
    private AlunoBancoHelper alunoBancoHelper;

    public AlunoBancoController(Context context) {
        this.alunoBancoHelper = new AlunoBancoHelper(context);
    }

    public boolean add(Aluno aluno) {
        ContentValues valores;
        long resultado;
        this.db = alunoBancoHelper.getWritableDatabase();
        valores = new ContentValues();
        valores.put(AlunoBancoHelper.FIELD_NOME, aluno.getNome());
        valores.put(AlunoBancoHelper.FIELD_FOTO, aluno.getFoto());
        resultado = db.insert(AlunoBancoHelper.TABELA,
                null, valores);
        db.close();
        if (resultado == -1)
            return false;
        else
            return true;
    }

    public Cursor getAll() {
        Cursor cursor;
        String[] campos = {alunoBancoHelper.ID,
                alunoBancoHelper.FIELD_NOME,
                alunoBancoHelper.FIELD_FOTO};
        db = alunoBancoHelper.getReadableDatabase();
        cursor = db.query(alunoBancoHelper.TABELA,
                campos,
                null,
                null,
                null,
                null,
                null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor getById(int id) {
        Cursor cursor;
        String[] campos =
                {alunoBancoHelper.ID, alunoBancoHelper.FIELD_NOME, alunoBancoHelper.FIELD_FOTO};
        String where = alunoBancoHelper.ID + "=" + id;
        db = alunoBancoHelper.getReadableDatabase();
        cursor = db.query(alunoBancoHelper.TABELA, campos, where, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public void update(Aluno aluno) {
        ContentValues valores;
        String where;
        db = alunoBancoHelper.getWritableDatabase();
        where = alunoBancoHelper.ID + "=" + aluno.getId();
        valores = new ContentValues();
        valores.put(AlunoBancoHelper.FIELD_NOME, aluno.getNome());
        valores.put(AlunoBancoHelper.FIELD_FOTO, aluno.getFoto());
        db.update(alunoBancoHelper.TABELA, valores, where, null);
        db.close();
    }

    public void remove(int id) {
        String where = alunoBancoHelper.ID + "=" + id;
        db = alunoBancoHelper.getReadableDatabase();
        db.delete(AlunoBancoHelper.TABELA, where, null);
        db.close();
    }
}
