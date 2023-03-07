package pb1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Solution1 {

    private String getTheLastWord (String sentence) {
        String[] words=sentence.split(" ");
        String lastWord=words[0];
        for (String word : words) {
            if (word.compareTo(lastWord)>0) {
                lastWord=word;
            }
        }
        return lastWord;
    }
    public void getSolution(String file_path) {
        try (BufferedReader buffer = new BufferedReader(
                new FileReader(file_path))) {
            String line;
            while ((line= buffer.readLine())!=null) {
                System.out.println(line+" solution: "+getTheLastWord(line));
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
