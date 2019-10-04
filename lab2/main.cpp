#include <iostream>

using namespace std;

/*
This program checks if the dot (x, y) is between two circles (r1, r2) or not
*/

int main() {
    int r1 = 0;
    int r2 = 0;
    int x = 0;
    int y = 0;

    cout << "Enter radius1: ";
    cin >> r1;
    cout << "Enter radius2: ";
    cin >> r2;
    cout << "Enter x value: ";
    cin >> x;
    cout << "Enter y value: ";
    cin >> y;

    if(x >= r1 && x <= r2 && y >= r1 && y <= r2) {
      cout << "This dot belongs to the figure" << endl;
    } else {
      cout << "This dot does not belong to the figure" << endl;
    }

    return 0;
}
