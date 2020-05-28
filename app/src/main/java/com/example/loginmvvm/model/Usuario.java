package com.example.loginmvvm.model;

public class Usuario {
    private long dni;
    private String apellidos;
    private String nombre;
    private String mail;
    private String pass;

    public Usuario() {
    }

    public Usuario(long dni, String apellidos, String nombre, String mail, String pass) {
        this.dni = dni;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.mail = mail;
        this.pass = pass;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
