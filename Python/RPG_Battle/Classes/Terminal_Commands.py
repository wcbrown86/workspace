"""
    Author: William Chad Brown
    Date: 06/17/2018

    Description:    This class is used to allow the calling program to access or run some terminal
                    commands. This class is meant to be used by multiple programs.

    Notes:          This Class is only set up to function on a Linux or Macinosh systems. The 
                    commands that are used in this class will not function on a Windows operating 
                    system. 

    Todo:           Provide functions that edit the color of the text pushed to the console.
                    
"""

# Needed imports
import subprocess
import os


class Terminal(object):


    # This function is used to clean up the terminal window when needed. It calls the clear 
    # command. 
    @staticmethod
    def clear_CLI():
        subprocess.call('clear')
