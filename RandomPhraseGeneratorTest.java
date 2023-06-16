package comprehensive;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RandomPhraseGeneratorTest {
	
	String[] grammars = {"src/comprehensive/abc_spaces.g", "src/comprehensive/abc.g", "src/comprehensive/hello_world .g", "src/comprehensive/poetic_sentence.g", "src/comprehensive/super_simple.g", "src/comprehensive/mathematical_expression.g"};
	ArrayList<String[]> list = new ArrayList<>();
	
	@BeforeEach
	void setUp() throws Exception {
		for(int i = 0; i < grammars.length; i++) {
			String[] temp = {grammars[i], "3"};
			list.add(temp);
		}
	}

	@Test
	void test() throws FileNotFoundException {
		RandomPhraseGenerator.main(list.get(0));
		RandomPhraseGenerator.main(list.get(1));
		RandomPhraseGenerator.main(list.get(2));
		RandomPhraseGenerator.main(list.get(3));
		RandomPhraseGenerator.main(list.get(4));
		RandomPhraseGenerator.main(list.get(5));
	}

}
