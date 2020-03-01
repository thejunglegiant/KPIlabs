#include <iostream>
#include <string>
#include <cstring>
#include "Text.h"

using namespace std;

void Text::addLine(char* textToAdd) {
    text.push_back(textToAdd);
}

void Text::removeLine(int rawToDelete) {
    text.erase(text.begin() + rawToDelete - 1);
}

Line Text::findBiggest() {
    int maxLen = text[0].getLength();
    int max = 0;
    for(int i = 0; i < text.size(); i++) {
        if(text[i].getLength() > maxLen) {
            maxLen = text[i].getLength();
            max = i;
        }
    }
    
    return text[max];
}

float Text::getPercentage(char obj) {
    float times = 0, total = 0;
    
    for(int i = 0; i < text.size(); i++) {
        total += float(text[i].getLength());
        times += float(text[i].findElement(obj));
    }

    return (times / total);
}

void Text::clearText() {
    text.erase(text.begin(), text.end());
}

int Text::getLength() {
    int total = 0;

    for(int i = 0; i < text.size(); i++)
        total += text[i].getLength();

    return total;
}

void Text::outputText() {
    for(Line line : text)
        line.outputString();
}