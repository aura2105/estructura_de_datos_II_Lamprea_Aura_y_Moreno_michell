
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Trie {
    private final NodoTrie raiz;

    public Trie() {
        raiz = new NodoTrie();
    }

    // Inserta una palabra en el Trie.
    public void insertar(String palabra) {
        if (palabra == null || palabra.trim().isEmpty()) {
            return;
        }

        palabra = palabra.trim().toLowerCase();
        NodoTrie actual = raiz;

        for (char c : palabra.toCharArray()) {
            actual = actual.hijos.computeIfAbsent(
                c, k -> new NodoTrie()
            );
        }

        actual.finPalabra = true;
    }

    // Busca una palabra completa.
    public boolean buscar(String palabra) {
        if (palabra == null || palabra.trim().isEmpty()) {
            return false;
        }

        NodoTrie actual = obtenerNodo(palabra.trim().toLowerCase());

        return actual != null && actual.finPalabra;
    }

    // Comprueba si existe alguna palabra con ese prefijo.
    public boolean empiezaCon(String prefijo) {
        if (prefijo == null) {
            return false;
        }

        if (prefijo.isEmpty()) {
            return true;
        }

        return obtenerNodo(prefijo.trim().toLowerCase()) != null;
    }

    // Devuelve el nodo correspondiente al final de una cadena.
    private NodoTrie obtenerNodo(String cadena) {
        NodoTrie actual = raiz;

        for (char c : cadena.toCharArray()) {
            actual = actual.hijos.get(c);

            if (actual == null) {
                return null;
            }
        }

        return actual;
    }

    // Sugiere un máximo de cinco palabras por prefijo.
    public List<String> sugerir(String prefijo) {
        return sugerir(prefijo, 5);
    }

    // Permite establecer otro límite máximo.
    public List<String> sugerir(String prefijo, int limite) {
        List<String> resultados = new ArrayList<>();

        if (prefijo == null || limite <= 0) {
            return resultados;
        }

        prefijo = prefijo.trim().toLowerCase();

        NodoTrie nodo = obtenerNodo(prefijo);

        if (nodo == null) {
            return resultados;
        }

        recolectar(nodo, prefijo, resultados, limite);

        return resultados;
    }

    // Recorre los nodos y construye las palabras completas.
    private void recolectar(
            NodoTrie nodo,
            String palabra,
            List<String> resultados,
            int limite) {

        if (resultados.size() >= limite) {
            return;
        }

        if (nodo.finPalabra) {
            resultados.add(palabra);
        }

        List<Character> caracteres =
            new ArrayList<>(nodo.hijos.keySet());

        Collections.sort(caracteres);

        for (char c : caracteres) {
            if (resultados.size() >= limite) {
                break;
            }

            recolectar(
                nodo.hijos.get(c),
                palabra + c,
                resultados,
                limite
            );
        }
    }

    // Devuelve la cantidad de palabras almacenadas.
    public int contarPalabras() {
        return contar(raiz);
    }

    private int contar(NodoTrie nodo) {
        int total = nodo.finPalabra ? 1 : 0;

        for (Map.Entry<Character, NodoTrie> entrada
                : nodo.hijos.entrySet()) {
            total += contar(entrada.getValue());
        }

        return total;
    }
}
