package fileUtils

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class jsonUtils {
	/**
	 * This function is used to fetch json path key value
	 *
	 * @param jsonString
	 * @param jsonPath
	 * @return keyValue
	 *
	 */
	@Keyword
	public static String getKeyValueUsingJsonPath(String jsonString, String jsonPath) {
		def slurper = new groovy.json.JsonSlurper()
		def responseAsText = slurper.parseText(jsonString)
		def keyValue = responseAsText."${jsonPath}"

		println " >> ${jsonPath} key value :: ${keyValue}"
		return keyValue
	}

	//	/**
	//	 * This function is used to fetch json path key value
	//	 *
	//	 * @param jsonString
	//	 * @param jsonPath
	//	 * @return keyValue
	//	 *
	//	 */
	//		@Keyword
	//		public static String getKeyValueUsingJsonPath(String jsonString, String jsonPath) {
	//			JsonPath js = new JsonPath(jsonData);
	//			String keyValue = js.getString(jsonPath);
	//			return keyValue;
	//
	//		}
}
