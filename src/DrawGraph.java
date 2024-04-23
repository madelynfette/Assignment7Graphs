import java.util.*;
//i could not figure out how to do the graphstream:( but here is the adjacency matrix
public class DrawGraph {
    public static void main(String[] args) {
        String input ="[(I,2),(A,5),(E,4),(F,1),(T,2),(S,3)]";
        int[][]adjacencyMatrix=createAdjacencyMatrix(input);
        printAdjacencyMatrix(adjacencyMatrix);
    }

    public static int[][] createAdjacencyMatrix(String input) {
        //store distances between vertices
        List<Integer>vertexNumbers =new ArrayList<>();
        //remove brackets

        input =input.replaceAll("[\\[\\]()]","");
        //split into pairs based on ,
        String[] pairs=input.split(",");
        //get numbers and add to list
        for(int i=1;i <pairs.length;i+=2) {

            vertexNumbers.add(Integer.parseInt(pairs[i]));
        }
        //get # of vertices
        int n =vertexNumbers.size();
        //create size of matrix


        int[][] adjacencyMatrix= new int[n][n];
        //fill matrix
        for(int i =0;i< n;i++) {

            int number =vertexNumbers.get(i);
            //calc pos of adj vertices from distance
            int left=(i - number+ n) % n;

            int right=(i + number)% n;
            //set appropriate in matrix to 1
            adjacencyMatrix[i][left]=1;
            adjacencyMatrix[i][right]=1;
        }

        return adjacencyMatrix;
    }

    public static void printAdjacencyMatrix(int[][] adjacencyMatrix) {
        //iterate through rows of matrix and print visual
        for(int[]row:adjacencyMatrix) {
            for(int val:row) {

                System.out.print(val+ " ");
            }
            System.out.println();
        }
    }
}
