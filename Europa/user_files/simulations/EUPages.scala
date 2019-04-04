package EU.Framework

import scala.concurrent.duration._
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._
import scala.util.Random

object EUPages{


//************************************************************************************ 
//**** Sets the common pause, commonly referred to as "Think Time" between 35 and 60 sconds
//************************************************************************************ 

	val CommonPause = pause(10,15)
	val Login=group("EU_Login"){
                 exec(http("request_0") .post("/api/authenticate") .check(regex("data\":\"(.+?)\",").saveAs("p_sessionId")) .headers(EUHeaders.headers_0) .body(RawFileBody("Europa1_0000_request.txt")))

                .exec(http("request_1") .put("/api/query") .headers(EUHeaders.headers_1) .body(RawFileBody("Europa1_0001_request.txt")))
                .exec(http("request_2") .put("/api/query") .headers(EUHeaders.headers_1) .body(RawFileBody("Europa1_0002_request.txt")))
                .exec(http("request_3") .put("/api/query") .headers(EUHeaders.headers_1) .body(RawFileBody("Europa1_0003_request.txt")))
	}

	val Q1=group("EU_Web_Page_View"){
                exec(http("request_4") .put("/api/query") .headers(EUHeaders.headers_1) .body(RawFileBody("Europa1_0004_request.txt")))
               .exec(http("Web_Page_View") .put("/api/query") .headers(EUHeaders.headers_1) .body(RawFileBody("Europa1_0005_request.txt")))
	}

	val Q2=group("EU_Call_Center_View"){
		 exec(http("request_6") .put("/api/query") .headers(EUHeaders.headers_1) .body(RawFileBody("Europa1_0004_request.txt")))
                .exec(http("Call_Center_View") .put("/api/query") .headers(EUHeaders.headers_1) .body(RawFileBody("Europa1_1005_request.txt")))
	}
	
	val Q3=group("Date_Dim_View"){
                 exec(http("request_8") .put("/api/query") .headers(EUHeaders.headers_1) .body(RawFileBody("Europa1_0004_request.txt")))
		.exec(http("Date_Dim_View") .put("/api/query") .headers(EUHeaders.headers_1) .body(RawFileBody("Europa1_2005_request.txt")))
	}

	val Q4=group("Income_Band_View"){
                 exec(http("request_10") .put("/api/query") .headers(EUHeaders.headers_1) .body(RawFileBody("Europa1_0004_request.txt")))
       		.exec(http("Income_Band_View") .put("/api/query") .headers(EUHeaders.headers_1) .body(RawFileBody("Europa1_3005_request.txt")))
	}

	val Q5=group("Item_2_View"){
		 exec(http("request_12") .put("/api/query") .headers(EUHeaders.headers_1) .body(RawFileBody("Europa1_0004_request.txt")))
                .exec(http("Item_2_View") .put("/api/query") .headers(EUHeaders.headers_1) .body(RawFileBody("Europa1_4005_request.txt")))
	}
	
	val Login2=group("EU_Login2"){
		val uri1 = "http://ac35f3a4954d611e9b87702cf5db7ea1-1751391548.us-east-2.elb.amazonaws.com/api"
                exec(http("LOGIN2_1") .post("/api/authenticate") .check(regex("data\":\"(.+?)\",").saveAs("p_sessionId2")) .headers(EUHeaders.headers_C0) .body(RawFileBody("CreateArtifacts_0000_request.txt")))
                .exec(http("LOGIN2_2") .put("/api/query") .headers(EUHeaders.headers_C1) .body(RawFileBody("CreateArtifacts_0001_request.txt")))
                .exec(http("LOGIN2_3") .put("/api/query") .headers(EUHeaders.headers_C1) .body(RawFileBody("CreateArtifacts_0002_request.txt")))
                .exec(http("LOGIN2_4") .put("/api/query") .headers(EUHeaders.headers_C1) .body(RawFileBody("CreateArtifacts_0003_request.txt")))
	}

	val CA=group("Create_Artifact_${table_name}"){
                 exec(http("C_${table_name}") .put("/api/query") .headers(EUHeaders.headers_C1) .body(RawFileBody("CreateArtifacts_0004_request.txt")))
                .exec(http("C_${table_name}") .put("/api/query") .headers(EUHeaders.headers_C1) .body(RawFileBody("CreateArtifacts_0005_request.txt")))
                .exec(http("C_${table_name}") .put("/api/query") .headers(EUHeaders.headers_C1) .body(RawFileBody("CreateArtifacts_0006_request.txt")))
                .exec(http("C_${table_name}") .put("/api/query") .headers(EUHeaders.headers_C1) .body(RawFileBody("CreateArtifacts_0007_request.txt")))
                // ADD
                .exec(http("CA_${table_name}") .put("/api/command") .headers(EUHeaders.headers_C1) .body(ElFileBody("CreateArtifacts_0008_request.txt")))
                .exec(http("request_9") .put("/api/query") .headers(EUHeaders.headers_C1) .body(RawFileBody("CreateArtifacts_0009_request.txt")))
	}
	
	val RA=group("Remove_Artifact_${table_name}"){
		// DeleteArtifact
                exec(http("D_${table_name}") .put("/api/command") .headers(EUHeaders.headers_1) .body(ElFileBody("DeleteArtifacts_0004_request.txt")))
                .exec(http("D_${table_name}") .put("/api/query") .headers(EUHeaders.headers_1) .body(RawFileBody("DeleteArtifacts_0005_request.txt")))
	}

        val CreateView = group("CreateView"){
                // create view
                exec(http("request_0") .put("/api/command") .headers(EUHeaders.headers_C1) .body(RawFileBody("CreateView_0000_request.txt")))
                .exec(http("request_1") .put("/api/query") .headers(EUHeaders.headers_C1) .body(RawFileBody("CreateView_0001_request.txt")))
                .exec(http("request_2") .put("/api/query") .headers(EUHeaders.headers_C1) .body(RawFileBody("CreateView_0002_request.txt")))
                .exec(http("request_3") .put("/api/query") .headers(EUHeaders.headers_C1) .body(RawFileBody("CreateView_0003_request.txt")))

                // Create and send sql
                .exec(http("request_4") .put("/api/command") .headers(EUHeaders.headers_C1) .body(RawFileBody("CreateView_0004_request.txt")))
                .exec(http("request_5") .put("/api/query") .headers(EUHeaders.headers_C1) .body(RawFileBody("CreateView_0005_request.txt")))

                // home
                .exec(http("request_6") .put("/api/query") .headers(EUHeaders.headers_C1) .body(RawFileBody("CreateView_0006_request.txt")))
                .exec(http("request_7") .put("/api/query") .headers(EUHeaders.headers_C1) .body(RawFileBody("CreateView_0007_request.txt")))
	}
}
