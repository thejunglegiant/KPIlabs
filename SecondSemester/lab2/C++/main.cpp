#include <iostream>
#include "Line.h"
#include "Text.h"

using namespace std;

int main(int argc, const char * argv[]) {
    // Creating a Text instance
    Text text = Text();

    string line = "";
    int amountOfRaws = 0;
    cout << "Enter amount of raws: ";
    cin >> amountOfRaws;
    
    for(int i = 0; i < amountOfRaws; i++) {
        cout << "Enter " << i + 1 << " raw: ";
        cin >> line;
        char* arrayOfTextToAdd = new char[line.length()];
        
        for(int i = 0; i < sizeof(line); i++)
            arrayOfTextToAdd[i] = line[i];
        text.addLine(arrayOfTextToAdd);
        line = "";
    }
    
    // Just your text
    cout << "Your text: \n";
    text.outputText();

    // Find the longest line in text
    cout << "The longest line is: " << endl;
    text.findBiggest().outputString();

    // How often char appears in text
    cout << "Per cent of numbers in your text = " << int(text.getPercentage('j') * 100) << "%" << endl;

    // Amount of chars in the whole text
    cout << "Text length: " << text.getLength() << endl;    
    
    // Remove the second line
    text.removeLine(2);
    cout << "Deleted 2 raw:" << endl;
    text.outputText();
    
    // Clear text
    text.clearText();
    cout << "Text cleaned:" << endl;
    text.outputText();
    
    return 0;
}
