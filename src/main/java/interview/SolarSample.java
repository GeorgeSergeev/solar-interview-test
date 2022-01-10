package interview;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class SolarSample {

	public static StringBuilder sb = new StringBuilder();

	public void doSomething(String parameter) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(parameter));
			for (String line = br.readLine(); line != null; line = br.readLine()) {
				sb.append(line);
				sb.append("\n");
			}
			String[] words = sb
					.toString()
					.split("\\s|\\(|\\)|\\.|\\[|\\]|,|\\+|;|\\\\|\"|!|\\||/|=|\\*|@|<|>");

			Arrays.stream(words)
					.collect(Collectors.groupingBy(w -> w, Collectors.counting()))
					.entrySet().stream()
					.filter(e -> e.getValue() == 1)
					.map(Map.Entry::getKey)
					.forEach(System.out::println);

			br.close();
		} catch (IOException ex) {
			Logger.getLogger(SolarSample.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
