package co.edu.uniquindio.seguimiento1.model;

import java.util.ArrayList;
import java.util.List;

public class Propietario {
    private String nombre;
    private String numeroID;
    private String email;
    private String numeroCelular;
    private int edad; // Agregado para el requerimiento 3
    private Vehiculo vehiculo;

    private List<VehiculoCarga> listaVehiculosAsociados = new ArrayList<>();

    public Propietario() {
    }

    public Propietario(String nombre, String numeroID, String email, String numeroCelular, int edad, Vehiculo vehiculo) {
        this.nombre = nombre;
        this.numeroID = numeroID;
        this.email = email;
        this.numeroCelular = numeroCelular;
        this.edad = edad;
        this.vehiculo = vehiculo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumeroID() {
        return numeroID;
    }

    public void setNumeroID(String numeroIdentificacion) {
        this.numeroID = numeroIdentificacion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Propietario{" +
                "nombre='" + nombre + '\'' +
                ", numeroIdentificacion='" + numeroID + '\'' +
                ", email='" + email + '\'' +
                ", numeroCelular='" + numeroCelular + '\'' +
                ", edad=" + edad +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public List<VehiculoCarga> getListaVehiculosAsociados() {
        return listaVehiculosAsociados;
    }

    public void setListaVehiculosAsociados(List<VehiculoCarga> listaVehiculosAsociados) {
        this.listaVehiculosAsociados = listaVehiculosAsociados;
    }

    /**
     * Calcula el peso total de carga que puede transportar el propietario
     * considerando su vehículo principal y vehículos asociados
     */
    public double calcularPesoTotalCarga() {
        double pesoTotal = 0;

        // Peso del vehículo principal si es de carga
        if (vehiculo instanceof VehiculoCarga) {
            pesoTotal += ((VehiculoCarga) vehiculo).getCapacidadCarga();
        }

        // Peso de los vehículos asociados
        for (VehiculoCarga vehiculoAsociado : listaVehiculosAsociados) {
            pesoTotal += vehiculoAsociado.getCapacidadCarga();
        }

        return pesoTotal;
    }
}