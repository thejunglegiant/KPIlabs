#ifndef LINE_H
#define LINE_H

class Line {
    private:
        char* line;
    public: 
        Line(char* Line);
        int getLength();
        int findElement(char obj);
        void outputString();
};

#endif