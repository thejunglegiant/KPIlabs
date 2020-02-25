using System;

namespace lab2 {
    class Line {
        private char[] line;
        public Line(char[] line = null) {
            this.line = line;
        }

        public void outputString() {
            for (int i = 0;i < line.Length;i++) {
                if (line[i] == default(char))
                    break;
                Console.Write(line[i]);
            }
        }

        public int getLength() {
            int i = 1;
            for (;i < line.Length;i++)
                if (line[i] == default(char))
                    break;
            
            return i;
        }

        public int findElement(char obj) {
            int counter = 0;
            for (int i = 0;i < line.Length;i++) {
                if (line[i] == default(char))
                    break;
                if (line[i] == obj)
                    counter++;
            }

            return counter;
        }
    }
}
