package com.example.usuario.letsparty;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
package com.edu.fatec.inviteme;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {


    //private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        /*firebaseAuth = FirebaseAuth.getInstance();

        //Cadastro do usuario
        firebaseAuth.createUserWithEmailAndPassword("jose@gmail.com","JoseJonatas")
                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){//Cadastro com sucesso
                            Log.i("createUser","cadastro com sucesso");
                        }else{
                            Log.i("createUser","Erro no cadastro");
                        }
                    }
                });*/
    }
}
