#ifndef EXPRESSION_H
#define EXPRESSION_H

class Expression {
    private:
        double _a, _c, _d;
        double fun();
    public:
        Expression(double, double, double);
        void setA(double);
        double getA();
        void setC(double);
        double getC();
        void setD(double);
        double getD();
        double getAnswer();
};

#endif