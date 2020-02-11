#include <iostream>

using namespace std;

/*
For all numbers in [a,b] range find as many dividers as possible from fibonacci sequence.
*/

int fibonacci(int number) {
    if (number == 0)
        return 0;
    if (number == 1)
        return 1;
    return fibonacci(number-1) + fibonacci(number-2);
}

int main() {
    int a = 0, b = 0;

    cout << "Enter start number of a range: ";
    cin >> a;
    cout << "Enter end number of a range: ";
    cin >> b;

    for (int i = a; i <= b; i++) {
        int x = 2;
        while (fibonacci(x) <= i) {
           if (i % fibonacci(x) == 0) {
               cout << fibonacci(x) << ", ";
           }
           x++;
        }
        cout << "\nThat's all for " << i << endl;
    }

    return 0;
}