package DM.Framework

import scala.concurrent.duration._
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._
import scala.util.Random

object DMPages{

        val uri2 = "http://search.lookupmanager.com/glg"
        val uri3 = "http://my.datameer.com/rest/external/v1/available"

//************************************************************************************ 
//**** Sets the common pause, commonly referred to as "Think Time" between 35 and 60 sconds
//************************************************************************************ 

	val CommonPause = pause(35,60)

//*********************
//***** Landing Page, Login
//*********************

	val Login=group("Login"){
                exec(http("Login_0") .get("/") .check(regex("CSRF.token = '(.+?)'").saveAs("p_csrf")) .headers(DMHeaders.headers_0))
                .exec(http("Login_1") .head("/user-activity") .headers(DMHeaders.headers_3))
                .exec(http("Login_2") .post("/login") .headers(DMHeaders.headers_4)
                        .formParam("username", "${name}")
                        .formParam("password", "12345")
                        .formParam("datameer-csrf-token", "${p_csrf}")
                        .formParam("datameer-csrf-token", "${p_csrf}"))
                .exec(http("Login_3") .options("/rest/user-management?_=1543351770244") .headers(DMHeaders.headers_6))
                .exec(http("Login_4") .options("/rest/user-management?_=1543351770245") .headers(DMHeaders.headers_6))
                .exec(http("Login_5") .head("/user-activity") .headers(DMHeaders.headers_3))
                .exec(http("Login_6") .options("/rest/user-management?_=1543351770288") .headers(DMHeaders.headers_6))
                .exec(http("Login_7") .get("/rest/user-management/logged-in-user?_=1543351770137") .headers(DMHeaders.headers_9))
                .exec(http("Login_8") .get("/rest/user-management/shareable-groups?fields=name&firstResult=0&maxResults=50&sortDir=ASC&sortBy=name&_=1543351770140") .headers(DMHeaders.headers_3))
                .exec(http("Login_9") .get("/rest/user-management/logged-in-user?_=1543351770138") .headers(DMHeaders.headers_3))
                .exec(http("Login_10") .get("/rest/user-management/authenticable-users?fields=username&firstResult=0&maxResults=50&sortDir=ASC&sortBy=username&_=1543351770139") .headers(DMHeaders.headers_3))
                .exec(http("Login_11") .get("/api/filesystem/files/search/fields?_=1543351771132") .headers(DMHeaders.headers_3))
                .exec(http("Login_12") .get("/browser/list-folders?_=1543351770141") .headers(DMHeaders.headers_9))
                .exec(http("Login_13") .get("/browser/list-filters") .headers(DMHeaders.headers_3))
                .exec(http("Login_14") .get("/internal-rest/extensionpoints/datameer.dap.sdk.exportjob.ExportFileType/registered?_=1543351770143") .headers(DMHeaders.headers_9))
                .exec(http("Login_16") .get("/browser/list-files?columnId=JOB_NAME&direction=ASC&from=0&rows=50&folderId=22&_=1543351770144") .headers(DMHeaders.headers_9))
	}

//*********************
//***** Logout
//*********************

	val Logout=group("Logout"){
                exec(http("Logout_17") .get("/browser/list-folders?_=1543351770145") .headers(DMHeaders.headers_9))
                .exec(http("Logout_18") .get("/browser/list-files?columnId=JOB_NAME&direction=ASC&from=0&rows=50&folderId=22&_=1543351770146") .headers(DMHeaders.headers_9))
                .exec(http("Logout_19") .post("/j_spring_security_logout") .headers(DMHeaders.headers_4) .formParam("datameer-csrf-token", "${p_csrf}"))
                .exec(http("Logout_20") .head("/user-activity") .headers(DMHeaders.headers_3))
	}

//************************************************************************************ 
//**** Select "File Browser" Tab
//************************************************************************************ 

	val FileBrowser = group("FileBrowser"){
                exec(http("request_0") .head("/check-session") .headers(DMHeaders.headers_9))
                .exec(http("request_1") .get("/browser/list-folders?_=1543361035245")  .check(regex("path\":\"/Users/${name}\",\"id\":\"homeFolder_(.+?)\",\"title\"").saveAs("p_homeFolder")) .headers(DMHeaders.headers_9))
                .exec(http("request_2") .get("/browser/list-files?columnId=JOB_NAME&direction=ASC&from=0&rows=50&folderId=22&_=1543361035246") .headers(DMHeaders.headers_9))
                .exec(http("request_3") .get("/browser") .headers(DMHeaders.headers_0))
                .exec(http("request_4") .options("/rest/user-management?_=1543361069023") .headers(DMHeaders.headers_6))
                .exec(http("request_5") .options("/rest/user-management?_=1543361069025") .headers(DMHeaders.headers_6))
                .exec(http("request_6") .head("/user-activity") .headers(DMHeaders.headers_3))
                .exec(http("request_7") .options("/rest/user-management?_=1543361069061") .headers(DMHeaders.headers_6))
                .exec(http("request_8") .get("/rest/user-management/logged-in-user?_=1543361068915") .headers(DMHeaders.headers_9))
                .exec(http("request_9") .get("/api/filesystem/files/search/fields?_=1543361069814") .headers(DMHeaders.headers_3))
                .exec(http("request_10") .get("/browser/list-filters") .headers(DMHeaders.headers_3))
                .exec(http("request_11") .get("/rest/user-management/shareable-groups?fields=name&firstResult=0&maxResults=50&sortDir=ASC&sortBy=name&_=1543361068918") .headers(DMHeaders.headers_3))
                .exec(http("request_12") .get("/rest/user-management/authenticable-users?fields=username&firstResult=0&maxResults=50&sortDir=ASC&sortBy=username&_=1543361068917") .headers(DMHeaders.headers_3))
                .exec(http("request_13") .get("/rest/user-management/logged-in-user?_=1543361068916") .headers(DMHeaders.headers_3))
                .exec(http("request_14") .get("/browser/list-folders?_=1543361068919") .headers(DMHeaders.headers_9))
                .exec(http("request_15") .get("/internal-rest/extensionpoints/datameer.dap.sdk.exportjob.ExportFileType/registered?_=1543361068921") .headers(DMHeaders.headers_9))
                .exec(http("request_17") .get("/browser/list-files?columnId=JOB_NAME&direction=ASC&from=0&rows=50&folderId=22&_=1543361068922") .headers(DMHeaders.headers_9))
                .exec(http("request_18") .get("/browser/list-folders?_=1543361068923") .headers(DMHeaders.headers_9))
                .exec(http("request_19") .get("/browser/list-files?columnId=JOB_NAME&direction=ASC&from=0&rows=50&folderId=22&_=1543361068924") .headers(DMHeaders.headers_9))
	}

//************************************************************************************ 
//**** Filter BY Work Book
//************************************************************************************ 

       	val FilterbyWorkbook=group("FilterbyWorkbook"){
                exec(http("FbyWB_3") .get("/browser/list-folders?_=1538434060224") .headers(DMHeaders.headers_3))
                .exec(http("FbyWB_4") .get("/browser/list-files?columnId=JOB_NAME&direction=ASC&from=0&rows=50&folderId=126&_=1538434060225") .headers(DMHeaders.headers_3))
                .exec(http("FbyWB_5") .get("/browser/list-files-by-filter?columnId=JOB_NAME&direction=ASC&from=0&rows=50&filterId=/Filter/By%20File%20Type/Workbooks&_=1538434060226") 
			.check(regex("\"id\": (.+?),").saveAs("p_WBID")) .headers(DMHeaders.headers_3))
                .exec(http("FbyWB_6") .get("/browser/list-folders?_=1538434060227") .headers(DMHeaders.headers_3))
                .exec(http("FbyWB_7") .get("/browser/list-files-by-filter?columnId=JOB_NAME&direction=ASC&from=0&rows=50&filterId=/Filter/By%20File%20Type/Workbooks&_=1538434060228") .headers(DMHeaders.headers_3))
	}

//************************************************************************************ 
//**** ExpandFolders
//************************************************************************************ 

	val ExpandFolders=group("ExpandFolders"){
                exec(http("EF_0") .get("/browser/list-folders?_=1537904149807") .headers(DMHeaders.headers_22))
                .exec(http("EF_1") .get("/browser/list-files?columnId=JOB_NAME&direction=ASC&from=0&rows=50&folderId=11&_=1537904149808") .headers(DMHeaders.headers_22))
                .exec(http("EF_2") .head("/user-activity") .headers(DMHeaders.headers_15))
                .exec(http("EF_3") .get("/browser/list-folders?_=1537904149809") .headers(DMHeaders.headers_22))
                .exec(http("EF_4") .get("/browser/list-files?columnId=JOB_NAME&direction=ASC&from=0&rows=50&folderId=11&_=1537904149810") .headers(DMHeaders.headers_22))
                .exec(http("EF_5") .head("/check-session") .headers(DMHeaders.headers_15))
                .exec(http("EF_6") .get("/browser/list-folders?_=1537904149811") .headers(DMHeaders.headers_22))
                .exec(http("EF_7") .get("/browser/list-files?columnId=JOB_NAME&direction=ASC&from=0&rows=50&folderId=11&_=1537904149812") .headers(DMHeaders.headers_22))
	}

//************************************************************************************ 
//**** Select Folder Based on User Name
//************************************************************************************ 

