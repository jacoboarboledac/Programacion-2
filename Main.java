package co.edu.uniquindio.seguimiento1;

import co.edu.uniquindio.seguimiento1.factory.ModelFactory;
import co.edu.uniquindio.seguimiento1.model.*;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static ModelFactory modelFactory = ModelFactory.getInstance();
    private static EmpresaTransporte empresaTransporte;

    public static void main(String[] args) {
        empresaTransporte = modelFactory.inicializarDatos();

        System.out.println(" SISTEMA DE " + empresaTransporte.getNombre() + " ===\n");

        mostrarMenu();
    }

    private static void mostrarMenu() {
        int opcion;
        do {
            System.out.println(" MENÚ PRINCIPAL");
            System.out.println("1. Gestión de Vehículos de Carga");
            System.out.println("2. Gestión de Vehículos de Pasajeros");
            System.out.println("3. Gestión de Propietarios");
            System.out.println("4. Consultas y Reportes");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    menuVehiculosCarga();
                    break;
                case 2:
                    menuVehiculosPasajeros();
                    break;
                case 3:
                    menuPropietarios();
                    break;
                case 4:
                    menuConsultasReportes();
                    break;
                case 0:
                    System.out.println("¡Gracias por usar el sistema!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 0);
    }

    //  MENÚ VEHÍCULOS DE CARGA
    private static void menuVehiculosCarga() {
        int opcion;
        do {
            System.out.println("\n=== GESTIÓN DE VEHÍCULOS DE CARGA ===");
            System.out.println("1. Crear vehículo de carga");
            System.out.println("2. Buscar vehículo de carga");
            System.out.println("3. Modificar vehículo de carga");
            System.out.println("4. Eliminar vehículo de carga");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    crearVehiculoCarga();
                    break;
                case 2:
                    buscarVehiculoCarga();
                    break;
                case 3:
                    modificarVehiculoCarga();
                    break;
                case 4:
                    eliminarVehiculoCarga();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    private static void crearVehiculoCarga() {
        System.out.println("\n--- Crear Vehículo de Carga ---");
        System.out.print("Placa: ");
        String placa = scanner.nextLine();
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Color: ");
        String color = scanner.nextLine();
        System.out.print("Capacidad de carga (kg): ");
        double capacidad = scanner.nextDouble();
        System.out.print("Número de ejes: ");
        int numeroEjes = scanner.nextInt();
        scanner.nextLine();

        VehiculoCarga vehiculo = new VehiculoCarga(placa, modelo, marca, color, capacidad, numeroEjes);

        if (empresaTransporte.agregarVehiculoCarga(vehiculo)) {
            System.out.println("✓ Vehículo de carga creado exitosamente.");
        } else {
            System.out.println("✗ Error: No se pudo crear el vehículo (posible placa duplicada).");
        }
    }

    private static void buscarVehiculoCarga() {
        System.out.println("\n--- Buscar Vehículo de Carga ---");
        System.out.print("Ingrese la placa: ");
        String placa = scanner.nextLine();

        VehiculoCarga vehiculo = empresaTransporte.buscarVehiculoCargaPlaca(placa);
        if (vehiculo != null) {
            System.out.println("Vehículo encontrado:");
            System.out.println("Placa: " + vehiculo.getPlaca());
            System.out.println("Marca: " + vehiculo.getMarca());
            System.out.println("Modelo: " + vehiculo.getModelo());
            System.out.println("Color: " + vehiculo.getColor());
            System.out.println("Capacidad: " + vehiculo.getCapacidadCarga() + " kg");
            System.out.println("Ejes: " + vehiculo.getNumeroEjes());
        } else {
            System.out.println("✗ No se encontró el vehículo con placa: " + placa);
        }
    }

    private static void modificarVehiculoCarga() {
        System.out.println("\n--- Modificar Vehículo de Carga ---");
        System.out.print("Ingrese la placa del vehículo a modificar: ");
        String placa = scanner.nextLine();

        VehiculoCarga vehiculoExistente = empresaTransporte.buscarVehiculoCargaPlaca(placa);
        if (vehiculoExistente == null) {
            System.out.println("✗ No se encontró el vehículo con placa: " + placa);
            return;
        }

        System.out.print("Nueva marca (" + vehiculoExistente.getMarca() + "): ");
        String marca = scanner.nextLine();
        if (!marca.trim().isEmpty()) vehiculoExistente.setMarca(marca);

        System.out.print("Nuevo modelo (" + vehiculoExistente.getModelo() + "): ");
        String modelo = scanner.nextLine();
        if (!modelo.trim().isEmpty()) vehiculoExistente.setModelo(modelo);

        System.out.print("Nuevo color (" + vehiculoExistente.getColor() + "): ");
        String color = scanner.nextLine();
        if (!color.trim().isEmpty()) vehiculoExistente.setColor(color);

        System.out.print("Nueva capacidad (" + vehiculoExistente.getCapacidadCarga() + "): ");
        String capacidadStr = scanner.nextLine();
        if (!capacidadStr.trim().isEmpty()) {
            vehiculoExistente.setCapacidadCarga(Double.parseDouble(capacidadStr));
        }

        System.out.print("Nuevo número de ejes (" + vehiculoExistente.getNumeroEjes() + "): ");
        String ejesStr = scanner.nextLine();
        if (!ejesStr.trim().isEmpty()) {
            vehiculoExistente.setNumeroEjes(Integer.parseInt(ejesStr));
        }

        VehiculoCarga resultado = empresaTransporte.modificarVehiculoCarga(vehiculoExistente);
        if (resultado != null) {
            System.out.println("✓ Vehículo modificado exitosamente.");
        } else {
            System.out.println("✗ Error al modificar el vehículo.");
        }
    }

    private static void eliminarVehiculoCarga() {
        System.out.println("\n--- Eliminar Vehículo de Carga ---");
        System.out.print("Ingrese la placa del vehículo a eliminar: ");
        String placa = scanner.nextLine();

        if (empresaTransporte.eliminarVehiculoCarga(placa)) {
            System.out.println("✓ Vehículo eliminado exitosamente.");
        } else {
            System.out.println("✗ No se encontró el vehículo con placa: " + placa);
        }
    }

    // === MENÚ VEHÍCULOS DE PASAJEROS ===
    private static void menuVehiculosPasajeros() {
        int opcion;
        do {
            System.out.println("\n=== GESTIÓN DE VEHÍCULOS DE PASAJEROS ===");
            System.out.println("1. Crear vehículo de pasajeros");
            System.out.println("2. Buscar vehículo de pasajeros");
            System.out.println("3. Modificar vehículo de pasajeros");
            System.out.println("4. Eliminar vehículo de pasajeros");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    crearVehiculoPasajeros();
                    break;
                case 2:
                    buscarVehiculoPasajeros();
                    break;
                case 3:
                    modificarVehiculoPasajeros();
                    break;
                case 4:
                    eliminarVehiculoPasajeros();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    private static void crearVehiculoPasajeros() {
        System.out.println("\n--- Crear Vehículo de Pasajeros ---");
        System.out.print("Placa: ");
        String placa = scanner.nextLine();
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Color: ");
        String color = scanner.nextLine();
        System.out.print("Número máximo de pasajeros: ");
        int maxPasajeros = scanner.nextInt();
        System.out.print("Usuarios movilizados: ");
        int usuariosMovilizados = scanner.nextInt();
        scanner.nextLine();

        VehiculoPasajero vehiculo = new VehiculoPasajero(placa, modelo, marca, color, maxPasajeros, usuariosMovilizados);

        if (empresaTransporte.agregarVehiculoPasajero(vehiculo)) {
            System.out.println("✓ Vehículo de pasajeros creado exitosamente.");
        } else {
            System.out.println("✗ Error: No se pudo crear el vehículo (posible placa duplicada).");
        }
    }

    private static void buscarVehiculoPasajeros() {
        System.out.println("\n--- Buscar Vehículo de Pasajeros ---");
        System.out.print("Ingrese la placa: ");
        String placa = scanner.nextLine();

        VehiculoPasajero vehiculo = empresaTransporte.buscarVehiculoPasajeroPlaca(placa);
        if (vehiculo != null) {
            System.out.println("Vehículo encontrado:");
            System.out.println("Placa: " + vehiculo.getPlaca());
            System.out.println("Marca: " + vehiculo.getMarca());
            System.out.println("Modelo: " + vehiculo.getModelo());
            System.out.println("Color: " + vehiculo.getColor());
            System.out.println("Máx. pasajeros: " + vehiculo.getNumeroMaximoPasajeros());
            System.out.println("Usuarios movilizados: " + vehiculo.getUsuariosMovilizados());
        } else {
            System.out.println("✗ No se encontró el vehículo con placa: " + placa);
        }
    }

    private static void modificarVehiculoPasajeros() {
        System.out.println("\n--- Modificar Vehículo de Pasajeros ---");
        System.out.print("Ingrese la placa del vehículo a modificar: ");
        String placa = scanner.nextLine();

        VehiculoPasajero vehiculoExistente = empresaTransporte.buscarVehiculoPasajeroPlaca(placa);
        if (vehiculoExistente == null) {
            System.out.println("✗ No se encontró el vehículo con placa: " + placa);
            return;
        }

        System.out.print("Nueva marca (" + vehiculoExistente.getMarca() + "): ");
        String marca = scanner.nextLine();
        if (!marca.trim().isEmpty()) vehiculoExistente.setMarca(marca);

        System.out.print("Nuevo modelo (" + vehiculoExistente.getModelo() + "): ");
        String modelo = scanner.nextLine();
        if (!modelo.trim().isEmpty()) vehiculoExistente.setModelo(modelo);

        System.out.print("Nuevo color (" + vehiculoExistente.getColor() + "): ");
        String color = scanner.nextLine();
        if (!color.trim().isEmpty()) vehiculoExistente.setColor(color);

        System.out.print("Nuevo máximo de pasajeros (" + vehiculoExistente.getNumeroMaximoPasajeros() + "): ");
        String maxPasajerosStr = scanner.nextLine();
        if (!maxPasajerosStr.trim().isEmpty()) {
            vehiculoExistente.setNumeroMaximoPasajeros(Integer.parseInt(maxPasajerosStr));
        }

        System.out.print("Nuevos usuarios movilizados (" + vehiculoExistente.getUsuariosMovilizados() + "): ");
        String usuariosStr = scanner.nextLine();
        if (!usuariosStr.trim().isEmpty()) {
            vehiculoExistente.setUsuariosMovilizados(Integer.parseInt(usuariosStr));
        }

        VehiculoPasajero resultado = empresaTransporte.modificarVehiculoPasajero(vehiculoExistente);
        if (resultado != null) {
            System.out.println("✓ Vehículo modificado exitosamente.");
        } else {
            System.out.println("✗ Error al modificar el vehículo.");
        }
    }

    private static void eliminarVehiculoPasajeros() {
        System.out.println("\n--- Eliminar Vehículo de Pasajeros ---");
        System.out.print("Ingrese la placa del vehículo a eliminar: ");
        String placa = scanner.nextLine();

        if (empresaTransporte.eliminarVehiculoPasajero(placa)) {
            System.out.println("✓ Vehículo eliminado exitosamente.");
        } else {
            System.out.println("✗ No se encontró el vehículo con placa: " + placa);
        }
    }

    // === MENÚ PROPIETARIOS ===
    private static void menuPropietarios() {
        int opcion;
        do {
            System.out.println("\n=== GESTIÓN DE PROPIETARIOS ===");
            System.out.println("1. Crear propietario");
            System.out.println("2. Buscar propietario");
            System.out.println("3. Modificar propietario");
            System.out.println("4. Eliminar propietario");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    crearPropietario();
                    break;
                case 2:
                    buscarPropietario();
                    break;
                case 3:
                    modificarPropietario();
                    break;
                case 4:
                    eliminarPropietario();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    private static void crearPropietario() {
        System.out.println("\n--- Crear Propietario ---");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Número de ID: ");
        String numeroID = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Número celular: ");
        String celular = scanner.nextLine();
        System.out.print("Edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese la placa del vehículo principal: ");
        String placaVehiculo = scanner.nextLine();

        // Buscar el vehículo
        Vehiculo vehiculo = empresaTransporte.buscarVehiculoCargaPlaca(placaVehiculo);
        if (vehiculo == null) {
            vehiculo = empresaTransporte.buscarVehiculoPasajeroPlaca(placaVehiculo);
        }

        if (vehiculo == null) {
            System.out.println("✗ No se encontró un vehículo con la placa: " + placaVehiculo);
            return;
        }

        Propietario propietario = new Propietario(nombre, numeroID, email, celular, edad, vehiculo);

        if (empresaTransporte.agregarPropietario(propietario)) {
            System.out.println("✓ Propietario creado exitosamente.");
        } else {
            System.out.println("✗ Error: No se pudo crear el propietario (posible ID duplicado).");
        }
    }

    private static void buscarPropietario() {
        System.out.println("\n--- Buscar Propietario ---");
        System.out.print("Ingrese el número de ID: ");
        String numeroID = scanner.nextLine();

        Propietario propietario = empresaTransporte.buscarPropietarioID(numeroID);
        if (propietario != null) {
            System.out.println("Propietario encontrado:");
            System.out.println("Nombre: " + propietario.getNombre());
            System.out.println("ID: " + propietario.getNumeroID());
            System.out.println("Email: " + propietario.getEmail());
            System.out.println("Celular: " + propietario.getNumeroCelular());
            System.out.println("Edad: " + propietario.getEdad());
            System.out.println("Vehículo principal: " + propietario.getVehiculo().getPlaca());
            System.out.println("Peso total de carga: " + propietario.calcularPesoTotalCarga() + " kg");
        } else {
            System.out.println("✗ No se encontró el propietario con ID: " + numeroID);
        }
    }

    private static void modificarPropietario() {
        System.out.println("\n--- Modificar Propietario ---");
        System.out.print("Ingrese el ID del propietario a modificar: ");
        String numeroID = scanner.nextLine();

        Propietario propietarioExistente = empresaTransporte.buscarPropietarioID(numeroID);
        if (propietarioExistente == null) {
            System.out.println("✗ No se encontró el propietario con ID: " + numeroID);
            return;
        }

        System.out.print("Nuevo nombre (" + propietarioExistente.getNombre() + "): ");
        String nombre = scanner.nextLine();
        if (!nombre.trim().isEmpty()) propietarioExistente.setNombre(nombre);

        System.out.print("Nuevo email (" + propietarioExistente.getEmail() + "): ");
        String email = scanner.nextLine();
        if (!email.trim().isEmpty()) propietarioExistente.setEmail(email);

        System.out.print("Nuevo celular (" + propietarioExistente.getNumeroCelular() + "): ");
        String celular = scanner.nextLine();
        if (!celular.trim().isEmpty()) propietarioExistente.setNumeroCelular(celular);

        System.out.print("Nueva edad (" + propietarioExistente.getEdad() + "): ");
        String edadStr = scanner.nextLine();
        if (!edadStr.trim().isEmpty()) {
            propietarioExistente.setEdad(Integer.parseInt(edadStr));
        }

        Propietario resultado = empresaTransporte.modificarPropietario(propietarioExistente);
        if (resultado != null) {
            System.out.println("✓ Propietario modificado exitosamente.");
        } else {
            System.out.println("✗ Error al modificar el propietario.");
        }
    }

    private static void eliminarPropietario() {
        System.out.println("\n--- Eliminar Propietario ---");
        System.out.print("Ingrese el ID del propietario a eliminar: ");
        String numeroID = scanner.nextLine();

        if (empresaTransporte.eliminarPropietario(numeroID)) {
            System.out.println("✓ Propietario eliminado exitosamente.");
        } else {
            System.out.println("✗ No se encontró el propietario con ID: " + numeroID);
        }
    }

    // === MENÚ CONSULTAS Y REPORTES ===
    private static void menuConsultasReportes() {
        int opcion;
        do {
            System.out.println("\n=== CONSULTAS Y REPORTES ===");
            System.out.println("1. Propietarios que superan un peso determinado");
            System.out.println("2. Usuarios movilizados por placa de vehículo");
            System.out.println("3. Propietarios mayores de 40 años");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    consultarPropietariosPorPeso();
                    break;
                case 2:
                    consultarUsuariosPorPlaca();
                    break;
                case 3:
                    consultarPropietariosMayores40();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    private static void consultarPropietariosPorPeso() {
        System.out.print("Ingrese el peso mínimo (kg): ");
        double pesoMinimo = scanner.nextDouble();
        scanner.nextLine();
        empresaTransporte.mostrarPropietariosPorPeso(pesoMinimo);
    }

    private static void consultarUsuariosPorPlaca() {
        System.out.print("Ingrese la placa del vehículo: ");
        String placa = scanner.nextLine();
        empresaTransporte.mostrarUsuariosMovilizadosPorPlaca(placa);
    }

    private static void consultarPropietariosMayores40() {
        empresaTransporte.mostrarPropietariosMayores40();
    }
}