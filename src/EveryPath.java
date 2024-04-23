import java.util.*;

class EveryPath {
    private static class Graph {
        private int vertices;
        private List<List<Integer>>adjacencylist;

        //construct graph
        Graph(int vertices){
            this.vertices=vertices;
            //create adjacency list
                adjacencylist=new ArrayList<>(vertices);
            for(int i = 0; i <vertices; i++) {
                adjacencylist.add(new ArrayList<>());
            }
        }


        void addEdge(int source,int destination) {
            adjacencylist.get(source).add(destination);
        }

        void printAllPaths(int u,int w) {

            //create empty list to store paths
            ArrayList<Integer>path =new ArrayList<>();

            printAllPathsUtil(u,w, path,0);
        }

        private void printAllPathsUtil(int u,int w, ArrayList<Integer> path, int pathLength) {
            //add starting vertex to path
            path.add(u);

            //check if length is 5
            if (pathLength ==4) {

                if (path.get(pathLength) ==w) {
                    System.out.println(path);
                }
            } else {
                //look at all neighbors of u to find paths
                for(int v: adjacencylist.get(u)){
                    if(!path.contains(v)) {
                        //recursively call but update params
                        printAllPathsUtil(v,w,new ArrayList<>(path),pathLength + 1);
                    }
                }
            }

            //remove last vertex
            path.remove(path.size()- 1);
        }
    }

    public static void main(String[] args) {
        //tester
            Graph graph =new Graph(6);
         graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 2);
        graph.addEdge(2,4);
        graph.addEdge(2,3);
        graph.addEdge(2, 5);
        graph.addEdge(3,4);
        graph.addEdge(4,5);

        //0-5 for simplicity
        int u =0;
        int w =5;
        System.out.println("paths of length 5 from u to w:");
         graph.printAllPaths(u,w);
    }
}

