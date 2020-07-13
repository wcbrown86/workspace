using System;
using System.Globalization;

namespace Operators
{

    class Program
    {
        static void Main(string[] args)
        {
            integerMath();
            orderOfOperation();
            comparisionOperators();
        }

        static void integerMath()
        {
            var a = 10;
            var b = 3;

            Console.WriteLine(a + b);
            Console.WriteLine(a / b);
            Console.WriteLine((float)a / (float)b + "\n");
        }

        static void orderOfOperation()
        {
            var a = 1;
            var b = 2;
            var c = 3;

            Console.WriteLine("Should be 7.");
            Console.WriteLine(a + b * c);

            Console.WriteLine("Should be 9.");
            Console.WriteLine((a + b) * c);
            Console.WriteLine("\n");

        }

        static void comparisionOperators()
        {
            var a = 1;
            var b = 2;
            var c = 3;

            Console.WriteLine("Should be true.");
            Console.WriteLine(a < b);

            Console.WriteLine("Should be false.");
            Console.WriteLine(a == b);

            Console.WriteLine("Should be true.");
            Console.WriteLine(a != b);

            Console.WriteLine("Should be true.");
            Console.WriteLine(c > b && c > a);

            Console.WriteLine("Should be false.");
            Console.WriteLine(c > b && c == a);

            Console.WriteLine("Should be true.");
            Console.WriteLine(c > b || c == a);

            Console.WriteLine("Should be false.");
            Console.WriteLine(!(c > b) && c > a);
        }
    }
}
