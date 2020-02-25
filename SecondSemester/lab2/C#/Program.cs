using System;
using static lab2.Text;
using static lab2.Line;

namespace lab2 {
    class Program {
        static void Main(string[] args) {
            int amountOfLines = 3;
            Line[] lines = new Line[1000];
            
            for (int j = 0; j < amountOfLines; j++) {
                lines[j] = inputString(1000);
            }
            Console.WriteLine();

            // Creating a Text instance
            Text text = new Text(amountOfLines, lines);

            // Add/Remove line
            text.addLine(lines[0]);
            text.removeLine(3);

            // Find the longest line in text
            Console.Write("The longest line: ");
            text.findBiggest().outputString();
            Console.WriteLine();

            // How often char appears in text
            Console.WriteLine("Char percentage: " + text.getPercentage('j') * 100 + "%");

            // Amount of chars in the whole text
            Console.WriteLine("Text length: " + text.getLength());

            // Clear the whole text
            Console.WriteLine("Full text: ");
            text.outputText();
            text.clearText();
            Console.WriteLine("Clear text: ");
            text.outputText();
        }

        static Line inputString(int n) {
            Console.Write("Enter your string: ");
            char[] input = new char[n];
            for (int i = 0;i < n;i++) {
                char temp = Console.ReadKey().KeyChar;
                if (i > 0 && temp == 13)
                    break;
                input[i] = temp;
            }
            Console.WriteLine();

            return new Line(input);
        }
    }
}
