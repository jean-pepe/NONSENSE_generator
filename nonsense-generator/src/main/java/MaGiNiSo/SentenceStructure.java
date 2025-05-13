package MaGiNiSo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class SentenceStructure extends Word{
	
	public static void setDictionary() {
		Word.createDictionary("src/main/java/MaGiNiSo/SentenceStructures.txt");
	}

	public SentenceStructure() {
		super();
	}
	
}


