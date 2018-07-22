"""
    Author: William Brown
    Date: July 2018

    Description: This class will be used to control the magic spells cast by either 
                 the players or the enemy. This will provide a central class to control 
                 the use of magic. 
"""

class Magic(object):
    

    def __init__(self, power):
        self.power = power
