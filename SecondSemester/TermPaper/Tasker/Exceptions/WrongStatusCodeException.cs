using System;
public class WrongStatusCodeException : Exception {
    public override string Message {
        get { return "Wrong status number was given"; }
    }

    public WrongStatusCodeException() : base() {}

    public WrongStatusCodeException(string message) : base(message) {}

    public WrongStatusCodeException(string message, Exception innerException)
        : base(message, innerException) {}
}