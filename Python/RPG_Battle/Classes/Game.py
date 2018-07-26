"""
    Author: William Chad Brown
    Copyright: May 2018
    
    Description:    This is the Game class, in this class the battle is controlled.
                    The play_game function is called from the main file. This function
                    controls the back and forth of the turn style battle simulation.

    Todo:           1. Restructure the play_game function. 
                    2. Pull the text that is in the play_game function to a seperate 
                       function to reduce the size of the play_game function. 
"""

# Import statements that is needed for the functions. 
from .Enemy import Enemy
import random


class Game(object):

    # The init function takes the information that the user passes,
    # in the difficulty setting, and the player character information.
    # Then it uses the difficulty setting and creates a enemy.
    def __init__(self, diff, player):

        # storing difficulty and player information.
        self.difficulty = diff
        self.player = player

        # used to determine the race of the enemy.
        rand = random.randint(1, 4)

        # if group that will create the enemy with the difficulty in mind.
        # Enemy( Health, Damage, Magic, Race).
        if diff is '1':
            self.enemy = Enemy(70, 10, 10, rand)
        elif diff is '2':
            self.enemy = Enemy(80, 10, 15, rand)
        elif diff is '3':
            self.enemy = Enemy(100, 20, 30, rand)
        elif diff is '4':
            self.enemy = Enemy(130, 30, 50, rand)

    # The play game function is the main funciton that controls the 
    # back and forth. The text and controls for the fight until the 
    # player wins or one of the characters runs from the fight.  
    def play_game(self):

        # Intro text
        print("Welcome to the Battle Ring!!")
        print("The contender has stepped forward. A", self.enemy.race, " entered!!")
        winner = False

        rand = random.randint(0, 100)

        # This if statment is used to deturmine if the player or the 
        # enemy will attack first. 
        if rand <= 80:

            print("You get the jump on the enemy and get to make the first move.")

            # THe while loop that will continue until either the player or the enemy 
            # dies, or runs away from the fight. 
            while winner is False:

                print("Your turn to attack")
                print("Current health -", self.player.health)
                print("Current magic - ", self.player.magic)
                print("Select you attack type.")
                print("1. Melee attack.")
                print("2. Magic")
                print("3. Run")
                user_input = input("Please make a selection.\n")

                if user_input is '1':
                    damage_out = self.player.attack()
                    self.enemy.reduce_health(damage_out)
                elif user_input is '2':
                    damage_out = 0
                    self.enemy.reduce_health(damage_out)
                elif user_input is '3':
                    can_run = self.player.run()

                    if can_run is True:
                        print("You are able to get away. But you have been banned from the arena!!\n")
                        winner = True
                    else:
                        print("The crowd pushes you back, preventing you from getting away. You lost 10 health.\n")
                        self.player.reduce_health(10)
                        if self.player.is_dead() is True:
                            print("You Have DIED!!!. The enemy has won!\n")
                            winner = True
