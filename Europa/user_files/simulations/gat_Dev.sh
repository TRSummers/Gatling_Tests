# Can be used from any directory to start a gatling job
#
#/Applications/gatling-charts-highcharts-bundle-2.3.1/bin/gatling.sh 

GATLING_HOME="/Applications/gatling-charts-highcharts-bundle-3.0.3/"
export GATLING_HOME

# ON will indicate the ouptput directory, making it much easier to tell which test it is
ON=`date +%m-%d-%y-%H:%M:%S`

SCENARIO=`expr $1`
HOST=`expr $2`
ITERATIONS=`expr $3`
RAMP=`expr $4`
SIMULATION_1=`expr $5`
SIMULATION_2=`expr $6`
SIMULATION_3=`expr $7`
SIMULATION_4=`expr $8`


export SCENARIO
export HOST
export ITERATIONS
export RAMP
export SIMULATION_1
export SIMULATION_2
export SIMULATION_3
export SIMULATION_4

if [[ $SIMULATION_3 == '' ]]; then
	clear
	echo 
	echo "All fields are required"
	echo 
	echo "Usage: gat_Dev.sh <simulation> <host> <iterations> <ramp> <ec21> <ec22> <ec23> <ec24>"
	echo 
	echo "simulation=string, host=string, iterations=int, ramp=int, ec21=int ec22=int ec23=int"
	echo 
	echo "If you don't want to run a particular scenario, ec21, ec22 or ec23, enter 0"
	echo 
	echo 
exit
fi

echo "========================"
echo "SCENARIO:" $SCENARIO
echo "HOSTNAME:" $HOST
echo "ITERATIONS:" $ITERATIONS
echo "RAMP:" $RAMP
echo "SIMULATION_1:" $SIMULATION_1
echo "SIMULATION_2:" $SIMULATION_2
echo "SIMULATION_3:" $SIMULATION_3
echo "SIMULATION_4:" $SIMULATION_4
echo "Output Dir:" $ON
echo "========================"

JAVA_OPTS="-DHOST=$2 -DITERATIONS=$3 -DRAMP=$4 -DSIMULATION_1=$5 -DSIMULATION_2=$6 -DSIMULATION_3=$7 -DSIMULATION_4=$8" $GATLING_HOME/bin/gatling.sh -s $1 -rd $SCENARIO-SIMULATION_1_$SIMULATION_1:SIMULATION_2_$SIMULATION_2:SIMULATION_3_$SIMULATION_3:Iterations_$ITERATIONS
