#
# Can be used from any directory to start a gatling job
# Sets defaults for command-line parameters
#


	while getopts "g:s:r:i:h:n:" opt
   	do
     		case $opt in
        		g ) GATLING_HOME=$OPTARG
				;;
        		s ) SIMULATIONS=$OPTARG
				;;
        		r ) RAMP=$OPTARG
				;;
        		i ) ITERATIONS=$OPTARG
				;;
        		h ) HOST=$OPTARG
				;;
        		n ) SCENARIO=$OPTARG
				;;
     		esac
	done

	let i=1
	
	for SIMULATION in $SIMULATIONS;do
		let SIMULATION_$i=$SIMULATION
      		echo $SIMULATION
		let i+=1
	done

	if [[ -z $SIMULATION_4 ]]; then
		let SIMULATION_4=0 
	fi

	if [[ -z $GATLING_HOME ]]; then
		GATLING_HOME='/Applications/gatling-charts-highcharts-bundle-2.3.1/'
	fi

	if [[ -z $SIMULATIONS ]]; then
		SIMULATION_1=5
		SIMULATION_2=5
		SIMULATION_3=2
		SIMULATION_4=2
	fi

	if [[ -z $ITERATIONS ]]; then
		ITERATIONS=10
	fi

	if [[ -z $RAMP ]]; then
		RAMP=20
	fi

	if [[ -z $HOST ]]; then
		HOST='ec2-54-74-168-205.eu-west-1.compute.amazonaws.com:8080'
	fi

	if [[ -z $SCENARIO ]]; then
		SCENARIO=DM.Framework.Sim
	fi

	export SCENARIO
	export HOST
	export ITERATIONS
	export RAMP
	export SIMULATION_1
	export SIMULATION_2
	export SIMULATION_3
	export SIMULATION_4
	export GATLING_HOME

# RESULT_LABEL will be added to the Gatling Report. It will aid in the identification of the test
	RESULT_LABEL=$SCENARIO-SIMULATION_1_$SIMULATION_1:SIMULATION_2_$SIMULATION_2:SIMULATION_3_$SIMULATION_3:SIMULATION_4_$SIMULATION_4:Iterations_$ITERATIONS

# ON is a Gatling parameter. It will indicate the ouptput directory, making it much easier to tell which test it is
	ON=`date +%m-%d-%y-%H:%M:%S`

	echo "========================"
	echo "SCENARIO:" $SCENARIO
	echo "HOST:" $HOST
	echo "ITERATIONS:" $ITERATIONS
	echo "RAMP:" $RAMP
	echo "SIMULATION_1:" $SIMULATION_1
	echo "SIMULATION_2:" $SIMULATION_2
	echo "SIMULATION_3:" $SIMULATION_3
	echo "SIMULATION_4:" $SIMULATION_4
	echo "GATLING_HOME" $GATLING_HOME
	echo "Output Directory:" $ON
	echo "RESULT_LABEL" $RESULT_LABEL
	echo "========================"

JAVA_OPTS="-DHOST=$HOST -DITERATIONS=$ITERATIONS -DRAMP=$RAMP -DSIMULATION_1=$SIMULATION_1 -DSIMULATION_2=$SIMULATION_2 -DSIMULATION_3=$SIMULATION_3 -DSIMULATION_4=$SIMULATION_4" $GATLING_HOME/bin/gatling.sh -on $ON -s $SCENARIO -rd $RESULT_LABEL
