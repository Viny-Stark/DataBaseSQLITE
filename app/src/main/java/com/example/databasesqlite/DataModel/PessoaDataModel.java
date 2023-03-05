package com.example.databasesqlite.DataModel;

public class PessoaDataModel {

    /*
    Integer id;
    String nome;
    String idade;
    String cpf;
    */
    public  static  final  String TABELA ="pessoa"; //nome da tabela e de sua escolha de acordo com seu projeto
    public  static final String ID ="id";
    public  static final String NOME ="nome";
    public  static final String IDADE ="idade";
    public  static final String CPF ="cpf";

    public static String query;

    public  static  String criarTabela(){
            query = "CREATE TABLE "+TABELA+" ( ";
            query += ID+" INTEGER PRIMARY KEY AUTOINCREMENT, ";
            query += NOME+" TEXT, ";
            query += IDADE+" TEXT, ";
            query += CPF+" INTEGER ";
            query += ")";

        return query;
    }


}
