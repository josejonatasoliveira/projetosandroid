package com.edu.fatec.inviteme.model;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseReference;

/**
 * Created by Usuario on 20/09/2017.
 */

public class RegisterUserOnFirebase extends Activity{

    private DatabaseReference mDataBase = new DatabaseReference();
    private DatabaseReference usuarioReference = mDataBase.child("usuarios");


    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //setContentView(/**/);
        Intent intent = getIntent();
        Bundle dataBase = intent.getExtras();
        Usuario user = new Usuario();
        String nome = (String) dataBase.get("nome");
        String email = (String) dataBase.get("email");
        String senha = (String) dataBase.get("senha");

        user.setEmail(email);
        user.setNome(nome);
        user.setSenha(senha);

        writeNewUser(user);


    }

    private void writeNewUser(Usuario user){

        usuarioReference.setValue(user);
    }

}
