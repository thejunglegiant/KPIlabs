using System;
public class WorkerAlreadyExistsException : Exception {
    public WorkerAlreadyExistsException(string message) : base(message) {}

    public WorkerAlreadyExistsException(string message, Exception innerException)
        : base(message, innerException) {}
}