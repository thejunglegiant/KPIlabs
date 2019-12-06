import java.io.*;

public class Main {
    // Array of start points
    private static int[] v;
    // Array of end points
    private static int[] u;
    // The amount of dots
    private static int n = 1;
    // The amount of edges
    private static int m = 1;
    // If the graph is homogeneous
    private static boolean graph = true;

    public static void main(String [] args) throws IOException {
        init("temp.txt");
        System.out.println();
        output(createAnIncidenceMatrix());
        System.out.println();
        output(createAnAdjacencyMatrix());
        System.out.println();
        getPowerOfEveryPoint(powerOfEveryPoint());
        System.out.println();
        getAllHangingAndIsolatedPoints(powerOfEveryPoint());
        System.out.println();
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
        m = Integer.parseInt(tokens[1]);
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

    private static int[][] createAnIncidenceMatrix() {
        int[][] array = new int[n][m];

        for (int j=0;j<n;j++) {
            for (int k=0;k<m;k++) {
                if (j+1 == v[k]) {
                    array[j][k] = -1;
                } else if (j+1 == u[k]) {
                    array[j][k] = 1;
                }
                if (j+1 == v[k] && j+1 == u[k]) {
                    array[j][k] = 2;
                }
            }
        }

        return array;
    }

    private static int[][] createAnAdjacencyMatrix() {
        int[][] array = new int[n][n];

        for (int k=0;k<v.length;k++) {
            array[v[k]-1][u[k]-1] = 1;
        }

        return array;
    }

    private static int[] powerOfEveryPoint() {
        int[][] array = createAnAdjacencyMatrix();
        int[] powerArray = new int[n];

        for (int j=0;j<n;j++) {
            for (int k=0;k<n;k++) {
                if (array[j][k] == 1) {
                    powerArray[j] += 1;
                }
            }
        }

        int firstElement = powerArray[0];
        for (int j : powerArray) {
            if (j != firstElement)
                graph = false;
        }

        return powerArray;
    }

    private static void getPowerOfEveryPoint(int[] array) {
        System.out.println("Power of every point: ");
        int i = 0;
        if (!graph) {
            for (int value : array) {
                System.out.println("V" + i + " = " + value + "");
                i++;
            }
        } else {
            System.out.println("V" + " = " + array[0] + "");
        }
    }

    private static void getAllHangingAndIsolatedPoints(int[] array) {
        System.out.print("Isolated points: ");
        for (int i=0; i < array.length;i++) {
            if (array[i] == 0) {
                System.out.print("V" + i + ", ");
                i++;
            }
        }
        System.out.print("\nHanging points: ");
        for (int i=0; i < array.length;i++) {
            if (array[i] == 1) {
                System.out.print("V" + i + ", ");
            }
        }
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
}