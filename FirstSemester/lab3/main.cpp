#include <iostream>

using namespace std;

/*
y[0] = 0; y[k] = (y[k-1] + 1) / (y[k-1] + 2), k = 1,2,... . User enters e > 0.
The program finds y[n], that satisfies y[n] - y[n-1] < e condition.
*/

int main() {
  double e = 0.0;
  double y = 0.0;
  double oldY = 0.0;

  cout << "Enter the number which is more than zero: ";
  cin >> e;

  while (e <= 0) {
    cout << "The number is wrong, try again: ";
    cin >> e;
  }

  while (true) {
    y = (oldY + 1) / (oldY + 2);

    if (y - oldY < e) {
      cout << "The first y which satisfies conditions is: " << y << endl;
      break;
    }

    oldY = y;
  }

  return 0;
}
