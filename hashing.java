import java.util.*;

public class hashing{

    static class Graph {
        HashMap<Object, LinkedList<Object>> adjList = new HashMap();
        HashMap<Object, Integer>  indexes = new HashMap<>();
        int index = -1;

        public Graph(ArrayList<Object> vertices) {
            for (int i = 0; i <vertices.size() ; i++) {
                Object vertex = vertices.get(i);
                LinkedList<Object> list = new LinkedList<>();
                adjList.put(vertex, list);
                indexes.put(vertex, ++index);
            }
        }

        public void addEdge(Object source, Object destination) {
            //add forward edge
            LinkedList<Object> list;
            list = adjList.get(source);
            list.addFirst(destination);
            adjList.put(source, list);
        }

        public void DFS(){
            int vertices = adjList.size();
            boolean [] visited = new boolean[vertices];

            for (Map.Entry<Object, LinkedList<Object>> entry : adjList.entrySet()) {
                Object source = entry.getKey();
                if(!visited[indexes.get(source)]){
                    DFSUtil(source, visited);
                }
//                System.out.println("Key = " +  +
//                        ", Value = " + entry.getValue());
            }
        }

        public void DFSUtil(Object source, boolean[] visited){

            //mark this visited
            visited[indexes.get(source)] = true;

            System.out.print(source + " ");
            LinkedList<Object> list = adjList.get(source);
            for (int i = 0; i <list.size() ; i++) {
                Object destination = list.get(i);
                if(!visited[indexes.get(destination)])
                    DFSUtil(destination,visited);
            }
        }

        public void printGraph() {
            Set<Object> set = adjList.keySet();
            Iterator<Object> iterator = set.iterator();

            while(iterator.hasNext()){
                Object vertex = iterator.next();
                System.out.print("Vertex " + vertex + " is connected to: ");
                LinkedList<Object> list = adjList.get(vertex);
                for (int i = 0; i <list.size() ; i++) {
                    System.out.print(list.get(i) + " ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Object> vertices = new ArrayList<>();
        vertices.add("Pune");
        vertices.add("Bangalore");
        vertices.add("Chennai");
        vertices.add("Delhi");
        vertices.add("Ranchi");
        vertices.add("Ahemadabad");
        vertices.add("Goa");
        Graph graph = new Graph(vertices);
        graph.addEdge("Pune","Bangalore");
        graph.addEdge("Pune", "Chennai");
        graph.addEdge("Bangalore", "Delhi");
        graph.addEdge("Bangalore","Ranchi");
        graph.printGraph();
        System.out.println("---------------Depth First Traversal------------");
        graph.DFS();
    }
}
