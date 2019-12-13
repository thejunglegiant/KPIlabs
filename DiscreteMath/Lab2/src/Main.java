import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // Array of start points
    private static int[] v;
    // Array of end points
    private static int[] u;
    // The amount of dots
    private static int n = 1;

    public static void main(String [] args) throws IOException {
        Scanner input = new Scanner(System.in);
        init("inputGraph.txt");
        int[][] adjacencyMatrix;
        System.out.print("Is this graph oriented (y/n): ");
        String oriented = input.nextLine();
        if (oriented.equals("y")) {
            adjacencyMatrix = createAnAdjacencyMatrixForOrientedGraph();
            int[][] distanceMatrix = createDistanceMatrix(adjacencyMatrix);
            int[][] reachMatrix = createReachMatrix(distanceMatrix);
            System.out.println("Distance matrix:");
            output(distanceMatrix);
            System.out.println("Reach matrix:");
            output(reachMatrix);
            System.out.println();
            if (checkForConnectivity(reachMatrix)) {
                System.out.println("This matrix is strongly connected.");
            } else if (checkForConnectivity(oneSideConnected(reachMatrix))) {
                System.out.println("This matrix is one side connected.");
            } else if (checkForConnectivity(
                    createReachMatrix(createDistanceMatrix(createAnAdjacencyMatrixForNotOrientedGraph())))
            ) {
                System.out.println("This matrix is weakly connected.");
            } else {
                System.out.println("This matrix is fully disconnected.");
            }
        } else if (oriented.equals("n")) {
            adjacencyMatrix = createAnAdjacencyMatrixForNotOrientedGraph();
            int[][] distanceMatrix = createDistanceMatrix(adjacencyMatrix);
            int[][] reachMatrix = createReachMatrix(distanceMatrix);
            System.out.println("Distance matrix:");
            output(distanceMatrix);
            System.out.println("Reach matrix:");
            output(reachMatrix);
            System.out.print("Radius = ");
            System.out.println(getRadius(distanceMatrix));
            System.out.print("Diameter = ");
            System.out.println(getDiameter(distanceMatrix));
            outputCenter(getCenter(distanceMatrix));
            System.out.print("Enter a point which layer will be defined about: ");
            int point = input.nextInt();
            outputLayers(getLayers(distanceMatrix, point), point);
        }
    }

    private static boolean checkForConnectivity(int[][] connectionMatrix) {
        boolean result = true;
        for (int j=0;j < n && result;j++) {
            for (int k = 0; k < n; k++) {
                if (connectionMatrix[j][k] != 1) {
                    result = false;
                    break;
                }
            }
        }

        return result;
    }

    private static int[][] oneSideConnected(int[][] reachMatrix) {
        int[][] result = new int[n][n];
        for (int j=0;j < n;j++) {
            for (int k = 0; k < n; k++) {
                result[j][k] = reachMatrix[k][j];
                if (result[j][k] == 0)
                    result[j][k] += reachMatrix[j][k];
            }
        }

        return result;
    }

    private static void outputLayers(ArrayList<ArrayList<Integer>> arrayList, int point) {
        int i = 1;
        for (ArrayList<Integer> row : arrayList) {
            if (!row.isEmpty()) {
                System.out.print("#" + i + " Layer of the point number " + point + " is: ");
                for (int el : row) {
                    System.out.print("V" + el + ", ");
                }
                i++;
                System.out.println();
            }
        }
    }

    private static void outputCenter(ArrayList<Integer> arrayList) {
        System.out.print("The center of the graph is: ");
        for (int el : arrayList) {
            System.out.print("V" +  el + ", ");
        }
        System.out.println();
    }

    private static ArrayList<ArrayList<Integer>> getLayers(int[][] distanceMatrix, int point) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (int j=0;j < getDiameter(distanceMatrix);j++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int k=0;k < n;k++) {
                if (distanceMatrix[point-1][k] == j + 1)
                    temp.add(k + 1);
            }
            result.add(temp);
        }

        return result;
    }

    private static ArrayList<Integer> getCenter(int[][] distanceMatrix) {
        ArrayList<Integer> center = new ArrayList<>();

        int[] temp = getMaxValue(distanceMatrix);

        int min = temp[0];
        for (int el : temp) {
            if (min > el) {
                min = el;
            }
        }

        for (int i=0;i < n;i++) {
            if (min == temp[i]) {
                center.add(i+1);
            }
        }

        return center;
    }

    private static int getDiameter(int[][] distanceMatrix) {
        int diameter = 0;

        for (int j=0;j < n;j++) {
            for (int k=0;k < n;k++) {
                if (diameter < distanceMatrix[j][k])
                    diameter = distanceMatrix[j][k];
            }
        }

        return diameter;
    }

    private static int getRadius(int[][] distanceMatrix) {
        int[] temp = getMaxValue(distanceMatrix);

        int radius = temp[0];
        for (int j=0;j < n;j++) {
            if (radius > temp[j]) {
                radius = temp[j];
            }
        }

        return radius;
    }

    private static int[] getMaxValue(int[][] distanceMatrix) {
        int[] result = new int[n];

        for (int j=0;j < n;j++) {
            int maxElement = distanceMatrix[j][0];
            for (int k=0;k < n;k++) {
                if (maxElement < distanceMatrix[j][k])
                    maxElement = distanceMatrix[j][k];
            }
            result[j] = maxElement;
        }

        return result;
    }

    private static int[][] createReachMatrix(int[][] distanceMatrix) {
        int[][] result = new int[n][n];

        for (int j=0;j < n;j++) {
            for (int k = 0; k < n; k++) {
                if (distanceMatrix[j][k] > 0 || j == k) {
                    result[j][k] = 1;
                }
            }
        }

        return result;
    }

    private static int[][] createDistanceMatrix(int[][] matrix) {
        int[][] result = new int[n][n];

        for (int j=0;j < n;j++) {
            for (int k=0;k < n;k++) {
                for (int i=n-1;i >= 1;i--) {
                    if (powerMatrix(matrix, i)[j][k] != 0)
                        result[j][k] = i;
                }
                result[j][j] = 0;
            }
        }

        return result;
    }

    private static int[][] powerMatrix(int[][] matrix, int power) {
        int[][] result = matrix;

        for (int i=1;i < power;i++) {
            result = multiplyMatrices(result, matrix);
        }

        return result;
    }

    private static int[][] multiplyMatrices(int[][] a, int[][] b) {
        int[][] result = new int[n][n];
        int sum;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum = 0 ;
                for (int k = 0; k < n; k++) {
                    sum += a[i][k] * b[k][j];
                }
                result[i][j] = sum ;
            }
        }

        return result;
    }

    private static int[][] createAnAdjacencyMatrixForOrientedGraph() {
        int[][] matrix = new int[n][n];

        for (int k=0;k<v.length;k++) {
            matrix[v[k]-1][u[k]-1] = 1;
        }

        return matrix;
    }

    private static int[][] createAnAdjacencyMatrixForNotOrientedGraph() {
        int[][] result = new int[n][n];
        int[][] matrix = createAnAdjacencyMatrixForOrientedGraph();

        for (int j=0;j < n;j++) {
            for (int k = 0; k < n; k++) {
                if (matrix[j][k] == 1) {
                    result[j][k] = matrix[j][k];
                    result[k][j] = matrix[j][k];
                }
            }
        }

        return result;
    }

    private static void output(int[][] array) {
        for (int[] column : array) {
            for (int row : column) {
                System.out.print(row);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    private static void init(String fileName) throws IOException {
        String line = null;
        // FileReader reads text files in the default encoding.
        FileReader fileReader = new FileReader(fileName);

        // Always wrap FileReader in BufferedReader.
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        line = bufferedReader.readLine();
        // Tokens for easier recognition
        String[] tokens = line.split(" ");

        n = Integer.parseInt(tokens[0]);
        // The amount of edges
        int m = Integer.parseInt(tokens[1]);
        v = new int[m];
        u = new int[m];
        int i = 0;
        while ((line = bufferedReader.readLine()) != null) {
            tokens = line.split(" ");
            v[i] = Integer.parseInt(tokens[0]);
            u[i] = Integer.parseInt(tokens[1]);
            i++;
        }

        bufferedReader.close();
    }
}
