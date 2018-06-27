#!/bin/bash

# does not account for neg numbers
sci_notation_regex='^[0-9]+([.][0-9]+)?(e[0-9]+|e-[0-9]+)?$'

function test_time {
    # compare 
    if [[ $1 =~ $sci_notation_regex ]] ; 
    then
#        echo time properly formatted 
	echo -n ''
    else
        echo ERROR: time is not on stderr or not formatted properly
        echo
        rm .time
        exit 1
    fi
    # delete tmp file 
    rm .time
}

SUCCESS_FILE=.passed_numint

if [ -e ${SUCCESS_FILE} ] ; 
then
    rm ${SUCCESS_FILE} 
fi

# dynamic test cases
while read test; 
do
t=($test)
#correctness
ANSW=$(./numint ${t[0]} 1 10 ${t[1]} ${t[2]} ${t[3]} ${t[4]} ${t[5]} 2> .time)
#echo ${ANSW}
if ./approx ${ANSW} ${t[6]};
then
#    echo correct 
# check time format
    test_time $(cat .time)

else # display error and quit
    echo FAIL: "./numint ${t[0]} 1 10 ${t[1]} ${t[2]} ${t[3]} ${t[4]} ${t[5]}" should give roughly "${t[6]}" not ${ANSW}
    exit 1
fi

done < util/test_numint_cases.txt


touch ${SUCCESS_FILE} 

# all tests passed
echo ================================
echo
echo Success! All NUMINT tests passed! ":)"
