"""
    Author: William Chad Brown
    Date: 06/15/2017
    Version: 1.0

    Description:    This program is intended to help with test formatting. This program
                    uses the Terminal_Commands.py to access the clipboard. The text is
                    formatted and placed baack in the clipboard. The text formatted to
                    keep its formatting when pulled from the terminal prompt and pasted
                    into a text box on a web based application.

                    If the text is to long by the character count, that is defined from the
                    variable max_char_count. Then the text is split up by the line, then before 
                    this count is exceeded by the next line four new line character are added 
                    to give a visual at the point the text needs to be broken up. This new
                    output is then placed into a text editor that the user can change, as long
                    as this editor can be called from the command line. Once in the editor 
                    the user can recopy the text in the right size chunk and rerun the program 
                    on each chunk to get the right formatting. 
"""

# Imports needed for the program to function. uses prebuilt classes
# Classes are used so the code can be reused as needed.
from Classes.Terminal_Commands import Terminal

# The user can define the max length that the text can be, this 
# count should be the total number of characters, not the work count.
# If the input exceeds this count the text will be split up and displayed. 
max_char_count = 4000

# This function uses the Terminal Class to pull the information from the clipboard
# the string is returned from the function call. and stored in from_clipboard.
# The the text is edited and a nother function call is made to add the updated
# Text back to the clip board.
def on_special_copy():

    from_clipboard = Terminal.pull_from_clipboard()

    # If statement is not accurate, currently the check_char_count only returns false
    # this is currently correct for testing.
    if check_char_count(from_clipboard) is True:
        from_clipboard = "[code] <pre> \n" + from_clipboard + "\n </pre> [/code]"
        from_clipboard = '<br />\n'.join(from_clipboard.split("\n"))
        Terminal.push_to_clipboard(from_clipboard)
    else:
        split_string = split_chunks(from_clipboard)
        Terminal.open_VSCode(split_string)


# The function checks the length of the proved string, if the string is too long then
# the function returns false, otherwise it returns true.
def check_char_count(input):

    count = len(input)

    if count < max_char_count:
        return True
    else:
        return False

# This function takes the text when it is too large and splits the text per the user
# defined max_char_count. The text is split at the new line character. Then each line 
# is added back until the next line will exceed the max_char_count. Once this point is reached
# four newline characters are added and the next line of text. This is to give the user 
# a visual of the different parts of the text. So that the user can copy the text in chucnks
# and run the program again to get the desired formatting and character count. 
def split_chunks(contents):
    next_split = max_char_count
    string_array = contents.split('\n')
    new_string = ''

    for word in string_array:
        if len(word) + len(new_string) > next_split:
            new_string += '\n\n\n\n'
            new_string += word
            next_split += max_char_count
        else:
            new_string += '\n' + word

    return new_string

# Calls the on_special_copy function to start the program.
on_special_copy()
