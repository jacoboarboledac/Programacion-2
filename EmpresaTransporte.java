package co.edu.uniquindio.seguimiento1.model;

import java.util.ArrayList;
import java.util.List;

public class EmpresaTransporte {
    private String nombre;

    private List<VehiculoCarga> listaVehiculosCarga = new ArrayList<>();
    private List<VehiculoPasajero> listaVehiculosPasajeros = new ArrayList<>();
    private List<Propietario> listaPropietarios = new ArrayList<>();

    public EmpresaTransporte() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<VehiculoCarga> getListaVehiculosCarga() {
        return listaVehiculosCarga;
    }

    public void setListaVehiculosCarga(List<VehiculoCarga> listaVehiculosCarga) {
        this.listaVehiculosCarga = listaVehiculosCarga;
    }

    public List<VehiculoPasajero> getListaVehiculosPasajeros() {
        return listaVehiculosPasajeros;
    }

    public void setListaVehiculosPasajeros(List<VehiculoPasajero> listaVehiculosPasajeros) {
        this.listaVehiculosPasajeros = listaVehiculosPasajeros;
    }

    public List<Propietario> getListaPropietarios() {
        return listaPropietarios;
    }

    public void setListaPropietarios(List<Propietario> listaPropietarios) {
        this.listaPropietarios = listaPropietarios;
    }

    //  CRUD PARA VEHICULOS DE CARGA

    //crear vehiculo de carga
    public boolean agregarVehiculoCarga(VehiculoCarga vehiculoCarga) {
       if (vehiculoCarga == null){
           return false;
       }
       for (VehiculoCarga vehiculo : listaVehiculosCarga) {
           if(vehiculo.getPlaca().equals(vehiculoCarga.getPlaca())){
               return false;
           }
       }
       listaVehiculosCarga.add(vehiculoCarga);
       return true;
    }

    //Buscar vehiculo de carga por placa
    public VehiculoCarga buscarVehiculoCargaPlaca(String placaVehiculoCarga) {
        if (placaVehiculoCarga == null)
            return null;

        for (VehiculoCarga vehiculoCarga : listaVehiculosCarga) {
            if (vehiculoCarga != null && placaVehiculoCarga.equals(vehiculoCarga.getPlaca())) {
                return vehiculoCarga;
            }
        }
        return null;
    }

    //Eliminar vehiculo de carga
    public boolean eliminarVehiculoCarga(String placaVehiculoCarga) {
        if(placaVehiculoCarga == null){
            return false;
        }
        for (int i = 0; i < listaVehiculosCarga.size(); i++) {
          VehiculoCarga vehiculo = listaVehiculosCarga.get(i);
          if (vehiculo.getPlaca().equals(placaVehiculoCarga)) {
              listaVehiculosCarga.remove(i);
              return true;
          }
        }
        return false;
    }

    //Actualizar vehiculo de carga
    public VehiculoCarga modificarVehiculoCarga(VehiculoCarga vehiculoCargaModificado) {
        if (vehiculoCargaModificado == null || vehiculoCargaModificado.getPlaca() == null){
            return null;
        }
        for (int i = 0; i < listaVehiculosCarga.size(); i++) {
            VehiculoCarga vehiculo = listaVehiculosCarga.get(i);
            if(vehiculo != null && vehiculo.getPlaca() != null &&
                    vehiculo.getPlaca().equals(vehiculoCargaModificado.getPlaca())){
                listaVehiculosCarga.set(i, vehiculoCargaModificado);
                return vehiculoCargaModificado;
            }
        }
        return null;
    }

    //  CRUD PARA VEHICULOS DE PASAJEROS

    //crear vehiculo de pasajeros
    public boolean agregarVehiculoPasajero(VehiculoPasajero vehiculoPasajero) {
        if (vehiculoPasajero == null){
            return false;
        }
        for (VehiculoPasajero vehiculo : listaVehiculosPasajeros) {
            if(vehiculo.getPlaca().equals(vehiculoPasajero.getPlaca())){
                return false;
            }
        }
        listaVehiculosPasajeros.add(vehiculoPasajero);
        return true;
    }

    //Buscar vehiculo de pasajeros por placa
    public VehiculoPasajero buscarVehiculoPasajeroPlaca(String placaVehiculoPasajero) {
        if (placaVehiculoPasajero == null)
            return null;

        for (VehiculoPasajero vehiculoPasajero : listaVehiculosPasajeros) {
            if (vehiculoPasajero != null && placaVehiculoPasajero.equals(vehiculoPasajero.getPlaca())) {
                return vehiculoPasajero;
            }
        }
        return null;
    }

    //Eliminar vehiculo de pasajeros
    public boolean eliminarVehiculoPasajero(String placaVehiculoPasajero) {
        if(placaVehiculoPasajero == null){
            return false;
        }
        for (int i = 0; i < listaVehiculosPasajeros.size(); i++) {
            VehiculoPasajero vehiculo = listaVehiculosPasajeros.get(i);
            if (vehiculo.getPlaca().equals(placaVehiculoPasajero)) {
                listaVehiculosPasajeros.remove(i);
                return true;
            }
        }
        return false;
    }

