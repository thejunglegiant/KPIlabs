using System;

namespace Tasker {
    internal class Task : IComparable<Task> {
        private string _title;
        // Priority: 0 - low, 1 - normal, 2 - important, 3 - critical;
        private int _priority;
        // Status: 0 - In progress, 1 - Done;
        private int _status;
        private DateTime deadline;

        public Task(string title, int priority, DateTime deadline) {
            this._title = title;
            this._status = 0;
            
            if (priority < 0 || priority > 3)
                throw new ArgumentException("Wrong type for priority");
            if (deadline.CompareTo(DateTime.Now) <= 0)
                throw new DeadlineExpiredException("The deadline has already gone");

            this._priority = priority;
            this.deadline = deadline;
        }

        public int CompareTo(Task task) {
            return -this._priority.CompareTo(task._priority);
        }

        public string Title {
            get { return this._title; }
        }

        public DateTime Deadline {
            get { return this.deadline; }
        }

        public string Priority {
            get {
                if (this._priority == 0) {
                    return "Low";
                } else if (this._priority == 1) {
                    return "Normal";
                } else if (this._priority == 2) {
                    return "Important";
                } else {
                    return "Critical";
                }
            }
        }

        public string Status {
            get {
                if (this._status == 0) {
                    return "In progress";
                } else {
                    return "Done";
                }
            }
        }

        public void done() {
            this._status = 1;
        }
    }
}
