#!/bin/bash #shebang. needed at the top of all shell sripts. this tells which shell to use.
# This is a comment. 
# $# is the number of arguments passed to the sript
# $* is all of the arguments passed. 

printf "Please Enter your name: "

read user_input

printf "Hello, $user_input \n"