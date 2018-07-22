"""
    Author: 
    Date:

    Description:
"""
import random


class Player(object):

    def __init__(self):
        self.sex = " "
        self.damage = 0
        self.health = 0
        self.magic = 0
        self.race = " "

    def create_player(self):

        print("Please select the attributes of your character.")

        selection = input("Please enter select one of the options below. \n"
                          + "1. Female  \n"
                          + "2. Male    \n")
        if selection is 1:
            self.sex = "Female"
        else:
            self.sex = "Male"

        selection_made = False
        while selection_made is False:
            print("Please select a race.1")
            print("1. Orc")
            print("2. Elf")
            print("3. Human")
            print("4. Dwarf")
            selection = input("Make a selection to see attributes\n")

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

    def attack(self):

        rand = random.randint(0, 100)
        attack_percent = rand / 100
        damage_out = attack_percent * self.damage
        print("You attacked and did", damage_out, " damage")
        return damage_out

    def run(self):
        rand = random.randint(0, 100)

        if rand <= 20:
            return True
        else:
            return False

    def reduce_health(self, x):
        self.health -= x

    def is_dead(self):
        if self.health <= 0:
            return True
        else:
            return False





