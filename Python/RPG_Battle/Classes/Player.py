"""
    Author: William Chad Brown
    Date: July 2018

    Description:    Ths class is used by the player to create there player, and to 
                    select the types of attacks the player will like to exicute. 

    Todo:
"""

# Imports, The random class is used to deturmine the attack hit points, and the ablility to run,
import random


class Player(object):

    # __init__ function sets all the player variables to empty or 0 values. 
    # This function is not needed. Can be removed and would not effect the program. 
    def __init__(self):
        self.sex = " "
        self.damage = 0
        self.health = 0
        self.magic = 0
        self.race = " "

    # This function is called when the game starts and is used to allow the user to
    # create there player. Each attribute of the player that can be changed will prompt 
    # the user to select there prefered choice. 
    def create_player(self):

        print("Please select the attributes of your character.")

        # Prompts the user to select the characters Sex. Currently supports just
        # Male and Female. 
        selection = input("Please enter select one of the options below. \n"
                          + "1. Female  \n"
                          + "2. Male    \n")
        if selection is 1:
            self.sex = "Female"
        else:
            self.sex = "Male"

        selection_made = False

        # Loop that allows the user to select the race of the charater. 
        # The loop will continue until the user enters a correct number. 
        # any number outside of the range will be rejected and the loop will 
        # continue. 
        while selection_made is False:
            print("Please select a race.")
            print("1. Orc")
            print("2. Elf")
            print("3. Human")
            print("4. Dwarf")
            selection = input("Make a selection to see attributes\n")

            # Use inputs '1' this will set the users race as an Orc, and will set 
            # all the related charater attributes as discribed below.
            if selection is '1':
                print("You Choose the mighty Orc.")
                print("Health: 110")
                print("Damage: 25")
                print("Magic: 30")
                selection = input("Would you like to battle as an Ork. y/n \n")
                if selection is 'y' or selection is 'Y':
                    selection_made = True
                    self.health = 110
                    self.damage = 25
                    self.magic = 30
                    self.race = "Orc"
                else:
                    selection_made = False
            
            # Use inputs '2' this will set the users race as an Elf, and will set 
            # all the related charater attributes as discribed below.
            elif selection is '2':
                print("You Choose the magical Elf.")
                print("Health: 90")
                print("Damage: 20")
                print("Magic: 100")
                selection = input("Would you like to battle as an Elf. y/n \n")
                if selection is 'y' or selection is 'Y':
                    selection_made = True
                    self.health = 90
                    self.damage = 15
                    self.magic = 100
                    self.race = "Elf"
                else:
                    selection_made = False
            
            # Use inputs '3' this will set the users race as an Human, and will set 
            # all the related charater attributes as discribed below.
            elif selection is '3':
                print("You Choose the noble Human.")
                print("Health: 100")
                print("Damage: 20")
                print("Magic: 50")
                selection = input("Would you like to battle as an Human. y/n \n")
                if selection is 'y' or selection is 'Y':
                    selection_made = True
                    self.health = 100
                    self.damage = 20
                    self.magic = 50
                    self.race = "Human"
                else:
                    selection_made = False
            
            # Use inputs '4' this will set the users race as an Dwarf, and will set 
            # all the related charater attributes as discribed below.
            elif selection is '4':
                print("You Choose the mystical Dwarf.")
                print("Health: 100")
                print("Damage: 25")
                print("Magic: 40")
                selection = input("Would you like to battle as an Dwarf. y/n \n")
                if selection is 'y' or selection is 'Y':
                    selection_made = True
                    self.health = 100
                    self.damage = 25
                    self.magic = 40
                    self.race = "Dwarf"
                else:
                    selection_made = False

    # The attack function calculates the total attack damage that the player will
    # deal on the enemy. This is calculated with a random number being used as a 
    # percentage of the total players attack points. 
    def attack(self):

        rand = random.randint(0, 100)
        attack_percent = rand / 100
        damage_out = attack_percent * self.damage
        print("You attacked and did", damage_out, " damage")
        return damage_out

    # The run function uses a random number to deturmin if the player can ran away
    # from the fight. If the player is unable to run then the player will lose health
    def run(self):
        rand = random.randint(0, 100)

        if rand <= 20:
            return True
        else:
            reduce_health(10)
            return False

    # Reduce Health subtracts the provided amount from the players health. 
    #
    # Needs to have a check for the player being dead built in. 
    def reduce_health(self, x):
        self.health -= x

    # This function checks to see if the players health has dropped to zero or 
    # below, if it has then it returns true and the player is dead. If not then 
    # the player is still kicking and the fight will go on. 
    def is_dead(self):
        if self.health <= 0:
            return True
        else:
            return False





