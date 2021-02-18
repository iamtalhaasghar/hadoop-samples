
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author talhaasghar
 */
public class Screen extends Application{

    
    public static void main(String[] args) {
        launch(args);
    }
    
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        GridPane pane = new GridPane();
        
        TextField urlInput = new TextField();
        Button okButton = new Button("Submit");
        
        pane.setAlignment(Pos.CENTER);
        
        pane.setHgap(30);
        pane.setVgap(20);
        
        pane.addRow(0, urlInput);
        pane.addRow(2, okButton);
        
        Scene scene = new Scene(pane, 600, 600);
        
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
        okButton.setOnAction(value->{
            
            String url = urlInput.getText();
            WebPageDownloader downloader = new WebPageDownloader(url);
            downloader.run();
                    
        });
    }
    
    public class WebPageDownloader extends Task<String>{
        private String url;
        public WebPageDownloader(String url){
            this.url = url;
        }
        @Override 
        protected String call() throws Exception {
            Scraper scraper = new Scraper();
            scraper.downloadWebPage(url);
            return null;
        }
    }
}


