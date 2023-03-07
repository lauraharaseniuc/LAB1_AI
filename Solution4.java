package pb4;

import pb1.Solution1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution4 {
    private Map<String,String> getWordsThatAppearOnlyOnce(String line) {
        String[] words=line.split(" ");
        List<String> wordsThatAppearOnlyOnce= new ArrayList<>();
        Map<String,String> wordsMap= new HashMap<>();
        for (String word: words) {
            if (! wordsMap.containsKey(word)) {
                wordsMap.put(word,word);
                wordsThatAppearOnlyOnce.add(word);
            }
            else {
                wordsMap.remove(word);
            }
        }
        return wordsMap;
    }
    public void getSolution(String fileName) {
        try (BufferedReader buffer = new BufferedReader(
                new FileReader(fileName))) {
            String line;
            while ((line= buffer.readLine())!=null) {
                System.out.println("The words that appear only once in: "+line+" are: ");
            this.getWordsThatAppearOnlyOnce(line).forEach((key,value)->{
                System.out.println(value+" ");
            });
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