    //Actualizar vehiculo de pasajeros
    public VehiculoPasajero modificarVehiculoPasajero(VehiculoPasajero vehiculoPasajeroModificado) {
        if (vehiculoPasajeroModificado == null || vehiculoPasajeroModificado.getPlaca() == null){
            return null;
        }
        for (int i = 0; i < listaVehiculosPasajeros.size(); i++) {
            VehiculoPasajero vehiculo = listaVehiculosPasajeros.get(i);
            if(vehiculo != null && vehiculo.getPlaca() != null &&
                    vehiculo.getPlaca().equals(vehiculoPasajeroModificado.getPlaca())){
                listaVehiculosPasajeros.set(i, vehiculoPasajeroModificado);
                return vehiculoPasajeroModificado;
            }
        }
        return null;
    }
    //  CRUD PARA PROPIETARIOS

    //crear propietario
    public boolean agregarPropietario(Propietario propietario) {
        if (propietario == null){
            return false;
        }
        for (Propietario propietario1 : listaPropietarios) {
            if(propietario1.getNumeroID().equals(propietario.getNumeroID())){
                return false;
            }
        }
        listaPropietarios.add(propietario);
        return true;
    }

    //Buscar propietario por id
    public Propietario buscarPropietarioID(String idPropietario) {
        if (idPropietario == null)
            return null;

        for (Propietario propietario : listaPropietarios) {
            if (propietario != null && idPropietario.equals(propietario.getNumeroID())) {
                return propietario;
            }
        }
        return null;
    }

    //Eliminar propietario
    public boolean eliminarPropietario(String idPropietario) {
        if(idPropietario == null){
            return false;
        }
        for (int i = 0; i < listaPropietarios.size(); i++) {
            Propietario propietario = listaPropietarios.get(i);
            if (propietario.getNumeroID().equals(idPropietario)) {
                listaPropietarios.remove(i);
                return true;
            }
        }
        return false;
    }

    //Actualizar propietario
    public Propietario modificarPropietario(Propietario propietarioModificado) {
        if (propietarioModificado == null || propietarioModificado.getNumeroID() == null){
            return null;
        }
        for (int i = 0; i < listaPropietarios.size(); i++) {
            Propietario propietario = listaPropietarios.get(i);
            if(propietario != null && propietario.getNumeroID() != null &&
                    propietario.getNumeroID().equals(propietarioModificado.getNumeroID())){
                listaPropietarios.set(i, propietarioModificado);
                return propietarioModificado;
            }
        }
        return null;
    }

   //Obtener usuario que superan un determinado peso
    public List<Propietario> obtenerPropietariosPorPeso(double pesoMinimo) {
        List<Propietario> propietariosSuperanPeso = new ArrayList<>();

        for (Propietario propietario : listaPropietarios) {
            double pesoTotal = propietario.calcularPesoTotalCarga();
            if (pesoTotal > pesoMinimo) {
                propietariosSuperanPeso.add(propietario);
            }
        }

        return propietariosSuperanPeso;
    }

    //Obtener numero de usuarios movilizados por placa
    public int obtenerUsuariosMovilizadosPorPlaca(String placa) {
        // Buscar en vehículos de pasajeros
        for (VehiculoPasajero vehiculo : listaVehiculosPasajeros) {
            if (vehiculo.getPlaca() != null && vehiculo.getPlaca().equals(placa)) {
                return vehiculo.getUsuariosMovilizados();
            }
        }

        // Buscar en vehículos de propietarios
        for (Propietario propietario : listaPropietarios) {
            if (propietario.getVehiculo() instanceof VehiculoPasajero) {
                VehiculoPasajero vehiculoPasajero = (VehiculoPasajero) propietario.getVehiculo();
                if (vehiculoPasajero.getPlaca() != null && vehiculoPasajero.getPlaca().equals(placa)) {
                    return vehiculoPasajero.getUsuariosMovilizados();
                }
            }
        }

        return 0; // Si no se encuentra el vehículo
    }

   //Obtener numero de propietarios mayores de 40
    public int obtenerPropietariosMayores40() {
        int contador = 0;

        for (Propietario propietario : listaPropietarios) {
            if (propietario.getEdad() > 40) {
                contador++;
            }
        }

        return contador;
    }

    //Metodo para mostrar propietarios que superan un peso
    public void mostrarPropietariosPorPeso(double pesoMinimo) {
        System.out.println("=== PROPIETARIOS QUE SUPERAN " + pesoMinimo + " KG DE CAPACIDAD ===");
        List<Propietario> propietarios = obtenerPropietariosPorPeso(pesoMinimo);

        if (propietarios.isEmpty()) {
            System.out.println("No hay propietarios que superen " + pesoMinimo + " kg de capacidad.");
        } else {
            for (Propietario propietario : propietarios) {
                double pesoTotal = propietario.calcularPesoTotalCarga();
                System.out.println("- " + propietario.getNombre() + " (Capacidad total: " + pesoTotal + " kg)");
            }
        }
        System.out.println();
    }

    //Metodo para mostrar usuarios movilizados por placa
    public void mostrarUsuariosMovilizadosPorPlaca(String placa) {
        System.out.println("=== USUARIOS MOVILIZADOS EN VEHÍCULO CON PLACA: " + placa + " ===");
        int usuarios = obtenerUsuariosMovilizadosPorPlaca(placa);
        System.out.println("Número de usuarios movilizados: " + usuarios);
        System.out.println();
    }

    //Metodo para mostrar propietarios mayores de 40
    public void mostrarPropietariosMayores40() {
        System.out.println("=== PROPIETARIOS MAYORES DE 40 AÑOS ===");
        int cantidad = obtenerPropietariosMayores40();
        System.out.println("Número de propietarios mayores de 40 años: " + cantidad);
        System.out.println();
    }


}