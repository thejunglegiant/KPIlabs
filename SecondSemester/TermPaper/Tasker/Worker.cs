namespace Tasker {
    public class Worker {
        public string Name { get; set; }
        public string Surname { get; set; }
        internal int Load { get; set; }

        public Worker(string name, string surname) {
            this.Name = name;
            this.Surname = surname;
            this.Load = 0;
        }
    }
}
