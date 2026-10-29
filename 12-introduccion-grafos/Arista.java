
public class Arista {

    String origen;
    String destino;
    double peso;
    boolean dirigida;

    // Constructor de la arista
    public Arista(String o, String d, double p, boolean dir) {
        origen = o;
        destino = d;
        peso = p;
        dirigida = dir;
    }

    // Muestra la conexion entre estudiantes
    public void mostrar() {
        String tipo;

        if (dirigida) {
            tipo = "dirigida";
        } else {
            tipo = "no dirigida";
        }

        System.out.println(
            origen + " -> " + destino
            + " | Interaccion: " + peso
            + " | " + tipo
        );
    }
}
