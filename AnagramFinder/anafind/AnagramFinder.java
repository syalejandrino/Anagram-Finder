package challengeproblem1;

import java.util.Scanner;
import java.util.Arrays;
import java.net.*;

public class AnagramFinder {
	
	private static int count = 0;
	private static String inResult = "none";

	public static void main (String[] args) {
		
		try {
			
			Scanner in = new Scanner(System.in);
			System.out.println("Find the anagram!");
			System.out.print("Please enter a word: ");
			inResult = in.nextLine();
			
			URL link = new URL("https://www.wordgamedictionary.com/enable/download/enable.txt");
			Scanner openLink = new Scanner(link.openStream());
			char[] array = inResult.toCharArray();
			while(openLink.hasNext()) {
				
				String nextLinkWord = openLink.next();
				char[] array2 = nextLinkWord.toCharArray();
				
				if(array.length == array2.length) {
					Arrays.sort(array);
					Arrays.sort(array2);
					for(int i=0; i<array2.length; i++) {
						if(array[i] == array2[i]) {
							count++;
						}
					}
				}
				
				if (count == array2.length) {
					System.out.println(nextLinkWord);
				}
				count = 0;
			} openLink.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		
		System.out.println("Do you want to try another word? Y|N");
		Scanner in2 = new Scanner(System.in);
		char ans = in2.next().charAt(0);
		char ansUpper = Character.toUpperCase(ans);
		
		if(ansUpper == 'Y') {
			main(null);
		}else{
			System.out.println("Thank you for trying the app!");
			System.exit(0);
		}
	}
}