        val GetHomeFolder = group("GetHomeFolder"){
                exec(http("GHF_5") .get("/api/filesystem/folders/${p_homeFolder}/permission?_=1537901823014") .headers(DMHeaders.headers_5))
                .exec(http("GHF_6") .get("/browser/list-files?columnId=JOB_NAME&direction=ASC&from=0&rows=50&folderId=${p_homeFolder}&_=1537901823015").headers(DMHeaders.headers_3))
                .exec(http("GHF_7") .head("/user-activity") .headers(DMHeaders.headers_15))
                .exec(http("GHF_8") .get("/browser/list-files?columnId=JOB_NAME&direction=ASC&from=0&rows=50&folderId=${p_homeFolder}&_=1537901823017") .headers(DMHeaders.headers_3))
                .exec(http("GHF_9") .get("/api/filesystem/folders/${p_homeFolder}/permission?_=1537901823016") .headers(DMHeaders.headers_5))
                .exec(http("GHF_10") .get("/browser/list-files?columnId=JOB_NAME&direction=ASC&from=0&rows=50&folderId=${p_homeFolder}&_=1537901823018") .headers(DMHeaders.headers_3))
                .exec(http("GHF_11") .get("/browser/list-folders?_=1537901823019") .headers(DMHeaders.headers_3))
                .exec(http("GHF_12") .get("/browser/list-files?columnId=JOB_NAME&direction=ASC&from=0&rows=50&folderId=${p_homeFolder}&_=1537901823020") .headers(DMHeaders.headers_3))
	}

//************************************************************************************ 
//**** Select a WorkBook
//************************************************************************************ 

	val SelectWB = group("SelectWB"){
                exec(http("SWB_39") .get("/browser/list-folders?_=1536089287130") .headers(DMHeaders.headers_9))
                .exec(http("SWB_40") .get("/browser/list-files?columnId=JOB_NAME&direction=ASC&from=0&rows=50&folderId=${p_homeFolder}&_=1536089287131") .headers(DMHeaders.headers_9))
                .exec(http("SWB_${p_content}") .head("/user-activity") .headers(DMHeaders.headers_3))
                .exec(http("SWB_42") .get("/api/workbooks/${p_content}/concurrent-users") .headers(DMHeaders.headers_9))
                .exec(http("SWB_43") .get("/workbook/${p_content}") .check(substring("rows")) .headers(DMHeaders.headers_0))
                .exec(http("SWB_44") .get("/rest/user-management/logged-in-user?_=1536089300472") .headers(DMHeaders.headers_9))
                .exec(http("SWB_45") .get("/rest/user-management/logged-in-user?_=1536089300473") .headers(DMHeaders.headers_9))
                .exec(http("SWB_46") .get(uri2 + "/?MCExt_RR|,|9D4884F2-9D57-5362-B29E-B4AAD33B0B73|,|449|,|531|,|Mozilla%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_13_6)%20AppleWebKit%2F537.36%20(KHTML%24cma%3B%20like%20Gecko)%20Chrome%2F68.0.3440.106%20Safari%2F537.36|,|http%3A%2F%2F127.0.0.1%3A32826%2Fworkbook%2F967|,|http%3A%2F%2F127.0.0.1%3A32826%2Fbrowser") 
			.headers(DMHeaders.headers_2))
                .exec(http("SWB_47") .get("/workbook/loadWorkbook/${p_content}/60?nocache=1536089300691") .headers(DMHeaders.headers_21))
                .exec(http("SWB_48") .get("/api/jobConfiguration/configurationStatus/${p_content}?nocache=1536089300786") .headers(DMHeaders.headers_21))
                .exec(http("SWB_49") .get("/function/listFunctions/${p_content}/0") .headers(DMHeaders.headers_9))
                .exec(http("SWB_50") .get("/api/filesystem/files/${p_id}") .headers(DMHeaders.headers_3))
	}

//************************************************************************************ 
//**** Create a new workbook to run
//************************************************************************************ 

	val WorkBook = group("WorkBook"){
                // Add File
                exec(http("NWB_21") .get("/browser/list-folders?_=1542307085260") .headers(DMHeaders.headers_3))
                .exec(http("NWB_request_22") .get("/browser/list-files?columnId=JOB_NAME&direction=ASC&from=0&rows=50&folderId=${p_homeFolder}&_=1542307085261") .headers(DMHeaders.headers_3))
                .exec(http("NWB_23") .head("/user-activity") .headers(DMHeaders.headers_8))
                .exec(http("NWB_24") .post("/workbook") .check(headerRegex("Location","workbook/(.*)").saveAs("p_workbook")).headers(DMHeaders.headers_7))
                .exec(http("NWB_25") .get("/workbook/${p_workbook}") .headers(DMHeaders.headers_0))
                .exec(http("NWB_26") .get("/rest/user-management/logged-in-user?_=1542307110242") .headers(DMHeaders.headers_3))
                .exec(http("NWB_27") .get("/rest/user-management/logged-in-user?_=1542307110243") .headers(DMHeaders.headers_3))
                .exec(http("NWB_28") .get("/workbook/loadWorkbook/${p_workbook}/60?nocache=1542307110442") .check(regex("dapFileId\": (.+?),").saveAs("p_dapFileId")) .headers(DMHeaders.headers_25))
                .exec(http("NWB_29") .get("/api/jobConfiguration/configurationStatus/${p_workbook}?nocache=1542307110464") .headers(DMHeaders.headers_25))
                .exec(http("NWB_30") .get("/function/listFunctions/${p_workbook}/0") .headers(DMHeaders.headers_3))
                .exec(http("NWB_31") .get("/browser/list-folders?_=1542307110244") .headers(DMHeaders.headers_3))
                .exec(http("NWB_32") .get("/getFiles?folderId=8&mode=LINK_DATA_SOURCE&origin=${p_workbook}") .headers(DMHeaders.headers_3))
                .exec(http("NWB_33") .get("/getFiles?folderId=8&mode=LINK_DATA_SOURCE&origin=${p_workbook}") .headers(DMHeaders.headers_3))

                // FileBrowser
                .exec(http("NWB_41") .get("/browser") .headers(DMHeaders.headers_0))
                .exec(http("NWB_42") .get("/browser/mediaTypeUploadResponse") .headers(DMHeaders.headers_0))
                .exec(http("NWB_43") .options("/rest/user-management?_=1542307149857") .headers(DMHeaders.headers_7))
                .exec(http("NWB_44") .options("/rest/user-management?_=1542307149860") .headers(DMHeaders.headers_7))
                .exec(http("NWB_45") .options("/rest/user-management?_=1542307149903") .headers(DMHeaders.headers_7))
                .exec(http("NWB_46") .get("/rest/user-management/logged-in-user?_=1542307149754") .headers(DMHeaders.headers_3))
                .exec(http("NWB_47") .get("/rest/user-management/logged-in-user?_=1542307149755") .headers(DMHeaders.headers_8))
                .exec(http("NWB_48") .get("/rest/user-management/shareable-groups?fields=name&firstResult=0&maxResults=50&sortDir=ASC&sortBy=name&_=1542307149757") .headers(DMHeaders.headers_8))
                .exec(http("NWB_49") .get("/rest/user-management/authenticable-users?fields=username&firstResult=0&maxResults=50&sortDir=ASC&sortBy=username&_=1542307149756") .headers(DMHeaders.headers_8))
                .exec(http("NWB_50") .get("/browser/list-filters") .headers(DMHeaders.headers_8))
                .exec(http("NWB_51") .get("/browser/list-folders?_=1542307149758") .headers(DMHeaders.headers_3))
                .exec(http("NWB_52") .get("/api/filesystem/folders/${p_homeFolder}/permission?_=1542307149759") .headers(DMHeaders.headers_5))
                .exec(http("NWB_53") .get("/internal-rest/extensionpoints/datameer.dap.sdk.exportjob.ExportFileType/registered?_=1542307149760") .headers(DMHeaders.headers_3))
                .exec(http("NWB_54") .get(uri3 + "") .headers(DMHeaders.headers_28))
                .exec(http("NWB_55") .get("/browser/list-files?columnId=JOB_NAME&direction=ASC&from=0&rows=50&folderId=${p_homeFolder}&_=1542307149761") .headers(DMHeaders.headers_3))
                .exec(http("NWB_56") .get("/browser/list-files?columnId=JOB_NAME&direction=ASC&from=0&rows=50&folderId=${p_homeFolder}&_=1542307149762") .headers(DMHeaders.headers_3))

                // New workbook
                .exec(http("request_57") .get("/browser/list-folders?_=1542307149763") .headers(DMHeaders.headers_3))
                .exec(http("request_58") .get("/browser/list-files?columnId=JOB_NAME&direction=ASC&from=0&rows=50&folderId=${p_homeFolder}&_=1542307149764") .headers(DMHeaders.headers_3))
                .exec(http("request_59") .get("/workbook/${p_workbook}") .headers(DMHeaders.headers_0))
                .exec(http("request_60") .get("/rest/user-management/logged-in-user?_=1542307162466") .headers(DMHeaders.headers_3))
                .exec(http("request_61") .get("/rest/user-management/logged-in-user?_=1542307162467") .headers(DMHeaders.headers_3))
                .exec(http("request_62") .get("/workbook/loadWorkbook/${p_workbook}/60?nocache=1542307162667") .headers(DMHeaders.headers_25))
                .exec(http("request_63") .get("/api/jobConfiguration/configurationStatus/${p_workbook}?nocache=1542307162682") .headers(DMHeaders.headers_25))
                .exec(http("request_64") .get("/function/listFunctions/${p_workbook}/0") .headers(DMHeaders.headers_3))
                .exec(http("request_65") .get("/browser/list-folders?_=1542307162468") .headers(DMHeaders.headers_3))
                .exec(http("request_66") .get("/getFiles?folderId=8&mode=LINK_DATA_SOURCE&origin=${p_workbook}") .headers(DMHeaders.headers_3))
                .exec(http("request_67") .get("/getFiles?folderId=8&mode=LINK_DATA_SOURCE&origin=${p_workbook}") .headers(DMHeaders.headers_3))

                // Add Data
                .exec(http("request_68") .head("/user-activity") .headers(DMHeaders.headers_8))
                .exec(http("request_69") .get("/browser/list-folders?_=1542307162469") .headers(DMHeaders.headers_3))
                .exec(http("request_70") .get("/workbook/${p_workbook}/partitioningInfo?entityType=dataSource&entityId[]=29&nocache=1542307173527") .headers(DMHeaders.headers_25))
                .exec(http("request_71") .post("/workbook/linkDataSource/${p_workbook}/29/60?nocache=1542307173567") .check(regex("sheetId\": \"(.+?)\",").saveAs("p_sheetuuid")) .headers(DMHeaders.headers_27))
                //.exec(http("request_72") .get("/workbook/${p_workbook}/4da5f2f9-b510-42a1-8614-2ac61b4e4e3c/visualization?nocache=1542307173789") .headers(DMHeaders.headers_25))
                .exec(http("request_72") .get("/workbook/${p_workbook}/${p_sheetuuid}/visualization?nocache=1542307173789") .headers(DMHeaders.headers_25))
                //.exec(http("request_73") .get("/workbook/${p_workbook}/4da5f2f9-b510-42a1-8614-2ac61b4e4e3c/visualization?nocache=1542307174075") .headers(DMHeaders.headers_25))
                .exec(http("request_73") .get("/workbook/${p_workbook}/${p_sheetuuid}/visualization?nocache=1542307174075") .headers(DMHeaders.headers_25))

                // Save
                .exec(http("request_74") .get("/browser/list-folders?_=1542307162470") .headers(DMHeaders.headers_3))
                .exec(http("request_75") .get("/browser/list-folders?_=1542307162471") .headers(DMHeaders.headers_3))
                .exec(http("request_76") .get("/getFiles?folderId=${p_homeFolder}&mode=SAVE_WORKBOOK&origin=${p_workbook}") .check(regex("uuid\":\"(.+?)\"").saveAs("p_uuid")) .headers(DMHeaders.headers_3))
                .exec(http("request_77") .head("/check-session") .headers(DMHeaders.headers_8))
                .exec(http("request_78") .get("/browser/list-folders?_=1542307162472") .headers(DMHeaders.headers_3))
                .exec(http("request_79") .get("/analyst/json/validateName?name=A_${name}_Workbook&id=${p_workbook}&folderId=${p_homeFolder}&extension=wbk") .headers(DMHeaders.headers_8))
                .exec(http("request_80") .put("/api/workbooks/${p_dapFileId}/command") .headers(DMHeaders.headers_19) .body(ElFileBody("NWBTest_0080_request.txt")))
                .exec(http("request_82") .get("/workbook/${p_workbook}/${p_sheetuuid}/visualization?nocache=1542307195091") .headers(DMHeaders.headers_25))
                .exec(http("request_83") .get("/browser/list-folders?_=1542307162473") .headers(DMHeaders.headers_3))
	}

//************************************************************************************ 
//**** Save New Workbook
//************************************************************************************ 

