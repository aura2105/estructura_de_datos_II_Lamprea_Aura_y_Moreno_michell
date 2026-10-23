
public class NodoProducto {

    // Producto almacenado en este nodo.
    private Producto producto;

    // Referencia al hijo izquierdo.
    private NodoProducto izquierdo;

    // Referencia al hijo derecho.
    private NodoProducto derecho;

    // Constructor: crea un nodo con un producto.
    public NodoProducto(Producto producto) {
        this.producto = producto;
    }

    // Obtiene el producto del nodo.
    public Producto getProducto() {
        return producto;
    }

    // Obtiene el hijo izquierdo.
    public NodoProducto getIzquierdo() {
        return izquierdo;
    }

    // Obtiene el hijo derecho.
    public NodoProducto getDerecho() {
        return derecho;
    }

    // Asigna el hijo izquierdo.
    public void setIzquierdo(NodoProducto izquierdo) {
        this.izquierdo = izquierdo;
    }

    // Asigna el hijo derecho.
    public void setDerecho(NodoProducto derecho) {
        this.derecho = derecho;
    }
}
