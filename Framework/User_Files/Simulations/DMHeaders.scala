
package DM.Framework
  
import scala.concurrent.duration._
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._
import scala.util.Random


object DMHeaders{

        val headers_0 = 	Map( "Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8", "Upgrade-Insecure-Requests" -> "1")
        val headers_1 =		Map( "Accept" -> "image/webp,image/apng,image/*,*/*;q=0.8", "Pragma" -> "no-cache")
        val headers_2 =		Map( "Accept-Encoding" -> "gzip, deflate")
        val headers_3 =		Map( "X-Datameer-CSRF" -> "${p_csrf}", "X-Requested-With" -> "XMLHttpRequest")
        val headers_4 =         Map( "Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8", "Origin" -> " + HOSTNAME", "Upgrade-Insecure-Requests" -> "1")
        val headers_5 =		Map( "Content-Type" -> "application/json", "X-Datameer-CSRF" -> "${p_csrf}", "X-Requested-With" -> "XMLHttpRequest")
        val headers_6 =		Map( "Origin" -> " + HOSTNAME", "X-Datameer-CSRF" -> "${p_csrf}", "X-Requested-With" -> "XMLHttpRequest")
        val headers_7 =		Map( "Accept" -> "*/*", "Origin" -> " + HOSTNAME", "X-Datameer-CSRF" -> "${p_csrf}", "X-Requested-With" -> "XMLHttpRequest")
        val headers_8 =		Map( "Accept" -> "*/*", "X-Datameer-CSRF" -> "${p_csrf}", "X-Requested-With" -> "XMLHttpRequest")
        val headers_9 =		Map( "Accept" -> "application/json, text/javascript, */*; q=0.01", "X-Datameer-CSRF" -> "${p_csrf}", "X-Requested-With" -> "XMLHttpRequest")
        val headers_10 =	Map( "Accept" -> "*/*", "Accept-Encoding" -> "gzip, deflate")
        val headers_11 =	Map( "Accept" -> "*/*", "X-Datameer-CSRF" -> "${p_csrf}", "X-Requested-With" -> "XMLHttpRequest")
        val headers_12 =	Map( "Accept" -> "*/*", "Content-Type" -> "application/x-www-form-urlencoded; charset=UTF-8", 
					"Origin" -> "http://127.0.0.1:32826", "X-Datameer-CSRF" -> "${p_csrf}", "X-Requested-With" -> "XMLHttpRequest")
        val headers_13 =	Map( "Accept" -> "application/json, text/javascript, */*; q=0.01", "Content-Type" -> "application/json", "X-Datameer-CSRF" -> "${p_csrf}", "X-Requested-With" -> "XMLHttpRequest")
        val headers_14 =	Map( "Accept" -> "*/*", "Accept-Encoding" -> "gzip, deflate", "Origin" -> "http://127.0.0.1:32826")
        val headers_15 =	Map( "Accept" -> "*/*", "X-Datameer-CSRF" -> "${p_csrf}", "X-Requested-With" -> "XMLHttpRequest")
        val headers_16 =        Map( "Content-Type" -> "application/x-www-form-urlencoded; charset=UTF-8", "X-Datameer-CSRF" -> "${p_csrf}", "X-Requested-With" -> "XMLHttpRequest")
        val headers_17 =        Map( "Content-Type" -> "application/x-www-form-urlencoded; charset=UTF-8", "Origin" -> " + HOSTNAME", "X-Datameer-CSRF" -> "${p_csrf}", "X-Requested-With" -> "XMLHttpRequest")
        val headers_18 =	Map( "Accept-Encoding" -> "gzip, deflate", "Origin" -> " + HOSTNAME")
        val headers_19 =        Map( "Content-Type" -> "application/json", "Origin" -> " + HOSTNAME", "X-Datameer-CSRF" -> "${p_csrf}", "X-Requested-With" -> "XMLHttpRequest")
        val headers_20 =        Map( "Accept" -> "*/*", "Accept-Encoding" -> "gzip, deflate", "Origin" -> " + HOSTNAME")
        val headers_21 =	Map( "Content-Type" -> "application/x-www-form-urlencoded; charset=UTF-8", "X-Datameer-CSRF" -> "${p_csrf}", "X-Requested-With" -> "XMLHttpRequest")
	val headers_22 =	Map( "X-Datameer-CSRF" -> "${p_csrf}", "X-Requested-With" -> "XMLHttpRequest")
        val headers_23 =	Map( "Accept" -> "application/json, text/javascript, */*; q=0.01", "Content-Type" -> "application/json", 
					"Origin" -> " + HOSTNAME", "X-Datameer-CSRF" -> "${p_csrf}", "X-Requested-With" -> "XMLHttpRequest")
        val headers_24 =	Map( "Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8", "Content-Type" -> "multipart/form-data; boundary=----WebKitFormBoundaryCcB2sqwsyFUxAGcQ", 
					"Origin" -> " + HOSTNAME", "Upgrade-Insecure-Requests" -> "1")
        val headers_25 =	Map( "Accept" -> "*/*", "Content-Type" -> "application/x-www-form-urlencoded; charset=UTF-8", "X-Datameer-CSRF" -> "${p_csrf}", "X-Requested-With" -> "XMLHttpRequest")
        val headers_26 =	Map( "Accept" -> "*/*", "Accept-Language" -> "en-US,en;q=0.9", "Content-Type" -> "application/x-www-form-urlencoded; charset=UTF-8", 
					"X-Datameer-CSRF" -> "${p_csrf}", "X-Requested-With" -> "XMLHttpRequest")
        val headers_27 =	Map( "Accept" -> "*/*", "Content-Type" -> "application/x-www-form-urlencoded; charset=UTF-8", "Origin" -> " + HOSTNAME", "X-Datameer-CSRF" -> "${p_csrf}", "X-Requested-With" -> "XMLHttpRequest")
        val headers_28 =	Map( "Accept" -> "*/*", "Accept-Encoding" -> "gzip, deflate", "Origin" -> " + HOSTNAME")
        val headers_29 =	Map( "Origin" -> " + HOSTNAME")
        val headers_30 =	Map( "Accept" -> "image/webp,image/apng,image/*,*/*;q=0.8")
        val headers_31 =        Map( "Accept" -> "application/json, text/javascript, */*; q=0.01", "Accept-Language" -> "en-US,en;q=0.9", "X-Datameer-CSRF" -> "${p_csrf}", "X-Requested-With" -> "XMLHttpRequest")
        val headers_32 =        Map( "Accept" -> "*/*", "Accept-Language" -> "en-US,en;q=0.9", "Content-Type" -> "application/x-www-form-urlencoded; charset=UTF-8", 
					"Origin" -> " + HOSTNAME", "X-Datameer-CSRF" -> "${p_csrf}", "X-Requested-With" -> "XMLHttpRequest")
        val headers_33 =        Map( "Accept" -> "*/*", "Accept-Language" -> "en-US,en;q=0.9", "Content-Type" -> "application/json", "X-Datameer-CSRF" -> "${p_csrf}", "X-Requested-With" -> "XMLHttpRequest")
        val headers_34 =    	Map( "Accept" -> "*/*", "Accept-Language" -> "en-US,en;q=0.9", "X-Datameer-CSRF" -> "${p_csrf}", "X-Requested-With" -> "XMLHttpRequest")
        val headers_35 =	Map( "Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8", "Content-Type" -> "multipart/form-data; boundary=----WebKitFormBoundaryqxLPijcaQA9x1sHE", 
					"Origin" -> " + HOSTNAME", "Upgrade-Insecure-Requests" -> "1")
        val headers_36 =	Map( "Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8", "Content-Type" -> "multipart/form-data; boundary=----WebKitFormBoundaryxkyOk7GDDAHzBaiT", 
					"Origin" -> " + HOSTNAME", "Upgrade-Insecure-Requests" -> "1")
        val headers_37 =	Map( "Accept" -> "*/*", "Accept-Language" -> "en-US,en;q=0.9", "Content-Type" -> "application/x-www-form-urlencoded; charset=UTF-8", 
					"X-Datameer-CSRF" -> "${p_csrf}", "X-Requested-With" -> "XMLHttpRequest")
}
