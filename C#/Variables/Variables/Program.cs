using System;

namespace Variables
{

    class Program
    {
        static void Main(string[] args)
        {
            variableTypes();
            formatString();
            constaintValues();
        }

        static void variableTypes()
        {
            byte number = 2;
            int count = 10;
            float totalPrice = 20.95f;
            char character = 'A';
            string firstName = "Chad";
            bool isWorking = false;

            var number2 = 2;
            var count2 = 10;
            var totalPrice2 = 20.95f;
            var character2 = 'A';
            var firstName2 = "Chad";
            var isWorking2 = true;

            Console.WriteLine("Printing Variables that are assigned Types at creation.");
            Console.WriteLine(number);
            Console.WriteLine(count);
            Console.WriteLine(totalPrice);
            Console.WriteLine(character);
            Console.WriteLine(firstName);
            Console.WriteLine(isWorking + "\n");

            Console.WriteLine("Printing variables that are assigned type by the compiler.");
            Console.WriteLine(number2);
            Console.WriteLine(count2);
            Console.WriteLine(totalPrice2);
            Console.WriteLine(character2);
            Console.WriteLine(firstName2);
            Console.WriteLine(isWorking2 + "\n");
        }

        static void formatString()
        {
            Console.WriteLine("Printing Min/Max values of data types.");
            Console.WriteLine("{0} {1}", byte.MinValue, byte.MaxValue);
            Console.WriteLine("{0} {1}" + "\n", float.MinValue, float.MaxValue);
        }

        static void constaintValues()
        {
            const float Pi = 3.14f;

            //Pi = 1; is not allowed due to const assignment

            Console.WriteLine(Pi);
        }


    }
}
