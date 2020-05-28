package com.example.loginmvvm.ui.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.loginmvvm.R;
import com.example.loginmvvm.model.Usuario;
import com.example.loginmvvm.ui.registro.RegisterActivity;

public class MainActivity extends AppCompatActivity {

    Button btnRegister, btnIngresar;
    EditText etMail, etPass;
    TextView message;
    ViewModelMain vm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configView();


    }

    private void configView() {
        btnIngresar = findViewById(R.id.btnIngresar);
        btnRegister = findViewById(R.id.btnRegister);
        etMail = findViewById(R.id.etMail);
        etPass = findViewById(R.id.etPass);
        message = findViewById(R.id.tvMessage);

        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(ViewModelMain.class);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
                i.putExtra("origen", "register");
                startActivity(i);
            }
        });
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vm.validar(etMail.getText().toString(), etPass.getText().toString());
            }
        });

        vm.getMessage().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                message.setText(s);
            }
        });


        vm.getUsuario().observe(this, new Observer<Usuario>() {
            @Override
            public void onChanged(Usuario usuario) {
                Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
                i.putExtra("origen", "login");
                startActivity(i);
            }
        });

    }


}
