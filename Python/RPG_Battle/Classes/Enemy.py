"""
    Author: William Brown
    Date: July 2018

    Description: This class is used to create and manage the enemys that the
                 the player will face. Most of the functions and actions are
                 simular or the same as the player. This class also contains 
                 the logic for the enemy attack patterns. 

    Todo:   
            1. Finish attack function.
            
            2. Refactor enemy creation. reduce code from other classes in creation
               change __init__ to only take three variables, self, level, and race. 
               have the __init__ deturmine the rest of the enemy attributes. this will 
               cut down code needed in other classes and will help with future changes.

"""

# Import staments, random is used to deturmine the attack values.
# as well as chance to run and other changing values. 
import random

class Enemy(object):

    # Init function, the current form has the calling class send 
    # all the requied informtion to create the enemy. This will be 
    # changed to have less information sent from the calling class. 
    def __init__(self, health, damage, magic, race):

        # Setting class variables based off of provided information
        self.health = health
        self.damage = damage
        self.magic = magic

        # if statments that set the enemy race. 
        if race is 1:
            self.race = "Ork"
        elif race is 2:
            self.race = "Elf"
        elif race is 3:
            self.race = "Human"
        else:
            self.race = "Dwarf"

    # Function used to reduce the health of the enemy when attacked
    def reduce_health(self, x):
        self.health -= x

    # Checks to see if the enemy is dead, the enemy is dead if health is 
    # less than or equal to 0.
    def is_dead(self):
        if self.health <= 0:
            return True
        else:
            return False
    # Function that is called to deturmine what type of attack
    # the enemy will preform, or if the enemy will attempt to run. 
    def attack(self, player):

        if self.health <= 5 and self.run() is True:
            return -100
        else:
            if player.health > 40:
                if self.magic > 10:
                    rand = random.randint(0, 100)
                    if rand > 40:
                        return self.malee()
                    
    def malee(self):

        rand = random.randint(0, 100)
        attack_percent = rand / 100
        damage_out = attack_percent * self.damage
        print("You attacked and did", damage_out, " damage")
        return damage_out

    def run(self):
        rand = random.randint(0,100)

        if rand <= 40:
            return True
        else:
            self.reduce_health(10)
            return False
