"""
    Author: William Chad Brown
    Copyright: May 2018
    Description:    This is the Game class, in this class the battle is controlled.
                    The play_game function is called from the main file. This function
                    controls the back and forth of the turn style battle simulation.
"""
from .Enemy import Enemy
import random


class Game(object):

    # init function, stores the player information and creates the enemy.
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

    def play_game(self):
        print("Welcome to the Battle Ring!!")
        print("The contender has stepped forward. A", self.enemy.race, " entered!!")
        winner = False

        rand = random.randint(0, 100)

        if rand <= 80:

            print("You get the jump on the enemy and get to make the first move.")
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
