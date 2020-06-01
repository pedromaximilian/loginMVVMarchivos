package com.example.loginmvvm.request;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import com.example.loginmvvm.model.Usuario;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ApiClient {
    private static SharedPreferences sp;



    public static void guardar(Context context, Usuario usuario){
        try {
            File archivo = new File (context.getFilesDir(), "misdatos.dat");
            FileOutputStream fo = new FileOutputStream(archivo);
            BufferedOutputStream bo = new BufferedOutputStream(fo);
            ObjectOutputStream oos = new ObjectOutputStream(bo);

            oos.writeObject(usuario);

            bo.flush();
            fo.close();

        } catch (IOException io) {
            Toast.makeText(context, "Error al guardar", Toast.LENGTH_LONG).show();
        }
    }

    public static Usuario leer(Context context){
        Usuario usuario = null;

        try {
            File archivo = new File (context.getFilesDir(), "misdatos.dat");
            FileInputStream fi = new FileInputStream(archivo);
            BufferedInputStream bi = new BufferedInputStream(fi);
            ObjectInputStream ois = new ObjectInputStream(bi);

            usuario = (Usuario) ois.readObject();

            fi.close();

        } catch (IOException io) {
            Toast.makeText(context, "No se encontró el archivo", Toast.LENGTH_LONG).show();
        } catch (ClassNotFoundException cnfe) {
            Toast.makeText(context, "No se encontró el objeto", Toast.LENGTH_LONG).show();
        }

        return usuario;
    }

    public static Usuario login(Context context, String mailInput, String passInput) {
        Usuario usuario = null;

        try {
            File archivo = new File(context.getFilesDir(), "misdatos.dat");
            FileInputStream fi = new FileInputStream(archivo);
            BufferedInputStream bi = new BufferedInputStream(fi);
            ObjectInputStream ois = new ObjectInputStream(bi);

            usuario = (Usuario) ois.readObject();

            fi.close();
            if (mailInput.equals(usuario.getMail()) && passInput.equals(usuario.getPass())) {
                return usuario;
            }

        } catch (IOException io) {
            //Toast.makeText(context, io.getMessage(), Toast.LENGTH_LONG).show();
        } catch (ClassNotFoundException ex) {
            //Toast.makeText(context, ex.getMessage(), Toast.LENGTH_LONG).show();
        }

        return null;


    }

    }




