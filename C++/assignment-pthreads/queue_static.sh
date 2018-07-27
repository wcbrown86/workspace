#!/bin/sh


RESULTDIR=result/
h=`hostname`



if [ ! -e .passed_static ];
then
    echo "You must pass all test before submitting"
    exit 1
fi

if [ ! -d ${RESULTDIR} ];
then
    mkdir ${RESULTDIR}
fi
    

INTENSITIES="1 10 100 1000"
THREADS="1 2 4 8 12 16"
SYNCS="iteration thread"
#NSPLOT="1 10 100 1000 10000 100000 1000000 10000000 100000000"
NSPLOT="1 100 10000 1000000 100000000"





# ensure sequential data exists before running 
# assumes the $INTENSITIES and $NS are the same in bench_sequential.sh



#for intensity in $INTENSITIES;
#do
#    for n in $NSPLOT;
#    do
	for thread in ${THREADS};
	do
#	    for sync in ${SYNCS};
#	    do
#		for gran in $GRANS;
#		do
		    #if [ ${gran} -eq 1 ] && [ ${n} -ge 100000  ] ;
                    #then 
		    #    echo ${gran} ${n}  #> ${RESULTDIR}/dynamic_${n}_${intensity}_${thread}_${sync}_${gran} 
		    #else
		#	echo -n 
#		qsub -q mamba -d $(pwd) -l nodes=1:ppn=${thread} -v THREAD=${thread} run_static.sh
		# this check should round up to the nearest power of two
		qsub -q mamba -d $(pwd) -l nodes=1:ppn=16 -v THREAD=${thread} run_static.sh -l walltime=02:00:00
 #kk		        ./dynamic_sched 1 0 10 ${n} ${intensity} ${thread} ${sync} ${gran} 2>${RESULTDIR}/dynamic_${n}_${intensity}_${thread}_${sync}_${gran}  >/dev/null #   fi 
#		done
#	    done
	done 
#    done
#done
