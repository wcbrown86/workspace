"""
    Author: William Chad Brown
    Title: RPG Battle Sim.
    Copyright: May, 2018

    Description:    This File is used to drive the overall program. This program will
                    ask the user to create there player and then continue. 

"""

# Imports needed for the program. Both imports points to created classes
from Classes.Player import Player
from Classes.Game import Game
from Classes.Terminal_Commands import Terminal

# Local variables 
difficulty = 0
player = Player()
Terminal.clear_CLI()
# Welcome message
print("Welcome to the RPG Battle Sim 2018!")
print("Please create your player! \n\n")

# Call to create the users character.
player.create_player()

# Asks the user to select the level of difficulty. 
difficulty = input("Please select a level of difficulty. \n"
                   + "1. Easy\n"
                   + "2. Normal\n"
                   + "3. Hard\n"
                   + "4. Extreme\n")

Terminal.clear_CLI()
# While loop that contines until the player currectly creates a character.
cont = False
while cont is False:
    print("You picked a", player.sex, player.race)
    print("that has a Health of", player.health,
          "\na damage of", player.damage,
          "\na magic point of", player.magic)
    user_in = input("Would you like to start the game? y/n \n")
    if user_in is 'y' or user_in is 'Y':
        cont = True
    elif user_in is 'n' or user_in is 'N':
        user_in = input("Would you like to remake your character? y/n. No will start the game. \n")
        if user_in is 'y' or 'Y':
            player.create_player()
        elif user_in is 'n' or 'N':
            cont = True
Terminal.clear_CLI()
# Once the players character is created to the players liking the game will begin. 
game = Game(difficulty, player)

game.play_game()
