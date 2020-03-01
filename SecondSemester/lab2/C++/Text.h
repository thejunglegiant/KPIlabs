#ifndef TEXT_H
#define TEXT_H

#include "Line.h"
#include <vector>

using namespace std;

class Text {
    private:
        int size = 0;
        vector<Line> text;
    public:
        void addLine(char* textToAdd);
        
        void removeLine(int rawToDelete);
        
        Line findBiggest();
        
        float getPercentage(char obj);

        void clearText();

        int getLength();

        void outputText();
};

#endif