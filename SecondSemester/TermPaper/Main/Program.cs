using System;
using System.Collections.Generic;
using Tasker;

namespace Main {
    public class Program {
        private static void Main(string[] args) {
            List<Project> projects = new List<Project>();
            List<Worker> workers = new List<Worker>();

            bool firstFlag = true;
            bool secondFlag = true;

            while (firstFlag) {
                try {
                    Console.WriteLine("\nMain Menu:");
                    Console.WriteLine("1. Create new project.");
                    Console.WriteLine("2. Choose an existing project.");
                    Console.WriteLine("3. Show staff workers.");
                    Console.WriteLine("4. Add new staff worker.");
                    Console.WriteLine("5. Exit.");
                    Console.Write("Enter option: ");
                    int choise = Int32.Parse(Console.ReadLine());
                    secondFlag = true;

                    switch (choise) {
                        case 1:
                            Console.Write("Enter your new project name: ");
                            projects.Add(new Project(Console.ReadLine()));

                            projects[projects.Count - 1].sendMessageEvent += messageToConsole;
                            projects[projects.Count - 1].sendWarningEvent += warningToConsole;

                            break;
                        case 2:
                            if (projects.Count < 1) {
                                Console.WriteLine("No projects available");
                                break;
                            }

                            Console.WriteLine("Projects:");
                            for (int i = 0; i < projects.Count; i++) {
                                Console.WriteLine("\t" + (i+1) + ". " + projects[i].Title);
                            }

                            Console.Write("Enter your project number: ");
                            choise = Int32.Parse(Console.ReadLine());

                            while (secondFlag) {
                                Console.WriteLine("\nMenu (" + projects[choise - 1].Title + "):");
                                Console.WriteLine("1. Show available workers.");
                                Console.WriteLine("2. Add worker.");
                                Console.WriteLine("3. Show tasks.");
                                Console.WriteLine("4. Create task.");
                                Console.WriteLine("5. Do task.");
                                Console.WriteLine("6. Change status.");
                                Console.WriteLine("7. Show status.");
                                Console.WriteLine("8. Remove all done tasks in the project.");
                                Console.WriteLine("9. Remove worker.");
                                Console.WriteLine("10. Delete project.");
                                Console.WriteLine("11. Back.");

                                Console.Write("Enter option: ");
                                int secondChoise = Int32.Parse(Console.ReadLine());
                                Console.WriteLine();
                                int workerIndex;
                                
                                switch (secondChoise) {
                                    case 1:
                                        if (projects[choise - 1].Staff < 1) {
                                            printWarn("No workers available. Create a new one first.");
                                            break;
                                        }

                                        Console.WriteLine("Workers:");
                                        projects[choise - 1].showProjectWorkers();

                                        break;
                                    case 2:
                                        if (workers.Count < 1) {
                                            printWarn("No workers available. Add new workers in the Main Menu first.");
                                            break;
                                        }

                                        Console.WriteLine("Workers:");
                                        for (int i = 0; i < workers.Count; i++) {
                                            Console.WriteLine("\t" + (i+1) + ". " + workers[i].Name + " " + workers[i].Surname);
                                        }

                                        Console.Write("Enter a number of worker which you want to add to the project: ");
                                        workerIndex = Int32.Parse(Console.ReadLine()) - 1;
                                        Console.WriteLine();

                                        projects[choise - 1].addWorker(workers[workerIndex]);

                                        break;
                                    case 3:
                                        if (projects[choise - 1].Staff < 1) {
                                            printWarn("No workers available. Create a new one first.");
                                            break;
                                        }

                                        Console.WriteLine("Choose a worker whose tasks you want to see.");
                                        Console.WriteLine("Workers:");
                                        projects[choise - 1].showProjectWorkers();

                                        Console.Write("Enter worker's number: ");
                                        workerIndex = Int32.Parse(Console.ReadLine()) - 1;
                                        Console.WriteLine();
                                        if (projects[choise - 1].getWorkerTasksAmount(workerIndex) < 1) {
                                            printWarn("This worker has no tasks yet");
                                            break;
                                        }

                                        Console.WriteLine("Tasks:");
                                        projects[choise - 1].showProjectTasks(workerIndex);

                                        break;
                                    case 4:
                                        if (projects[choise - 1].Staff < 1) {
                                            printWarn("No workers available. Create a new one first.");
                                            break;
                                        }

                                        Console.Write("Enter task title: ");
                                        string title = Console.ReadLine();
                                        Console.Write("Enter deadline (1 - tomorrow, 2 - day after tomorrow...): ");
                                        DateTime date = DateTime.Now.AddDays(Int32.Parse(Console.ReadLine()));
                                        Console.Write("Enter priority for the task(0-3): ");
                                        int priority = Int32.Parse(Console.ReadLine());
                                        Console.WriteLine();
                                        projects[choise - 1].createTask(title, date, priority);

                                        break;
                                    case 5:
                                        if (projects[choise - 1].Staff < 1) {
                                            printWarn("No workers available. Add workers to be able to do tasks");
                                            break;
                                        }

                                        Console.WriteLine("Choose a worker whose task is done.");
                                        Console.WriteLine("Workers:");
                                        projects[choise - 1].showProjectWorkers();
                                        Console.Write("Enter worker number: ");
                                        workerIndex = Int32.Parse(Console.ReadLine()) - 1;
                                        Console.WriteLine();

                                        if (projects[choise - 1].getWorkerTasksAmount(workerIndex) < 1) {
                                            printWarn("This worker has no tasks at all");
                                            break;
                                            
                                        }

                                        Console.WriteLine("Tasks:");
                                        projects[choise - 1].showProjectTasks(workerIndex);
                                        Console.Write("Enter a number of needed task: ");
                                        int taskIndex = Int32.Parse(Console.ReadLine()) - 1;
                                        Console.WriteLine();
                                        projects[choise - 1].doTask(workerIndex, taskIndex);

                                        break;
                                    case 6:
                                        Console.WriteLine("Options:");
                                        Console.WriteLine("1. Planned");
                                        Console.WriteLine("2. In progress");
                                        Console.WriteLine("3. Finished");

                                        Console.Write("Choose new status for the project: ");
                                        int newStatus = Int32.Parse(Console.ReadLine()) - 1;
                                        Console.WriteLine();
                                        projects[choise - 1].setStatus(newStatus);

                                        break;
                                    case 7:
                                        Console.WriteLine("Status: " + projects[choise - 1].Status);

                                        break;
                                    case 8:
                                        projects[choise - 1].removeAllDoneTasks();
                                        break;
                                    case 9:
                                        if (projects[choise - 1].Staff < 1) {
                                            printWarn("No workers for removing available.");
                                            break;
                                        }

                                        Console.WriteLine("Workers:");
                                        projects[choise - 1].showProjectWorkers();
                                        Console.Write("Enter worker number (he/she will be deleted): ");
                                        workerIndex = Int32.Parse(Console.ReadLine()) - 1;
                                        Console.WriteLine();

                                        projects[choise - 1].removeWorker(workerIndex);

                                        break;
                                    case 10:
                                        Console.Write("Are you sure? (y/n): ");
                                        string answer = Console.ReadLine();
                                        Console.WriteLine();

                                        if (answer == "y") {
                                            projects.RemoveAt(choise - 1);
                                            secondFlag = false;
                                        } else {
                                            printWarn("Project was not deleted");
                                        }
                                        
                                        break;
                                    case 11:
                                        secondFlag = false;
                                        break;
                                    default:
                                        printWarn("No such option!");
                                        break;
                                }
                            }
                            break;
                        case 3:
                            if (workers.Count < 1) {
                                printWarn("There are no workers in staff. Add new staff worker first.");
                                break;
                            }

                            Console.WriteLine("Workers:");
                            for (int i = 0; i < workers.Count; i++) {
                                Console.WriteLine("\t" + (i+1) + ". " + workers[i].Name + " " + workers[i].Surname);
                            }

                            break;
                        case 4:
                            Console.Write("Enter new worker name: ");
                            string name = Console.ReadLine();
                            Console.Write("Enter new worker surname: ");
                            string surname = Console.ReadLine();
                            Console.WriteLine();
                            workers.Add(new Worker(name, surname));

                            Console.WriteLine("Workers:");
                            for (int i = 0; i < workers.Count; i++) {
                                Console.WriteLine("\t" + (i+1) + ". " + workers[i].Name + " " + workers[i].Surname);
                            }

                            break;
                        case 5:
                            firstFlag = false;
                            secondFlag = false;
                            break;
                        default:
                            printWarn("No such option!");
                            break;
                    }
                } catch (FormatException) {
                    printWarn("Wrong option format");
                }
            }
        }

        private static void messageToConsole(object sender, MessageEventArgs e) {
            Console.WriteLine(e.Message);
        }

        private static void warningToConsole(object sender, MessageEventArgs e) {
            printWarn(e.Message);
        }

        private static void printWarn(string warn) {
            Console.WriteLine("\n!!! " + warn + " !!!\n");
        }
    }
}
