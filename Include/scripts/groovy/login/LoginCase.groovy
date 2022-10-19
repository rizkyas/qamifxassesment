package login
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

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class LoginCase {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Given("I want to navigate to Form Login")
	def OpenUrlLogin() {
		WebUI.openBrowser('https://dev-company.profesi.io/auth/login')
		
	}

	@When("Login using correct email (.*) and password (.*)")
	def InputEmailAndPassword(String email, String password) {
		WebUI.setText(findTestObject('Login/Input Email'), email)
		WebUI.setText(findTestObject('Login/Input Password'), password)
	}

	@And("I Checklist Remember me")
	def ClickRememberMe() {
		WebUI.click(findTestObject('Login/Remember Me'))
		WebUI.delay(10)
	}
	
	@And("I Click Submit Button")
	def ClickSubmitButton() {
		WebUI.click(findTestObject('Login/Button Login'))
		WebUI.delay(10)
		
	}
	
	@Then("I shouldbe able to dashboard page")
	def ShowDashboard() {
		WebUI.verifyElementPresent(findTestObject('Home Page/Profile'), 15)

	}
	
	@Given("I want to navigate to Form Login 1")
	def OpenUrlLogin1() {
		WebUI.openBrowser('https://dev-company.profesi.io/auth/login')
		
	}

	@When("Login using wrong format email (.*) and password (.*)")
	def InputWrongFormatEmailAndPassword(String email, String password) {
		WebUI.setText(findTestObject('Login/Input Email'), email)
		WebUI.setText(findTestObject('Login/Input Password'), password)
	}
	
	@Then("Alert Email Format be displayed")
	def ShowAlerWrongFormatEmail() {
		WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Profesi.io/Alert Email Format'), 3)

	}
	
	@Given("I want to navigate to Form Login 2")
	def OpenUrlLogin2() {
		WebUI.openBrowser('https://dev-company.profesi.io/auth/login')
		
	}

	@When("Login using in correct email (.*) and password (.*)")
	def InputIncorrectEmailAndPassword(String email, String password) {
		WebUI.setText(findTestObject('Login/Input Email'), email)
		WebUI.setText(findTestObject('Login/Input Password'), password)
	}

	@And("I Checklist Remember me 2")
	def ClickRememberMe1() {
		WebUI.click(findTestObject('Login/Remember Me'))
		WebUI.delay(2)
	}
	
	@And("I Click Submit Button 2")
	def ClickSubmitButton2() {
		WebUI.click(findTestObject('Login/Button Login'))
		WebUI.delay(1)
		
	}
	
	@Then("Alert wrong password be displayed")
	def ShowAlert() {
		WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Profesi.io/p_Email atau password Anda salah. Silahkan _6c2179'), 1)

	}
	
	@Given("I want to navigate to Form Login 3")
	def OpenUrlLogin3() {
		WebUI.openBrowser('https://dev-company.profesi.io/auth/login')
		
	}

	@When("Login using empty email (.*) and password (.*)")
	def InputEmptyEmailAndPassword(String email, String password) {
		WebUI.setText(findTestObject('Login/Input Email'), email)
		WebUI.setText(findTestObject('Login/Input Password'), password)
	}

	@And("I Checklist Remember me 3")
	def ClickRememberMe3() {
		WebUI.click(findTestObject('Login/Remember Me'))
		WebUI.delay(2)
	}
	
	@Then("Alert Empty email and password be displayed")
	def ShowAlertEmailAndPasswordEmpty() {
		WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Profesi.io/Alert Email Harus Diisi'), 1)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Profesi.io/Alert Password Harus Diisi'), 1)

	}
	
	@Given("I want to navigate to Form Login 4")
	def OpenUrlLogin4() {
		WebUI.openBrowser('https://dev-company.profesi.io/auth/login')
		
	}

	@When("I Click Forgot Password")
	def ClickForgotPassword() {
		WebUI.click(findTestObject('Object Repository/Page_Profesi.io/Lupa Kata Sandi'))
	}

	@And("Show Form Input Email")
	def ShowInputEmail() {
		WebUI.delay(2)
	}
	
	@And("I input Email (.*)")
	def InputEmail(String email){
		WebUI.setText(findTestObject('Object Repository/Page_Profesi.io/Input Email Forgot Password'),email)
		WebUI.delay(2)
	}
	
	@And("I Click Button Pulihkan")
	def Pulihkan(){
		WebUI.click(findTestObject('Object Repository/Page_Profesi.io/Button Pulihkan'))
		WebUI.delay(2)
	}
	
	@Then("Alert Successfully be displayed")
	def AlertSuccessfully() {
		WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Profesi.io/Info Konfirmasi Kata Sandi'), 1)

	}
	
	@And("I Open Email")
	def OpenYopmail(){
		WebUI.openBrowser('https://yopmail.com/')
		WebUI.delay(2)
	}
	
	@And("Input Verification code (.*)")
	def InputVerification(String email){
		WebUI.setText(findTestObject('Object Repository/Page_Profesi.io/Yopmail Input'), email)
		WebUI.click(findTestObject('Object Repository/Page_Profesi.io/Check Inbox'))
		WebUI.delay(2)
	}
}