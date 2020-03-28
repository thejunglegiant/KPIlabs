#ifndef RECT_H
#define RECT_H

#include "Shape.h"

class Rectangle : public Shape {
    private:
        double width, length;
    public:
        Rectangle(double**, int);
        double getArea();
        double getPerimeter();
        void getInfo();
};

#endif