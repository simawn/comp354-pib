package model.board;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * This class will process a .json file and return a JSON object. Using Simple JSON library
 * @author Simon Huang
 */
public class JSONProcessor {
	
	/**
	 * Processes the current .json file defined in Constants
	 * @return Processed JSONObject
	 */
	public static JSONObject ProcessCurrentJSON() {
		return ProcessJSON(Constants.WORDS_PATH);
	}
	
	/**
	 * Process any kind of .json file
	 * @param path Path to a .json file
	 * @return Processed JSONObject
	 */
	public static JSONObject ProcessCustomJSON(Path path) {
		return ProcessJSON(path);
	}
	
	/**
	 * Process .json object. If the specified file does not exist, the program will terminate and display the error
	 * 
	 * @param path Path to a .json file
	 * @return Processed JSONObject
	 */
	private static JSONObject ProcessJSON(Path path) {
		
		JSONObject jsonObj = null;
		
		//processes a json file taken from our given path parameter. If it does not 
		// exist then exception is thrown and caught and error message is displayed showing what type of error it is
		try {
			JSONParser parser = new JSONParser();
			jsonObj = (JSONObject) parser.parse(new FileReader(path.toString()));
		} catch (FileNotFoundException e) {
			System.err.println(".json file not found");
			e.printStackTrace();
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Error reading .json file");
			e.printStackTrace();
			System.exit(1);
		} catch (ParseException e) {
			System.err.println("Error parsing .json file");
			e.printStackTrace();
			System.exit(1);
		}
		
		return jsonObj;
	}
}
