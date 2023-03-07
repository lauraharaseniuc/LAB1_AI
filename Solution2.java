package pb2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Solution2 {
    private Double getEuclidianDistance(String line) {
        String[] elements=line.split(" ");
        String[] points1=elements[0].split(",");
        Double point1= Double.parseDouble((String) points1[0].subSequence(1,points1[0].length()));
        Double point2= Double.parseDouble((String) points1[1].subSequence(0,points1[0].length()-1));

        String[] points2=elements[1].split(",");
        Double point3= Double.parseDouble((String) points2[0].subSequence(1,points2[0].length()));
        Double point4= Double.parseDouble((String) points2[1].subSequence(0,points2[0].length()-1));
        return Math.sqrt(Math.pow(point1-point3,2)+Math.pow(point2-point4,2));
    }
    public void getSolution(String fileName) {
        try (BufferedReader buffer = new BufferedReader(
                new FileReader(fileName))) {
            String line;
            while ((line= buffer.readLine())!=null) {
                System.out.println("Distance between "+line+": "+getEuclidianDistance(line));
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
