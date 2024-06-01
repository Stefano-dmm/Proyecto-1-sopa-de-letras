package listasadyacentes;

/**
 *
 * @author eduardopinzon
 */
public class ListasAdyacentes {

    /**
     * @param args the command line arguments
     */
    
        
    public void agregarArista(String vertice1, String vertice2) {
    Vertice v1 = obtenerVertice(vertice1);
    Vertice v2 = obtenerVertice(vertice2);
        if (v1 != null && v2 != null) {
        v1.agregarAdyacente(v2);
        v2.agregarAdyacente(v1);
        }
    }

    private Vertice obtenerVertice(String vertice2) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
        
    
}
    

