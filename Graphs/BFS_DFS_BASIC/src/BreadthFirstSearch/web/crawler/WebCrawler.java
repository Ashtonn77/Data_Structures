package BreadthFirstSearch.web.crawler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCrawler {
    
    private Queue<String> queue;
    private List<String> discoveredWebsiteList;

    public WebCrawler() {
        this.queue = new LinkedList<>();
        this.discoveredWebsiteList = new ArrayList<>();
    }
    
    public void discoverWeb(String root){
        
        this.queue.add(root);
        this.discoveredWebsiteList.add(root);

        while(!queue.isEmpty()){
            
            String currentUrl = this.queue.remove();
            String rawHtml = readUrl(currentUrl);

            String regExp = "href=[\\'\"]?([^\\'\" >]+)";
            Pattern pattern = Pattern.compile(regExp);
            Matcher matcher = pattern.matcher(rawHtml);
                                 
            while(matcher.find()){
                
                String childUrl = matcher.group();

//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }

                if(!discoveredWebsiteList.contains(childUrl)){
                    discoveredWebsiteList.add(childUrl);
                    System.out.println("Website found -> URL: " + childUrl);
                    queue.add(childUrl);
                }
                
            }
            
        }
        
    }

    private String readUrl(String current) {
        
        StringBuilder rawHtml = new StringBuilder();

        try {
            
            URL url = new URL(current);
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            
            String inputLine = "";            
            while((inputLine = in.readLine()) != null){
                
                rawHtml.append(inputLine);
            }
            
            in.close();
            
        } catch (Exception e) {
            System.out.println("error trying to get link -> error: " + e.getClass().getSimpleName());
        }
    
        return rawHtml.toString();
    }

}
