using System;
public class NoSuchWorkerException : Exception {
    public NoSuchWorkerException(string message) : base(message) {}

    public NoSuchWorkerException(string message, Exception innerException)
        : base(message, innerException) {}
}