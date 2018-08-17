import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
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

'set date variable'
def d = new Date()
def date = d.format('yyyyMMdd')

'Send GET Request to COSI'
responseData = WS.sendRequest(findTestObject('Object Repository/COSI/Catalog'))

responseCode = responseData.getStatusCode()
println('Response Code: ' + responseCode)

'Response Body'
responseText = responseData.getResponseText()

xmlf = 'Data Files/' + date + '_catalog.xml'
File file = new File(xmlf)
file.write "${responseText}"

'Parse XML (//from file)'
//def xmlFile = "catalog-1533807464904_formatted.xml"
def cat = new XmlSlurper().parse(xmlf)


'Create csv file'
fname = 'Data Files/' + date + '_catalog.csv'
File csv = new File(fname)

'Write output to CSV'
csv.write "articleNo, value\n"
def an = cat.articles.article.each { ac ->
	csv << "${ac.articleNo.toString()}, ${ac.price.purchasePrice.toString()}\n"
}
