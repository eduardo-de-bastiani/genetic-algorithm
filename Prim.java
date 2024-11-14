import java.util.*;

public class Prim {
    int vertices;
    LinkedList<Edge>[] adjacencyList;

    // Constructor to initialize the graph with
      // the given number of vertices
    public Prim(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    // Method to add an edge to the graph
    void addEdge(int source, int dest, int weight) {
        Edge edge = new Edge(source, dest, weight);
        adjacencyList[source].add(edge);
      
          // Adding the reverse edge since it's an undirected graph
        adjacencyList[dest].add(new Edge(dest, source, weight)); 
    }

    // Method to implement Prim's algorithm to
      // find the Minimum Spanning Tree (MST)
    public void primMST() {
          // Array to keep track of vertices included in MST
        boolean[] inMST = new boolean[vertices]; 
      
          // Priority queue to select the edge
          // with the smallest weight
        PriorityQueue<Edge> priorityQueue =
              new PriorityQueue<>(Comparator.comparingInt(e -> e.weight)); 
        
          // List to store the MST edges
          List<Edge> mst = new ArrayList<>(); 

          // Start from any vertex, here it's 0
        int startVertex = 0; 
      
          // Mark the start vertex as included in MST
        inMST[startVertex] = true; 

        // Add all edges from the start vertex to the priority queue
        for (Edge edge : adjacencyList[startVertex]) {
            priorityQueue.add(edge);
        }

        // Process the edges in the priority queue
        while (!priorityQueue.isEmpty()) {
              // // Get the edge with the smallest weight
            Edge currentEdge = priorityQueue.poll(); 

            // If the destination vertex is not yet
              // included in MST
            if (!inMST[currentEdge.dest]) {
                  // Add the edge to the MST
                mst.add(currentEdge); 
              
                  // Mark the destination vertex as included in MST
                inMST[currentEdge.dest] = true; 

                // Add all edges from the current edge's
                  // destination to the priority queue
                for (Edge edge : adjacencyList[currentEdge.dest]) {
                    if (!inMST[edge.dest]) {
                        priorityQueue.add(edge);
                    }
                }
            }
        }

        // Print the edges in the MST
        System.out.println("Minimum Spanning Tree:");
        for (Edge edge : mst) {
            System.out.println("Edge: " + edge.source + " - "
                               + edge.dest + " Weight: " + edge.weight);
        }
    }
}