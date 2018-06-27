/*
 ** Author: William Brown
 ** UNCC ID: 800816688
 ** Course Name: ECGR 2103
 ** Assignment Number: 7 problem 9.1
 ** Description: This program takes is a string and 
 ** corrects the error in capitization and spaceing.
 */
#include <iostream>
#include <string>
using namespace std;

void editSentence(string str);

int main()
{
    string sentence;
    char cont = 'Y';
    
    //Continues loop to keep the program running until the user prompts to stop
    while(toupper(cont) == 'Y')
    {
        // Asks the user to enter the sentence and assigns this information to
        // the variable sentence.
        cout << "Please enter a sentence you wish to have edited" << endl;
        cout << "the sentence should be no longer than 100 characters." << endl;
        getline(cin, sentence);
        
        // Checks to see if the string entered is of a valid length
        if((!sentence.empty()) && (sentence.length() < 100))
        {
            // Runs the edit sentence function to change the sentence as needed.
            editSentence(sentence);
            // Asks the user if they would like to correct another sentence
            cout << "Would you like to edit another sentence? Y/N" << endl;
            cin >> cont;
        }
        else
            cout << "The sentence that you entered was either empty or too long." << endl;
            // tells the user if the sentence they entered is invalid
        
    }
        return 0;
}

// runs through the sentence to check for capitization and spacing errors
void editSentence(string str)
{
    // Loops through the char array that is a string
    for(int i = 0; i < str.length(); i++)
    {
        // if it is the first letter or space in the string
        if(i == 0)
        {
            // if the first char in the string is a empty char
            if(str.at(i) == ' ')
            {
                //It moves the char in the next index up one space.
                for(int j = 0; (j < str.length()) && (str.at(j+1) == ' '); j++)
                    for(int k = 0; k < str.length(); k++)
                        str.at(k) = str.at(k+1);
            }
            // makes sure that the first letter is an upper case letter
            else
                str.at(i) = toupper(str.at(i));
        }
        // if not the first char in the string.
        else
        {
            // Checks to make sure there is only one space.
            if(str.at(i) == ' ')
            {
                for(int j = i; (j < str.length() - 1) && (str.at(i+1) == ' '); j++)
                {
                    for(int k = i; k < str.length(); k++)
                    {
                        if((k+1) < str.length())
                        {
                            str.at(k) = str.at(k+1);
                        }
                        else
                        {
                            str.at(k) = ' ';
                        }
                    }
                }
            }
            // makes sure that all chars after the first letter are lower case.
            else
            {
                str.at(i) = tolower(str.at(i));
            }
        }
    }
    
    // Prints out the new sentence
    cout << str << endl;
}