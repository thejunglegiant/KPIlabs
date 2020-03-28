#include "Rectangle.h"
#include <iostream>

using namespace std;

int main() {
    double **array;
    array = new double *[2];
    for(int i = 0; i <10; i++)
        array[i] = new double[2];
    array[0][0] = 1.0;
    array[0][1] = 2.0;
    array[1][0] = 4.0;
    array[1][1] = 5.0;
    Rectangle rect = Rectangle(array, 2);

    rect.getInfo();
    cout << "Area: " << rect.getArea() << endl;
    cout << "Perimeter: " << rect.getPerimeter() << endl;

    return 0;
}