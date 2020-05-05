#include <iostream>
#include <ctime>

using namespace std;

int* sort(int*, int);
void printArray(int*, int);

int main() {
    srand(time(NULL));
    
    int length = 7;
    int* array = new int[length];
    for (int i = 0; i < length; i++)
        array[i] = rand() % 100;
    
    int* (*function)(int*, int);
    void (*print)(int*, int);
    print = printArray;
    function = sort;

    function(array, length);
    print(array, length);

    return 0;
}

int* sort(int* arr, int length) {
    for (int j = 0; j < length; j++) {
        for (int k = j; k < length; k++) {
            if (arr[j] < arr[k]) {
                int temp = arr[j];
                arr[j] = arr[k];
                arr[k] = temp;
            }
        }
    }

    return arr;
}

void printArray(int* arr, int length) {
    for (int i = 0; i < length; i++)
        cout << arr[i] << ' ';
    cout << endl;
}
