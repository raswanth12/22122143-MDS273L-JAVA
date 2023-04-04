import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


    public class readtextfile {

            public static void main(String[] args) {
            
        String fileName = "text.txt";
        String line = null;
        HashMap<Character, Integer> vowels = new HashMap<>();
        HashMap<Character, Integer> digits = new HashMap<>();

        vowels.put('a', 0);
        vowels.put('e', 0);
        vowels.put('i', 0);
        vowels.put('o', 0);
        vowels.put('u', 0);

        digits.put('0', 0);
        digits.put('1', 0);
        digits.put('2', 0);
        digits.put('3', 0);
        digits.put('4', 0);
        digits.put('5', 0);
        digits.put('6', 0);
        digits.put('7', 0);
        digits.put('8', 0);
        digits.put('9', 0);

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                for(int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if(Character.isDigit(c)) {
                    digits.put(c, digits.get(c) + 1);
                } else if(Character.isAlphabetic(c)) {
                    c = Character.toLowerCase(c);
                    if(vowels.containsKey(c)) {
                        vowels.put(c, vowels.get(c) + 1);
                    }
                }
                }
            }

            bufferedReader.close();
        } catch(IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");
        }

        System.out.println("Vowels and their count:");
        System.out.println(vowels);
        System.out.println("Digits and their count:");
        System.out.println(digits);}
      // Change the file path to the location of your text file
        String filePath = "text.txt";

        Map<String, Integer> wordCounts = new HashMap<>();
        Map<Character, Integer> charCounts = new HashMap<>();{

        

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
        }BufferedReader br;
        String line;
        while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    wordCounts.merge(word, 1, Integer::sum);
                    for (char c : word.toCharArray()) {
                        charCounts.merge(c, 1, Integer::sum);
                    }
                }
            }
        }

        List<Map.Entry<String, Integer>> wordList = new ArrayList<>(wordCounts.entrySet());
        wordList.sort(Map.Entry.<String, Integer>comparingByValue().reversed());
        List<Map.Entry<Character, Integer>> charList = new ArrayList<>(charCounts.entrySet());
        charList.sort(Map.Entry.<Character, Integer>comparingByValue().reversed());

        System.out.println("Top five repeated words and their count:");
        for (int i = 0; i < 5 && i < wordList.size(); i++) {
            System.out.println(wordList.get(i).getKey() + ": " + wordList.get(i).getValue());
        }
        System.out.println("Least five repeated words and their count:");
        for (int i = wordList.size() - 1; i >= wordList.size() - 5 && i >= 0; i--) {
            System.out.println(wordList.get(i).getKey() + ": " + wordList.get(i).getValue());
        }

        System.out.println("Top five repeated characters and their count:");
        for (int i = 0; i < 5 && i < charList.size(); i++) {
            System.out.println(charList.get(i).getKey() + ": " + charList.get(i).getValue());
        }
        System.out.println("Least five repeated characters and their count:");
        for (int i = charList.size() - 1; i >= charList.size() - 5 && i >= 0; i--) {
            System.out.println(charList.get(i).getKey() + ": " + charList.get(i).getValue());
        }
    }


    

    