	val SaveNewWB = group("SaveNewWb"){
                exec(http("SNWB_61") .get("/browser/list-folders?_=1537831412812") .headers(DMHeaders.headers_9))
                .exec(http("SNWB_62") .get("/browser/list-folders?_=1537831412813") .headers(DMHeaders.headers_9))
                .exec(http("SNWB_63") .get("/getFiles?folderId=${p_homeFolder}&mode=SAVE_WORKBOOK&origin=1016") .headers(DMHeaders.headers_9))
                .exec(http("SNWB_64") .get("/browser/list-folders?_=1537831412814") .headers(DMHeaders.headers_9))
                .exec(http("SNWB_65") .get("/browser/list-folders?_=1537831412815") .headers(DMHeaders.headers_9))
                .exec(http("SNWB_66") .get("/analyst/json/validateName?name=ADMIN_Workbook&id=1118&folderId=${p_homeFolder}&extension=wbk") .headers(DMHeaders.headers_3))
                .exec(http("SNWB_67") .put("/api/workbooks/1088/command") .headers(DMHeaders.headers_23) .body(ElFileBody("NewWorkBook_0067_request.txt")))
                .exec(http("SNWB_68") .get("/workbook/loadWorkbook/1118/60?nocache=1537831466139") .headers(DMHeaders.headers_21))
                .exec(http("SNWB_69") .get("/workbook/1016/ae13b737-12ce-4601-a2ba-e19dcfaec273/visualization?nocache=1537831466595") .headers(DMHeaders.headers_21))
	}

//************************************************************************************ 
//**** Select CSV File
//************************************************************************************ 

	val SelectCSV = group("SelectCSV"){
                exec(http("CSV_36") .head("/user-activity") .headers(DMHeaders.headers_3))
                .exec(http("CSV_37") .get("/browser/list-folders?_=1534366779467") .headers(DMHeaders.headers_9))
                .exec(http("CSV_38") .get("/workbook/1014/partitioningInfo?entityType=dataSource&entityId[]=29&nocache=1534366801812") .headers(DMHeaders.headers_21))
                .exec(http("CSV_39") .post("/workbook/linkDataSource/1014/29/60?nocache=1534366801843") .headers(DMHeaders.headers_17))
                .exec(http("CSV_40") .get("/workbook/1014/4ecdb7d0-8446-4e41-a88a-b63d437af92c/visualization?nocache=1534366802096") .headers(DMHeaders.headers_21))
                .exec(http("CSV_41") .get("/workbook/1014/4ecdb7d0-8446-4e41-a88a-b63d437af92c/visualization?nocache=1534366802462") .headers(DMHeaders.headers_21))
                .exec(http("CSV_42") .head("/check-session") .headers(DMHeaders.headers_3))
                .exec(http("CSV_43") .get("/browser/list-folders?_=1534366779468") .headers(DMHeaders.headers_9))
	}

//************************************************************************************ 
//**** AddFormula to existing workbook
//************************************************************************************ 

	val AddForumula = group("AddFormula"){
                exec(http("AF_44") .get("/browser/list-folders?_=1534366779469") .headers(DMHeaders.headers_9))
                .exec(http("AF_45") .get("/workbook/createNewSheet/1014?nocache=1534366821977") .headers(DMHeaders.headers_21))
                .exec(http("AF_46") .get("/browser/list-folders?_=1534366779470") .headers(DMHeaders.headers_9))
                .exec(http("AF_47") .get("/api/workbooks/76/switchSheet/0/60?nocache=1534366835192") .headers(DMHeaders.headers_21))
                .exec(http("AF_48") .head("/check-session") .headers(DMHeaders.headers_3))
                .exec(http("AF_49") .post("/api/workbooks/76/calculateFormula?rows=60&nocache=1534366839888") 
			.headers(DMHeaders.headers_17) .formParam("workbookId", "1014") .formParam("formula", "GROUPBY(#TEMP9_csv!DAG)") .formParam("formulaTargetColumnIndex", "0") .formParam("formulaTargetSheetIndex", "1")) 
                .exec(http("AF_50") .get("/workbook/listDownstreamSheets/1014/4ecdb7d0-8446-4e41-a88a-b63d437af92c") .headers(DMHeaders.headers_9))
                .exec(http("AF_51") .get("/workbook/1014/75caa1d3-d134-4dd2-9fa5-f5b9a98e8e38/visualization?nocache=1534366840139") .headers(DMHeaders.headers_21))
                .exec(http("AF_52") .get("/workbook/1014/75caa1d3-d134-4dd2-9fa5-f5b9a98e8e38/visualization?nocache=1534366840496") .headers(DMHeaders.headers_21))
                .exec(http("AF_53") .get("/browser/list-folders?_=1534366779471") .headers(DMHeaders.headers_9))
	}

//************************************************************************************ 
//**** Logout
//************************************************************************************ 

//	val Logout = group("Logout"){
                 //exec(http("Logout_83") .head("/user-activity") .headers(DMHeaders.headers_3))
               // .exec(http("Logout_84") .post("/j_spring_security_logout") .headers(DMHeaders.headers_4) .formParam("datameer-csrf-token", "${p_csrf}"))
              //  .exec(http("Logout_85") .get(uri2 + "/?MCExt_RR|,|9D4884F2-9D57-5362-B29E-B4AAD33B0B73|,|449|,|531|,|Mozilla%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_13_6)%20AppleWebKit%2F537.36%20(KHTML%24cma%3B%20like%20Gecko)%20Chrome%2F68.0.3440.106%20Safari%2F537.36|,|http%3A%2F%2F127.0.0.1%3A32826%2Flogin|,|http%3A%2F%2F127.0.0.1%3A32826%2Fbrowser") .headers(DMHeaders.headers_13))
	//}

//************************************************************************************ 
//**** New folder based on User Name
//************************************************************************************ 
                
