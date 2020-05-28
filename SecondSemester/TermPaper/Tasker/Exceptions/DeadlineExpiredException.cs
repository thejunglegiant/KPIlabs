using System;
public class DeadlineExpiredException : Exception {
    public DeadlineExpiredException(string message) : base(message) {}

    public DeadlineExpiredException(string message, Exception innerException)
        : base(message, innerException) {}
}