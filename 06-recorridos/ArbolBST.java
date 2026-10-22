
import java.util.LinkedList;
import java.util.Queue;

public class ArbolBST {

    // Nodo principal del árbol
    NodoArbol raiz;

    // Constructor del árbol vacío
    public ArbolBST() {
        raiz = null;
    }

    // Método para insertar una fruta
    public void insertar(String fruta) {
        raiz = insertarRecursivo(raiz, fruta);
    }

    // Busca la posición correcta para insertar la fruta
    private NodoArbol insertarRecursivo(
            NodoArbol actual, String fruta) {

        // Si el espacio está vacío, crea un nodo
        if (actual == null) {
            return new NodoArbol(fruta);
        }

        // Compara alfabéticamente las frutas
        int comparacion = fruta.compareToIgnoreCase(actual.fruta);

        // Si es menor alfabéticamente, va a la izquierda
        if (comparacion < 0) {
            actual.izquierdo =
                    insertarRecursivo(actual.izquierdo, fruta);
        }

        // Si es mayor alfabéticamente, va a la derecha
        else if (comparacion > 0) {
            actual.derecho =
                    insertarRecursivo(actual.derecho, fruta);
        }

        // No permite insertar frutas repetidas
        return actual;
    }

    // PREORDEN: raíz, izquierda, derecha
    public void preorden(NodoArbol nodo) {

        // Si el nodo está vacío, termina
        if (nodo == null) {
            return;
        }

        // Primero muestra la fruta actual
        System.out.print(nodo.fruta + " - ");

        // Después recorre la izquierda
        preorden(nodo.izquierdo);

        // Finalmente recorre la derecha
        preorden(nodo.derecho);
    }

    // INORDEN: izquierda, raíz, derecha
    public void inorden(NodoArbol nodo) {

        if (nodo == null) {
            return;
        }

        // Recorre primero las frutas de la izquierda
        inorden(nodo.izquierdo);

        // Muestra la fruta actual
        System.out.print(nodo.fruta + " - ");

        // Recorre las frutas de la derecha
        inorden(nodo.derecho);
    }

    // POSTORDEN: izquierda, derecha, raíz
    public void postorden(NodoArbol nodo) {

        if (nodo == null) {
            return;
        }

        // Primero recorre la izquierda
        postorden(nodo.izquierdo);

        // Después recorre la derecha
        postorden(nodo.derecho);

        // Muestra la fruta al final
        System.out.print(nodo.fruta + " - ");
    }

    // RECORRIDO POR NIVELES usando una cola
    public void porNiveles(NodoArbol raiz) {

        // Si el árbol está vacío, termina
        if (raiz == null) {
            return;
        }

        // Crea una cola para organizar los nodos
        Queue<NodoArbol> cola = new LinkedList<>();

        // Agrega primero la raíz
        cola.add(raiz);

        // Repite mientras existan nodos en la cola
        while (!cola.isEmpty()) {

            // Extrae el primer nodo de la cola
            NodoArbol actual = cola.poll();

            // Muestra la fruta
            System.out.print(actual.fruta + " - ");

            // Agrega el hijo izquierdo si existe
            if (actual.izquierdo != null) {
                cola.add(actual.izquierdo);
            }

            // Agrega el hijo derecho si existe
            if (actual.derecho != null) {
                cola.add(actual.derecho);
            }
        }
    }

    // Devuelve la raíz para utilizarla desde Main
    public NodoArbol getRaiz() {
        return raiz;
    }
}
