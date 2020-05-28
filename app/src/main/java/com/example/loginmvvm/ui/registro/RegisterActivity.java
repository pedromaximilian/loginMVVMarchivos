package com.example.loginmvvm.ui.registro;

import android.os.Bundle;

import com.example.loginmvvm.model.Usuario;
import com.example.loginmvvm.ui.login.ViewModelMain;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.loginmvvm.R;

public class RegisterActivity extends AppCompatActivity {
    ViewModelRegister vm;
    EditText etDni, etApellido, etNombre, etMail, etPass;
    Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        configView();
    }

    private void configView() {
        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(ViewModelRegister.class);

        etDni = findViewById(R.id.etDni);
        etApellido = findViewById(R.id.etApellido);
        etNombre = findViewById(R.id.etNombre);
        etMail = findViewById(R.id.etMail);
        etPass = findViewById(R.id.etPass);
        btnGuardar = findViewById(R.id.btnGuardar);

        vm.origen(getIntent().getStringExtra("origen"));

        vm.getUsuario().observe(this, new Observer<Usuario>() {
            @Override
            public void onChanged(Usuario u) {
                etDni.setText(u.getDni()+"");
                etApellido.setText(u.getApellidos()+"");
                etNombre.setText(u.getNombre()+"");
                etMail.setText(u.getMail()+"");
                etPass.setText(u.getPass()+"");
            }
        });

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vm.guardar(
                        Long.parseLong(etDni.getText().toString()),
                        etApellido.getText().toString(),
                        etNombre.getText().toString(),
                        etMail.getText().toString(),
                        etPass.getText().toString()
                );

                btnGuardar.setActivated(false);
            }
        });


    }

}
