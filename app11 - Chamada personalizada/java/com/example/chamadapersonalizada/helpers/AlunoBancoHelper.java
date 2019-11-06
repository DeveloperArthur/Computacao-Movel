package com.example.chamadapersonalizada.helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AlunoBancoHelper extends SQLiteOpenHelper {
    public static final String BANCO = "bdaluno";
    public static final String TABELA = "alunos";
    public static final String ID = "id";
    public static final String FIELD_NOME = "nome";
    public static final String FIELD_FOTO = "foto";
    public static final int VERSION = 1;

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE "+TABELA+" ("
                +ID+" intereger primary key autoincrement,"
                +FIELD_NOME+" text,"
                +FIELD_FOTO+" text"
        +")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABELA);
        onCreate(db);
    }

    public AlunoBancoHelper(Context context) {
        super(context, BANCO, null, VERSION);
    }
}