	val NewFolder = group("NewFolder"){
                exec(http("NF_0")  .get("/browser/list-folders?_=1537896755707") .headers(DMHeaders.headers_3))
                .exec(http("NF_1") .get("/browser/list-files?columnId=JOB_NAME&direction=ASC&from=0&rows=50&folderId=11&_=1537896755706") .headers(DMHeaders.headers_3))
                .exec(http("NF_2") .head("/check-session") .headers(DMHeaders.headers_11))
                .exec(http("NF_3") .post("/browser/create-folder") .headers(DMHeaders.headers_12) .formParam("parentFolderId", "11") .formParam("name", "${name}"))
                .exec(http("NF_5") .get("/browser/list-files?columnId=JOB_NAME&direction=ASC&from=0&rows=50&folderId=81&_=1537896755709") .headers(DMHeaders.headers_3))
                .exec(http("NF_6") .get("/browser/list-folders?_=1537896755710") .headers(DMHeaders.headers_3))
                .exec(http("NF_7") .get("/browser/list-files?columnId=JOB_NAME&direction=ASC&from=0&rows=50&folderId=81&_=1537896755711") .headers(DMHeaders.headers_3))
	}

//************************************************************************************ 
//**** New subfolder based on User Name
//************************************************************************************ 
                
	val NewSubFolder = group("NewSubFolder"){
                exec(http("NF0")  .get("/browser/list-folders?_=1537896755707") .headers(DMHeaders.headers_3))
                .exec(http("NF_1") .get("/browser/list-files?columnId=JOB_NAME&direction=ASC&from=0&rows=50&folderId=${p_homeFolder}&_=1537896755706") .headers(DMHeaders.headers_3))
                .exec(http("NF_2") .head("/check-session") .headers(DMHeaders.headers_11))
                .exec(http("NF_3") .post("/browser/create-folder") .headers(DMHeaders.headers_12) .formParam("parentFolderId", "${p_homeFolder}") .formParam("name", "${name}_Subfolder"))
                .exec(http("NF_5") .get("/browser/list-files?columnId=JOB_NAME&direction=ASC&from=0&rows=50&folderId=81&_=1537896755709") .headers(DMHeaders.headers_3))
                .exec(http("NF_6") .get("/browser/list-folders?_=1537896755710") .headers(DMHeaders.headers_3))
                .exec(http("NF_7") .get("/browser/list-files?columnId=JOB_NAME&direction=ASC&from=0&rows=50&folderId=81&_=1537896755711") .headers(DMHeaders.headers_3))
	}

//************************************************************************************ 
//**** Agree to T&C for new users (Includes Login) (Used for creating and activating new users)
//************************************************************************************ 

	val accept = group("accept"){
                exec(http("request_0") .get("/login") .check(regex("CSRF.token = '(.+?)'").saveAs("p_csrf")) .headers(DMHeaders.headers_0))
                .exec(http("request_1") .head("/user-activity") .headers(DMHeaders.headers_3))
                .exec( http("request_2") .get("/favicon.ico") .headers(DMHeaders.headers_1))
                .exec(http("request_3") .post("/login") .headers(DMHeaders.headers_4)
                        .formParam("username", "${name}") .formParam("password", "12345") 
                        .formParam("datameer-csrf-token", "${p_csrf}")
                        .formParam("datameer-csrf-token", "${p_csrf}")
                        .resources(http("request_4") .head("/user-activity") .headers(DMHeaders.headers_3)))
                // Click Yes
                .exec(http("request_5") .get("/assets/fonts/dmicon.woff2?rev=aa1c17ebaa6daf37ac127defba47bd095d1f8de2") .headers(DMHeaders.headers_29))
                .exec(http("request_6") .post("/accept-terms") .headers(DMHeaders.headers_4) .formParam("termsOfUseAccepted", "true") .formParam("datameer-csrf-token", "${p_csrf}"))
                .exec(http("request_7") .options("/rest/user-management?_=1542757072322") .headers(DMHeaders.headers_6))
                .exec(http("request_8") .options("/rest/user-management?_=1542757072325") .headers(DMHeaders.headers_6))
                .exec(http("request_9") .get("/images/aam/aamNotAvailable.jpeg") .headers(DMHeaders.headers_30))
                .exec(http("request_10") .options("/rest/user-management?_=1542757072364") .headers(DMHeaders.headers_6))
                .exec(http("request_11") .head("/user-activity") .headers(DMHeaders.headers_3))
                .exec(http("request_12") .get("/rest/user-management/logged-in-user?_=1542757072222") .headers(DMHeaders.headers_3))
                .exec(http("request_13") .get("/rest/user-management/logged-in-user?_=1542757072221") .headers(DMHeaders.headers_9))
                .exec(http("request_14") .get("/rest/user-management/shareable-groups?fields=name&firstResult=0&maxResults=50&sortDir=ASC&sortBy=name&_=1542757072224") .headers(DMHeaders.headers_3))
                .exec(http("request_15") .get("/rest/user-management/authenticable-users?fields=username&firstResult=0&maxResults=50&sortDir=ASC&sortBy=username&_=1542757072223") .headers(DMHeaders.headers_3))
                .exec(http("request_16") .get("/browser/list-filters") .headers(DMHeaders.headers_3))
                .exec(http("request_17") .get("/browser/list-folders?_=1542757072225") .headers(DMHeaders.headers_9))
                .exec(http("request_18") .get("/internal-rest/extensionpoints/datameer.dap.sdk.exportjob.ExportFileType/registered?_=1542757072227") .headers(DMHeaders.headers_9))
                .exec(http("request_19") .get("/api/filesystem/folders/44/permission?_=1542757072226") .headers(DMHeaders.headers_13))
                .exec(http("request_20") .get("/browser/list-files?columnId=JOB_NAME&direction=ASC&from=0&rows=50&folderId=44&_=1542757072228") .headers(DMHeaders.headers_9))
                .exec(http("request_21") .get("/assets/fonts/3600b37f-2bf1-45f3-be3a-03365f16d9cb.woff2") .headers(DMHeaders.headers_29))
                .exec(http("request_22") .get("/api/filesystem/files/search/fields?_=1542757073318") .headers(DMHeaders.headers_3))
                .exec(http("request_23") .get("/browser/list-folders?_=1542757072229") .headers(DMHeaders.headers_9))
                .exec(http("request_24") .get("/browser/list-files?columnId=JOB_NAME&direction=ASC&from=0&rows=50&folderId=44&_=1542757072230") .headers(DMHeaders.headers_9))
                // Logout
                .exec(http("request_25") .post("/j_spring_security_logout") .headers(DMHeaders.headers_4) .formParam("datameer-csrf-token", "${p_csrf}"))
                .exec(http("request_26") .head("/user-activity") .headers(DMHeaders.headers_3))
	}


