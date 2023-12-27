import java.util.ArrayList;
//import java.util.Random;
public class TestPuzzleJava {
    
	public static void main(String[] args) {
		PuzzleJava generator = new PuzzleJava();
		ArrayList<Integer> randomRolls = generator.getTenRolls();
		System.out.println(randomRolls);

        //..
		// Write your other test cases here.
		//..

        char letter = generator.getRandomLetter();
		System.out.println("The random letter is: " + letter);

        String password = generator.generatePassword();
        System.out.println("The Password is: " + password);

        ArrayList<String> passwords = generator.getNewPasswordSet(5);
        System.out.println(passwords);

        ArrayList<String> words = generator.shuffleArray(passwords);
        System.out.println(words);
	}
}
