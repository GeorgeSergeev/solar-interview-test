package interview;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class SolarSample {

	private static final String regExp = "\\s|\\(|\\)|\\.|\\[|\\]|,|\\+|;|\\\\|\"|!|\\||/|=|\\*|@|<|>";

	public void printUniqueWordsFromFile(String filePath) {
		getUniqueWordsFromFile(filePath).forEach(System.out::println);
	}

	public List<String> getUniqueWordsFromFile(String filePath){
		return Arrays.stream(getWordsFromFile(filePath))
				.collect(Collectors.groupingBy(w -> w, Collectors.counting()))
				.entrySet().stream()
				.filter(e -> e.getValue() == 1)
				.map(Map.Entry::getKey)
				.sorted()
				.collect(Collectors.toList());
	}

	private String[] getWordsFromFile(String filePath){
		StringBuilder sb = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			for (String line = br.readLine(); line != null; line = br.readLine()) {
				sb.append(line);
				sb.append("\n");
			}
		}
		catch (IOException ex) {
			Logger.getLogger(SolarSample.class.getName()).log(Level.SEVERE, null, ex);
		}
		return sb.toString().split(regExp);
	}
}
