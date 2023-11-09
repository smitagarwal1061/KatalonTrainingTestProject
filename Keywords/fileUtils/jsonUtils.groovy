package fileUtils

import com.kms.katalon.core.annotation.Keyword

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
//	@Keyword
//	public static String getKeyValueUsingJsonPath(String jsonString, String jsonPath) {
//		JsonPath js = new JsonPath(jsonData);
//		String keyValue = js.getString(jsonPath);
//		return keyValue;
//	}
}
