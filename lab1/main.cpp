#include <iostream>
#include <math.h>

using namespace std;

int main() {
    double x = 0.0;
    double a = 0.0;
    double b = 0.0;

    cout << "Enter the length of cube edge: ";
    cin >> x;
    a = pow(x,3);
    b = 4.0 * pow(x,2);

    cout << "Cube volume: " << a << endl;
    cout << "Side surface area of cube: " << b << endl;

    return 0;
}
