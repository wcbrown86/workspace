/*
 ** Author: William Brown
 ** UNCC ID: 800816688
 ** Course Name: ECGR 2103
 ** Assignment Number: 7 problem 9.8
 ** Description: This program takes a sentence and
 ** translates it to pig latin
 */

#include <iostream>
#include <string>
using namespace std;

string vowelWord(string str);
string constantWord(string str);

int main()
{
    string sentence;
    string pigLatin;
    char vowel[5] = {'A', 'E', 'I', 'O', 'U'};
    int length = 0;
    
    // Prompts user to to enter the sentence to translate
    cout << "Please enter your sentence that you would like to be \ntranslated to pig latin" << endl;
    getline(cin, sentence);
    
    // Loops through the sentence parsing out the words
    for(int i = 0; i < sentence.length(); i += length)
    {
        int start = i;
        length = 0;
        string temp;
        
        // Finds the length of the word to be translated
        for(int j = i; (j < sentence.length()) && (sentence.at(j) != ' '); j++)
        {
            length++;
        }
        // temp variable for the word to be translated
        temp = sentence.substr(start, length);
        
        // Checks to see if temp has a value
        if(temp.length() > 0)
        {
            bool isVowel = false;
            
            // Checks to see if the word starts with a vowel
            for (int j = 0; j < 5; j++)
            {
                if(toupper(temp.at(0)) == vowel[i])
                {
                        isVowel = true;
                        break;
                }
            }
            
            // Calls the right function to translate the word
            if(isVowel)
            {
                pigLatin += vowelWord(temp) + " ";
            }
            else
            {
                pigLatin += constantWord(temp) + " ";
            }

        }
        
        // Makes sure that the loop keeps moving forward
        else
        {
            length++;
        }
    }
    
    // Prints out the translated sentence
    cout << pigLatin << endl;
    
    return 0;
}

// Takes a word starting with a vowel and translates it.
string vowelWord(string str)
{
    return str + "way";
}

// Takes a word starting with a constant and translates it
string constantWord(string str)
{
    //grabs the first letter
    char first = str.at(0);
    
    // moves all the letter after the first up one position.
    for(int i = 0; i < str.length() - 1; i++)
    {
        str.at(i) = str.at(i+1);
    }
    
    //adds the first letter to the end of the word.
    str.at(str.length()-1) = first;
    
    return str + "ay";
}