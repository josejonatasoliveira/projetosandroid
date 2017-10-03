package com.edu.fatec.inviteme;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.edu.fatec.inviteme.model.RegisterUserOnFirebase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class CadastrarUserActivity extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAuth firebaseAuth;
    TextView username = (TextView)  findViewById(R.id.enterNameId);
    TextView email = (TextView) findViewById(R.id.enterNameId);
    TextView pass = (TextView) findViewById(R.id.enterSenhaId);
    Button cadastrar = (Button) findViewById(R.id.buttonCadastrarId);
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_user);
        firebaseAuth = FirebaseAuth.getInstance();
        cadastrar.setOnClickListener(this);
        progressDialog = new ProgressDialog(this);

        private DatabaseReference mDatabase;


    }

    private void registerUser(){
        String nameText = username.getText().toString().trim();
        String emailText = email.getText().toString().trim();
        String senhaText = pass.getText().toString().trim();

        if (TextUtils.isEmpty(nameText)){
            Toast.makeText(this,R.string.enter_name,Toast.LENGTH_LONG).show();
        }

        if (TextUtils.isEmpty(emailText)){
            Toast.makeText(this,R.string.enter_email, Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(senhaText)){
            Toast.makeText(this, R.string.enter_pass, Toast.LENGTH_LONG).show();
        }

        progressDialog.setMessage(getString(R.string.resgistering));
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(senhaText,emailText,senhaText)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(CadastrarUserActivity.this, R.string.registeringSucess, Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(getApplicationContext(), RegisterUserOnFirebase.class);
                            intent.putExtra("nome", username.getText().toString().trim());
                            intent.putExtra("email", email.getText().toString().trim());
                            intent.putExtra("senha", pass.getText().toString().trim());
                            startActivity(intent);
                        }else{
                            Toast.makeText(CadastrarUserActivity.this, R.string.registeringError, Toast.LENGTH_LONG).show();
                        }
                        progressDialog.dismiss();
                    }
                });

    }


    @Override
    public void onClick(View view) {
        registerUser();

    }
}
