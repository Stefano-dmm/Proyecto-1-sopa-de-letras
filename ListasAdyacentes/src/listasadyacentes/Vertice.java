package listasadyacentes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eduardopinzon
 */
public class Vertice {
    private String nombre;
    private List<Vertice> adyacentes;

    public Vertice(String nombre) {
        this.nombre = nombre;
        this.adyacentes = new ArrayList<>();
    }
    
    public String getNombre() {
        return nombre;
    }

    public void agregarAdyacente(Vertice vertice) {
        this.adyacentes.add(vertice);
    }
    
    public List<Vertice> getAdyacentes() {
        return adyacentes;
    }
    
    
}
