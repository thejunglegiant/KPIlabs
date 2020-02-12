#include <iostream>

using namespace std;

/*
Program finds the greatest common divisor from two given numbers.
*/

int main() {
    int n = 0;
    int m = 0;

    // Greates common divisor
    int gcd = 1;

    cout << "Enter the first number: ";
    cin >> n;
    cout << "Enter the second number: ";
    cin >> m;

    
    for (int i = 1; i <= m; i++) {
        if (n % i == 0 && m % i == 0 && gcd < i)
            gcd = i;
    }

    cout << gcd << endl;

    return 0;
}