#include <iostream>
#include <ctime>

using namespace std;

/*
Find MIN value and MAX number from negative ones and then change them.
*/

void fillArray(int array[], int size) {
    bool unique = true;

    for (int i = 0; i < size;) {
        int element = rand() % 201 - 100;

        for (int j = 0; j < size; j++) {
            if (array[j] == element) {
                unique = false;
                break;
            }
        }
        
        unique = true;
        if (unique) {
            array[i] = element;
            i++;
        }
    }
}

void printArray(int arr[], int size) {
    for (int i = 0; i < size; i++) {
        cout << arr[i] << " ";
    }
    
    cout << endl;
}

int main() {
    srand(time(NULL));

    int size = 0;
    cout << "Enter array's length: ";
    cin >> size;

    int array[size];
    int *pmaxNegative = array;
    int *pmin = array;
    fillArray(array, size);
    printArray(array, size);

    // Max value from negative numbers
    for (int i = 0; i < 10; i++) {
        if ((*pmaxNegative > 0 || *pmaxNegative < *(array+i)) && *(array+i) < 0) {
            pmaxNegative = (array+i);
        }
    }

    // Min value from the whole array
    for (int i = 0; i < 10; i++) {
        if (*(array+i) < *pmin) {
            pmin = (array+i);
        }
    }

    int temp = *pmin;
    *pmin = *pmaxNegative;
    *pmaxNegative = temp;
    
    printArray(array, size);
    
    return 0;
}