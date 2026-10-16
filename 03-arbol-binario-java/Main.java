
/*
 * Proyecto: 03-arbol-binario-java
 * Clase: Main
 * Descripcion: Crea y prueba un arbol binario de animales.
 */

// Clase principal del programa.
public class Main {

    // Metodo principal: aqui comienza la ejecucion del programa.
    public static void main(String[] args) {

        // ==========================================
        // 1. CREACION MANUAL DEL ARBOL DE ANIMALES
        // ==========================================

        // Se crea la raiz del arbol con el animal Perro.
        NodoArbol<String> animales = new NodoArbol<>("Perro");

        // Se crean los dos hijos directos de la raiz.
        animales.setIzquierdo(new NodoArbol<>("Gato"));
        animales.setDerecho(new NodoArbol<>("Conejo"));

        // Se agregan dos hijos al nodo Gato.
        animales.getIzquierdo().setIzquierdo(
            new NodoArbol<>("Leon")
        );

        animales.getIzquierdo().setDerecho(
            new NodoArbol<>("Tigre")
        );

        // Se agregan dos hijos al nodo Conejo.
        animales.getDerecho().setIzquierdo(
            new NodoArbol<>("Oso")
        );

        animales.getDerecho().setDerecho(
            new NodoArbol<>("Panda")
        );

        // El arbol ya tiene siete nodos enlazados manualmente.


        // ==========================================
        // 2. IMPRESION DEL ARBOL
        // ==========================================

        // Se muestra el titulo del arbol de animales.
        System.out.println("===== ARBOL DE ANIMALES =====");

        // Se llama al metodo que recorre e imprime los nodos.
        imprimirArbol(animales);


        // ==========================================
        // 3. MOSTRAR LA RAIZ Y SUS HIJOS
        // ==========================================

        System.out.println("\n===== RAIZ E HIJOS =====");

        // Se imprime el dato de la raiz y sus hijos directos.
        animales.imprimirRaizYHijos();


        // ==========================================
        // 4. VALIDACION DE UN NODO HOJA
        // ==========================================

        System.out.println("\n===== VALIDACION DE NODO HOJA =====");

        // Se obtiene el nodo Leon, que se encuentra debajo de Gato.
        NodoArbol<String> hoja =
            animales.getIzquierdo().getIzquierdo();

        // Primero se comprueba que el nodo exista.
        // Despues se verifica que no tenga hijos.
        if (hoja != null
                && hoja.getIzquierdo() == null
                && hoja.getDerecho() == null) {

            // Si ambas referencias son null, Leon es un nodo hoja.
            System.out.println(
                hoja.getDato() + " es un nodo hoja."
            );
        }


        // ==========================================
        // 5. VALIDACION DE REFERENCIAS NULL
        // ==========================================

        System.out.println("\n===== VALIDACION DE NULL =====");

        // Se comprueba que el hijo izquierdo de la raiz exista.
        if (animales.getIzquierdo() != null) {
            System.out.println(
                "El hijo izquierdo de Perro es: "
                + animales.getIzquierdo().getDato()
            );
        }

        // Se comprueba si Leon tiene hijo derecho.
        // Como no tiene, la referencia es null.
        if (hoja != null && hoja.getDerecho() == null) {
            System.out.println(
                "Leon no tiene hijo derecho."
            );
        }


        // ==========================================
        // 6. ARBOL DE EXPRESIONES MATEMATICAS
        // ==========================================

        System.out.println("\n===== ARBOL DE EXPRESIONES =====");

        // Se crea la raiz con el operador multiplicacion.
        NodoArbol<String> expresion = new NodoArbol<>("*");

        // Se crea el operador suma como hijo izquierdo.
        NodoArbol<String> suma = new NodoArbol<>("+");

        // Se enlaza el operador suma a la raiz.
        expresion.setIzquierdo(suma);

        // Se coloca el numero 2 como hijo derecho de la raiz.
        expresion.setDerecho(new NodoArbol<>("2"));

        // Se colocan los operandos 3 y 4 debajo del operador suma.
        suma.setIzquierdo(new NodoArbol<>("3"));
        suma.setDerecho(new NodoArbol<>("4"));

        // Se imprime el arbol de la expresion matematica.
        imprimirArbol(expresion);

        // Se muestra la expresion y se calcula su resultado.
        System.out.println("Expresion: (3 + 4) * 2");
        System.out.println("Resultado: " + ((3 + 4) * 2));
    }


    // ==========================================
    // 7. METODO PARA RECORRER EL ARBOL
    // ==========================================

    // Metodo generico que recibe un nodo y recorre sus descendientes.
    public static <T> void imprimirArbol(NodoArbol<T> nodo) {

        // Si el nodo es null, se termina esta llamada.
        // Esto evita intentar acceder a un objeto inexistente.
        if (nodo == null) {
            return;
        }

        // Se imprime el nodo actual y sus hijos directos.
        nodo.imprimirRaizYHijos();

        // Se recorre primero el subarbol izquierdo.
        imprimirArbol(nodo.getIzquierdo());

        // Despues se recorre el subarbol derecho.
        imprimirArbol(nodo.getDerecho());
    }
}
