
import AuxiliarClasses.Queue;
import AuxiliarClasses.Node;
import java.util.Arrays;

/**
 * Graph
 */
/**
 *
 * @author Camilo Camargo
 */
public class Graph {
    int[][] adjacencyMatrix;
    int[] distance;
    int[] visited; //for the graph traversal
    Queue queue; //for BFS
    int numberOfVertices;
    boolean directed;
    
    Graph(int numberOfVertices, boolean directed){
        this.numberOfVertices = numberOfVertices;
        this.directed = directed;
        adjacencyMatrix = new int[numberOfVertices][numberOfVertices];
        visited = new int[numberOfVertices];
        distance = new int[numberOfVertices];
        Arrays.fill(distance, -1);
        queue = new Queue();
    }
    
    public void createConection(int from, int to, int weight){
        if(directed){
            adjacencyMatrix[from][to] = weight;
        }else{
            adjacencyMatrix[from][to] = weight;
            adjacencyMatrix[to][from] = weight;
        }
    }
    
    public String DFS(int start, String output){
        output += start + " ";
        visited[start] = 1;
        for (int i = 0; i < numberOfVertices; i++) {
                if(adjacencyMatrix[start][i] != 0 && visited[i] == 0){
                    output = DFS(i,output);
                }
        }
        return output;
    }
    
    public String BFS(int start, String output){
        if(visited[start] == 0){
            output += start + " ";
            visited[start] = 1;
        }
        for (int i = 0; i < numberOfVertices; i++) {
            if(adjacencyMatrix[start][i] != 0 && visited[i] == 0){
                output += i + " ";
                visited[i] = 1;
                queue.enqueue(new Node(i));
            }
        }
        while(!queue.isEmpty()){
            output = BFS(queue.dequeue().value,output);
        }
        return output;
    }
    
    public int distance(int from, int to){
        return adjacencyMatrix[from][to];
    }
    
    public void shortestPath(int from, int to, int visited[], int distance) {
        visited[from] = 1;
        if(adjacencyMatrix[from][to] != 0) {//founded
            if(this.distance[to] == -1){
                this.distance[to] = distance + distance(from,to);
            }else if(distance + distance(from,to) < this.distance[to]){
                this.distance[to] = distance + distance(from,to);
            }
        }
        for (int i = 0; i < numberOfVertices; i++) {
            if(adjacencyMatrix[from][i] != 0 && visited[i] == 0 && i != to){
                shortestPath(i, to, visited.clone(), distance + distance(from,i));
            }
        }
    }
    
    public static void main(String[] args) {
        Graph g = new Graph((7), false);
        g.createConection(0, 1, 2);
        g.createConection(1, 6, 8);
        g.createConection(6, 4, 5);
        g.createConection(6, 2, 9);
        g.createConection(2, 5, 11);
        g.createConection(2, 3, 10);
        g.createConection(5, 3, 7);
        g.createConection(4, 3, 20);
        int v[] = new int [7];
        g.shortestPath(0, 5, v, 0);
        String output = "";
        //System.out.println(g.BFS(0, output));
        for (int i = 0; i < g.numberOfVertices; i++) {
            System.out.print(g.distance[i] + " ");
        }
    }
}
