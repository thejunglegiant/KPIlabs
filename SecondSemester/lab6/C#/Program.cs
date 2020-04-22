using System;

namespace lab6 {
    class Program {
        static void Main(string[] args) {
            Expression expression = new Expression(2, -1, -3);
            try {
                Console.WriteLine(expression.getAnswer());
            } catch(DivideByZeroException e) {
                Console.WriteLine(e.Message);
            } catch(ZeroOrLessException e) {
                Console.WriteLine(e.Message);
            }
        }
    }
}
