package BreadthFirstSearch.web.crawler;

public class App {

    public static void main(String[] args) {

        WebCrawler crawler = new WebCrawler();
        String rootUrl = "https://stackoverflow.com/";

        crawler.discoverWeb(rootUrl);
        
        
    }
}
