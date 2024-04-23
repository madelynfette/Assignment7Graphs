public class DirectedOrUndirected {
    public static void main(String[] args) {
        int[][] directedGraph = {
                {0, 1, 0},
                {0, 0, 1},
                {0, 0, 0}
        };
        int[][] undirectedGraph = {
                {0, 1, 1},
                {1, 0, 1},
                {1, 1, 0}
        };

        //check if works on directed graph
        boolean isDirected =isDirected(directedGraph);
        System.out.println(isDirected);

        //check if works on undirected graph
        boolean isUndirected =isDirected(undirectedGraph);
        System.out.println(isUndirected);

    }

    static boolean isDirected(int[][]matrix) {
        //get matrix size
        int n =matrix.length;

        //check if square, if not, return false
        if (n !=matrix[0].length) {
            return false;
        }

        //iterate over matrix elements
        for (int i =0; i< n;i++) {
            for (int j =0; j < n;j++) {

                //check no edges connect back to same vertex
                if (i ==j && matrix[i][j]!= 0){
                    return false;
                }
                //check for edges that are undirected
                if (matrix[i][j] != 0 && matrix[j][i] != 0){
                    return false;
                }
            }
        }

        return true;
    }


}