package listasadyacentes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eduardopinzon
 */
public class Grafo {
    
    private List<Vertice> vertices;

    public Grafo() {
        this.vertices = new ArrayList<>();
    }
    
    public void agregarVertice(Vertice vertice) {
        this.vertices.add(vertice);
    }
     
    public Vertice obtenerVertice(String nombre) {
        for (Vertice vertice : this.vertices) {
            if (vertice.getNombre().equals(nombre)) {
                return vertice;
            }
        }
        return null;
    }
     
    public void recorrerDFS(Vertice vertice) {
    if (vertice != null) {
        System.out.println(vertice.getNombre());
        vertice.getAdyacentes().forEach(this::recorrerDFS);
        }
    }
    


     

}
