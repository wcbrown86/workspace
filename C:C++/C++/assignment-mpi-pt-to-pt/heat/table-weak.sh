#!/bin/sh

RESULTDIR=result/

SIZE_1="7900 11400 15600"
SIZE_4="15800 22800 31200"
SIZE_9="23700 34200 46800"
SIZE_16="31600 45600 62400"
SIZE_25="39500 57000 78000"
SIZE_36="47400 68400 93600"

for i in 1 4 9 16 25 36;
do
    echo ${i}
    SIZE=SIZE_${i}
    for sz in ${!SIZE} ;
    do
        echo $sz $(cat ${RESULTDIR}/weak_${sz}_${i})
#        echo $i $(cat ${RESULTDIR}/${sz}_${i})
    done

    echo "------------------------"
  
done

