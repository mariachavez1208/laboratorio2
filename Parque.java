import java.util.ArrayList;

public class Parque {

    private String nombre;
    private String codigo;
    private String encargado;
    private PuntoAcceso[] puntosAcceso;
    private ArrayList<Visitante> visitantes;

    public Parque(String nombre, String codigo, String encargado) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.encargado = encargado;
        puntosAcceso = new PuntoAcceso[5];
        visitantes = new ArrayList<Visitante>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getEncargado() {
        return encargado;
    }

    public void habilitarPunto(int posicion, PuntoAcceso punto) {
        validarPosicion(posicion);

        if (puntosAcceso[posicion] != null) {
            throw new IllegalStateException(
                    "La posición ya está ocupada."
            );
        }

        puntosAcceso[posicion] = punto;
    }

    public PuntoAcceso obtenerPunto(int posicion) {
        validarPosicion(posicion);

        if (puntosAcceso[posicion] == null) {
            throw new IllegalStateException(
                    "La posición está vacía."
            );
        }

        return puntosAcceso[posicion];
    }

    public void listarPuntos() {
        boolean existenPuntos = false;

        for (int i = 0; i < puntosAcceso.length; i++) {
            if (puntosAcceso[i] != null) {
                System.out.println(
                        "Posición " + i + ": " + puntosAcceso[i]
                );
                existenPuntos = true;
            }
        }

        if (!existenPuntos) {
            System.out.println(
                    "No hay puntos de acceso habilitados."
            );
        }
    }

    public void modificarPunto(
            int posicion,
            int capacidad,
            Boolean estado
    ) {
        PuntoAcceso punto = obtenerPunto(posicion);
        punto.setCapacidadMaxima(capacidad);
        punto.setEstado(estado);
    }

    public void cerrarPunto(int posicion) {
        obtenerPunto(posicion);
        puntosAcceso[posicion] = null;
    }

    public void registrarVisitante(Visitante visitante) {
        if (buscarVisitante(visitante.getCodigoEntrada()) != null) {
            throw new IllegalArgumentException(
                    "El código de entrada ya está registrado."
            );
        }

        visitantes.add(visitante);
    }

    public void listarVisitantes() {
        if (visitantes.isEmpty()) {
            System.out.println("No hay visitantes registrados.");
        } else {
            for (Visitante visitante : visitantes) {
                System.out.println(visitante);
            }
        }
    }

    public Visitante buscarVisitante(String codigoEntrada) {
        for (Visitante visitante : visitantes) {
            if (visitante.getCodigoEntrada().equals(codigoEntrada)) {
                return visitante;
            }
        }

        return null;
    }

    public void modificarVisitante(
            String codigo,
            String nombre,
            int edad,
            int atracciones,
            int puntos
    ) {
        Visitante visitante = buscarVisitante(codigo);

        if (visitante == null) {
            throw new IllegalStateException(
                    "El visitante no está registrado."
            );
        }

        visitante.setNombre(nombre);
        visitante.setEdad(edad);
        visitante.setAtraccionesVisitadas(atracciones);
        visitante.setPuntosAcumulados(puntos);
    }

    public void eliminarVisitante(String codigo) {
        Visitante visitante = buscarVisitante(codigo);

               if (visitante == null) {
            throw new IllegalStateException(
                    "El visitante no está registrado."
            );
        }

        visitantes.remove(visitante);
    }

    public int contarPuntosHabilitados() {
        int cantidad = 0;

        for (PuntoAcceso punto : puntosAcceso) {
            if (punto != null) {
                cantidad++;
            }
        }

        return cantidad;
    }

    public int contarEspaciosDisponibles() {
        return 5 - contarPuntosHabilitados();
    }

    public PuntoAcceso obtenerPuntoMayorCapacidad() {
        PuntoAcceso mayor = null;

        for (PuntoAcceso punto : puntosAcceso) {
            if (punto != null) {
                if (mayor == null
                        || punto.getCapacidadMaxima()
                        > mayor.getCapacidadMaxima()) {
                    mayor = punto;
                }
            }
        }

        return mayor;
    }

    public Visitante obtenerVisitanteMayorPuntaje() {
        Visitante mayor = null;

        for (Visitante visitante : visitantes) {
            if (mayor == null
                    || visitante.getPuntosAcumulados()
                    > mayor.getPuntosAcumulados()) {
                mayor = visitante;
            }
        }

        return mayor;
    }

    public Visitante obtenerVisitanteMasAtracciones() {
        Visitante mayor = null;

        for (Visitante visitante : visitantes) {
            if (mayor == null
                    || visitante.getAtraccionesVisitadas()
                    > mayor.getAtraccionesVisitadas()) {
                mayor = visitante;
            }
        }

        return mayor;
    }

    public double calcularPromedioEdad() {
        if (visitantes.isEmpty()) {
            return 0;
        }

        int sumaEdades = 0;

        for (Visitante visitante : visitantes) {
            sumaEdades += visitante.getEdad();
        }

        return (double) sumaEdades / visitantes.size();
    }

    public void mostrarReporte() {
        System.out.println("\nREPORTE DEL PARQUE");
        System.out.println("Nombre: " + nombre);
        System.out.println("Código: " + codigo);
        System.out.println("Encargado: " + encargado);
        System.out.println(
                "Puntos habilitados: "
                        + contarPuntosHabilitados()
        );
        System.out.println(
                "Espacios disponibles: "
                        + contarEspaciosDisponibles()
        );

        PuntoAcceso puntoMayor = obtenerPuntoMayorCapacidad();

        if (puntoMayor == null) {
            System.out.println(
                    "Punto con mayor capacidad: No disponible."
            );
        } else {
            System.out.println(
                    "Punto con mayor capacidad: " + puntoMayor
            );
        }

        System.out.println(
                "Visitantes registrados: " + visitantes.size()
        );

        if (visitantes.isEmpty()) {
            System.out.println(
                    "Visitante con más puntos: No disponible."
            );
            System.out.println(
                    "Visitante con más atracciones: No disponible."
            );
            System.out.println(
                    "Promedio de edad: No disponible."
            );
        } else {
            System.out.println(
                    "Visitante con más puntos: "
                            + obtenerVisitanteMayorPuntaje()
            );
            System.out.println(
                    "Visitante con más atracciones: "
                            + obtenerVisitanteMasAtracciones()
            );
            System.out.printf(
                    "Promedio de edad: %.2f%n",
                    calcularPromedioEdad()
            );
        }
    }

    public void validarPosicion(int posicion) {
        if (posicion < 0 || posicion >= 5) {
            throw new IndexOutOfBoundsException(
                    "La posición debe estar entre 0 y 4."
            );
        }
    }
}