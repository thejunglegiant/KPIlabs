#include <iostream>

using namespace std;

/*
All the words which are placed on even positions need to be written in reverse order.
*/

int main() {
    char *str = "Odd even1 odd even2 odd even3 odd even4 odd even5 odd even6";
    int i = 0;
    int even = 1;

    while (str[i] != '\0') {
        if (str[i] == ' ') {
            cout << " ";
            even++;

            // Looking for even word
            if (even % 2 == 0) {
                int j = i + 1;
                int temp = 0;

                // Gets it's length
                while (str[j] != ' ') {
                    if (j == strlen(str)) {
                        break;
                    }
                    j++;
                }
                temp = j - 1;

                // Writes the word in reverse order
                for (; i < j; j--) {
                    if (str[j] != ' ') {
                        cout << str[j];
                    }
                }
                i = temp;
            }
        } else {
            cout << str[i];
        }
        i++;
    }

    cout << endl;
    return 0;
}