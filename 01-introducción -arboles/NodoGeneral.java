
import java.util.ArrayList;      // Permite crear listas dinámicas.
import java.util.Collections;    // Permite obtener una lista no modificable.
import java.util.List;           // Permite trabajar con listas.

 /**
  * Clase genérica que representa un nodo del árbol.
  * Cada nodo almacena un dato y una lista de nodos hijos.
  */
public class NodoGeneral<T> {

    // Guarda el dato o nombre que tendrá el nodo.
    // final significa que la referencia no se puede reasignar.
    private final T dato;

    // Guarda la lista de hijos que pertenecen a este nodo.
    private final List<NodoGeneral<T>> hijos;

    // Constructor: se ejecuta cuando creamos un nuevo nodo.
    public NodoGeneral(T dato) {

        // Guardamos el dato recibido en el atributo del nodo.
        this.dato = dato;

        // Inicializamos la lista de hijos vacía.
        this.hijos = new ArrayList<>();
    }

    // Método para agregar un nodo hijo al nodo actual.
    public void agregarHijo(NodoGeneral<T> hijo) {

        // Verificamos que el nodo hijo no sea null.
        if (hijo == null) {

            // Si es null, mostramos un error y no lo agregamos.
            throw new IllegalArgumentException(
                "El nodo hijo no puede ser null."
            );
        }

        // Agregamos el hijo a la lista del nodo actual.
        hijos.add(hijo);
    }

    // Método que devuelve el dato almacenado en el nodo.
    public T getDato() {
        return dato;
    }

    // Método que permite consultar la lista de hijos.
    public List<NodoGeneral<T>> getHijos() {

        // Devolvemos una vista que no permite modificar
        // directamente la lista original de hijos.
        return Collections.unmodifiableList(hijos);
    }

    // Método que verifica si el nodo no tiene hijos.
    public boolean esHoja() {

        // Devuelve true si la lista está vacía;
        // de lo contrario, devuelve false.
        return hijos.isEmpty();
    }
}
