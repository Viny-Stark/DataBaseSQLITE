package com.example.databasesqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.databasesqlite.appUtil.DataBase;
import com.example.databasesqlite.appUtil.Pessoa;
import com.example.databasesqlite.controller.PessoaController;

public class MainActivity extends AppCompatActivity {


    PessoaController controller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Pessoa pessoa =new Pessoa();
        pessoa.setNome("Vinicius");
        pessoa.setIdade("29");
        pessoa.setCpf("2905105");

        controller = new PessoaController(this);
        controller.incluir(pessoa);
    }


}