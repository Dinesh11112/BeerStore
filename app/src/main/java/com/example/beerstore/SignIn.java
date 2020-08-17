package com.example.beerstore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignIn extends AppCompatActivity {
    private static final String TAG = "SignIn";
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private EditText email,password;
    private Button signin;
    SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        mAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.Email);
        password = findViewById(R.id.Password);
        signin = findViewById(R.id.signin);

        mAuthListener = new FirebaseAuth.AuthStateListener(){
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth){
                FirebaseUser user = firebaseAuth.getCurrentUser();
               pref = getSharedPreferences(user.getEmail(),MODE_PRIVATE);
            }
        };


        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String memail = email.getText().toString();
                String mpass = password.getText().toString();
                if(!memail.equals("") && !mpass.equals("")){
                    mAuth.signInWithEmailAndPassword(memail,mpass);
                    toastmessage("Signed in Successfully"+ email.getText().toString());
                    Intent i = new Intent(SignIn.this, ShopActivity.class);
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("username",memail);
                    editor.commit();
                    startActivity(i);
                }
                else{
                    toastmessage("please fill all the fields");
                }
            }
        });
    }
    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }
    @Override
    public void onStop() {
        super.onStop();
        if(mAuthListener != null){
            mAuth.addAuthStateListener(mAuthListener);
        }
    }
    private void toastmessage(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}