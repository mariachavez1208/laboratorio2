
public class PuntoAcceso {
    private String codigo;
    private String nombre;
    private String ubicacion;
    private int capacidadMaxima;
    private Boolean habilitado = false;

    public PuntoAcceso(String codigo, String nombre, String ubicacion,
                       int capacidadMaxima, String estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        setCapacidadMaxima(capacidadMaxima);
        setEstado(habilitado);
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public Boolean getEstado() {
        return habilitado;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        if (capacidadMaxima <= 0) {
            throw new IllegalArgumentException(
                    "La capacidad máxima debe ser mayor que 0.");
        }
        this.capacidadMaxima = capacidadMaxima;
    }

    public void setEstado(boolean estado) {
        this.habilitado = estado;
    }

    @Override
    public String toString() {
        return "PuntoAcceso{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", capacidadMaxima=" + capacidadMaxima +
                '}';
    }
}
