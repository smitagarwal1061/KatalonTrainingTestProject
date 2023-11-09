package fileUtils

import com.kms.katalon.core.annotation.Keyword

import io.restassured.path.json.JsonPath

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
		JsonPath js = new JsonPath(jsonString);
		String keyValue = js.getString(jsonPath);
		return keyValue;
	}
}
