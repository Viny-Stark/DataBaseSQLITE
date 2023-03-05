package com.example.databasesqlite.AppDataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.databasesqlite.DataModel.PessoaDataModel;

public class DataBase extends SQLiteOpenHelper {
    public DataBase(Context context) {
        super(context, "banco", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try {

            // Executar o que desejamos
            db.execSQL(PessoaDataModel.criarTabela());

            Log.d("Log_DataBase", "Tabela pessoa gerada com sucesso :"+ PessoaDataModel.criarTabela());


        } catch (SQLException e) {


            Log.d("Log_DataBase", "Tabela nao foi gerada");


        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql_pessoas = "DROP TABLE IF EXISTS pessoas;";

        db.execSQL(sql_pessoas);
        onCreate(db);
    }
    public void inserirPessoa(Pessoa pessoa){

        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = new ContentValues();

        dados.put("nome",pessoa.getNome());
        dados.put("idade",pessoa.getIdade());
        dados.put("cpf",pessoa.getCpf());

        db.insert("pessoa",null,dados);
        db.close();

    }
}
