package DM.Framework

import scala.concurrent.duration._
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._
import scala.util.Random

object DMPages2{

        val uri2 = "http://search.lookupmanager.com/glg"
        val uri3 = "http://my.datameer.com/rest/external/v1/available"

//*********************************
//*** Run Workbook
//*********************************

        val RunECWorkbook = group("RunECWorkbook") {
                //FB
		group("FileBrowser")(
                exec(http("request_0") .get("/browser/list-folders?_=1543873401197") .headers(DMHeaders.headers_9))
                .exec(http("request_1") .get("/browser/list-files?columnId=JOB_NAME&direction=ASC&from=0&rows=50&folderId=${p_homeFolder}&_=1543873401198") .headers(DMHeaders.headers_9))
                .exec(http("request_2") .get("/browser") .headers(DMHeaders.headers_0))
                .exec(http("request_3") .options("/rest/user-management?_=1543873427943") .headers(DMHeaders.headers_6))
                .exec(http("request_4") .options("/rest/user-management?_=1543873427944") .headers(DMHeaders.headers_6))
                .exec(http("request_5") .head("/user-activity") .headers(DMHeaders.headers_3))
                .exec(http("request_6") .options("/rest/user-management?_=1543873427984") .headers(DMHeaders.headers_6))
                .exec(http("request_7") .get("/rest/user-management/logged-in-user?_=1543873427832") .headers(DMHeaders.headers_9))
                .exec(http("request_8") .get("/rest/user-management/logged-in-user?_=1543873427833") .headers(DMHeaders.headers_3))
                .exec(http("request_9") .get("/rest/user-management/shareable-groups?fields=name&firstResult=0&maxResults=50&sortDir=ASC&sortBy=name&_=1543873427835") .headers(DMHeaders.headers_3))
                .exec(http("request_10") .get("/rest/user-management/authenticable-users?fields=username&firstResult=0&maxResults=50&sortDir=ASC&sortBy=username&_=1543873427834") .headers(DMHeaders.headers_3))
                .exec(http("request_11") .get("/api/filesystem/files/search/fields?_=1543873428986") .headers(DMHeaders.headers_3))
                .exec(http("request_12") .get("/browser/list-filters") .headers(DMHeaders.headers_3))
                .exec(http("request_13") .get("/browser/list-folders?_=1543873427836") .headers(DMHeaders.headers_9))
                .exec(http("request_14") .get("/internal-rest/extensionpoints/datameer.dap.sdk.exportjob.ExportFileType/registered?_=1543873427838") .headers(DMHeaders.headers_9))
                .exec(http("request_15") .get("/api/filesystem/folders/${p_homeFolder}/permission?_=1543873427837") .headers(DMHeaders.headers_13))
                .exec(http("request_16") .get("/browser/list-files?columnId=JOB_NAME&direction=ASC&from=0&rows=50&folderId=${p_homeFolder}&_=1543873427839") .headers(DMHeaders.headers_9)))

                //Sort
		.group("Sort")(
                exec(http("Sort_0") .get("/browser/list-folders?_=1543875354006") .headers(DMHeaders.headers_22))
                .exec(http("Sort_3") .get("/browser/list-folders?_=1543875354008") .headers(DMHeaders.headers_22))
                .exec(http("Sort_4") .get("/browser/list-files?columnId=JOB_NAME&direction=ASC&from=0&rows=50&folderId=${p_homeFolder}&_=1543875354009")
                        .check(regex("\"contentId\": (.+?),").find(6).saveAs("p_wbid"))
                        .check(regex("\"id\": (.+?),").find(6).saveAs("p_connected"))
                         .headers(DMHeaders.headers_22))
                .exec(http("Sort_5") .get("/api/filesystem/files/${p_connected}?_=1543875496407") .headers(DMHeaders.headers_8))
                .exec(http("Sort_6") .head("/user-activity") .headers(DMHeaders.headers_8))
                .exec(http("Sort_7") .get("/browser/list-files?columnId=JOB_NAME&direction=DESC&from=0&rows=50&folderId=${p_homeFolder}&_=1543875354010") .headers(DMHeaders.headers_22))
                .exec(http("Sort_9") .head("/check-session") .headers(DMHeaders.headers_8))
                .exec(http("Sort_10") .get("/browser/list-folders?_=1543875354011") .headers(DMHeaders.headers_22))
                .exec(http("Sort_11") .get("/browser/list-files?columnId=JOB_NAME&direction=DESC&from=0&rows=50&folderId=${p_homeFolder}&_=1543875354012") .headers(DMHeaders.headers_22)))

                // SelecWB
		.group("SelectWorkBook")(
                exec(http("request_20") .get("/browser/list-folders?_=1543868888975") .headers(DMHeaders.headers_31))
                .exec(http("request_21") .get("/browser/list-files?columnId=JOB_NAME&direction=ASC&from=0&rows=50&folderId=${p_homeFolder}&_=1543868888976") .headers(DMHeaders.headers_31))
                .exec(http("request_22") .get("/api/filesystem/files/${p_connected}?_=1543868911412") .headers(DMHeaders.headers_34)) //1373 ECWB11
                .exec(http("request_23") .get("/api/filesystem/files/${p_connected}?_=1543868911421") .headers(DMHeaders.headers_34)) //ECWB11
                .exec(http("request_24") .get("/api/filesystem/files/${p_connected}?_=1543868911463") .headers(DMHeaders.headers_34)) //ECWB11
                .exec(http("request_25") .get("/api/filesystem/files/${p_connected}?_=1543868915958") .headers(DMHeaders.headers_34)) //ECWB11
                .exec(http("request_26") .get("/api/filesystem/files/${p_connected}?_=1543868916173") .headers(DMHeaders.headers_34)) //ECWB11
                .exec(http("request_27") .get("/api/filesystem/files/${p_connected}?_=1543868916187") .headers(DMHeaders.headers_34)) //ECWB11
                .exec(http("request_28") .get("/api/workbooks/${p_wbid}/concurrent-users") .headers(DMHeaders.headers_31))
                .exec(http("request_29") .get("/workbook/${p_wbid}") .headers(DMHeaders.headers_4))
                .exec(http("request_30") .head("/user-activity") .headers(DMHeaders.headers_27))
                .exec(http("request_31") .get("/rest/user-management/logged-in-user?_=1543868916767") .headers(DMHeaders.headers_31))
                .exec(http("request_32") .get("/rest/user-management/logged-in-user?_=1543868916768") .headers(DMHeaders.headers_31))
                .exec(http("request_33") .get("/workbook/loadWorkbook/${p_wbid}/60?nocache=1543868917531") .headers(DMHeaders.headers_37)) //ECWB133
                .exec(http("request_35") .get("/api/jobConfiguration/configurationStatus/${p_wbid}?nocache=1543868917742") .headers(DMHeaders.headers_26))
                .exec(http("request_36a") .get("/api/functions?nocache=1543868917931") .headers(DMHeaders.headers_33)) //ECWB136
                .exec(http("request_39") .get("/api/filesystem/files/${p_connected}?_=1543868918265") .headers(DMHeaders.headers_34))) //ECWB11

                // Run
		.pause(15)
		.group("RunWorkBook")(
                exec(http("request_40") .post("/browser/job-execution?configuration=${p_wbid}&nocache=1543868930896") .headers(DMHeaders.headers_26))
                .exec(http("request_41") .get("/api/jobConfiguration/configurationStatus/${p_wbid}?nocache=1543868930933") .headers(DMHeaders.headers_26))
                .exec(http("request_42") .get("/api/jobConfiguration/configurationStatus/${p_wbid}?nocache=1543868931111") .headers(DMHeaders.headers_26))
                .exec(http("request_43") .get("/workbook/loadWorkbook/${p_wbid}/60?nocache=1543868931370") .headers(DMHeaders.headers_26))
                .pause(6)
                .exec(http("request_46") .get("/api/jobConfiguration/configurationStatus/${p_wbid}?nocache=1543868938326")
			.check(regex("jobId\": (.+?),").saveAs("p_jobId"))
			.headers(DMHeaders.headers_26))
                .exec(http("request_48") .get("/api/jobConfiguration/configurationStatus/${p_wbid}?nocache=1543868939344") .headers(DMHeaders.headers_26))
                .pause(1)
                .exec(http("request_50") .get("/api/jobConfiguration/configurationStatus/${p_wbid}?nocache=1543868941558") .headers(DMHeaders.headers_26))
                .pause(4)
                .exec(http("request_52") .head("/check-session") .headers(DMHeaders.headers_27))
                .pause(2)
                .exec(http("request_53") .get("/api/jobConfiguration/configurationStatus/${p_wbid}?nocache=1543868949785") .headers(DMHeaders.headers_26))
                .pause(1)
                .exec(http("request_55") .get("/api/jobConfiguration/configurationStatus/${p_wbid}?nocache=1543868951976") .headers(DMHeaders.headers_26))
                .pause(7)
                .exec(http("request_57") .get("/api/jobConfiguration/configurationStatus/${p_wbid}?nocache=1543868960202") .headers(DMHeaders.headers_26))
                .exec(http("request_58") .get("/workbook/loadWorkbook/${p_wbid}/60?nocache=1543868960683") .headers(DMHeaders.headers_26))
                .pause(1)
                .exec(http("request_61") .get("/api/jobConfiguration/configurationStatus/${p_wbid}?nocache=1543868962423") .headers(DMHeaders.headers_26))
                .exec(http("request_62") .get("/workbook/loadWorkbook/${p_wbid}/60?nocache=1543868962824") .headers(DMHeaders.headers_26))
                .pause(7))

	}

//*********
// Rearrange Columns and run workbook
//*********

