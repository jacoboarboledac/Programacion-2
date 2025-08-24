package co.edu.uniquindio.seguimiento1.model;

public class VehiculoPasajero extends Vehiculo {
    private int numeroMaxPasajeros;
    private int usuariosMovilizados; // Agregado para el requerimiento 2

    public VehiculoPasajero() {
    }

    public VehiculoPasajero(String placa, String modelo, String marca, String color, int numeroMaximoPasajeros) {
        super(placa, modelo, marca, color);
        this.numeroMaxPasajeros = numeroMaximoPasajeros;
        this.usuariosMovilizados = usuariosMovilizados;
    }

    public VehiculoPasajero(String placa, String modelo, String marca, String color, int numeroMaximoPasajeros, int usuariosMovilizados) {
        super(placa, modelo, marca, color);
        this.numeroMaxPasajeros = numeroMaximoPasajeros;
        this.usuariosMovilizados = usuariosMovilizados;
    }

    public int getNumeroMaximoPasajeros() {
        return numeroMaxPasajeros;
    }

    public void setNumeroMaximoPasajeros(int numeroMaximoPasajeros) {
        this.numeroMaxPasajeros = numeroMaximoPasajeros;
    }

    public int getUsuariosMovilizados() {
        return usuariosMovilizados;
    }

    public void setUsuariosMovilizados(int usuariosMovilizados) {
        this.usuariosMovilizados = usuariosMovilizados;
    }

    @Override
    public void encender() {
        System.out.println("Encendiendo vehículo de pasajeros");
    }

    @Override
    public String toString() {
        return "VehiculoPasajero{" +
                "placa='" + getPlaca() + '\'' +
                ", modelo='" + getModelo() + '\'' +
                ", marca='" + getMarca() + '\'' +
                ", color='" + getColor() + '\'' +
                ", numeroMaxPasajeros=" + numeroMaxPasajeros +
                ", usuariosMovilizados=" + usuariosMovilizados +
                '}';
    }
}