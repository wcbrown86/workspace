#!/bin/sh

RESULTDIR=result/

if [ ! -d ${RESULTDIR} ];
then
    mkdir ${RESULTDIR}
fi

P=${PBS_NP}
SIZE="11400 36000 72000"

for sz in $SIZE ;
do
   mpirun ./mpi_heat $sz 5 2> ${RESULTDIR}/strong_${sz}_${P}
done
