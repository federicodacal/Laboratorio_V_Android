package com.example.ejerformulario;

public class Persona {
    public String nombre;
    public String apellido;
    public String dni;
    public String sexo;

    public Persona(String nombre, String apellido, String dni, String sexo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return this.nombre.concat(" ").concat(this.apellido).concat(" | DNI: ").concat(this.dni).concat(" Sexo: ").concat(this.sexo);
    }

}
