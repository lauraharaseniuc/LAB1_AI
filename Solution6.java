package pb6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution6 {
    private int getMajorityNumber(String line) {
        String[] numbers=line.split(",");
        Integer noOfElements= Integer.parseInt(numbers[0]);

        Map<Integer,Integer> numbersMap= new HashMap<>();
        int majorityNumber= Integer.parseInt(numbers[1]);

        int sum=0;
        for (String number: numbers) {
            if (!Objects.equals(number, noOfElements.toString())) {
                if (!numbersMap.containsKey(Integer.parseInt(number))) {
                    numbersMap.put(Integer.parseInt(number),0);
                }
                else {
                    Integer frequency=numbersMap.get(Integer.parseInt(number));
                    numbersMap.replace(Integer.parseInt(number),frequency+1);
                    if (frequency+1>noOfElements/2) {
                        majorityNumber=Integer.parseInt(number);
                    }
                }
            }
        }
        return majorityNumber;
    }
    public void getSolution(String fileName) {
        try (BufferedReader buffer = new BufferedReader(
                new FileReader(fileName))) {
            String line;
            while ((line= buffer.readLine())!=null) {
                System.out.println("The solution for the given data: "+line+" is "+ getMajorityNumber(line));
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
