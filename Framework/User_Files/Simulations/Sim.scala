package DM.Framework

import io.gatling.commons.validation._
import org.apache.commons._
import scala.io.Source
import scala.concurrent.duration._
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._
import scala.util.Random


class Sim extends Simulation {

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

		val feeder = csv("TEMPNAMES.csv").circular

		group("Scen_1"){
			repeat(1){
				exec(
       				feed(feeder),
       			 	DMPages.Login)
			}
      			.repeat(ITR){
				exec(
				DMPages.FileBrowser, DMPages.CommonPause, 
				DMPages.NewFolder, DMPages.CommonPause,
				DMPages.FilterbyWorkbook, DMPages.CommonPause)
			}
      			.repeat(1){
				exec(
				DMPages.Logout)
			}
        	}
	}

//****************************************************
//****************************************************
// These users do the following:
// Log into Datameer
// Select Filebrowser
// Get their home folder
// Upload a new data file
// Log out
//****************************************************
//****************************************************

  	val scen_2 = scenario("Users_2").repeat(1,"x"){

  		val feeder = csv("steve.csv").circular

    		group("Scen_2") {
      			repeat(1){
      				exec(
        			feed(feeder),
        			DMPages.Login)
			}
			.repeat(ITR){
				exec(
				DMPages.FileBrowser, DMPages.CommonPause,
				DMPages.GetHomeFolder, DMPages.CommonPause,
				DMPages.NewFileUpload2, DMPages.CommonPause)
			}
			.repeat(1){
 				exec(	
				DMPages.Logout)
        		}
		}
	}

//****************************************************
//****************************************************
// These users do the following:
// Log in to Datameer
// Select Filebrowser
// Sort their workbooks
// Select a workbook
// Run the workbook
// Log out
//****************************************************
//****************************************************

  	val scen_3 = scenario("Users_3").repeat(ITR,"x"){

  		val feeder = csv("anna.csv").circular

		group("Scen_3") {
			exec(
			feed(feeder),
			DMPages.Login,
			DMPages.FileBrowser, DMPages.CommonPause,
			DMPages2.RunECWorkbook, DMPages.CommonPause,
			DMPages.Logout)
		}
	}

//****************************************************
//****************************************************
// These users do the following:
// Log in to Datameer
// Select Filebrowser
// Select a workbook
// Rearrange columns
// Run the workbook
// Log out
//****************************************************
//****************************************************

	val scen_4 = scenario("Users_4").repeat(ITR,"x"){

		val r = scala.util.Random

		var f1 = Iterator.continually(Map("f1" -> (r.nextInt(16))))
		var f2 = Iterator.continually(Map("f2" -> (r.nextInt(16))))
		var f3 = Iterator.continually(Map("f3" -> (r.nextInt(16))))
		var f4 = Iterator.continually(Map("f4" -> (r.nextInt(16))))

		group("Scen_4") {
			exec(
			feed(f1),
			feed(f2),
			feed(f3),
			feed(f4),
			DMPages2.ChangeColumns, DMPages.CommonPause, 
			DMPages.Logout)
		}
	}

	val httpProtocol=http.baseUrl("http://" + HOSTNAME) .inferHtmlResources() .acceptHeader("*/*") .acceptEncodingHeader("gzip, deflate") .acceptLanguageHeader("en-US,en;q=0.9") 
		.userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36")

	setUp(
    		scen_1.inject(rampUsers(Users_1) during (RAMP seconds)),
    		scen_2.inject(rampUsers(Users_2) during (RAMP seconds)),
		scen_3.inject(rampUsers(Users_3) during (RAMP seconds)),
    		scen_4.inject(rampUsers(Users_4) during (RAMP seconds))).protocols(httpProtocol)
}
