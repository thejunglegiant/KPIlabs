using System;
public class ZeroOrLessException : Exception {
    public ZeroOrLessException(string message) : base(message) {}

    public ZeroOrLessException(string message, Exception innerException)
        : base(message, innerException) {}
}