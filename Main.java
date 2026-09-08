import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean habilitado = false;

        System.out.println("PARQUE UNIVERSITARIO DE ATRACCIONES");
        System.out.println("\nIngrese la información del parque:");

        System.out.print("Nombre: ");
        String nombreParque = scanner.nextLine();

        System.out.print("Código: ");
        String codigoParque = scanner.nextLine();

        System.out.print("Encargado: ");
        String encargado = scanner.nextLine();

        Parque parque = new Parque(nombreParque, codigoParque, encargado);
        int opcion = 0;

        while (opcion != 12) {
            System.out.println("\nMENÚ PRINCIPAL");
            System.out.println("1. Habilitar punto de acceso");
            System.out.println("2. Consultar puntos de acceso");
            System.out.println("3. Consultar un punto de acceso");
            System.out.println("4. Modificar punto de acceso");
            System.out.println("5. Cerrar punto de acceso");
            System.out.println("6. Registrar visitante");
            System.out.println("7. Consultar visitantes");
            System.out.println("8. Buscar visitante");
            System.out.println("9. Modificar visitante");
            System.out.println("10. Eliminar visitante");
            System.out.println("11. Mostrar reporte del parque");
            System.out.println("12. Salir");

            try {
                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1: {
                        System.out.print("Posición del arreglo (0-4): ");
                        int posicion = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Código del punto: ");
                        String codigo = scanner.nextLine();

                        System.out.print("Nombre del punto: ");
                        String nombre = scanner.nextLine();

                        System.out.print("Ubicación: ");
                        String ubicacion = scanner.nextLine();

                        System.out.print("Capacidad máxima por hora: ");
                        int capacidad = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Estado: ");
                        String estado = scanner.nextLine();

                        if(estado.equals("Habilitado")){
                            habilitado = true;
                        } else if(estado.equals("Deshabilitado")){
                            habilitado = false;
                        } else{
                            habilitado = true;
                        }

                        PuntoAcceso punto = new PuntoAcceso(
                                codigo,
                                nombre,
                                ubicacion,
                                capacidad,
                                estado
                        );

                        parque.habilitarPunto(posicion, punto);
                        System.out.println("Punto de acceso habilitado.");
                        break;
                    }

                    case 2: {
                        parque.listarPuntos();
                        break;
                    }

                    case 3: {
                        System.out.print("Posición del arreglo (0-4): ");
                        int posicion = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println(parque.obtenerPunto(posicion));
                        break;
                    }

                    case 4: {
                        System.out.print("Posición del arreglo (0-4): ");
                        int posicion = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Nueva capacidad: ");
                        int capacidad = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Nuevo estado: ");
                        String estado = scanner.nextLine();

                        if(estado.equals("Habilitado")){
                            habilitado = true;
                        } else if(estado.equals("Deshabilitado")){
                            habilitado = false;
                        } else{
                            habilitado = true;
                        }

                        parque.modificarPunto(posicion, capacidad, habilitado);
                        System.out.println("Punto de acceso modificado.");
                        break;
                    }

                    case 5: {
                        System.out.print("Posición del arreglo (0-4): ");
                        int posicion = scanner.nextInt();
                        scanner.nextLine();

                        parque.cerrarPunto(posicion);
                        System.out.println("Punto de acceso cerrado.");
                        break;
                    }

                    case 6: {
                        System.out.print("Código de entrada: ");
                        String codigo = scanner.nextLine();

                        System.out.print("Nombre: ");
                        String nombre = scanner.nextLine();

                        System.out.print("Edad: ");
                        int edad = scanner.nextInt();

                        System.out.print("Atracciones visitadas: ");
                        int atracciones = scanner.nextInt();

                        System.out.print("Puntos acumulados: ");
                        int puntos = scanner.nextInt();
                        scanner.nextLine();

                        Visitante visitante = new Visitante(
                                codigo,
                                nombre,
                                edad,
                                atracciones,
                                puntos
                        );

                        parque.registrarVisitante(visitante);
                        System.out.println("Visitante registrado.");
                        break;
                    }

                    case 7: {
                        parque.listarVisitantes();
                        break;
                    }

                    case 8: {
                        System.out.print("Código de entrada: ");
                        String codigo = scanner.nextLine();

                        Visitante visitante = parque.buscarVisitante(codigo);

                        if (visitante == null) {
                            System.out.println("Visitante no encontrado.");
                        } else {
                            System.out.println(visitante);
                        }

                        break;
                    }

                    case 9: {
                        System.out.print("Código del visitante: ");
                        String codigo = scanner.nextLine();

                        System.out.print("Nuevo nombre: ");
                        String nombre = scanner.nextLine();

                        System.out.print("Nueva edad: ");
                        int edad = scanner.nextInt();

                        System.out.print("Nueva cantidad de atracciones: ");
                        int atracciones = scanner.nextInt();

                        System.out.print("Nuevos puntos: ");
                        int puntos = scanner.nextInt();
                        scanner.nextLine();

                        parque.modificarVisitante(
                                codigo,
                                nombre,
                                edad,
                                atracciones,
                                puntos
                        );

                        System.out.println("Visitante modificado.");
                        break;
                    }

                    case 10: {
                        System.out.print("Código del visitante: ");
                        String codigo = scanner.nextLine();

                        parque.eliminarVisitante(codigo);
                        System.out.println("Visitante eliminado.");
                        break;
                    }

                    case 11: {
                        parque.mostrarReporte();
                        break;
                    }

                    case 12: {
                        System.out.println("Programa finalizado.");
                        break;
                    }

                    default: {
                        System.out.println("Opción inválida.");
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un número entero.");
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println("Dato inválido: " + e.getMessage());
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Posición inválida: " + e.getMessage());
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            } finally {
                System.out.println("----------------------------------------");
            }
        }

        scanner.close();
    }
}