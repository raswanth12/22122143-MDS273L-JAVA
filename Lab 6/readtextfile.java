    import java.io.BufferedReader;
    import java.io.FileReader;
    import java.io.IOException;
    import java.util.HashMap;


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
        System.out.println(digits);
    }
    }

    