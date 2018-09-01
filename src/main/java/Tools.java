import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Tools {

    public static int getStatusConnectionCode(String url){
        Connection.Response response = null;
        try {
            response = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(100000).ignoreHttpErrors(true).execute();
        } catch (Exception e) {
            System.out.println("Excepcion al obtener el Status Code: " + e.getMessage());
        }
        return response.statusCode();
    }

    public static Document getHtmlDocument(String url){
        Document doc = null;
        try {
            doc = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(100000).get();
        } catch (Exception e) {
            System.out.println("Excepcion al obtener el HTML de la pagina\n" + e.getMessage());
        }
        return doc;
    }
}
