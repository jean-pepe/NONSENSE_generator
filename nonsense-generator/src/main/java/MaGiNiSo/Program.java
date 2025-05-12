package MaGiNiSo;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Good morning! Welcome to our Nonsense Generator!");
		String sentence;
		String answer;
		
		while(true) {
			
			System.out.println("Please, write an input sentence");
			sentence = input.nextLine();
			System.out.println("Which is the verbal tense of your sentence? past/present/future");
			answer = input.nextLine();
			//llamamos a analizar la frase
			
			System.out.println("Do you want the sintactic tree of your sentence?");
			System.out.println("If your answer is yes, please write YES (in capital letters, with enthusiasm), if not,"
					+ " please write anything else");
			answer = input.nextLine();
			if (answer == "YES") //llamamos a la función
				
			System.out.println("In which verbal tense do you want your new super special sentence?");
			answer = input.nextLine();
			//llamamos a generator
			System.out.println("Here's your new sentence:");
			//imprimimos la frase
			
			System.out.println("I know you have faith in us... but if you don't, do you want to validate the sentence toxicity?");
			System.out.println("Write YES if positive, anything else if negative");
			if (answer == "YES") //llamamos a la función
			
			System.out.println("Thanks for using our Nonsense Generator! Do you want to try again? If positive, write YES");
			if (answer != "YES") {
				System.out.println("Good bye!");
				break;
			}
			
		}
		
		input.close();

	}

}
