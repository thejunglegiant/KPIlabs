using System;

namespace lab6 {
    public class Expression {
        private double _a, _c, _d;

        public Expression(double a, double c, double d) {
            this._a = a;
            this._c = c;
            this._d = d;
        }

        public double a {
            set { this._a = value; }
            get { return this._a; }
        }
        public double c {
            set { this._c = value; }
            get { return this._c; }
        }
        public double d {
            set { this._d = value; }
            get { return this._d; }
        }

        public double getAnswer() {
            if(this._c + this._a == 1)
                throw new DivideByZeroException("Division by zero is impossible!");

            if(this._d <= 0)
                throw new ZeroOrLessException("d value must be strictly more than zero!");
                
            return fun();
        }

        private double fun() {
            return (2*this._c - this._d*Math.Sqrt(42*this._d))
                / (this._c + this._a - 1);
        }
    }
}