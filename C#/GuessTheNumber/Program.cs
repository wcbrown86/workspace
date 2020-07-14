using System;
using System.Globalization;
using System.Net;

namespace GuessTheNumber
{
    class Program
    {
        static void Main(string[] args)
        {
            string userEnteredName = "";
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

            //Change Text Color
            Console.ForegroundColor = ConsoleColor.Green;

            Console.WriteLine("{0}: Version: {1} by {2} \n", appName, appVersion, appAuthor);

            Console.ForegroundColor = ConsoleColor.White;
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
                yesOrNo = Console.ReadLine();

                if (yesOrNo.ToLower().Equals("y"))
                {
                    return true;
                }
                else if (yesOrNo.ToLower().Equals("n"))
                {
                    return false;
                }
                else
                {
                    Console.WriteLine("\n");
                    Console.WriteLine("You did not enter a valid y or n, please try again.");
                }
            } while (true);

        }
    
        static void theGame(string userName)
        {
            int correctNumber;
            int numberGuessed;
            bool cont = true;
            string userInput;

            correctNumber = new Random().Next(1,11);

            do
            {
                Console.WriteLine("\n");
                Console.WriteLine("Please guess an number between 1 and 10.");
                userInput = Console.ReadLine();


                do
                {
                    try
                    {
                        numberGuessed = Convert.ToInt32(userInput);
                        break;
                    }
                    catch (Exception)
                    {
                        Console.WriteLine("\n");
                        Console.WriteLine("Please enter a valid number.");

                    }

                } while (true);

                if(numberGuessed == correctNumber)
                {
                    Console.WriteLine("\n");
                    Console.WriteLine("Congrats {0}. You have guessed correctly.", userName);
                    cont = false;
                }
                else
                {
                    Console.WriteLine("\n");
                    Console.WriteLine("Sorry {0}.You did not answer correctly. Would you like to try again?", userName);

                    if (!yesOrNo())
                        cont = false;
                }

            } while (cont);
        }
    }   

}
