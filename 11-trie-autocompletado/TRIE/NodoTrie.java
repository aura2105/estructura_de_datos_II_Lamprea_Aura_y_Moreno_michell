
import java.util.HashMap;
import java.util.Map;

public class NodoTrie {
    Map<Character, NodoTrie> hijos;
    boolean finPalabra;

    public NodoTrie() {
        hijos = new HashMap<>();
        finPalabra = false;
    }
}
