package comprehensive;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/**
 * Generates a random phrase given a properly formatted input grammar.
 * 
 * @author Draeden Jensen & John Haraden
 *
 */
public class RandomPhraseGenerator {

	private static HashMap<String, ArrayList<String>> map;
	
	public static void main(String[] args) throws FileNotFoundException {
		map = buildGrammar(args[0]);
		int times = Integer.parseInt(args[1]);
		
		String start = getRand(map.get("<start>"));
		
		for(int i = 0; i < times; i++) {
			//System.out.println(buildPhrase(start));
			buildPhrase(start);
		}
	}
	
	/**
	 * Creates a key-value pair HashMap using non-terminal expressions as the key and 
	 * creates an ArrayList of possible values as the value.
	 * 
	 * @param fileName  String representation of file path
	 * @return HashMap representation of the Grammar
	 * @throws FileNotFoundException
	 */
	private static HashMap<String, ArrayList<String>> buildGrammar(String fileName) throws FileNotFoundException {
		File theFile = new File(fileName);
		Scanner reader = new Scanner(theFile);
		Scanner firstLine = new Scanner(theFile);
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		
		boolean skip = true;
		if(firstLine.nextLine().equals("{")) {
			skip = false;
		}
		firstLine.close();
		reader.useDelimiter("\\{");
		
	    while(reader.hasNext()) {
			if(skip) {
				reader.next();
			}
			skip = true; 
			
			if(reader.hasNextLine()) {
				reader.nextLine();
				String key = reader.nextLine();
				ArrayList<String> temp = new ArrayList<>();
				
				String next = reader.nextLine();
				while(next.charAt(0) != '}') {
					temp.add(next);
					next = reader.nextLine();
				}
				map.put(key, temp);
			}
		}
		reader.close();
		
		return map;
	}
	
	/**
	 * Builds phrases by replacing non-terminals with terminal values
	 * 
	 * @param start String representation of phrase needing non-terminal replacement
	 * @return StringBuilder representation of the final phrase with all non-terminals replaced
	 */
	private static String buildPhrase(String start) {
		StringBuilder sb = new StringBuilder(start);
		
		while(true) {
			int open = sb.indexOf("<");
			int close = sb.indexOf(">");
			
			if(open == -1) {
				return sb.toString();
			} else {
				sb.replace(open, close + 1, findWord(sb.substring(open, close + 1)));
			}
		}
	}
	
	/**
	 * Finds and returns value for given key. Can return non-terminals if 
	 * specified by the grammar
	 * 
	 * @param key  Non-terminal value to replace
	 * @return String value to replace non-terminal
	 */
	private static String findWord(String key) {
		return getRand(map.get(key));
	}
	
	/**
	 * Returns pseudo-random value from given ArrayList of values
	 * 
	 * @param arr  ArrayList of values for a specific key
	 * @return String representation of the random value
	 */
	private static String getRand(ArrayList<String> arr) {
		Random rng = new Random();
		return arr.get(rng.nextInt(arr.size()));
	}
}
