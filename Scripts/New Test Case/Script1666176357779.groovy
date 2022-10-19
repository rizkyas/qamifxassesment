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

WebUI.openBrowser('')

WebUI.navigateToUrl('https://dev-company.profesi.io/')

WebUI.setText(findTestObject('Object Repository/Page_Profesi.io/input_Email_vs-inputx vs-input--input norma_38a119'), 'asdad@gmail.com')

WebUI.setEncryptedText(findTestObject('Object Repository/Page_Profesi.io/input_Kata Sandi_vs-inputx vs-input--input _61cc14'), 
    'P2It3HX3F5iIJrPkvnFUjQ==')

WebUI.click(findTestObject('Object Repository/Page_Profesi.io/input_Kata Sandi_vs-checkbox--input'))

WebUI.click(findTestObject('Object Repository/Page_Profesi.io/i_Login_feather icon-log-in'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Profesi.io/p_Email atau password Anda salah. Silahkan _6c2179'), 
    10)

