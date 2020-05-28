using System;
using System.Collections.Generic;

namespace Tasker {
    public class Project {
        public event EventHandler<MessageEventArgs> sendMessageEvent;
        public event EventHandler<MessageEventArgs> sendWarningEvent;

        // Status: 0 - planned, 1 - in progress, 2 - finished;
        private int _status;
        private string _title;
        private Dictionary<Worker, List<Task>> storage;

        public Project(string title) {
            this._title = title;
            this._status = 0;
            this.storage = new Dictionary<Worker, List<Task>>();
        }

        public string Title {
            set { this._title = value; }
            get { return this._title; }
        }

        public string Status {
            get {
                if (this._status == 0) {
                    return "Planned";
                } else if (this._status == 1) {
                    return "In progress";
                } else {
                    return "Finished";
                }
            }
        }

        public int Staff {
            get { return this.storage.Keys.Count; }
        }

        public void setStatus(int newStatus) {
            try {
                if (newStatus < 0 || newStatus > 2)
                    throw new WrongStatusCodeException();

                this._status = newStatus;
            } catch (WrongStatusCodeException e) {
                sendWarningEvent?.Invoke(this, new MessageEventArgs(e.Message));
            }
        }

        public void addWorker(Worker newWorker) {
            try {
                if (this.storage.ContainsKey(newWorker)) {
                    throw new WorkerAlreadyExistsException(
                        "A worker named " + newWorker.Name + " already exists"
                    );
                }

                this.storage.Add(newWorker, new List<Task>());
            } catch (WorkerAlreadyExistsException e) {
                sendWarningEvent?.Invoke(this, new MessageEventArgs(e.Message));
            }
        }

        public void removeWorker(int workerIndex) {
            Worker[] workers = new Worker[this.storage.Count];
            this.storage.Keys.CopyTo(workers, 0);

            this.storage.Remove(workers[workerIndex]);
        }

        public void createTask(string title, DateTime deadline, int priority = 0) {
            try {
                Task newTask = new Task(title, priority, deadline);
                Worker[] workers = new Worker[this.storage.Keys.Count];
                this.storage.Keys.CopyTo(workers, 0);

                Worker mostSuitableWorker = workers[0];
                foreach (Worker person in workers) {
                    if (person.Load < mostSuitableWorker.Load)
                        mostSuitableWorker = person;
                }
                
                mostSuitableWorker.Load++;
                this.storage[mostSuitableWorker].Add(newTask);
                this.storage[mostSuitableWorker].Sort();
            } catch (DeadlineExpiredException e) {
                sendWarningEvent?.Invoke(this, new MessageEventArgs(e.Message));
            } catch (ArgumentException e) {
                sendWarningEvent?.Invoke(this, new MessageEventArgs(e.Message));
            }
        }

        public void showProjectTasks(int workerIndex) {
            Worker[] workers = new Worker[this.storage.Count];
            this.storage.Keys.CopyTo(workers, 0);
            int counter = 1;
            
            foreach (Task item in this.storage[workers[workerIndex]]) {
                sendMessageEvent?.Invoke(this, new MessageEventArgs(
                    "\t" + counter + ". " + item.Title + ", deadline: "
                    + item.Deadline.ToShortDateString() + ", " + item.Priority
                    + ", " + item.Status)
                );

                counter++;
            }

            if (counter == 1)
                sendWarningEvent(this, new MessageEventArgs("No tasks exist"));
        }


        public void showProjectWorkers() {
            int counter = 1;

            foreach (Worker person in this.storage.Keys) {
                sendMessageEvent?.Invoke(this, new MessageEventArgs(
                    "\t" + counter + ". " + person.Name + " " + person.Surname)
                );

                counter++;
            }

            if (counter == 1)
                sendWarningEvent(this, new MessageEventArgs("No workers exist"));
        }

        public void doTask(int workerIndex, int index) {
            try {
                Worker[] workers = new Worker[this.storage.Count];
                this.storage.Keys.CopyTo(workers, 0);

                this.storage[workers[workerIndex]][index].done();
            } catch(ArgumentOutOfRangeException) {
                sendWarningEvent?.Invoke(this, new MessageEventArgs(
                    "There is no such a task"
                ));
            }
        }

        public int getWorkerTasksAmount(int workerIndex) {
            Worker[] workers = new Worker[this.storage.Count];
            this.storage.Keys.CopyTo(workers, 0);

            return this.storage[workers[workerIndex]].Count;
        }

        private List<Task> getAllDoneTasks() {
            List<Task> tmp = new List<Task>();

            foreach (List<Task> list in this.storage.Values)
                foreach (Task item in list)
                    if (item.Status == "Done")
                        tmp.Add(item);
            
            return tmp;
        }

        public void removeAllDoneTasks() {
            int counter = 1;

            foreach (Task item in this.getAllDoneTasks()) {
                foreach (List<Task> list in this.storage.Values) {
                    list.Remove(item);
                    counter++;
                }
            }

            if (counter == 1)
                sendWarningEvent(this, new MessageEventArgs("No done tasks exist"));
        }
    }
}
