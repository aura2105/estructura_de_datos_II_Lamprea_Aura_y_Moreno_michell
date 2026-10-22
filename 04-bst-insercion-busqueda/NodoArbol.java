
public class NodoArbol<T> {

    // Letra o dato que almacena el nodo
    private T dato;

    // Referencia al hijo izquierdo
    private NodoArbol<T> izquierdo;

    // Referencia al hijo derecho
    private NodoArbol<T> derecho;

    // Constructor del nodo
    public NodoArbol(T dato) {
        this.dato = dato;
    }

    public T getDato() {
        return dato;
    }

    public NodoArbol<T> getIzquierdo() {
        return izquierdo;
    }

    public NodoArbol<T> getDerecho() {
        return derecho;
    }

    public void setIzquierdo(NodoArbol<T> izquierdo) {
        this.izquierdo = izquierdo;
    }

    public void setDerecho(NodoArbol<T> derecho) {
        this.derecho = derecho;
    }
}
