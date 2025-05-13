package MaGiNiSo;

import java.util.List;

public class Adjective extends Word{
	
	public static void setDictionary() {
		Word.createDictionary("src/main/java/MaGiNiSo/Adjectives.txt");
	}

	public Adjective() {
		super();
	}
	
	public static void addAdjectives(List<String> adjectives) {
		Word.add(adjectives);
	}
}