	val Agree = group("Agree"){
                exec(http("TC_0") .get("/login") .check(regex("CSRF.token = '(.+?)'").saveAs("p_csrf")) .headers(DMHeaders.headers_0))
                .exec(http("TC_1") .get("/favicon.ico") .headers(DMHeaders.headers_1))
                .exec(http("TC_2") .get(uri2 + "/?MCExt_RR|,|9D4884F2-9D57-5362-B29E-B4AAD33B0B73|,|449|,|531|,|Mozilla%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_13_6)%20AppleWebKit%2F537.36%20(KHTML%24cma%3B%20like%20Gecko)%20Chrome%2F68.0.3440.106%20Safari%2F537.36|,|http%3A%2F%2F127.0.0.1%3A32826%2Flogin|,|http%3A%2F%2F127.0.0.1%3A32826%2Fbrowser") .headers(DMHeaders.headers_2))
                // Login
                .exec(http("TC_3") .head("/user-activity") .headers(DMHeaders.headers_3))
                .exec(http("TC_4") .post("/login") .headers(DMHeaders.headers_4) .formParam("username", "${name}") .formParam("password", "admin") .formParam("datameer-csrf-token", "${p_csrf}") .formParam("datameer-csrf-token", "${p_csrf}"))
                .exec(http("TC_5") .get(uri2 + "/?MCExt_RR|,|9D4884F2-9D57-5362-B29E-B4AAD33B0B73|,|449|,|531|,|Mozilla%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_13_6)%20AppleWebKit%2F537.36%20(KHTML%24cma%3B%20like%20Gecko)%20Chrome%2F68.0.3440.106%20Safari%2F537.36|,|http%3A%2F%2F127.0.0.1%3A32826%2Faccept-terms|,|http%3A%2F%2F127.0.0.1%3A32826%2Flogin") .headers(DMHeaders.headers_2))
                .pause(1)
                
                // Agree
                .exec(http("TC_6") .head("/user-activity") .headers(DMHeaders.headers_3))
                .exec(http("TC_7") .post("/accept-terms") .headers(DMHeaders.headers_4) .formParam("termsOfUseAccepted", "true") .formParam("datameer-csrf-token", "${p_csrf}"))
                .exec(http("TC_8") .get("/browser/mediaTypeUploadResponse") .headers(DMHeaders.headers_0))
                .exec(http("TC_9") .options("/rest/user-management?_=1537469036356") .headers(DMHeaders.headers_6))
                .exec(http("TC_10") .options("/rest/user-management?_=1537469036360") .headers(DMHeaders.headers_6))
                .exec(http("TC_11") .options("/rest/user-management?_=1537469036402") .headers(DMHeaders.headers_6))
                .exec(http("TC_12") .get("/rest/user-management/logged-in-user?_=1537469036274") .headers(DMHeaders.headers_9))
                .exec(http("TC_13") .get("/rest/user-management/logged-in-user?_=1537469036275") .headers(DMHeaders.headers_3))
                .exec(http("TC_14") .get("/rest/user-management/shareable-groups?fields=name&firstResult=0&maxResults=50&sortDir=ASC&sortBy=name&_=1537469036277") .headers(DMHeaders.headers_3))
                .exec(http("TC_15") .get("/rest/user-management/authenticable-users?fields=username&firstResult=0&maxResults=50&sortDir=ASC&sortBy=username&_=1537469036276") .headers(DMHeaders.headers_3))
                .exec(http("TC_16") .get("/browser/list-filters") .headers(DMHeaders.headers_3))
                .exec(http("TC_17") .get("/browser/list-folders?_=1537469036278") .headers(DMHeaders.headers_9))
                .exec(http("TC_18") .get(uri2 + "/?MCExt_RR|,|9D4884F2-9D57-5362-B29E-B4AAD33B0B73|,|449|,|531|,|Mozilla%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_13_6)%20AppleWebKit%2F537.36%20(KHTML%24cma%3B%20like%20Gecko)%20Chrome%2F68.0.3440.106%20Safari%2F537.36|,|http%3A%2F%2F127.0.0.1%3A32826%2Fbrowser|,|http%3A%2F%2F127.0.0.1%3A32826%2Faccept-terms") .headers(DMHeaders.headers_2))
                .exec(http("TC_19") .get("/api/filesystem/folders/39/permission?_=1537469036279") .headers(DMHeaders.headers_13))
                .exec(http("TC_20") .get("/internal-rest/extensionpoints/datameer.dap.sdk.exportjob.ExportFileType/registered?_=1537469036280") .headers(DMHeaders.headers_9))
                .exec(http("TC_21") .get("/browser/list-files?columnId=JOB_NAME&direction=ASC&from=0&rows=50&folderId=39&_=1537469036282") .headers(DMHeaders.headers_9))
                .exec(http("TC_22") .get(uri3 + "") .headers(DMHeaders.headers_18))
        }

//************************************************************************************ 
//**** New File Upload
//************************************************************************************ 

