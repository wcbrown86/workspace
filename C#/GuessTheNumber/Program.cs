using System;

namespace GuessTheNumber
{
    class Program
    {
        static void Main(string[] args)
        {
            string userEnteredName;
            bool willPlayGame;
            //Application starts hear by displaying the application information.
            displayApplicationInformation();

            //Gather information from the user. 
            userEnteredName = getUserInformation();

            //Ask the user if they would like to play a game.
            willPlayGame = askUserToPlayTheGame(userEnteredName);

            if (willPlayGame)
            {
                theGame(userEnteredName);
            }

            //End game message.
            Console.WriteLine("\n");
            Console.WriteLine("Thanks for playing {0}. Exiting the game, have a nice day.", userEnteredName);


        }

        static void displayApplicationInformation()
        {
            //Set Application Variables.
            string appName = "Guess The Number";
            string appVersion = "1.0.0";
            string appAuthor = "William Brown";

            printMessageInColor(ConsoleColor.Red, string.Format("{0}: Version: {1} by {2} \n", appName, appVersion, appAuthor));
        }

        static string getUserInformation()
        {
            Console.WriteLine("What is your name?");

            string userName = Console.ReadLine();

            return userName;
        }

        static bool askUserToPlayTheGame(string userName)
        {

            Console.WriteLine("\n");
            Console.WriteLine("Hello {0}, would you like to play a game of Guess The Number?", userName);

            if (yesOrNo())
                return true;
            else
                return false;

        }

        static bool yesOrNo()
        {
            Console.WriteLine("Please enter either y or n.");
            string yesOrNo = "";

            do
            {
                yesOrNo = Console.ReadLine().ToLower();

                if (yesOrNo.Equals("y"))
                {
                    return true;
                }
                else if (yesOrNo.Equals("n"))
                {
                    return false;
                }
                else
                {
                    printMessageInColor(ConsoleColor.Red, "You did not enter a valid y or n, please try again.");
                }
            } while (true);

        }

        static void theGame(string userName)
        {
            int correctNumber;
            int numberGuessed;
            bool cont = true;
            string userInput;

            correctNumber = new Random().Next(1, 11);

            do
            {
                Console.WriteLine("\n");
                Console.WriteLine("Please guess an number between 1 and 10.");

                do
                {
                    try
                    {
                        userInput = Console.ReadLine();
                        numberGuessed = Convert.ToInt32(userInput);
                        break;
                    }
                    catch (Exception)
                    {
                        printMessageInColor(ConsoleColor.Red, "Please enter a valid number.");

                    }

                } while (true);

                if (numberGuessed == correctNumber)
                {
                    printMessageInColor(ConsoleColor.Green, string.Format("Congrats {0}. You have guessed correctly.", userName));
                    cont = false;
                }
                else
                {
                    printMessageInColor(ConsoleColor.Red, string.Format("Sorry {0}.You did not answer correctly. Would you like to try again?", userName));

                    if (!yesOrNo())
                        cont = false;
                }

            } while (cont);
        }

        static void printMessageInColor(ConsoleColor color, string message)
        {
            Console.ForegroundColor = color;
            Console.WriteLine("\n");
            Console.WriteLine(message);
            Console.ForegroundColor = ConsoleColor.White;
        }
    }   

}
