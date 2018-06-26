"""
    Author: William Chad Brown
    Date: 06/15/2017
    Version: 1.0

    Description:    This program is intended to help with test formatting. This program
                    uses the Terminal_Commands.py to access the clipboard. The text is
                    formatted and placed baack in the clipboard. The text formatted to
                    keep its formatting when pulled from the terminal prompt and pasted
                    into a text box on a web based application.
"""

# Imports needed for the program to function. uses prebuilt classes
# Classes are used so the code can be reused as needed.
from Classes.Terminal_Commands import Terminal
from Classes.PopupWindows import PopupWindows


# This function uses the Terminal Class to pull the information from the clipboard
# the string is returned from the function call. and stored in from_clipboard.
# The the text is edited and a nother function call is made to add the updated
# Text back to the clip board.
#
# Currently working on added a count feature that checks to make sure the string is
# not too long for the text box. If it is too long the user is shown a text box with the
# code to allow the user to reduce the length of the text.
def on_special_copy():

    from_clipboard = Terminal.pull_from_clipboard()

    # If statement is not accurate, currently the check_char_count only returns false
    # this is currently correct for testing.
    if check_char_count(from_clipboard) is True:
        from_clipboard = "<code> \n" + from_clipboard + "\n </code>"
        from_clipboard = '<br />\n'.join(from_clipboard.split("\n"))
        Terminal.push_to_clipboard(from_clipboard)
    else:
        create_popup_edit(from_clipboard)


# The function checks the length of the proved string, if the string is too long then
# the function returns false, otherwise it returns true.
#
# Current output is incorrect for the purpose of testing.
def check_char_count(input):

    count = len(input)

    if count < 4000:
        return False
    else:
        return False


# This function is used to create a popup window with the text the that user is
# trying to edit. This will allow the user to edit the size of the text to reduce it
# to a size that can be pasted into the provided window.
def create_popup_edit(input):
    popup = PopupWindows(input)
    window = popup.create_window()
    window.setTitle("Test")
    window.show()


# Calls the on_special_copy function to start the program.
on_special_copy()
