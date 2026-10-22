
public class ArbolBST {

    private NodoArbol<String> raiz;

    public ArbolBST() {
        raiz = null;
    }

    // Insertar una letra
    public void insertar(String letra) {
        raiz = insertarRec(raiz, letra);
    }

    private NodoArbol<String> insertarRec(
            NodoArbol<String> nodo, String letra) {

        if (nodo == null) {
            return new NodoArbol<>(letra);
        }

        int comparacion = letra.compareTo(nodo.getDato());

        if (comparacion < 0) {
            nodo.setIzquierdo(
                insertarRec(nodo.getIzquierdo(), letra));
        } else if (comparacion > 0) {
            nodo.setDerecho(
                insertarRec(nodo.getDerecho(), letra));
        }

        return nodo;
    }

    // Buscar una letra
    public boolean buscar(String letra) {
        return buscarRec(raiz, letra);
    }

    private boolean buscarRec(
            NodoArbol<String> nodo, String letra) {

        if (nodo == null) {
            return false;
        }

        if (letra.equals(nodo.getDato())) {
            return true;
        }

        if (letra.compareTo(nodo.getDato()) < 0) {
            return buscarRec(nodo.getIzquierdo(), letra);
        }

        return buscarRec(nodo.getDerecho(), letra);
    }

    // Eliminar una letra
    public void eliminar(String letra) {
        raiz = eliminarRec(raiz, letra);
    }

    private NodoArbol<String> eliminarRec(
            NodoArbol<String> nodo, String letra) {

        if (nodo == null) {
            return null;
        }

        int comparacion = letra.compareTo(nodo.getDato());

        if (comparacion < 0) {
            nodo.setIzquierdo(
                eliminarRec(nodo.getIzquierdo(), letra));
        } else if (comparacion > 0) {
            nodo.setDerecho(
                eliminarRec(nodo.getDerecho(), letra));
        } else {

            // CASO 1: la letra no tiene hijos
            if (nodo.getIzquierdo() == null
                    && nodo.getDerecho() == null) {
                return null;
            }

            // CASO 2: solo tiene hijo derecho
            if (nodo.getIzquierdo() == null) {
                return nodo.getDerecho();
            }

            // CASO 2: solo tiene hijo izquierdo
            if (nodo.getDerecho() == null) {
                return nodo.getIzquierdo();
            }

            // CASO 3: tiene dos hijos
            String sucesor = minValor(nodo.getDerecho());

            // Reemplazar la letra por el sucesor
            nodo.setDato(sucesor);

            // Eliminar la letra duplicada de su posición anterior
            nodo.setDerecho(
                eliminarRec(nodo.getDerecho(), sucesor));
        }

        return nodo;
    }

    // Buscar la letra menor del subárbol derecho
    private String minValor(NodoArbol<String> nodo) {

        while (nodo.getIzquierdo() != null) {
            nodo = nodo.getIzquierdo();
        }

        return nodo.getDato();
    }

    // Mostrar las letras en orden alfabético
    public void imprimirEnOrden() {
        imprimirEnOrdenRec(raiz);
        System.out.println();
    }

    private void imprimirEnOrdenRec(NodoArbol<String> nodo) {
        if (nodo != null) {
            imprimirEnOrdenRec(nodo.getIzquierdo());
            System.out.print(nodo.getDato() + " ");
            imprimirEnOrdenRec(nodo.getDerecho());
        }
    }

    // Dibujar el árbol de lado en la consola
    public void imprimirArbol() {
        imprimirArbolRec(raiz, 0);
    }

    private void imprimirArbolRec(
            NodoArbol<String> nodo, int nivel) {

        if (nodo == null) {
            return;
        }

        imprimirArbolRec(nodo.getDerecho(), nivel + 1);

        for (int i = 0; i < nivel; i++) {
            System.out.print("    ");
        }

        System.out.println(nodo.getDato());

        imprimirArbolRec(nodo.getIzquierdo(), nivel + 1);
    }
}
