package pb3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Solution3 {
    private Double getScalarDistance(String line) {
        String[] vectors=line.split(" ");
        String[] vector1Elements=vectors[0].split(",");
        String[] vector2Elements=vectors[1].split(",");
        List<Double> vector1ElementsAsNumbers= new ArrayList<>();
        List<Double> vector2ElementsAsNumbers= new ArrayList<>();
        if (vector1Elements.length>1) {
            vector1ElementsAsNumbers.add(Double.valueOf(vector1Elements[0].substring(1)));
            int index=1;
            while (index<vector1Elements.length-1) {
                vector1ElementsAsNumbers.add(Double.valueOf(vector1Elements[index].substring(0)));
                index++;
            }
            vector1ElementsAsNumbers.add(Double.valueOf(vector1Elements[vector1Elements.length-1].substring(0,vector1Elements[vector1Elements.length-1].length()-1)));
        }
        else if (vector1Elements.length==1){
            vector1ElementsAsNumbers.add(Double.valueOf(vector1Elements[0].substring(1, vector1Elements[0].length()-1)));
        }
        if (vector2Elements.length>1) {
            vector2ElementsAsNumbers.add(Double.valueOf(vector2Elements[0].substring(1)));
            int index=1;
            while (index<vector2Elements.length-1) {
                vector2ElementsAsNumbers.add(Double.valueOf(vector2Elements[index].substring(0)));
                index++;
            }
            vector2ElementsAsNumbers.add(Double.valueOf(vector2Elements[vector2Elements.length-1].substring(0,vector2Elements[vector2Elements.length-1].length()-1)));
        }
        else if (vector2Elements.length==1){
            vector2ElementsAsNumbers.add(Double.valueOf(vector2Elements[0].substring(1, vector2Elements[0].length()-1)));
        }

        double scalarDistance= 0;
        int index=0;
        for (Double number: vector1ElementsAsNumbers) {
            if (index<vector2ElementsAsNumbers.size() && vector2ElementsAsNumbers.get(index) !=0 && number!=0) {
                scalarDistance+=number*vector2ElementsAsNumbers.get(index);
            }
            index++;
        }
        return scalarDistance;
    }
    public void getSolution(String fileName) {
        try (BufferedReader buffer = new BufferedReader(
                new FileReader(fileName))) {
            String line;
            while ((line= buffer.readLine())!=null) {
                System.out.println("Distance between "+line+": "+getScalarDistance(line));
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
