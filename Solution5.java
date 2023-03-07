package pb5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Solution5 {
    private int getRepeatedNumber(String line) {
        String[] numbers=line.split(" ");
        int noOfElements= Integer.parseInt(numbers[0]);

        int sum=0;
        for (String number: numbers) {
            sum+=Integer.parseInt(number);
        }
        int repeatedNumber=sum-noOfElements*(noOfElements+1)/2;
        return repeatedNumber;
    }
    public void getSolution(String fileName) {
        try (BufferedReader buffer = new BufferedReader(
                new FileReader(fileName))) {
            String line;
            while ((line= buffer.readLine())!=null) {
                System.out.println("The solution for the given data: "+line+" is "+getRepeatedNumber(line));
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
