package comprehensive;

import java.io.FileNotFoundException;
import java.io.IOException;

public class TimeRandomPhraseGenerator {

	public static void main(String[] args) throws IOException {

		int timesToLoop = 100;
		
//		System.out.println("increasing number of nonterminals: ");
//		for(int n = 100; n <= 2000; n += 100) {
//			
//			GrammarGenerator.generateGrammar("src/comprehensive/grammar.g", n);
//			String[] path = {"src/comprehensive/grammar.g", "1"};
//			
//			long startTime, midpointTime, stopTime;
//			
//			startTime = System.nanoTime();
//			while(System.nanoTime() - startTime < 100000000) {}
//			
//			startTime = System.nanoTime();
//			
//			for(int i = 0; i < timesToLoop; i++) {
//				RandomPhraseGenerator.main(path);
//			}
//			
//			midpointTime = System.nanoTime();
//			
//			for(int i = 0; i < timesToLoop; i++) {}
//			
//			stopTime = System.nanoTime();
//			
//			double averageTime = ((midpointTime - startTime) + (midpointTime - stopTime))
//					/ (double) timesToLoop;
//			
//			System.out.println(n + "\t" + averageTime);
//		}
		
		System.out.println("increasing number of phraes to generate: ");
		for(int n = 1000; n <= 20000; n += 1000) {
			Integer phrases = n;
			
			GrammarGenerator.generateGrammar("src/comprehensive/grammar.g", 10);
			String[] path = {"src/comprehensive/grammar.g", phrases.toString()};
			
			long startTime, midpointTime, stopTime;
			
			startTime = System.nanoTime();
			while(System.nanoTime() - startTime < 100000000) {}
			
			startTime = System.nanoTime();
			
			for(int i = 0; i < timesToLoop; i++) {
				RandomPhraseGenerator.main(path);
			}
			
			midpointTime = System.nanoTime();
			
			for(int i = 0; i < timesToLoop; i++) {}
			
			stopTime = System.nanoTime();
			
			double averageTime = ((midpointTime - startTime) + (midpointTime - stopTime))
					/ (double) timesToLoop;
			
			System.out.println(n + "\t" + averageTime);
		}
	}

}
