package co.edu.uniquindio.seguimiento1.factory;

import co.edu.uniquindio.seguimiento1.model.EmpresaTransporte;
import co.edu.uniquindio.seguimiento1.model.Propietario;
import co.edu.uniquindio.seguimiento1.model.VehiculoCarga;
import co.edu.uniquindio.seguimiento1.model.VehiculoPasajero;

public class ModelFactory {
    private static ModelFactory instance;

    EmpresaTransporte empresaTransporte;

    private ModelFactory() {
    }

    public static ModelFactory getInstance() {
        if (instance == null) {
            instance = new ModelFactory();
        }
        return instance;
    }

    public EmpresaTransporte inicializarDatos() {
        EmpresaTransporte empresa = new EmpresaTransporte();
        empresa.setNombre("La carreta");

        // Crear vehículos de carga
        VehiculoCarga vehiculoCarga = new VehiculoCarga("ABC123", "Volvo", "FH", "Blanco", 350, 3);
        VehiculoCarga vehiculoCarga2 = new VehiculoCarga("DEF456", "Mercedes", "Actros", "Azul", 200, 2);
        VehiculoCarga vehiculoCarga3 = new VehiculoCarga("GHI789", "Scania", "R500", "Rojo", 400, 4);

        // Crear vehículos de pasajeros
        VehiculoPasajero vehiculoPasajero1 = new VehiculoPasajero("XYZ111", "Mercedes", "Sprinter", "Blanco", 25, 150);
        VehiculoPasajero vehiculoPasajero2 = new VehiculoPasajero("XYZ222", "Ford", "Transit", "Gris", 15, 89);
        VehiculoPasajero vehiculoPasajero3 = new VehiculoPasajero("XYZ333", "Iveco", "Daily", "Negro", 20, 200);

        // Crear propietarios con edades variadas
        Propietario propietario1 = new Propietario("Juan Pérez", "12345678", "juan@email.com", "300-123-4567", 45, vehiculoCarga);
        propietario1.getListaVehiculosAsociados().add(vehiculoCarga2);

        Propietario propietario2 = new Propietario("María González", "87654321", "maria@email.com", "300-987-6543", 35, vehiculoPasajero1);

        Propietario propietario3 = new Propietario("Carlos Rodríguez", "11111111", "carlos@email.com", "300-111-1111", 50, vehiculoCarga3);

        Propietario propietario4 = new Propietario("Ana López", "22222222", "ana@email.com", "300-222-2222", 28, vehiculoPasajero2);

        // Agregar vehículos a las listas de la empresa
        empresa.getListaVehiculosCarga().add(vehiculoCarga);
        empresa.getListaVehiculosCarga().add(vehiculoCarga2);
        empresa.getListaVehiculosCarga().add(vehiculoCarga3);

        empresa.getListaVehiculosPasajeros().add(vehiculoPasajero1);
        empresa.getListaVehiculosPasajeros().add(vehiculoPasajero2);
        empresa.getListaVehiculosPasajeros().add(vehiculoPasajero3);

        // Agregar propietarios a la empresa
        empresa.getListaPropietarios().add(propietario1);
        empresa.getListaPropietarios().add(propietario2);
        empresa.getListaPropietarios().add(propietario3);
        empresa.getListaPropietarios().add(propietario4);

        this.empresaTransporte = empresa;
        return empresa;
    }

    public EmpresaTransporte getEmpresaTransporte() {
        return empresaTransporte;
    }

}