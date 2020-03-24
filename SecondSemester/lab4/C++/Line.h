#ifndef LINE_H
#define LINE_H

#include <iostream>

class Line {
    private:
        char *_line{};
        size_t size;
        void init(char *);
    public:
        Line();
        Line(char *);
        Line(const Line &);
        char* getLine();

        Line operator=(const Line &);
        Line operator+(const Line &);
        Line operator-(char);

        ~Line();
};


#endif