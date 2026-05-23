import java.io.Serializable;

public class PartidoPadel implements Serializable {
    private String nombre1, nombre2, marcador;

    public PartidoPadel(String nombre1, String nombre2, String marcador) {
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.marcador = marcador;
    }

    public String getNombre1() {
        return nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public String getMarcador() {
        return marcador;
    }
}