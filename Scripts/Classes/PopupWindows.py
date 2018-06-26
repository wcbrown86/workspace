from PyQt5 import QtGui
import sys


class PopupWindows:

    def __init__(self, input):

        self.input = input
        print("This is just a test")

    def create_window(self):
        app = QtGui.QGuiApplication(sys.argv)
        window = QtGui.QWindow()
        window.setGeometry(0, 0, 500, 300)
        return window
