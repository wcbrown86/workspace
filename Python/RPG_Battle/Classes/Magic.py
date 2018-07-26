"""
    Author: William Brown
    Date: July 2018

    Description: This class will be used to control the magic spells cast by either 
                 the players or the enemy. This will provide a central class to control 
                 the use of magic. 

    Todo:        1. Create a function that gives the user a choice of what magic spell that 
                    the user would like to use.

                 2. Create a fucntion for each magic spell. 

                 3. Created a way to control what magic spells are avalible depending on the level
                    of the user.

                 4. provide a fucntion that allows the enemy to "choice" a magic spell to cast. 
"""

class Magic(object):
    

    def __init__(self, power):
        self.power = power
