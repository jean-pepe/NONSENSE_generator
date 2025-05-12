package MaGiNiSo;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		//setting the dictionaries
		Noun.setDictionaryNoun();
		Verb.setDictionaryVerb();
		Adjective.setDictionaryAdj();
		SentenceStructure.setDictionaryStruc();
		
		Scanner input = new Scanner(System.in);
		System.out.println("Good morning! Welcome to our Nonsense Generator!");
		Analyzator analyze;
		String sentence;
		String answer;
		String generated;
		
		while(true) {
			
			System.out.println("Please, write an input sentence");
			sentence = input.nextLine();
			System.out.println("Which is the verbal tense of your sentence? past/present/future");
			answer = input.nextLine();
			analyze = new Analyzator();
			analyze.analyzeSyntax(sentence, answer);
			
			System.out.println("Do you want the sintactic tree of your sentence?");
			System.out.println("If your answer is yes, please write YES (in capital letters, with enthusiasm), if not,"
					+ " please write anything else");
			answer = input.nextLine();
			if (answer.equals("YES")) analyze.printSyntacticTree();
				
			System.out.println("In which verbal tense do you want your new super special sentence?");
			answer = input.nextLine();
			generated = Generator.generateSentence(answer);
			System.out.println("Here's your new sentence:");
			System.out.println("\t" + generated);
			
			System.out.println("I know you have faith in us... but if you don't, do you want to validate the sentence toxicity?");
			System.out.println("Write YES if positive, anything else if negative");
			if (answer.equals("YES")) {
				System.out.println(Validator.validateSentence(generated));
			}
			
			System.out.println("Thanks for using our Nonsense Generator! Do you want to try again? If positive, write YES");
			answer = input.nextLine();
			if (!answer.equals("YES")) {
				System.out.println("Good bye!");
				break;
			}
			
		}
		
		input.close();

	}

}
