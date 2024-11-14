import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.lang.*;
import java.util.*;

// distância: sqrt((x1 - x2)**2 + (y1 -y2)**2) 

public class Vovo{
    public static void main(String[] args) {
        Prim  graph = new Prim(2009);

        Path filePath = new File("data.txt").toPath();
        Charset charset = Charset.defaultCharset();        
		List<String> stringList = new ArrayList<>();
	    try {
		    stringList = Files.readAllLines(filePath, charset);
	    } catch (IOException e) {
		    e.printStackTrace();
	    }
        String[] cidades = stringList.toArray(new String[]{});
        Double[] lat = new Double[cidades.length]; // Double[] lat
        Double[] lon = new Double[cidades.length]; // Double[] long

        for(int i = 0; i< cidades.length; i++){
            String[] temp = cidades[i].split(" ");
            lat[i] = Double.parseDouble(temp[1]);
            lon[i] = Double.parseDouble(temp[2]);
        }

        for(int i = 0; i< cidades.length; i++){
            System.out.println(cidades[i]);
        }
    }

    public static double calculaDist(double lat1, double lat2, double lon1, double long2){
        double dist = 0;        
        
        dist = Math.sqrt(Math.pow((lat1 - lat2), 2) + Math.pow((lon1 - long2), 2));
        
        return dist;
    }
    
    public static double Fitness(double lat[], double lon[], ArrayList<String> cidades){
        Double distTotal = 0.0;
        for(int i = 0; i < cidades.size(); i++){
           if(i == cidades.size() - 1){
               distTotal += calculaDist(lat[i], lat[0], lon[i], lon[0]);
           }
           else{
               distTotal += calculaDist(lat[i], lat[i + 1], lon[i], lon[i + 1]);
           }
           
        }
        return distTotal;
    }
    
    

    public static ArrayList<String> geneticAlgorithm(ArrayList<String> cidades){
        ArrayList<String> roteiro = new ArrayList<>();
        
        return roteiro;
    }

    

}