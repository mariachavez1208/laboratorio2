
public class Visitante {
    private String codigoEntrada;
    private String nombre;
    private int edad;
    private int atraccionesVisitadas;
    private int puntosAcumulados;

    public Visitante(String codigoEntrada, String nombre, int edad,
                     int atraccionesVisitadas, int puntosAcumulados) {
        this.codigoEntrada = codigoEntrada;
        this.nombre = nombre;
        setEdad(edad);
        setAtraccionesVisitadas(atraccionesVisitadas);
        setPuntosAcumulados(puntosAcumulados);
    }

    public String getCodigoEntrada() {
        return codigoEntrada;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public int getAtraccionesVisitadas() {
        return atraccionesVisitadas;
    }

    public int getPuntosAcumulados() {
        return puntosAcumulados;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        if (edad <= 0) {
            throw new IllegalArgumentException("La edad debe ser mayor que 0.");
        }
        this.edad = edad;
    }

    public void setAtraccionesVisitadas(int atraccionesVisitadas) {
        if (atraccionesVisitadas < 0) {
            throw new IllegalArgumentException(
                    "La cantidad de atracciones visitadas no puede ser negativa.");
        }
        this.atraccionesVisitadas = atraccionesVisitadas;
    }

    public void setPuntosAcumulados(int puntosAcumulados) {
        if (puntosAcumulados < 0) {
            throw new IllegalArgumentException(
                    "Los puntos acumulados no pueden ser negativos.");
        }
        this.puntosAcumulados = puntosAcumulados;
    }

    @Override
    public String toString() {
        return "Visitante{" +
                "codigoEntrada='" + codigoEntrada + '\'' +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", atraccionesVisitadas=" + atraccionesVisitadas +
                ", puntosAcumulados=" + puntosAcumulados +
                '}';
    }
}
