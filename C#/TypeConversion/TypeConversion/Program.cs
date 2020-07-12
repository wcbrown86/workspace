using System;
using System.Activities.Statements;

namespace TypeConversion
{

    class Program
    {
        static void Main(string[] args)
        {
            byteToInt();
            intToByte();
            varToInt();
            stringToBoolean();
        }

        static void byteToInt()
        {
            byte b = 1;
            int i = b;

            Console.WriteLine("The byte was converted to an int.");
            Console.WriteLine(i + "\n");
        }

        static void intToByte()
        {
            int i = 100;
            // This will give an error must cast informtion due to lost of data
            //byte b = i;
            byte b = (byte)i;

            Console.WriteLine("The int was converted to a byte, information was lost.");
            Console.WriteLine(b + "\n");

        }

        static void varToInt()
        {
            var number = "1234";
            int i = Convert.ToInt32(number);

            Console.WriteLine("var string value was converted to an int.");
            Console.WriteLine(i + "\n");

            
            try
            {
                var numberToByte = "1234";
                byte b = Convert.ToByte(numberToByte);
                //"Attempt to convert var string value to byte, this will fail."
                Console.WriteLine(b);
            }
            catch (Exception)
            {
                Console.WriteLine("The number could not be converted to a byte.\n");
            }
        }

        static void stringToBoolean()
        {
            try
            {
                string str = "true";
                bool b = Convert.ToBoolean(str);

                Console.WriteLine("Converting string to boolean.");
                Console.WriteLine(b + "\n");
            }
            catch (Exception)
            {
                Console.WriteLine("The conversion from tring to boolean failed.");
            }
        }
    }
}
