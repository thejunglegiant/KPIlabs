#ifndef SHAPE_H
#define SHAPE_H

class Shape {
    private:
        int size;
    public:
        double** coord;
        Shape(double**, int);
        double getLength(double, double, double, double);

        ~Shape();
};

#endif