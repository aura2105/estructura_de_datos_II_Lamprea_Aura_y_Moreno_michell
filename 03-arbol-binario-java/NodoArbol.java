
/*
 * Proyecto: 03-arbol-binario-java
 * Clase: NodoArbol
 * Descripcion: Representa un nodo de un arbol binario.
 * Cada nodo almacena un dato y dos referencias a sus hijos.
 */

// Se declara una clase generica que puede almacenar diferentes tipos de datos.
public class NodoArbol<T> {

    // Guarda el dato del nodo, en este caso el nombre de un animal.
    private T dato;

    // Referencia al hijo que se encuentra a la izquierda.
    private NodoArbol<T> izquierdo;

    // Referencia al hijo que se encuentra a la derecha.
    private NodoArbol<T> derecho;

    // Constructor que recibe el dato que almacenara el nodo.
    public NodoArbol(T dato) {
        this.dato = dato;

        // Al crear el nodo, inicialmente no tiene hijos.
        this.izquierdo = null;
        this.derecho = null;
    }

    // Devuelve el dato almacenado en el nodo.
    public T getDato() {
        return dato;
    }

    // Devuelve la referencia al hijo izquierdo.
    public NodoArbol<T> getIzquierdo() {
        return izquierdo;
    }

    // Devuelve la referencia al hijo derecho.
    public NodoArbol<T> getDerecho() {
        return derecho;
    }

    // Asigna un nodo como hijo izquierdo.
    public void setIzquierdo(NodoArbol<T> nodo) {
        izquierdo = nodo;
    }

    // Asigna un nodo como hijo derecho.
    public void setDerecho(NodoArbol<T> nodo) {
        derecho = nodo;
    }

    // Imprime el dato de la raiz y los datos de sus hijos directos.
    public void imprimirRaizYHijos() {

        // Muestra el dato del nodo actual.
        System.out.println("Raiz: " + dato);

        // Comprueba que el hijo izquierdo exista antes de acceder a su dato.
        if (izquierdo != null) {
            System.out.println(
                "Hijo izquierdo: " + izquierdo.getDato()
            );
        } else {
            // Se ejecuta cuando no hay hijo izquierdo.
            System.out.println("Hijo izquierdo: no existe");
        }

        // Comprueba que el hijo derecho exista antes de acceder a su dato.
        if (derecho != null) {
            System.out.println(
                "Hijo derecho: " + derecho.getDato()
            );
        } else {
            // Se ejecuta cuando no hay hijo derecho.
            System.out.println("Hijo derecho: no existe");
        }
    }
}
