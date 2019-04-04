package EU.Framework

import io.gatling.commons.validation._
import org.apache.commons._
import scala.io.Source
import scala.concurrent.duration._
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._
import scala.util.Random


class EUSim extends Simulation {

//****************************************************
//****************************************************
// HOSTNAME = Hostname of the test system
// ITR = Number of iterations
// RAMP = Rampup speed
// Users_1 = Number of users executing the Users_1 scenario
// Users_2 = Number of users executing the Users_2 scenario
// Users_3 = Number of users executing the Users_3 scenario
// Users_4 = Number of users executing the Users_4 scenario
//****************************************************
//****************************************************

	val HOSTNAME = System.getProperty("HOST")
	val ITR = System.getenv("ITERATIONS").toInt
	val RAMP = System.getenv("RAMP").toInt
	val Users_1  = System.getenv("SIMULATION_1").toInt
	val Users_2  = System.getenv("SIMULATION_2").toInt
	val Users_3  = System.getenv("SIMULATION_3").toInt
	val Users_4  = System.getenv("SIMULATION_4").toInt

//****************************************************
//****************************************************
//These users do the following
// Log into Datameer
// Select Filebrowser
// Create a new folder
// Filter by Workbook
// Log out
//****************************************************
//****************************************************

	val scen_1 = scenario("Users_1").repeat(1,"x"){

		//val feeder = csv("TEMPNAMES.csv").circular

		group("Scen_1"){
			repeat(1){
				exec(
       			 	EUPages.Login)
			}
      			.repeat(ITR){
				exec(EUPages.Q1)
			}
        	}
	}


	val scen_2 = scenario("Users_2").repeat(1,"x"){

		val feeder = csv("europa_tables.csv").circular

		group("Scen_2"){
			repeat(ITR){
				exec( 
				feed(feeder), 
				EUPages.Login2,
				EUPages.CA)
			}
		}
	}

	val scen_3 = scenario("Users_3").repeat(1,"x"){

		val feeder = csv("europa_tables.csv").circular

		group("Scen_3"){
			repeat(ITR){
				exec( 
				feed(feeder), 
				EUPages.Login2,
				EUPages.RA)
			}
		}
	}

	val scen_4 = scenario("Users_4").repeat(1,"x"){
		group("Scen_4"){
			repeat(ITR){
				exec(
				EUPages.Login2,
				EUPages.CreateView)
			}
		}
	}
//Ron's cluster
        val httpProtocol = http.baseUrl("http://ab92983624fe811e9a6d10a711e8cb4d-1846488253.us-east-2.elb.amazonaws.com") .inferHtmlResources() .acceptHeader("*/*") .acceptEncodingHeader("gzip, deflate") .acceptLanguageHeader("en-GB,en-US;q=0.9,en;q=0.8") .authorizationHeader("Bearer ${p_sessionId}") .contentTypeHeader("application/json") .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36")

//Tom's cluster
        val httpProtocol2 = http .baseUrl("http://ac35f3a4954d611e9b87702cf5db7ea1-1751391548.us-east-2.elb.amazonaws.com") .inferHtmlResources() .acceptHeader("*/*") .acceptEncodingHeader("gzip, deflate") .acceptLanguageHeader("en-GB,en-US;q=0.9,en;q=0.8") .authorizationHeader("Bearer ${p_sessionId2}") .contentTypeHeader("application/json") .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36") 
	setUp(
    		scen_1.inject(rampUsers(Users_1) during (RAMP seconds)).protocols(httpProtocol),
    		scen_2.inject(rampUsers(Users_2) during (RAMP seconds)).protocols(httpProtocol2),
    		scen_3.inject(rampUsers(Users_3) during (RAMP seconds)).protocols(httpProtocol2),
    		scen_4.inject(rampUsers(Users_4) during (RAMP seconds)).protocols(httpProtocol2))
}