                // StartUpload
	val NewFileUpload2 = group("NewFileUpload2"){
		group("Filter")(
                exec(http("NFU_0") .head("/check-session") .headers(DMHeaders.headers_15))
                .exec(http("NFU_1") .get("/browser/list-files?columnId=JOB_NAME&direction=ASC&from=0&rows=50&folderId=${p_homeFolder}&_=1538161754751") .headers(DMHeaders.headers_3))
                .exec(http("NFU_2") .get("/browser/list-folders?_=1538161754750") .headers(DMHeaders.headers_3))
                .exec(http("NFU_3") .get("/file-upload/create") .headers(DMHeaders.headers_0))
                .exec(http("NFU_4") .get("/rest/user-management/logged-in-user?_=1538162063575") .headers(DMHeaders.headers_3))
                .exec(http("NFU_5") .get("/rest/user-management/logged-in-user?_=1538162063576") .headers(DMHeaders.headers_3))
                .exec(http("NFU_6") .get("/rest/user-management/logged-in-user?_=1538162063577") .headers(DMHeaders.headers_3))
                .exec(http("NFU_7") .get(uri2 + "/?MCExt_RR|,|9D4884F2-9D57-5362-B29E-B4AAD33B0B73|,|449|,|531|,|Mozilla%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_13_6)%20AppleWebKit%2F537.36%20(KHTML%24cma%3B%20like%20Gecko)%20Chrome%2F68.0.3440.106%20Safari%2F537.36|,|http%3A%2F%2F127.0.0.1%3A32826%2Ffile-upload%2Fupload|,|http%3A%2F%2F127.0.0.1%3A32826%2Fbrowser") .headers(DMHeaders.headers_10)))

                // Browse
		.group("Browse")(
                exec(http("NFU_8") .head("/user-activity") .headers(DMHeaders.headers_15))

                // Next
                .exec(http("NFU_9") .post("/file-upload/upload") .headers(DMHeaders.headers_36) .body(ElFileBody("uploadfile_0009_request.JSON"))) //ulf9
                .exec(http("NFU_10") .get("/rest/user-management/logged-in-user?_=1538162104723") .headers(DMHeaders.headers_3))
                .exec(http("NFU_11") .get("/rest/user-management/logged-in-user?_=1538162104724") .headers(DMHeaders.headers_3))
                .exec(http("NFU_12") .get("/rest/user-management/logged-in-user?_=1538162104725") .headers(DMHeaders.headers_3))
                .exec(http("NFU_13") .get(uri2 + "/?MCExt_RR|,|9D4884F2-9D57-5362-B29E-B4AAD33B0B73|,|449|,|531|,|Mozilla%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_13_6)%20AppleWebKit%2F537.36%20(KHTML%24cma%3B%20like%20Gecko)%20Chrome%2F68.0.3440.106%20Safari%2F537.36|,|http%3A%2F%2F127.0.0.1%3A32826%2Ffile-upload%2Fcreate%2FdataDetails|,|http%3A%2F%2F127.0.0.1%3A32826%2Ffile-upload%2Fupload") .headers(DMHeaders.headers_10)))

                // Next
		.group("Next")(
                exec(http("NFU_14") .head("/user-activity") .headers(DMHeaders.headers_15))
                .exec(http("NFU_15") .post("/properties/update") .headers(DMHeaders.headers_35) .body(ElFileBody("uploadfile_0015_request.JSON"))) //ulf_15
                .exec(http("NFU_16") .get("/rest/user-management/logged-in-user?_=1538162114605") .headers(DMHeaders.headers_3))
                .exec(http("NFU_17") .get("/rest/user-management/logged-in-user?_=1538162114606") .headers(DMHeaders.headers_3))
                .exec(http("NFU_18") .get("/rest/user-management/logged-in-user?_=1538162114607") .headers(DMHeaders.headers_3)) 
		.exec(http("NFU_19") .post("/define-fields-preview") .check(regex("\"/import-schema-log/(.+?)\"}").saveAs("p_configid")) .headers(DMHeaders.headers_17)
                        .formParam("triggeredBy", "")
                        .formParam("action", "")
                        .formParam("columnIndex", "")
                        .formParam("charLength", "")
                        .formParam("emptyValuePlaceholders", "")
                        .formParam("errorHandlingMode", "DROP_RECORD")
                        .formParam("_partitionDefinitionCommand.partitioned", "false")
                        .formParam("partitionDefinitionCommand.advanced", "false")
                        .formParam("partitionDefinitionCommand.columnName", "")
                        .formParam("partitionDefinitionCommand.generatingExpression", "")
                        .formParam("partitionDefinitionCommand.dateFormat", "yyyyMMddHH")
                        .formParam("datameer-csrf-token", "${p_csrf}"))
                .exec(http("NFU_20") .get(uri2 + "/?MCExt_RR|,|9D4884F2-9D57-5362-B29E-B4AAD33B0B73|,|449|,|531|,|Mozilla%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_13_6)%20AppleWebKit%2F537.36%20(KHTML%24cma%3B%20like%20Gecko)%20Chrome%2F68.0.3440.106%20Safari%2F537.36|,|http%3A%2F%2F127.0.0.1%3A32826%2Ffile-upload%2Fcreate%2FdefineFields|,|http%3A%2F%2F127.0.0.1%3A32826%2Ffile-upload%2Fcreate%2FdataDetails") .headers(DMHeaders.headers_10)))

                // Next 
		.group("Next")(
                exec(http("NFU_21") .head("/user-activity") .headers(DMHeaders.headers_15))
                .exec(http("NFU_22a")
                        .post("/file-upload/create/defineFields")
                        .headers(DMHeaders.headers_4)
                        .formParam("triggeredBy", "")
                        .formParam("action", "finish")
                        .formParam("columnIndex", "")
                        .formParam("charLength", "")
                        .formParam("fields[0].name", "test")
                        .formParam("fields[1].name", "dasFileName")
                        .formParam("fields[2].name", "dasFilePath")
                        .formParam("fields[3].name", "dasLastModified")
                        .formParam("fields[4].name", "dasJobExecutionId")
                        .formParam("fields[5].name", "dasJobExecutionStartTime")
                        .formParam("_fields[0].include", "false")
                        .formParam("fields[0].include", "on")
                        .formParam("_fields[1].include", "false")
                        .formParam("_fields[2].include", "false")
                        .formParam("_fields[3].include", "false")
                        .formParam("_fields[4].include", "false")
                        .formParam("_fields[5].include", "false")
                        .formParam("_fields[0].acceptEmptyEntries", "false")
                        .formParam("fields[0].acceptEmptyEntries", "on")
                        .formParam("_fields[1].acceptEmptyEntries", "false")
                        .formParam("_fields[2].acceptEmptyEntries", "false")
                        .formParam("_fields[3].acceptEmptyEntries", "false")
                        .formParam("_fields[4].acceptEmptyEntries", "false")
                        .formParam("_fields[5].acceptEmptyEntries", "false")
                        .formParam("fields[0].type", """{"type":"STRING"}""") 
                        .formParam("fields[1].type", """{"type":"STRING"}""")
                        .formParam("fields[2].type", """{"type":"STRING"}""")
                        .formParam("fields[3].type", """{"type":"DATE"}""")
                        .formParam("fields[4].type", """{"type":"INTEGER"}""")
                        .formParam("fields[5].type", """{"type":"DATE"}""")
                        .formParam("emptyValuePlaceholders", "")
                        .formParam("errorHandlingMode", "DROP_RECORD")
                        .formParam("_partitionDefinitionCommand.partitioned", "false")
                        .formParam("partitionDefinitionCommand.advanced", "true")
                        .formParam("partitionDefinitionCommand.columnName", "")
                        .formParam("partitionDefinitionCommand.generatingExpression", "")
                        .formParam("partitionDefinitionCommand.dateFormat", "yyyyMMddHH")
                        .formParam("datameer-csrf-token", "${p_csrf}"))
                .exec(http("NFU_23") .get("/rest/user-management/logged-in-user?_=1538162127853") .headers(DMHeaders.headers_3))
                .exec(http("NFU_24") .get("/rest/user-management/logged-in-user?_=1538162127854") .headers(DMHeaders.headers_3))
                .exec(http("NFU_25") .get("/rest/user-management/logged-in-user?_=1538162127855") .headers(DMHeaders.headers_3))
                .exec(http("NFU_26") .get(uri2 + "/?MCExt_RR|,|9D4884F2-9D57-5362-B29E-B4AAD33B0B73|,|449|,|531|,|Mozilla%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_13_6)%20AppleWebKit%2F537.36%20(KHTML%24cma%3B%20like%20Gecko)%20Chrome%2F68.0.3440.106%20Safari%2F537.36|,|http%3A%2F%2F127.0.0.1%3A32826%2Ffile-upload%2Fcreate%2Fsample|,|http%3A%2F%2F127.0.0.1%3A32826%2Ffile-upload%2Fcreate%2FdefineFields") .headers(DMHeaders.headers_10)))

                // Next
		.group("Next")(
                exec(http("NFU_27") .head("/user-activity") .headers(DMHeaders.headers_15))
                .exec(http("NFU_28") .post("/file-upload/create/sample") .check(regex("\"unsaved_(.+?)\"/") .saveAs("p_unsaved")) .headers(DMHeaders.headers_4)
                        .formParam("maxPreviewRecords", "5000")
                        .formParam("hadoopProperties", "")
                        .formParam("datameer-csrf-token", "${p_csrf}"))
                .exec(http("NFU_29") .get("/rest/user-management/logged-in-user?_=1538162139486") .headers(DMHeaders.headers_3))
                .exec(http("NFU_30") .get("/rest/user-management/logged-in-user?_=1538162139487") .headers(DMHeaders.headers_3))
                .exec(http("NFU_31") .get("/rest/user-management/logged-in-user?_=1538162139488") .headers(DMHeaders.headers_3))
                .exec(http("NFU_32") .get(uri2 + "/?MCExt_RR|,|9D4884F2-9D57-5362-B29E-B4AAD33B0B73|,|449|,|531|,|Mozilla%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_13_6)%20AppleWebKit%2F537.36%20(KHTML%24cma%3B%20like%20Gecko)%20Chrome%2F68.0.3440.106%20Safari%2F537.36|,|http%3A%2F%2F127.0.0.1%3A32826%2Ffile-upload%2Fcreate%2Fdescription|,|http%3A%2F%2F127.0.0.1%3A32826%2Ffile-upload%2Fcreate%2Fsample") .headers(DMHeaders.headers_10)))

                // Save1
		.group("Save1")(
                exec(http("NFU_33") .head("/user-activity") .headers(DMHeaders.headers_15))
                .exec(http("NFU_34") .post("/file-upload/create/description") .headers(DMHeaders.headers_4)
                        .formParam("description", "")
                        .formParam("folderId", "")
                        .formParam("fileName", "unsaved_${p_unsaved}")
                        .formParam("page", "5")
                        .formParam("saveMode", "SAVE")
                        .formParam("datameer-csrf-token", "${p_csrf}"))
                .exec(http("NFU_35") .get("/rest/user-management/logged-in-user?_=1538162150464") .headers(DMHeaders.headers_3))
                .exec(http("NFU_36") .get("/rest/user-management/logged-in-user?_=1538162150465") .headers(DMHeaders.headers_3))
                .exec(http("NFU_37") .get("/browser/list-folders?_=1538162150466") .headers(DMHeaders.headers_3))
                .exec(http("NFU_38") .get("/rest/user-management/logged-in-user?_=1538162150467") .headers(DMHeaders.headers_3))
                .exec(http("NFU_39") .get(uri2 + "/?MCExt_RR|,|9D4884F2-9D57-5362-B29E-B4AAD33B0B73|,|449|,|531|,|Mozilla%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_13_6)%20AppleWebKit%2F537.36%20(KHTML%24cma%3B%20like%20Gecko)%20Chrome%2F68.0.3440.106%20Safari%2F537.36|,|http%3A%2F%2F127.0.0.1%3A32826%2Ffile-upload%2Fcreate%2Ffile-browser|,|http%3A%2F%2F127.0.0.1%3A32826%2Ffile-upload%2Fcreate%2Fdescription") .headers(DMHeaders.headers_10))
                .exec(http("NFU_40") .get("/getFiles?folderId=${p_homeFolder}&mode=SAVE_FILE_UPLOAD&origin=") .headers(DMHeaders.headers_3))
                .exec(http("NFU_41") .get("/getFiles?folderId=${p_homeFolder}&mode=SAVE_FILE_UPLOAD&origin=") .headers(DMHeaders.headers_3)))

                // Save2
		.group("Save2")(
                exec(http("NFU_42") .get("/browser/list-folders?_=1538162150468") .headers(DMHeaders.headers_3))
                .exec(http("NFU_43") .head("/user-activity") .headers(DMHeaders.headers_15))
                .exec(http("NFU_44") .get("/analyst/json/validateName?name=B${p_csrf}_txt&id=&folderId=${p_homeFolder}&extension=upl") .headers(DMHeaders.headers_15))
                .exec(http("NFU_45") .post("/file-upload/create/save?folderId=${p_homeFolder}&fileName=B${p_csrf}_txt") .headers(DMHeaders.headers_7))
                .exec(http("NFU_46") .get("/browser/job-execution?configuration=${p_configid}") .headers(DMHeaders.headers_0))
                .exec(http("NFU_48") .options("/rest/user-management?_=1538162164714") .headers(DMHeaders.headers_7))
                .exec(http("NFU_49") .options("/rest/user-management?_=1538162164717") .headers(DMHeaders.headers_7))
                .exec(http("NFU_50") .options("/rest/user-management?_=1538162164758") .headers(DMHeaders.headers_7))
                .exec(http("NFU_51") .get("/rest/user-management/logged-in-user?_=1538162164630") .headers(DMHeaders.headers_3))
                .exec(http("NFU_52") .get("/rest/user-management/logged-in-user?_=1538162164631") .headers(DMHeaders.headers_15))
                .exec(http("NFU_53") .get("/rest/user-management/shareable-groups?fields=name&firstResult=0&maxResults=50&sortDir=ASC&sortBy=name&_=1538162164633") .headers(DMHeaders.headers_15))
                .exec(http("NFU_54") .get("/rest/user-management/authenticable-users?fields=username&firstResult=0&maxResults=50&sortDir=ASC&sortBy=username&_=1538162164632") .headers(DMHeaders.headers_15))
                .exec(http("NFU_55") .get("/browser/list-filters") .headers(DMHeaders.headers_15))
                .exec(http("NFU_56") .get("/browser/list-folders?_=1538162164634") .headers(DMHeaders.headers_3))
                .exec(http("NFU_57") .get(uri2 + "/?MCExt_RR|,|9D4884F2-9D57-5362-B29E-B4AAD33B0B73|,|449|,|531|,|Mozilla%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_13_6)%20AppleWebKit%2F537.36%20(KHTML%24cma%3B%20like%20Gecko)%20Chrome%2F68.0.3440.106%20Safari%2F537.36|,|http%3A%2F%2F127.0.0.1%3A32826%2Fbrowser|,|http%3A%2F%2F127.0.0.1%3A32826%2Ffile-upload%2Fcreate%2Ffile-browser") .headers(DMHeaders.headers_10))
                .exec(http("NFU_58") .get("/api/filesystem/folders/${p_homeFolder}/permission?_=1538162164635") .headers(DMHeaders.headers_5))
                .exec(http("NFU_59") .get("/internal-rest/extensionpoints/datameer.dap.sdk.exportjob.ExportFileType/registered?_=1538162164636") .headers(DMHeaders.headers_3))
                .exec(http("NFU_60") .get("/browser/list-files?columnId=JOB_NAME&direction=ASC&from=0&rows=50&folderId=${p_homeFolder}&_=1538162164637") .headers(DMHeaders.headers_3))
                .exec(http("NFU_61") .get("/browser/list-files?columnId=JOB_NAME&direction=ASC&from=0&rows=50&folderId=${p_homeFolder}&_=1538162164638") .headers(DMHeaders.headers_3))
                .exec(http("NFU_62") .get(uri3 + "") .headers(DMHeaders.headers_20))
                .exec(http("NFU_63") .get("/browser/list-folders?_=1538162164639") .headers(DMHeaders.headers_3))
                .exec(http("NFU_64") .get("/browser/list-files?columnId=JOB_NAME&direction=ASC&from=0&rows=50&folderId=${p_homeFolder}&_=1538162164640") .headers(DMHeaders.headers_3))
                .exec(http("NFU_65") .get("/browser/list-folders?_=1538162164641") .headers(DMHeaders.headers_3))
                .exec(http("NFU_66") .get("/browser/list-files?columnId=JOB_NAME&direction=ASC&from=0&rows=50&folderId=${p_homeFolder}&_=1538162164642") .headers(DMHeaders.headers_3)))
	}

//************************************************************************************ 
//**** Run a workbook
//************************************************************************************ 

