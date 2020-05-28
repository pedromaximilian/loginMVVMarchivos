package com.example.loginmvvm.ui.login;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.loginmvvm.model.Usuario;
import com.example.loginmvvm.request.ApiClient;

public class ViewModelMain extends AndroidViewModel {
    private MutableLiveData<String> message;
    private MutableLiveData<Usuario> usuario;
    private Context context;

    public ViewModelMain(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }

    public LiveData<String> getMessage() {
        if (message == null){
            message = new MutableLiveData<>();
        }
        return message;
    }

    public  LiveData<Usuario> getUsuario(){
        if (usuario == null){
            usuario = new MutableLiveData<>();
        }
        return usuario;
    }

    public void validar(String mail, String pass){
        Usuario usuario = ApiClient.login(context, mail, pass);

        if( usuario != null){

            this.usuario.setValue(usuario);

        }else{
            this.message.setValue("No se encontro el usuario");
        }

    }
}
