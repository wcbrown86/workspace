#!/bin/sh

RESULTDIR=result/
h=`hostname`

if [ "$h" = "mba-i1.uncc.edu"  ];
then
    echo Do not run this on the headnode of the cluster, use qsub!
    exit 1
fi

if [ ! -d ${RESULTDIR} ];
then
    mkdir ${RESULTDIR}
fi


NS="1000 100000"
THREADS="2 8 12 16"


# bench
for m in $NS;
do
for n in $NS;
do
    for t in $THREADS;
    do
	./lcs $m $n $t >/dev/null 2> ${RESULTDIR}/lcs_${m}_${n}_${t}
#	./lcs 1000 1000 $t >/dev/null 2> ${RESULTDIR}/lcs_1000_1000_${t}
#	./lcs 1000 100000 $t >/dev/null 2> ${RESULTDIR}/lcs_1000_100000_${t}
#	./lcs 100000 100000 $t >/dev/null 2> ${RESULTDIR}/lcs_100000_100000_${t}
    done
done
done
