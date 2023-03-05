package com.example.databasesqlite.appUtil;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.databasesqlite.dataModel.PessoaDataModel;

public class DataBase extends SQLiteOpenHelper {

    SQLiteDatabase db;
    public DataBase(Context context) {
        super(context, "banco", null, 1);

        db = getWritableDatabase();
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
    public boolean insert(String tabela, ContentValues dados){

        boolean sucesso=true;

        try{
            Log.d("Log_DataBase",tabela+"insert() executado com sucesso");
            sucesso=db.insert(tabela,null,dados)>0;

        }catch (SQLException e){
            Log.e("Log_DataBase",tabela+" falhou ao executar o insert" +e.getMessage());
        }

        return sucesso;

    }
}
