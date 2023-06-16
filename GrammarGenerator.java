package comprehensive;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Random;

/**
 * @author John Haraden & Draeden Jensen
 *
 */
public class GrammarGenerator {
	
	public static void main(String[] args) throws IOException {
		
		generateGrammar("src/comprehensive/grammar.g", 8);
		
	}
	
	public static void generateGrammar(String fileName, int size) throws IOException {
		Random rnd = new Random();
		
		try {
			PrintWriter write = new PrintWriter(new FileWriter(fileName));;
			int terminals = 5;
			
			write.write("{\n<start>\n");
			
			for(int i = 0; i < (size / 2); i++) {
				write.write("<nonTerminal" + rnd.nextInt(size) + "> and ");
			}
			
			write.write("\n}\n");
			
			for(int i = 0; i < size; i++) {
				write.write("\n{\n");
				write.write("<nonTerminal" + i + ">\n");
				
				for(int j = 0; j < terminals; j++) {
					for (int s = 0; s <= i; s++) {
						write.write((char) (rnd.nextInt(26) + 'a'));
					}	
					write.write("\n");
				}
				write.write("}\n");
			}
			
			write.close();
		}
		catch(Exception e){e.printStackTrace();}
	}

}
