package modelo;

import java.sql.Date;

public class Conta {
    private int idOrador;
    private String nombre;
    private String mail;
    private String tema;
    private Date fechaAlta;

    // Constructor
    public Conta() {
    }

    // Getters y setters
    // ...

    // Resto de métodos y atributos
    // ...

    public int getIdOrador() {
        return idOrador;
    }

    public void setIdOrador(int idOrador) {
        this.idOrador = idOrador;
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

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
}

