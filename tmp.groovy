/*import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
*/
import java.lang.*
import java.util.*
import java.util.logging.Logger
import java.io.*
import java.net.*
import groovy.lang.*
import groovy.util.*
import groovy.xml.*
import groovy.transform.ToString
import java.math.BigInteger
import java.math.BigDecimal

/*
'Send GET Request to COSI'
responseData = WS.sendRequest(findTestObject('Object Repository/COSI/Catalog'))

responseCode = responseData.getStatusCode()
println('Response Code: ' + responseCode)

'Response Body'
responseText = responseData.getResponseText()
//println('Response body: ' + responseText)
*/

'set date variable'
def d = new Date()
def date = d.format('yyyyMMdd')


'Create csv file'
new File(date + '_catalog.xml').createNewFile()

'Parse the XML catalog'

Logger logger = Logger.getLogger("test.log")
logger.info ("I am a test info log")

//String fileContents = new File('catalog-1533807464904_formatted.xml').text
//rt = new XmlSlurper().parseText(fileContents)

def xmlFile = "catalog-1533807464904_formatted.xml"
def rt = new XmlParser().parse(xmlFile)

//def wtf = [:]
//wtf = ['articleNo:${articleNo}', 'prodName:${name}']

//def wtf = new XmlSlurper().parseText(fileContents)

//println "articleNo is: ${rt.articles.article.articleNo}"
//println "Name is: ${rt.articles.article.localeArticle.name}"

nu = rt.Row.collect${rt.article}
countMap = rt.unique(false).collectEntries{article -> [article, rt.count(article)]}

println "${countMap}"
/*
//String fileContents = new File('catalog-1533807464904_formatted.xml').text

//static void main(args) {
    String fileContents = new File('catalog-1533807464904_formatted.xml').text
    rt = new XmlSlurper().parseText(fileContents)
    nu = rt.Row.collect{rt.article}
    countMap = nu.unique(false).collectEntries{article -> [article, nu.count(article)]}

    def wtf = [:]
    wtf = [articleNo:${rt.articleNo}, name:${rt.name}]

    println "Nr is: ${wtf['articleNo']}"
    println "Name is: ${wtf['name']}"

    //println "There are ${countMap} items in the COSI catalog."
    //manager.listener.logger.println ${countMap}
    //logger.info ("${articleNo}, ${name}")


        articleNo = cmlObj.Row.collect{rt.articleNo}
        name = cmlObj.Row.collect{rt.name}
        File file = new File(date + '_catalog.xml')
        file.write "$articleNo, $name"
        println file.text
        logger.info ("${articleNo}, ${name}")
//}


def listings() {
    while (cCount <= countMap) {
        def articleNo = cmlObj.Row.collect{rt.articleNo}
        def name = cmlObj.Row.collect{rt.name}

        println "${articleNo}, ${name}"
}
*/
