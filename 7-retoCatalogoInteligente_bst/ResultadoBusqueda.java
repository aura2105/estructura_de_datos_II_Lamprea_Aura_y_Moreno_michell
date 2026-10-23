
public class ResultadoBusqueda {

    // Producto encontrado; será null si no existe.
    private final Producto producto;

    // Número de nodos comparados durante la búsqueda.
    private final int comparaciones;

    // Camino recorrido dentro del árbol.
    private final String camino;

    // Constructor del resultado de búsqueda.
    public ResultadoBusqueda(Producto producto,
                             int comparaciones,
                             String camino) {
        this.producto = producto;
        this.comparaciones = comparaciones;
        this.camino = camino;
    }

    // Indica si se encontró el producto.
    public boolean encontrado() {
        return producto != null;
    }

    // Devuelve el producto encontrado.
    public Producto getProducto() {
        return producto;
    }

    // Devuelve el número de comparaciones.
    public int getComparaciones() {
        return comparaciones;
    }

    // Devuelve el camino recorrido.
    public String getCamino() {
        return camino;
    }
}