        val ChangeColumns = group("ChangeColumns") {
	val r = scala.util.Random
        var f1 = 1+r.nextInt(15)
       	var f2 = 1+r.nextInt(15)
        var f3 = 1+r.nextInt(15)
        var f4 = 1+r.nextInt(15)

	     group("Login")(
              exec(http("request_0") .get("/login") .check(regex("CSRF.token = '(.+?)'").saveAs("p_csrf")) .headers(DMHeaders.headers_0))
                .exec(http("request_1") .head("/user-activity") .headers(DMHeaders.headers_3))
                .exec(http("request_2") .get("/favicon.ico") .headers(DMHeaders.headers_1))
                .exec(http("request_3") .post("/login") .headers(DMHeaders.headers_4)
                        .formParam("username", "anna4")
                        .formParam("password", "12345")
                        .formParam("datameer-csrf-token", "${p_csrf}")
                        .formParam("datameer-csrf-token", "${p_csrf}"))
                .exec(http("request_4") .options("/rest/user-management?_=1544653388363") .headers(DMHeaders.headers_6))
                .exec(http("request_5") .options("/rest/user-management?_=1544653388367") .headers(DMHeaders.headers_6))
                .exec(http("request_6") .head("/user-activity") .headers(DMHeaders.headers_3))
                .exec(http("request_7") .options("/rest/user-management?_=1544653388407") .headers(DMHeaders.headers_6))
                .exec(http("request_8") .get("/rest/user-management/logged-in-user?_=1544653388240") .headers(DMHeaders.headers_3))
                .exec(http("request_9") .get("/rest/user-management/logged-in-user?_=1544653388239") .headers(DMHeaders.headers_9))
                .exec(http("request_10") .get("/rest/user-management/shareable-groups?fields=name&firstResult=0&maxResults=50&sortDir=ASC&sortBy=name&_=1544653388242") .headers(DMHeaders.headers_3))
                .exec(http("request_11") .get("/rest/user-management/authenticable-users?fields=username&firstResult=0&maxResults=50&sortDir=ASC&sortBy=username&_=1544653388241") .headers(DMHeaders.headers_3))
                .exec(http("request_12") .get("/api/filesystem/files/search/fields?_=1544653390317") .headers(DMHeaders.headers_3))
                .exec(http("request_13") .get("/browser/list-filters") .headers(DMHeaders.headers_3))
                .exec(http("request_14") .get("/browser/list-folders?_=1544653388243") .headers(DMHeaders.headers_9))
                .exec(http("request_15") .get("/internal-rest/extensionpoints/datameer.dap.sdk.exportjob.ExportFileType/registered?_=1544653388245") .headers(DMHeaders.headers_9))
                .exec(http("request_16") .get("/api/filesystem/folders/19/permission?_=1544653388244") .headers(DMHeaders.headers_13))
                .exec(http("request_17") .get("/browser/list-files?columnId=JOB_NAME&direction=ASC&from=0&rows=50&folderId=19&_=1544653388246") .headers(DMHeaders.headers_9))
                .exec(http("request_18") .get("/browser/list-folders?_=1544653388247") .headers(DMHeaders.headers_9))
                .exec(http("request_19") .get("/browser/list-files?columnId=JOB_NAME&direction=ASC&from=0&rows=50&folderId=19&_=1544653388248") .headers(DMHeaders.headers_9))
                .exec(http("request_20") .get("/browser/list-folders?_=1544653388249") .headers(DMHeaders.headers_9)))

                // OPenExportFile
		.group("OpenExportFile")(
                exec(http("request_21") .get("/api/filesystem/files/39?_=1544653415642") .headers(DMHeaders.headers_3))
                .exec(http("request_22") .get("/api/workbooks/9/concurrent-users") .headers(DMHeaders.headers_9))
                .exec(http("request_23") .head("/check-session") .headers(DMHeaders.headers_3))
                .exec(http("request_24") .get("/workbook/9") .headers(DMHeaders.headers_0))
                .exec(http("request_25") .head("/user-activity") .headers(DMHeaders.headers_3))
                .exec(http("request_26") .get("/rest/user-management/logged-in-user?_=1544653419670") .headers(DMHeaders.headers_9))
                .exec(http("request_27") .get("/rest/user-management/logged-in-user?_=1544653419671") .headers(DMHeaders.headers_9))
                .exec(http("request_28") .get("/workbook/loadWorkbook/9/60?nocache=1544653422408") .headers(DMHeaders.headers_16))
                .exec(http("request_29") .put("/api/workbooks/39/query?nocache=1544653423961") .headers(DMHeaders.headers_19) .body(ElFileBody("rearrangecolumns_0029_request.txt")))
                .exec(http("request_30") .get("/api/functions?nocache=1544653423927") .headers(DMHeaders.headers_5))
                .exec(http("request_31") .get("/api/filesystem/files/39?_=1544653424305") .headers(DMHeaders.headers_3))
                .exec(http("request_32") .put("/api/workbooks/39/query?nocache=1544653424195") .headers(DMHeaders.headers_19) .body(ElFileBody("rearrangecolumns_0032_request.txt")))
                .exec(http("request_33") .put("/api/workbooks/39/query?nocache=1544653424242") .headers(DMHeaders.headers_19) .body(ElFileBody("rearrangecolumns_0033_request.txt")))
                .exec(http("request_34") .get("/workbook/9/fc595a39-2acf-4061-b2c1-11428d58491c/visualization?nocache=1544653424358") .headers(DMHeaders.headers_16))
                .exec(http("request_35") .get("/api/jobConfiguration/configurationStatus/9?nocache=1544653423747") .headers(DMHeaders.headers_16))

                // Click sheet 1
		.group("ArrangeColumns")(
                exec(http("request_36b") .head("/check-session") .headers(DMHeaders.headers_32))) //ECWB140
                .exec(http("request_38") .put("/api/workbooks/39/query?nocache=1544653478682") .headers(DMHeaders.headers_19) .body(ElFileBody("rearrangecolumns_0038_request.txt")))
                .exec(http("request_39") .put("/api/workbooks/39/query?nocache=1544653478732") .headers(DMHeaders.headers_19) .body(ElFileBody("rearrangecolumns_0039_request.txt")))
                .exec(http("request_40") .get("/workbook/9/fc595a39-2acf-4061-b2c1-11428d58491c/visualization?nocache=1544653478739") .headers(DMHeaders.headers_16))
                .exec(http("request_41") .head("/check-session") .headers(DMHeaders.headers_3))
                .exec(http("request_42") .head("/user-activity") .headers(DMHeaders.headers_3))
                .exec(http("request_44") .put("/api/workbooks/39/query?nocache=1544653491461") .headers(DMHeaders.headers_19) .body(ElFileBody("rearrangecolumns_0044_request.txt")))
                .exec(http("request_45") .put("/api/workbooks/39/query?nocache=1544653491502") .headers(DMHeaders.headers_19) .body(ElFileBody("rearrangecolumns_0045_request.txt")))
                .exec(http("request_46") .get("/workbook/9/fc595a39-2acf-4061-b2c1-11428d58491c/visualization?nocache=1544653491507") .headers(DMHeaders.headers_16)))
		.pause(25)

                // RunmodifiedWB
		.group("RunModifiedWorkbook")(
                exec(http("request_48") .post("/browser/job-execution?configuration=9&nocache=1544653509940") .headers(DMHeaders.headers_17))
                .exec(http("request_49") .get("/api/jobConfiguration/configurationStatus/9?nocache=1544653509974") .headers(DMHeaders.headers_16))
                .exec(http("request_50") .get("/api/jobConfiguration/configurationStatus/9?nocache=1544653510149") .headers(DMHeaders.headers_16))
                .exec(http("request_51") .get("/workbook/loadWorkbook/9/60?nocache=1544653510684") .headers(DMHeaders.headers_16))
                .exec(http("request_52") .put("/api/workbooks/39/query?nocache=1544653511287") .headers(DMHeaders.headers_19) .body(ElFileBody("rearrangecolumns_0052_request.txt")))
                .exec(http("request_54") .get("/workbook/9/fc595a39-2acf-4061-b2c1-11428d58491c/visualization?nocache=1544653511343") .headers(DMHeaders.headers_16))
                .exec(http("request_55") .get("/api/jobConfiguration/configurationStatus/9?nocache=1544653519172") .headers(DMHeaders.headers_16))
                .exec(http("request_56") .get("/api/jobConfiguration/configurationStatus/9?nocache=1544653520685") .headers(DMHeaders.headers_16))
                .exec(http("request_57") .get("/api/jobConfiguration/configurationStatus/9?nocache=1544653520893") .headers(DMHeaders.headers_16))
                .exec(http("request_58") .get("/api/jobConfiguration/configurationStatus/9?nocache=1544653531911") .headers(DMHeaders.headers_16))
                .exec(http("request_59") .get("/api/jobConfiguration/configurationStatus/9?nocache=1544653532279") .headers(DMHeaders.headers_16)))
	}
}

