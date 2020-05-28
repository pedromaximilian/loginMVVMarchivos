package com.example.loginmvvm.ui.registro;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.loginmvvm.model.Usuario;
import com.example.loginmvvm.request.ApiClient;

public class ViewModelRegister extends AndroidViewModel {
    private MutableLiveData<Usuario> usuario;
    private Context context;


    public ViewModelRegister(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
        usuario = new MutableLiveData<Usuario>();
    }

    public LiveData<Usuario> getUsuario(){
        if (usuario == null){
            usuario = new MutableLiveData<>();
        }
        return usuario;
    }

    public void guardar(long dni, String apellido, String nombre, String mail, String pass){
        Usuario usuario = new Usuario(dni, apellido, nombre, mail, pass);

        ApiClient.guardar(context, usuario);

    }

    public void origen(String origen){
        ApiClient.leer(context);

        if (origen.equals("login")){
            usuario.setValue(ApiClient.leer(context));
        }

    }


}
