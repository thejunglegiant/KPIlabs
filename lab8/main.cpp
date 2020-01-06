#include <iostream>
#include <ctime>

using namespace std;

/*
Change the rows with the biggest and the smallest values between two matrices.
User enters the amount of rows and columns only.
*/

void fillMatrix(int *matrix[], int n, int m) {
    for (int j = 0; j < n; j++) {
        for (int k = 0; k < m; k++) {
            matrix[j][k] = rand() % 90 + 10;
        }
    }
}

void printMatrix(int *matrix[], int n, int m) {
    cout << endl;

    for (int j = 0; j < n; j++) {
        for (int k = 0; k < m; k++) {
            cout << matrix[j][k] << "\t";
        }

        cout << endl;
    }

    cout << endl;
}

int findGreatestRow(int *matrix[], int n, int m) {
    int row = 0;
    int element = matrix[0][0];

    for (int j = 0; j < n; j++) {
        for (int k = 0; k < m; k++) {
            if (element < matrix[j][k]) {
                element = matrix[j][k];
                row = j;
            }
        }
    }

    return row;
}

int findLowestRow(int *matrix[], int n, int m) {
    int row = 1;
    int element = matrix[0][0];

    for (int j = 0; j < n; j++) {
        for (int k = 0; k < m; k++) {
            if (element > matrix[j][k]) {
                element = matrix[j][k];
                row = j;
            }
        }
    }

    return row;
}

void changeRows(int *matrix1[], int *matrix2[], int row1, int row2, int m) {
    for (int i = 0; i < m; i++) {
        int temp = matrix1[row1][i];
        matrix1[row1][i] = matrix2[row2][i];
        matrix2[row2][i] = temp;
    }
}

int main() {
    srand(time(NULL));
    
    int n = 0;
    int m = 0;
    cout << "Enter amount of rows and columns for both matrices." << endl << "Rows:";
    cin >> n;
    cout << "Columns: ";
    cin >> m;

    // Initialize matrix #1
    int **firstMatrix = new int *[n];
    for (int i = 0; i < n; i++) {
        firstMatrix[i] = new int [m];
    }
    fillMatrix(firstMatrix, n, m);
    // Initialize matrix #2
    int **secondMatrix = new int *[n];
    for (int i = 0; i < n; i++) {
        secondMatrix[i] = new int [m];
    }
    fillMatrix(secondMatrix, n, m);

    printMatrix(firstMatrix, n, m);
    printMatrix(secondMatrix, n, m);
    
    cout << "--------------------------------" << endl;
    changeRows(firstMatrix, secondMatrix, findGreatestRow(firstMatrix, n, m), findGreatestRow(secondMatrix, n, m), m);
    changeRows(firstMatrix, secondMatrix, findLowestRow(firstMatrix, n, m), findLowestRow(secondMatrix, n, m), m);

    printMatrix(firstMatrix, n, m);
    printMatrix(secondMatrix, n, m);

    // Delete all from memory
    for (int i = 0; i < n; i++) {
        delete [] firstMatrix[i];
        delete [] secondMatrix[i];
    }
    delete [] firstMatrix;
    delete [] secondMatrix;

    return 0;
}