	val RunWB = group("RunWB"){
                // Filter_my_Files
		group("Filter")(
                exec(http("RWB_22") .head("/user-activity") .headers(DMHeaders.headers_8))
                .exec(http("RWB_23") .get("/browser/list-folders?_=1538681643425") .headers(DMHeaders.headers_3))
                .exec(http("RWB_24") .get("/browser/list-files?columnId=JOB_NAME&direction=ASC&from=0&rows=50&folderId=160&_=1538681643426") .headers(DMHeaders.headers_3))
                .exec(http("RWB_25") .get("/browser/list-files-by-filter?columnId=JOB_NAME&direction=ASC&from=0&rows=50&filterId=/Filter/My%20Files&_=1538681643427") .check(regex("\"contentId\": (.+?),").saveAs("p_contentId")) .headers(DMHeaders.headers_3))
                .exec(http("RWB_26") .head("/check-session") .headers(DMHeaders.headers_8))
                .exec(http("RWB_27") .get("/browser/list-folders?_=1538681643428") .headers(DMHeaders.headers_3))
                .exec(http("RWB_28") .get("/browser/list-files-by-filter?columnId=JOB_NAME&direction=ASC&from=0&rows=50&filterId=/Filter/My%20Files&_=1538681643429") .headers(DMHeaders.headers_3)))
                // Run
		.group("Run")(
                exec(http("RWB_29") .post("/browser/job-execution") .headers(DMHeaders.headers_12) .formParam("configuration", "${p_contentId}"))
                //.exec(http("request_29") .post("/browser/job-execution") .headers(DMHeaders.headers_12) .formParam("configuration", "1167"))
                .exec(http("RWB_30") .get("/browser/list-files-by-filter?columnId=JOB_NAME&direction=ASC&from=0&rows=50&filterId=/Filter/My%20Files&_=1538681643430") .headers(DMHeaders.headers_3))
                .exec(http("RWB_31") .get("/browser/list-folders?_=1538681643431") .headers(DMHeaders.headers_3))
                .exec(http("RWB_32") .get("/browser/list-files-by-filter?columnId=JOB_NAME&direction=ASC&from=0&rows=50&filterId=/Filter/My%20Files&_=1538681643432") .headers(DMHeaders.headers_3))
                .exec(http("RWB_33") .get("/browser/list-folders?_=1538681643433") .headers(DMHeaders.headers_3))
                .exec(http("RWB_34") .get("/browser/list-files-by-filter?columnId=JOB_NAME&direction=ASC&from=0&rows=50&filterId=/Filter/My%20Files&_=1538681643434") .headers(DMHeaders.headers_3)))
		
	}

//************************************************************************************ 
//**** Add Data to a workbook, sort and run
//************************************************************************************ 

