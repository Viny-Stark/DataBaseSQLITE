package com.example.databasesqlite.controller;

import android.content.ContentValues;
import android.content.Context;

import com.example.databasesqlite.appUtil.DataBase;
import com.example.databasesqlite.appUtil.Pessoa;
import com.example.databasesqlite.dataModel.PessoaDataModel;

public class PessoaController extends DataBase {

    private static  final String TABELA= PessoaDataModel.TABELA;
    private ContentValues dados;

    public PessoaController(Context context) {
        super(context);
    }
    public  boolean incluir(Pessoa obj){

        //incluir dados na tabela pessoa
        dados= new ContentValues();

        dados.put(PessoaDataModel.NOME, obj.getNome());
        dados.put(PessoaDataModel.IDADE, obj.getIdade());
        dados.put(PessoaDataModel.CPF, obj.getCpf());


        return  insert(TABELA, dados);
    }


}
