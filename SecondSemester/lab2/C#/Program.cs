using System;

namespace lab2 {
    class Program {
        static void Main(string[] args) {
            int amountOfLines = 3;
            Line[] lines = new Line[amountOfLines];
            
            for (int j = 0; j < amountOfLines; j++) {
                lines[j] = inputString(1000);
            }
            Console.WriteLine();

            // Creating a Text instance
            Text text = new Text(lines);

            // Find the longest line in text
            Console.Write("The longest line: ");
            text.findBiggest().outputString();
            Console.WriteLine();

            // How often char appears in text
            Console.WriteLine("Char percentage: " + (int)(text.getPercentage('j') * 100) + "%");

            // Amount of chars in the whole text
            Console.WriteLine("Text length: " + text.getLength());
            
            // Add/Remove line
            Console.WriteLine("With added line:");
            text.addLine(lines[0]);
            text.outputText();
            Console.WriteLine();
            Console.WriteLine("With removed line:");
            text.removeLine(3);
            text.outputText();
            Console.WriteLine();

            // Clear the whole text
            Console.WriteLine("Full text: ");
            text.outputText();
            Console.WriteLine();
            text.clearText();
            Console.WriteLine("Cleared text: ");
            text.outputText();
            Console.WriteLine();
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
