"""
    Author: William Chad Brown
    Title: RPG Battle Sim.
    Copyright: May, 2018

    Description:

"""
from Classes.Player import Player
from Classes.Game import Game

difficulty = 0
player = Player()

print("\n")
print("Welcome to the RPG Battle Sim 2018!")
print("Please create your player! \n\n")

player.create_player()

print("")
difficulty = input("Please select a level of difficulty. \n"
                   + "1. Easy\n"
                   + "2. Normal\n"
                   + "3. Hard\n"
                   + "4. Extreme\n")
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

game = Game(difficulty, player)

game.play_game()
