import java.util.HashMap;
import java.util.Map;

public class Vertex{

    private String label = null;
    private Map<Vertex, Edge> edges = new HashMap<>();
    private boolean isVisited = false;

}