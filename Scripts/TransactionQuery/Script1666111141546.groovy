import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import java.sql.Connection
import java.sql.ResultSet


globalConnection = CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.getGlobalConnection'()

TransactionData = CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(globalConnection, 
    'SELECT a.trx_id  AS InvoiceNo,b.name AS Wholesaler,c.courier_service_name AS DeliveryService,a.date_order AS DateOrder FROM transaction a left JOIN wholesaler b ON b.id = a.wholesaler_id left JOIN courier c ON c.id = b.courier_service_id WHERE b.id = 7')
println TransactionData
NumberInvoice =CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getListCellValue'(TransactionData, 'InvoiceNo')
System.out.println("Invoice No: "+NumberInvoice)
if(System.out.println(NumberInvoice).equals("DX01.006.009")) {
		System.out.println("Query: "+"Query is correct")
	} else {
		System.out.println("Query: "+"Query is not correct")
	}
Wholesaler =CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getListCellValue'(TransactionData, 'Wholesaler')
DeliveryService =CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getListCellValue'(TransactionData, 'DeliveryService')
DateOrder =CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getListCellValue'(TransactionData, 'DateOrder')
System.out.println("Invoice No: "+NumberInvoice+"|"+" Wholesaler: "+Wholesaler+"|"+"Delivery Service"+DeliveryService+"|"+"DateOrder"+DateOrder+"|")

TransactionDataFalse = CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(globalConnection,
	'SELECT a.trx_id  AS InvoiceNo,b.name AS Wholesaler,c.courier_service_name AS DeliveryService,a.date_order AS DateOrder FROM transaction a left JOIN wholesaler b ON b.id = a.wholesaler_id left JOIN courier c ON c.id = b.courier_service_id WHERE b.id = 6')
println TransactionDataFalse
InvoiceNumber =CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getListCellValue'(TransactionDataFalse, 'InvoiceNo')
Wholeseller =CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getListCellValue'(TransactionDataFalse, 'Wholesaler')
ServiceDelivery =CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getListCellValue'(TransactionDataFalse, 'DeliveryService')
OrderDate =CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getListCellValue'(TransactionDataFalse, 'DateOrder')
if(System.out.println(InvoiceNumber).equals("DX01.006.009") && System.out.println(Wholeseller).equals("Budi") ) {
	System.out.println("Invoice Number "+"is correct" + NumberInvoice)
	System.out.println("Wholeseller"+"is correct"+ Wholeseller)
} else {
	System.out.println("Invoice Number is not correct"+" " +InvoiceNumber+" "+ "Invoice Number must DX01.006.009")
	System.out.println("Wholeseller is not correct"+" "+Wholeseller +" "+"Wholeseller must Budi")
	System.out.println("ServiceDelivery is not correct"+" " +InvoiceNumber+" "+ "ServiceDelivery must JNE Reguler")
	System.out.println("DateOrder is not correct"+" "+OrderDate +" "+"OrderDate must 2002-05-04")
}
System.out.println("Invoice No: "+InvoiceNumber+"|"+" Wholesaler: "+Wholeseller+"|"+"Delivery Service"+ServiceDelivery+"|"+"DateOrder"+OrderDate+"|")

CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.closeConnection'(globalConnection)

