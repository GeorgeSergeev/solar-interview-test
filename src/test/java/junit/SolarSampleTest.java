package junit;

import static org.junit.Assert.assertTrue;

import interview.SolarSample;
import org.junit.Test;

import java.util.List;

public class SolarSampleTest {

	@Test
	public void doSomethingTest() {
		System.out.println("Test");
		SolarSample tester = new SolarSample();
		tester.doSomething("src\\main\\resources\\test.txt");
	}

}
