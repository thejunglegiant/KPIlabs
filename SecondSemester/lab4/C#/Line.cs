using System;

namespace lab4 {
    public class Line {
        private char[] _line;

        public Line(int length) {
            this._line = new char[length];
        }

        public Line(string newLine) {
            this._line = newLine.ToCharArray();
        }

        public Line(char[] newLine) {
            this._line = newLine;
        }

        public Line(Line anotherLine) {
            this._line = anotherLine.getLine();
        }

        public char this[int i] {
            get {
                return this._line[i];
            }
        }

        public int getLength() {
            return this._line.Length;
        }

        public char[] getLine() {
            return this._line;
        }

        public string getString() {
            return new string(this._line);
        }

        public static Line operator +(Line a, Line b) {
            char[] temp = new char[a.getLength() + b.getLength()];
            int i = 0;

            for (; i < a.getLength(); i++)
                temp[i] = a[i];
            for (; i < temp.Length; i++)
                temp[i] = b[i - a.getLength()];
            
            return new Line(temp);
        }

        public static Line operator -(Line main, char symbol) {
            for (int i = 0; i < main.getLength(); i++) {
                if (main._line[i] == symbol) {
                    char[] temp = new char[main.getLength() - 1];
                    int j = 0;

                    for (; j < i; j++) {
                        temp[j] = main._line[j];
                    }
                    for (; j < main.getLength()-1; j++) {
                        Console.WriteLine(j);
                        temp[j] = main._line[j+1];
                    }
                    
                    return new Line(temp);
                }
            }

            return main;
        }
    }
}
