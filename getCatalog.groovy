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

'set date variable'
def d = new Date()
def date = d.format('yyyyMMdd')

'Parse XML (from file)'
def xmlFile = "catalog-1533807464904_formatted.xml"
def cat = new XmlSlurper().parse(xmlFile)


'Create csv file'
fname = date + '_catalog.csv'
File csv = new File(fname)

'Write output to CSV'
csv.write "articleNo, value\n"
def an = cat.articles.article.each { ac ->
    csv << "${ac.articleNo.toString()}, ${ac.price.purchasePrice.toString()}\n"
}
