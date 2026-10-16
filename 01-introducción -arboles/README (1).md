En esta actividad se representa un organigrama empresarial mediante una estructura de árbol. Se utiliza una estructura jerárquica porque existe un elemento principal y diferentes niveles que dependen de él.

La empresa se encuentra en la raíz del árbol, seguida por el gerente general y las diferentes áreas de la organización. Cada área se divide en departamentos y funciones específicas.
En nuestro visual creamos una carpeta llamada organigrama en donde esta un archivo NodoGeneral.java se encuentra la clase que permite construir nuestro árbol.

Esta clase es genérica, porque utiliza la letra T para poder almacenar diferentes tipos de datos. En nuestro caso, usamos String para guardar los nombres de la empresa, los departamentos y las áreas.

Tenemos un atributo llamado dato, que guarda el nombre de cada nodo, y una lista llamada hijos, que permite almacenar los nodos que dependen de él.

El constructor NodoGeneral inicializa el nombre del nodo y crea una lista vacía para sus hijos.

También tenemos el método agregarHijo, que sirve para conectar un nodo con otro. Este método verifica que el hijo no sea null, es decir, que no esté vacío.

El método getDato devuelve el nombre del nodo y getHijos permite consultar sus hijos sin permitir modificaciones directas a la lista.

Por último, el método esHoja verifica si un nodo no tiene hijos. Por ejemplo, Contabilidad es una hoja porque no tiene otros departamentos debajo de ella.
