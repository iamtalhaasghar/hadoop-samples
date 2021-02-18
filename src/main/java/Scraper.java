
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author programmer
 */
public class Scraper {
    public void downloadWebPage(String url){
        String text = "";
        try {
            Document document = Jsoup.connect(url).get();
            Elements paragraphs = document.getElementsByTag("p");
            
            for (Element paragraph : paragraphs) {
                String tempText = paragraph.text();
                for (char character : tempText.toCharArray()) {
                    if(Character.isAlphabetic(character) || Character.isDigit(character) || Character.isSpaceChar(character)){
                        text += String.valueOf(character);
                    }
                    else{
                        text += " ";
                    }
                    
                }
                text += "\n";             
                
            }
            String temp[] = url.split("/");
            System.out.println(temp[temp.length-1]);
            saveText(temp[temp.length-1] + ".txt", text.toLowerCase());
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    private void saveText(String filename, String text){
        try (FileWriter fout = new FileWriter(filename)) {
            fout.write(text);
        } catch (IOException ex) {
            Logger.getLogger(Scraper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
