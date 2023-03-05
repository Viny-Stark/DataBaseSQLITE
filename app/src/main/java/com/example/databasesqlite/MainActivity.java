package com.example.databasesqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.databasesqlite.AppDataBase.DataBase;
import com.example.databasesqlite.AppDataBase.Pessoa;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Pessoa pessoa =new Pessoa();
        pessoa.setNome("Vinicius");
        pessoa.setIdade("29");
        pessoa.setCpf("2905105");

        DataBase base = new DataBase(this);

        base.inserirPessoa(pessoa);
    }


}