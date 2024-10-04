package com.example.kawine;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Register extends AppCompatActivity {

    private EditText inputUser, inputPassword, inputPasswordVerify;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        inputUser = findViewById(R.id.inputUser);
        inputPassword = findViewById(R.id.inputPassword);
        inputPasswordVerify = findViewById(R.id.inputPasswordVerify);
        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = inputUser.getText().toString();
                String password = inputPassword.getText().toString();
                String passwordVerify = inputPasswordVerify.getText().toString();

                if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)){
                    Toast.makeText( Register.this, "Por favor ingrese un usuario y contraseña.", Toast.LENGTH_SHORT).show();
                } else {
                    if (TextUtils.isEmpty(passwordVerify)){
                        Toast.makeText( Register.this, "Por favor verifique la contraseña ingresada.", Toast.LENGTH_SHORT).show();
                    } else {
                        if(!password.equals(passwordVerify)){
                            Toast.makeText( Register.this, "Las contraseñas ingresadas no coinciden.", Toast.LENGTH_SHORT).show();
                        } else {
                            Intent intent = new Intent(Register.this, Login.class);
                            startActivity(intent);
                        }
                    }
                }
            }
        });
    }
}