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
import internal.GlobalVariable

import org.apache.http.util.Asserts
import org.openqa.selenium.Keys as Keys


responseGetAccessToken = WS.sendRequestAndVerify(findTestObject('Postman/PayPal-GetAccessToken'))

def accessToken = CustomKeywords.'fileUtils.jsonUtils.getKeyValueUsingJsonPath'(responseGetAccessToken.getResponseBodyContent(), 'access_token')
println " >> access token :: " +accessToken

GlobalVariable.ACCESSTOKEN = accessToken
 
responseCreateOrders = WS.sendRequestAndVerify(findTestObject('Postman/PayPal-CreateOrders'))

def hrefOrder = CustomKeywords.'fileUtils.jsonUtils.getKeyValueUsingJsonPath'(responseCreateOrders.getResponseBodyContent(), 'links[0].href')
def orderIdCreateOrders = CustomKeywords.'fileUtils.jsonUtils.getKeyValueUsingJsonPath'(responseCreateOrders.getResponseBodyContent(), 'id')
println " >> href Order :: " +hrefOrder
println " >> Order ID :: " +orderIdCreateOrders

GlobalVariable.HREF = hrefOrder

def responseGetOrders = WS.sendRequest(findTestObject('Postman/PayPal-GetOrders'))

def orderIdGetOrders = CustomKeywords.'fileUtils.jsonUtils.getKeyValueUsingJsonPath'(responseGetOrders.getResponseBodyContent(), 'id')
println " >> Order ID :: " +orderIdGetOrders

WebUI.verifyMatch(orderIdGetOrders, orderIdCreateOrders, false)