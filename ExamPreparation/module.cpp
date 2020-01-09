#include <iostream>
#include <ctime>

using namespace std;

int **create_matrix(int size) {
    int **arr = new int*[size];
    srand(time(NULL));

    for (int j = 0; j < size; j++) {
        arr[j] = new int[size];
        for (int k = 0; k < size; k++) {
            arr[j][k] = rand() % 10;
        }
    }
    
    return arr;
}

void print_matrix(int **matrix, int size) {
    for (int j = 0; j < size; j++) {
        for (int k = 0; k < size; k++) {
            cout << matrix[j][k] << " ";
        }
        cout << endl;
    }
}

int count_matrix(int **matrix, int size) {
    int sum = 0;
    int counter = 0;
    int center = (int)(size / 2);

    for (int j = 0; j < size; j++) {
        for (int k = 0; k <= counter; k++) {
            if (k == 0) {
                sum += matrix[j][center];
            } else {
                sum += matrix[j][center - k];
                sum += matrix[j][center + k];
            }
        }
        (j < center) ? counter++ : counter--;
    }

    return sum;
}
