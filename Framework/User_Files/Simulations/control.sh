#!/bin/bash

clear

	x=1; j=1
	yorn='n'
	
	echo "=============================================================================================="
	echo "=============================================================================================="
	echo
	echo "Run a test from the remote Gatling host against a cloud-based System Under Test."
	echo
	echo "=============================================================================================="
	echo "=============================================================================================="
	echo 
	echo "Use this script to run a test from the Gatling host against an existing application instance."
	echo "Currently, you can run with defaults or you can modify various runtime parameters."
	echo 
	echo "=============================================================================================="
	echo "=============================================================================================="
	echo 
	echo "Defaluts that can be overridden re as follows:"
	echo
	echo
	echo "Number of iterations.............10"
	echo "Ramp up time.................... 20 (seconds)"
	echo "Number of users for SIMULATION_1..5"
	echo "Number of users for SIMULATION_2..5"
	echo "Number of users for SIMULATION_3. 2"
	echo "Number of users for SIMULATION_2. 2"
	echo 
	echo "Defaults that currently cannot be overridden:"
	echo
	echo "HOST..............................ec2-54-74-168-205.eu-west-1.compute.amazonaws.com:8080"
	echo "GATLING_HOME....................../users/gatling-3.0.3/"
	echo 
	echo "=============================================================================================="
	echo "=============================================================================================="
	read -p "Hit <enter> to continue."
	echo
	clear
	echo "=============================================================================================="
	echo "=============================================================================================="
	echo 
	echo "Defaluts that can be overridden re as follows:"
	echo
	echo
	echo "Number of iterations.............10"
	echo "Ramp up time.................... 20 (seconds)"
	echo "Number of users for SIMULATION_1..5"
	echo "Number of users for SIMULATION_2..5"
	echo "Number of users for SIMULATION_3. 2"
	echo "Number of users for SIMULATION_2. 2"
	echo 
	echo "Defaults that currently cannot be overridden:"
	echo
	echo "HOST..............................ec2-54-74-168-205.eu-west-1.compute.amazonaws.com:8080"
	echo "GATLING_HOME....................../users/gatling-3.0.3/"
	echo 
	echo "=============================================================================================="
	echo "=============================================================================================="
	echo "When prompted, enter D for defaults, as defined above or"
	echo "enter O and then enter override values as prompted. Case doesn't matter."
	echo
	echo "Defaults............D"
	echo "You will not prompted for further inupt."
	echo
	echo "Override vars......O"
	echo "Note: If overriding defaults, you are required to enter all values."
	echo
	echo "Enter these operands when prompted:"
	echo "Iteratons........i"
	echo "Ramp.............r"
	echo "Simulation(s).......1,2,3,4"
	echo
	echo "=============================================================================================="
	read -p "Enter D (Defult) or O (Override): " var

  	case  $var  in
		[D,d])       
			clear
			echo "=============================================================================================="
			echo
			echo "Running with Default runtime values."
			echo
			echo "Iterations............10"
			echo "Ramp up time..........20 (Seconds)"
			echo "Simulation_1 Users....5"
			echo "Simulation_2 Users....5"
			echo "Simulation_3 Users....2"
			echo "Simulation_4 Users....2"
			echo 
			echo "=============================================================================================="

			ssh -i "~/.ssh/tsummers-ec2.pem" root@ec2-54-155-136-115.eu-west-1.compute.amazonaws.com /usr/gatling-3.0.3/user-files/simulations/gat.sh

			break
                    ;;
		[O,o])
			clear
			while [ "$yorn" == "n" ];
			  do
				echo "=============================================================================================="
				echo
				echo "How Many Iterations?"
				read -p  'Enter number: ' iterations 
				echo "Ramp up time"
				read -p  'Enter number: ' ramp
				echo "Users for Simulation 1"
				read -p  'Enter number: ' s1
				echo "Users for Simulation 2"
				read -p  'Enter number: ' s2
				echo "Users for Simulation 3"
				read -p  'Enter number: ' s3
				echo "Users for Simulation 4"
				read -p  'Enter number: ' s4
				clear
				echo "==================================================="
				echo
				echo "Running with the following controls"
				echo
				echo "Iterations..............$iterations"
				echo "Ramp up time............$ramp (seconds)"
				echo "Simulation 1 Users......$s1"
				echo "Simulation 2 Users......$s2"
				echo "Simulation 3 Users......$s3"
				echo "Simulation 4 Users......$s4"
				echo
				echo "==================================================="
				read -p "Run with these overrides? Y or N: " yorn

			done
		    ;;
		esac 

		echo "Running..."
		~/.ssh/runremote.sh $iterations $ramp $s1 $s2 $s3 $s4

#	done
