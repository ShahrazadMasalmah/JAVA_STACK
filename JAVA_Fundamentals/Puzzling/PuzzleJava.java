import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
public class PuzzleJava {
    public ArrayList<Integer> getTenRolls() {
        ArrayList<Integer> myArray = new ArrayList<Integer>();
        Random randMachine = new Random();
        int i = 0;
        while(i < 10){
            int number = randMachine.nextInt(1, 20);
            myArray.add(number);
            i++;
        }
        return myArray;
    }

    public char getRandomLetter() {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        char[] letters = new char[26];
        Random randMachine = new Random();
        for(int i = 0; i < alphabet.length(); i++){
            letters[i] = alphabet.charAt(i);
        }
        int number = randMachine.nextInt(0, 25);
        char letter = letters[number];
        return letter;
    }

    public String generatePassword(){
        String password = "";
        int i=0;
        while(i < 8){
            password += getRandomLetter();
            i++;
        }
        return password;
    }

    public ArrayList<String> getNewPasswordSet(int length) {
        ArrayList<String> myPasswords = new ArrayList<String>();
        int i=0;
        while(i < length){
            myPasswords.add(generatePassword());
            i++;
        }
        return myPasswords;
    }

    public ArrayList<String> shuffleArray(ArrayList<String> words){
         //shuffle the array
        Collections.shuffle(words);
        //Random randMachine = new Random();
        //int k = 0;
        //while (k < 4) {
        //    int i = randMachine.nextInt(0, words.size() - 1);
        //    int j = randMachine.nextInt(0, words.size() - 1);
        //    String temp1 = words.get(i);
        //    String temp2 = words.get(j);
        //    words.set(i,temp2);
        //    words.set(j, temp1);
        //    k++;
        //}
        return words;
    }
}
