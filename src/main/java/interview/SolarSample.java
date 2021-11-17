package interview;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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

			List<String> uniqueWords = new ArrayList<String>();
			for (int i = 0; i < words.length; i++){
				String testedWord = words[i];
				int count = 0;
				for (int j = 0; j < words.length; j++){
					if (testedWord.equals(words[j]))
						count++;
				}

				if (count == 1 && !uniqueWords.contains(testedWord))
					uniqueWords.add(testedWord);
			}

			Collections.sort(uniqueWords);
			for (int i = 0; i < uniqueWords.size(); i++){
				System.out.println(uniqueWords.get(i));
			}

			br.close();
		} catch (IOException ex) {
			Logger.getLogger(SolarSample.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
