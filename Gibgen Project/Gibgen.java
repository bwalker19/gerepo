import java.util.*;
import java.io.*;

/*
 * Author: Brandon Walker
 * Coding Challenge for GE
 * 
 * Program that reads in a line of text and scrambles the words.
 */
public class Gibgen{
  //Runs the program
  public static void main(String args[]){
    Gibgen g = new Gibgen();
    Scanner input = new Scanner(System.in);
    String text = "";
    System.out.println("Enter text to scramble: ");
    boolean done = false;   
    while (!done) {
      text = input.nextLine();

     if (text.equals("")) {
        done = true;
     } 
     else {
        g.performScramble(text);
     }
    }
  }
  public Gibgen() {
  }          
  //Scrambles a word while keeping the first and
  //last letters the same(also keeps numbers 
  //and punctuations where they are).
  private static String scramble(String txt) {
    StringTokenizer st = new StringTokenizer(txt, " ,.!?()-+/*=%@#$&:;\"'", true);
    String[] tokens = new String[st.countTokens()];
    String scrambled = "";
    int letter = 0;
    int wordlength = 0;
    char[] temp;
    while(st.hasMoreTokens()) {
        tokens[letter] = st.nextToken();
        letter++;
    }
    for(int i = 0; i < tokens.length; i++) {
        if(tokens[i].length() <= 3) {
            scrambled += tokens[i];
            continue;
        }   
        wordlength = tokens[i].length() - 1;
        temp = new char[wordlength + 1];
        temp[0] = tokens[i].charAt(0);
        temp[wordlength] = tokens[i].charAt(wordlength);
        ArrayList<Character> c = new ArrayList<Character>();
        for(int j = 1; j < wordlength; j++) {
          c.add(tokens[i].charAt(j));
        }
        Collections.shuffle(c);
        String z = new String();
        for(Character x:c){
          z += x.toString();
        }
        String output = new String(temp[0] + z + temp[wordlength]);
        scrambled += output;
    }
    return scrambled;
}
  //Method to perform the "scrambling" on each of the words
  //@ensure:      will return the scrambled words
  void performScramble(String line) {
    String[] words = line.split("\\s+");
    for (String word: words) {
        System.out.println(scramble(word));
    }    
}
}