"""
    Author: William Chad Brown
    Date: 06/17/2018

    Description:    This class is used to allow the calling program to access or run some terminal
                    commands. This class is meant to be used by multiple programs.

    Notes:          This Class is only set up to function on a Linux or Macinosh systems. The 
                    commands that are used in this class will not function on a Windows operating 
                    system. 
"""

# Needed imports
import subprocess
import os


class Terminal(object):

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

    # This function is called when the copied text needs to be edited before it can be pasted 
    # The function writes to a file called temp.txt. If the file does not exist then it is 
    # created, if if does exist the contents of the file is overwritten. Once the file is 
    # made and the inforamtion is placed in the file, the terminal command to open Visual
    # Studio Code. This can be changed to any editor that can be launched from the command line.
    @staticmethod
    def open_VSCode(contents):
        outFile = open('temp.txt', "w")
        outFile.write(contents)
        outFile.close()
        open_code = subprocess.Popen(['/usr/local/bin/code', 'temp.txt'], stdin=subprocess.PIPE)
        open_code.communicate()[0]

    # This function is used to clean up the terminal window when needed. It calls the clear 
    # command. 
    @staticmethod
    def clear_CLI():
        subprocess.call('clear')
