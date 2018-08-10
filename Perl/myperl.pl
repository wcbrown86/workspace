#!/usr/bin/perl

# This is a comment in perl. The "program" does not preform any function, this
# is used to help me learn some of the basics of Perl.

$myvar = "this is a variable, it does not look at type.";
print "$myvar\n"; # The print funciton does not automatically give a newline. 

@array = ("This", "is", "How", "we", "do", "arrays");
$count = $#array + 1; # this will give you the count of the array
print "$count\n";

# Diconary or key,value pair array.
%user = ("username" => "williamBrown", "password" => "password", "name" => "William Brown");
print $user{"name"}. "\n"; # the dot is used as concatinate.


# Grabbing user input
print "what is your name. ";
$input = <STDIN>;
chomp($input);
print "Hello ".$input."\n";

# @ARGV is the standard array that is used to store arguments passed to the program. 

# != ne, == eq, greater than gt, less than lt, greater than or equal gtl, less than or equal lte