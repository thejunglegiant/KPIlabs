import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
        int startPoint = 1;
        adjacencyMatrix = createAnAdjacencyMatrix();
        System.out.print("Enter the point from which to start: ");
        startPoint = input.nextInt();
        System.out.println();
        System.out.println("Poi|BFS|Line content");
        System.out.println("---------------------");
        breadthFirstSearch(adjacencyMatrix, startPoint);
        System.out.println();
        System.out.println("Poi|DFS|Stack content");
        System.out.println("---------------------");
        depthFirstSearch(adjacencyMatrix, startPoint);
    }

    private static void depthFirstSearch(int[][] adjacencyMatrix, int actualPoint) {
        int counter = 1;
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<Integer> donePoints = new ArrayList<>();

        donePoints.add(actualPoint);
        temp.add(actualPoint);
        System.out.print("V" + actualPoint + " | " + (counter++) + " | ");
        System.out.println(temp);
        for (int j=0;j <= temp.size();j++) {
            for (int k = 0; k < n; k++) {
                if (adjacencyMatrix[actualPoint-1][k] == 1 && !donePoints.contains(k+1)) {
                    donePoints.add(k+1);
                    temp.add(k+1);
                    System.out.print("V" + (k+1) + " | " + (counter++) + " | ");
                    System.out.println(temp);
                    break;
                } else if (k == n - 1) {
                    temp.remove(temp.size() - 1);
                    System.out.print("-- | - | ");
                    System.out.println(temp);
                }
            }
            actualPoint = temp.isEmpty() ? 0 : temp.get(temp.size() - 1);
            j = 0;
        }
    }

    private static void breadthFirstSearch(int[][] adjacencyMatrix, int actualPoint) {
        int counter = 1;
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<Integer> donePoints = new ArrayList<>();

        donePoints.add(actualPoint);
        temp.add(actualPoint);
        System.out.print("V" + actualPoint + " | " + (counter++) + " | ");
        System.out.println(temp);
        for (int j=0;j < n;j++) {
            for (int k = 0; k < n; k++) {
                if (adjacencyMatrix[actualPoint-1][k] == 1 && !donePoints.contains(k+1)) {
                    donePoints.add(k+1);
                    temp.add(k+1);
                    System.out.print("V" + (k+1) + " | " + (counter++) + " | ");
                    System.out.println(temp);
                }
            }
            temp.remove(0);
            actualPoint = temp.isEmpty() ? 0 : temp.get(0);
            System.out.print("-- | - | ");
            System.out.println(temp);
        }
    }

    private static int[][] createAnAdjacencyMatrix() {
        int[][] matrix = new int[n][n];

        for (int k=0;k<v.length;k++) {
            matrix[v[k]-1][u[k]-1] = 1;
            matrix[u[k]-1][v[k]-1] = 1;
        }

        return matrix;
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