package junit;

import static org.junit.Assert.assertEquals;

import interview.SolarSample;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SolarSampleTest {

	private static final List<String> testWords = Arrays.asList("звон", "мышь", "хвост");
	private static final String testFilePath = "src\\main\\resources\\test.txt";
	private static final SolarSample solarSample = new SolarSample();

	@Test
	public void getUniqueWordsFromFileTest() {
		System.out.println("Test");
		assertEquals(testWords, solarSample.getUniqueWordsFromFile(testFilePath));
	}

}
