"""
    Author: William Chad Brown
    Date: 06/17/2018

    Description:    This class is used to allow the calling program to access or run some terminal
                    commands. This class is meant to be used by multiple programs.
"""

# Needed imports
import subprocess


class Terminal:

    # Unused init, was first setup for testing, the code was left encase it needs
    # to be used again later.
    def __init__(self):
        print("Start Terminal")

    # This function pulls the contents of the clip boards and translates that to a string then
    # returns that string. The command pbpaste is used to pull the information from the
    # clipboard. The information in the clipboard is converted to UTF-8 encoding to use by
    # the program.
    @staticmethod
    def pull_from_clipboard():
        return subprocess.check_output('pbpaste', env={'LANG': 'en_US.UTF-8'}).decode('utf-8')

    # This function puts the information back into the clipboard for the user to use as needed.
    # The command pbcopy is used to put the information from the program back into the clipboard.
    # Once the program fuction has run the user and paste from the clipboard as needed.
    @staticmethod
    def push_to_clipboard(contents):
        paste = subprocess.Popen('pbcopy', env={'LANG': 'en_US.UTF-8'}, stdin=subprocess.PIPE)
        paste.communicate(contents.encode('utf-8'))




