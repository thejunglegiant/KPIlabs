#include <iostream>
#include "Line.h"

using namespace std;

int main() {
    Line C1 = Line();
    Line C2 = Line("15");
    Line C3 = Line(C2);

    C1 = C2 - '5' + C3;
    cout << C1.getLine() << endl;

    return 0;
}