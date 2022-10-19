import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException


import org.junit.runner.RunWith
import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import java.sql.Connection
import java.sql.ResultSet




class RunQueryTransaction {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Given("I Navigate to database administration")
	def NavigateToDatabaseAdministration() {
		println ("Database Administration Displayed")
	}

	@When("I connect to database")
	def ConnectToDatabase() {
		globalConnection = CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.getGlobalConnection'()
		println ("\n Database Connected" )
	}

	@And("I Run Query for Invoice No DX01.006.009")
	def RunQueryDX01006009() {
		TransactionData = CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(globalConnection,
				'SELECT a.trx_id  AS InvoiceNo,b.name AS Wholesaler,c.courier_service_name AS DeliveryService,a.date_order AS DateOrder FROM transaction a left JOIN wholesaler b ON b.id = a.wholesaler_id left JOIN courier c ON c.id = b.courier_service_id WHERE b.id = 7')
		println TransactionData
	}

	@And("result query Invoice No DX01.006.009 is show")
	def ResultQuery() {
		InvoiceNo = CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getListCellValue'(TransactionData, 'InvoiceNo')
		Wholesaler =CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getListCellValue'(TransactionData, 'Wholesaler')
		DeliveryService =CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getListCellValue'(TransactionData, 'DeliveryService')
		DateOrder =CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getListCellValue'(TransactionData, 'DateOrder')
		System.out.println("Invoice No: "+InvoiceNo+"|"+" Wholesaler: "+Wholesaler+"|"+"Delivery Service"+DeliveryService+"|"+"DateOrder"+DateOrder+"|")
	}
	@Then("Validate the result is invoice_no (.*) and whole_saler (.*) and delivery_service (.*) and date_order (.*)")
	def ValidateQuery( String invoice_no, String whole_saler, String delivery_service, String date_order) {
		InvoiceNo =CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getListCellValue'(TransactionData, 'InvoiceNo')
		if(println(InvoiceNo) != invoice_no) {
			println("False")
		} else {
			System.out.println("Invoice No: "+"True")
		}
		Wholesaler =CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getListCellValue'(TransactionData, 'Wholesaler')
		DeliveryService =CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getListCellValue'(TransactionData, 'DeliveryService')
		DateOrder =CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getListCellValue'(TransactionData, 'DateOrder')
		System.out.println("Invoice No: "+InvoiceNo+"|"+" Wholesaler: "+Wholesaler+"|"+"Delivery Service"+DeliveryService+"|"+"DateOrder"+DateOrder+"|")
	}
}