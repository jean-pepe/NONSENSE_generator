package MaGiNiSo;

import java.util.List;

public class Noun extends Word {
	
	public static void setDictionary() {
		Word.createDictionary("src/main/java/MaGiNiSo/Nouns.txt");
	}

	public Noun() {
		super();
	}
	
	public static void addNoun(List<String> nouns) {
		Word.add(nouns);
	}
	
}
