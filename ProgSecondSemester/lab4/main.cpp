#include <iostream>
#include <math.h>

using namespace std;

/*
Program needs to find a sum of (a - b)^2 n times
(n is a natural number which user enters when the app starts)
When loop iteration counter is even, then a = i / 2 and b = i + 7
else a = i, b = i^2
*/

int main() {
    int n = 0;
    double answer = 0.0;

    cout << "Enter natural n value (amount of iterations): ";
    cin >> n;

    for (int i = 1; i <= n; i++) {
        float a = i;
        float b = pow(i,2);

        if (i % 2 == 0) {
            a = i / 2;
            b = i + 7;
        }
        
        answer = pow((a - b), 2);
    }
    
    cout << "The answer equals -> " << answer << endl;

    return 0;
}