
public class NodoArbol {

    // Nombre de la fruta almacenada en el nodo
    String fruta;

    // Referencia al hijo izquierdo
    NodoArbol izquierdo;

    // Referencia al hijo derecho
    NodoArbol derecho;

    // Constructor que recibe el nombre de la fruta
    public NodoArbol(String fruta) {
        this.fruta = fruta;

        // Inicialmente el nodo no tiene hijos
        this.izquierdo = null;
        this.derecho = null;
    }
}
