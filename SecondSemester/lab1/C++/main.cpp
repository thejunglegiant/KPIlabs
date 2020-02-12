#include <iostream>
#include "functions.h"

using namespace std;

int main() {
    // Increment function test
    cout << increment(63) << endl;
    cout << increment(-18) << endl;
    cout << increment(92) << endl << endl;

    // Equality function test
    cout << (compareBinaries(11, 11)
        ? "Numbers are equal" : "Numbers are not equal") << endl;
    cout << (compareBinaries(84, -2)
        ? "Numbers are equal" : "Numbers are not equal") << endl;
    cout << (compareBinaries(61, 107)
        ? "Numbers are equal" : "Numbers are not equal") << endl;

    return 0;
}