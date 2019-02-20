package waroftheworlds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Main {

    private final static FileInput indata = new FileInput("the_book.csv");
    private final static Map<String, Integer> map = new HashMap<String, Integer>();
   
    
    
    public static void main(String[] args) {
        new Main();
    }
    
    public Main() {
        String line;
        String[] words;
        
        ArrayList<Entry<String, Integer>> uniqueList = new ArrayList<Entry<String, Integer>>();
        

        while ((line = indata.fileReadLine()) != null) {
            // Remove anything that's not a letter or space
            line = line.replaceAll("[^a-zA-Z ]","")
                    .toLowerCase().trim();
           
            // Don't process lines with no characters
            if (line.isEmpty()) {
                continue;
            }
            
            // Split string over one or more spaces
            words = line.split(" +");
            
            // Look for each word in the map
            for (String word : words) {
                // This word isn't yet a key, init count to 1
                if (!map.containsKey(word)) {
                    map.put(word, 1);
                }
                else {
                    // Increment count using word as key
                    map.put(word, map.get(word) + 1);
                }

            }

           

            
            
//             Loop over entries in the map, getting each key/value pair
//            for (Map.Entry<String, Integer> entry : map.entrySet()) {
//                 //System.out.println(entry.getKey() + " " + entry.getValue());
//            }
            
            
            
        }
        
        //gets stream of data from hashmap and sequentially compares each entry based on value. Then extracts the top ten values and outputs them to console.
        System.out.println("----Top Ten Words---");
        map.entrySet().stream().sorted((x,y)-> y.getValue().compareTo(x.getValue())).limit(10).distinct().forEach(x -> System.out.println(x.getKey() + " " + x.getValue()));
        
        //outputs list of unique words
        System.out.println("----Unique Words----");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
                 
//                 checks if word is unique and adds it to list of unique values.
                 if(entry.getValue() == 1)
                 {                     
                     uniqueList.add(entry);
                 }
             }
        System.out.println("Number of unique words: " + uniqueList.size());
        
        
        
    }
    
}