	val AddData=group("AddData"){
                group("FMF")(
                exec(http("AD_21") .get("/browser/list-folders?_=1539267560198") .headers(DMHeaders.headers_9))
                .exec(http("AD_22") .get("/browser/list-files?columnId=JOB_NAME&direction=ASC&from=0&rows=50&folderId=${p_homeFolder}&_=1539267560199") .headers(DMHeaders.headers_9))
                //.exec(http("AD_22") .get("/browser/list-files?columnId=JOB_NAME&direction=ASC&from=0&rows=50&folderId=${p_homeFolder}&_=1539267560199") .headers(DMHeaders.headers_9))
                .exec(http("AD_23") .head("/user-activity") .headers(DMHeaders.headers_3))
                .exec(http("AD_24") .head("/check-session") .headers(DMHeaders.headers_3))
                .exec(http("AD_25") .get("/browser/list-folders?_=1539267560200") .headers(DMHeaders.headers_9))
                .exec(http("AD_26") .get("/browser/list-files-by-filter?columnId=JOB_NAME&direction=ASC&from=0&rows=50&filterId=/Filter/My%20Files&_=1539267560202")
                .check(regex("\"contentId\": (.+?),").saveAs("p_contentId"))
                .check(regex("\"id\": (.+?),").saveAs("p_id"))
                .check(regex("uuid\": \"(.+?)\",").saveAs("p_uuid")) .headers(DMHeaders.headers_9)))

                .group("GWB")(
                exec(http("AD_27") .get("/browser/list-folders?_=1539267560203") .headers(DMHeaders.headers_9))
                .exec(http("AD_28") .get("/browser/list-files-by-filter?columnId=JOB_NAME&direction=ASC&from=0&rows=50&filterId=/Filter/My%20Files&_=1539267560204") .headers(DMHeaders.headers_9))
                .exec(http("AD_29") .get("/api/workbooks/${p_contentId}/concurrent-users") .headers(DMHeaders.headers_9))
                .exec(http("AD_30") .get("/workbook/${p_contentId}") .headers(DMHeaders.headers_0))
                .exec(http("AD_31") .get("/rest/user-management/logged-in-user?_=1539267609417") .headers(DMHeaders.headers_9))
                .exec(http("AD_32") .get("/rest/user-management/logged-in-user?_=1539267609416") .headers(DMHeaders.headers_9))
                .exec(http("AD_33") .get("/workbook/loadWorkbook/${p_contentId}/60?nocache=1539267609624") .headers(DMHeaders.headers_16))
                .exec(http("AD_34") .get("/api/jobConfiguration/configurationStatus/${p_contentId}?nocache=1539267609862")  .headers(DMHeaders.headers_16))
                .exec(http("AD_35") .get(uri2 + "/?MCExt_RR|,|9D4884F2-9D57-5362-B29E-B4AAD33B0B73|,|449|,|531|,|Mozilla%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_13_6)%20AppleWebKit%2F537.36%20(KHTML%24cma%3B%20like%20Gecko)%20Chrome%2F68.0.3440.106%20Safari%2F537.36|,|http%3A%2F%2F127.0.0.1%3A32826%2Fworkbook%2F${p_contentId}|,|http%3A%2F%2F127.0.0.1%3A32826%2Fbrowser") .headers(DMHeaders.headers_2))
                .exec(http("AD_36") .get("/function/listFunctions/${p_contentId}/0") .headers(DMHeaders.headers_9))
                .exec(http("AD_37") .get("/api/filesystem/files/${p_id}")  .headers(DMHeaders.headers_3)))

                // GWB
                .group("GWB")(
                exec(http("AD2_27") .get("/browser/list-folders?_=1539267560203") .headers(DMHeaders.headers_9))
                .exec(http("AD2_28") .get("/browser/list-files-by-filter?columnId=JOB_NAME&direction=ASC&from=0&rows=50&filterId=/Filter/My%20Files&_=1539267560204") .headers(DMHeaders.headers_9))
                .exec(http("AD2_29") .get("/api/workbooks/${p_contentId}/concurrent-users") .headers(DMHeaders.headers_9))
                .exec(http("AD2_30") .get("/workbook/${p_contentId}") .headers(DMHeaders.headers_0))
                .exec(http("AD2_31") .get("/rest/user-management/logged-in-user?_=1539267609417") .headers(DMHeaders.headers_9))
                .exec(http("AD2_32") .get("/rest/user-management/logged-in-user?_=1539267609416") .headers(DMHeaders.headers_9))
                .exec(http("AD2_33") .get("/workbook/loadWorkbook/${p_contentId}/60?nocache=1539267609624") .headers(DMHeaders.headers_16))
                .exec(http("AD2_34") .get("/api/jobConfiguration/configurationStatus/${p_contentId}?nocache=1539267609862")  .headers(DMHeaders.headers_16))
                .exec(http("AD2_35") .get(uri2 + "/?MCExt_RR|,|9D4884F2-9D57-5362-B29E-B4AAD33B0B73|,|449|,|531|,|Mozilla%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_13_6)%20AppleWebKit%2F537.36%20(KHTML%24cma%3B%20like%20Gecko)%20Chrome%2F68.0.3440.106%20Safari%2F537.36|,|http%3A%2F%2F127.0.0.1%3A32826%2Fworkbook%2F${p_contentId}|,|http%3A%2F%2F127.0.0.1%3A32826%2Fbrowser") .headers(DMHeaders.headers_2))
                .exec(http("AD2_36") .get("/function/listFunctions/${p_contentId}/0") .headers(DMHeaders.headers_9))
                .exec(http("AD2_37") .get("/api/filesystem/files/${p_id}")  .headers(DMHeaders.headers_3)))

                // AddData to workbook
                .group("AddData")(
                exec(http("AD_39") .get("/workbook/createNewSheet/${p_contentId}?nocache=1539267638360")  .headers(DMHeaders.headers_16))
                .exec(http("AD_40") .head("/check-session") .headers(DMHeaders.headers_3))
                .exec(http("AD_41") .head("/user-activity") .headers(DMHeaders.headers_3))
                .exec(http("AD_42") .get("/browser/list-folders?_=1539267609418") .headers(DMHeaders.headers_9))
                .exec(http("AD_43") .get("/getFiles?folderId=132&mode=LINK_DATA_SOURCE&origin=${p_contentId}")  .headers(DMHeaders.headers_9))
                .exec(http("AD_44") .get("/getFiles?folderId=132&mode=LINK_DATA_SOURCE&origin=${p_contentId}")  .headers(DMHeaders.headers_9))
                .exec(http("AD_45") .get("/workbook/${p_contentId}/partitioningInfo?entityType=dataSource&entityId[]=1221&nocache=1539267657864") .headers(DMHeaders.headers_16))
                .exec(http("AD_46") .post("/workbook/linkDataSource/${p_contentId}/1221/60?nocache=1539267657906")  .headers(DMHeaders.headers_17))
                .exec(http("AD_49") .get("/browser/list-folders?_=1539267609419") .headers(DMHeaders.headers_9))
                .exec(http("AD_50") .head("/check-session") .headers(DMHeaders.headers_3)))

                // SAVE
                .group("Save")(
                exec(http("AD_51") .get("/browser/list-folders?_=1539267609420") .headers(DMHeaders.headers_9))
                .exec(http("AD_52") .get("/browser/list-folders?_=1539267609421") .headers(DMHeaders.headers_9))
                .exec(http("AD_53") .get("/browser/list-folders?_=1539267609422") .headers(DMHeaders.headers_9))
                .exec(http("AD_54") .get("/getFiles?folderId=31&mode=SAVE_WORKBOOK&origin=${p_contentId}") .headers(DMHeaders.headers_9))
                .exec(http("AD_55") .get("/analyst/json/validateName?name=A_NewUser7_Workbook&id=${p_contentId}&folderId=31&extension=wbk") .headers(DMHeaders.headers_3))
                .exec(http("AD_56") .put("/api/workbooks/${p_id}/command")  .headers(DMHeaders.headers_23) .body(ElFileBody("AddDataNew_0056_request.txt")))
                .exec(http("AD_57") .get("/workbook/loadWorkbook/${p_contentId}/60?nocache=1539267688073") .headers(DMHeaders.headers_16))
                .exec(http("AD_59") .get("/browser/list-folders?_=1539267609423") .headers(DMHeaders.headers_9))
                .exec(http("AD_60") .get("/browser/list-folders?_=1539267609424") .headers(DMHeaders.headers_9)))

                // FileBrowser
                .group("FileBrowser")(
                exec(http("AD_85") .get("/browser/list-folders?_=1539267609436") .headers(DMHeaders.headers_9))
                .exec(http("AD_86") .head("/check-session") .headers(DMHeaders.headers_3))
                .exec(http("AD_87") .get("/browser") .headers(DMHeaders.headers_0))
                .exec(http("AD_88") .get("/browser/mediaTypeUploadResponse") .headers(DMHeaders.headers_0))
                .exec(http("AD_89") .options("/rest/user-management?_=1539267761779") .headers(DMHeaders.headers_6))
                .exec(http("AD_90") .options("/rest/user-management?_=1539267761783") .headers(DMHeaders.headers_6))
                .exec(http("AD_91") .options("/rest/user-management?_=1539267761823") .headers(DMHeaders.headers_6))
                .exec(http("AD_92") .get("/rest/user-management/logged-in-user?_=1539267761675") .headers(DMHeaders.headers_9))
                .exec(http("AD_93") .get("/rest/user-management/logged-in-user?_=1539267761676") .headers(DMHeaders.headers_3))
                .exec(http("AD_94") .get("/rest/user-management/shareable-groups?fields=name&firstResult=0&maxResults=50&sortDir=ASC&sortBy=name&_=1539267761678") .headers(DMHeaders.headers_3))
                .exec(http("AD_95") .get("/rest/user-management/authenticable-users?fields=username&firstResult=0&maxResults=50&sortDir=ASC&sortBy=username&_=1539267761677") .headers(DMHeaders.headers_3))
                .exec(http("AD_96") .get("/browser/list-filters") .headers(DMHeaders.headers_3))
                .exec(http("AD_97") .get("/browser/list-folders?_=1539267761679") .headers(DMHeaders.headers_9))
                .exec(http("AD_98") .get("/api/filesystem/folders/${p_homeFolder}/permission?_=1539267761680")  .headers(DMHeaders.headers_13))
                .exec(http("AD_99") .get(uri3 + "") .headers(DMHeaders.headers_18))
                .exec(http("AD_100") .get("/internal-rest/extensionpoints/datameer.dap.sdk.exportjob.ExportFileType/registered?_=1539267761681") .headers(DMHeaders.headers_9))
                .exec(http("AD_101") .get("/browser/list-files?columnId=JOB_NAME&direction=ASC&from=0&rows=50&folderId=${p_homeFolder}&_=1539267761683") .headers(DMHeaders.headers_9))
                .exec(http("AD_102") .get(uri2 + "/?MCExt_RR|,|9D4884F2-9D57-5362-B29E-B4AAD33B0B73|,|449|,|531|,|Mozilla%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_13_6)%20AppleWebKit%2F537.36%20(KHTML%24cma%3B%20like%20Gecko)%20Chrome%2F68.0.3440.106%20Safari%2F537.36|,|http%3A%2F%2F127.0.0.1%3A32826%2Fbrowser|,|http%3A%2F%2F127.0.0.1%3A32826%2Fworkbook%2F${p_contentId}") .headers(DMHeaders.headers_2))
                .exec(http("AD_103") .head("/user-activity") .headers(DMHeaders.headers_3))
                .exec(http("AD_104") .get("/browser/list-files-by-filter?columnId=JOB_NAME&direction=ASC&from=0&rows=50&filterId=/Filter/My%20Files&_=1539267761684") .headers(DMHeaders.headers_9))
                .exec(http("AD_105") .get("/browser/list-folders?_=1539267761685") .headers(DMHeaders.headers_9))
                .exec(http("AD_106") .get("/browser/list-files-by-filter?columnId=JOB_NAME&direction=ASC&from=0&rows=50&filterId=/Filter/My%20Files&_=1539267761686") .headers(DMHeaders.headers_9)))
	}

}

