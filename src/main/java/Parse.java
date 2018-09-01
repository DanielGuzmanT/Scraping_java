import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Parse {

    public static final String url = "https://jarroba.com";

    public static void main( String[] args ){
        //Comprobar si devuelve 200 al hacer la peticion
        if(Tools.getStatusConnectionCode(url)==200){
            //extraemos el HTML de la web en un objeto Document
            Document document = Tools.getHtmlDocument(url);

            //Buscamos todas las entradas que estan dentro de:
            Elements entradas = document.select("div.col-md-4.col1-xs-12")
                    .not("div.com-md-offset-2.col-md-4.col-xs-12");
            System.out.println("Numero de entradas en la pagina inicial de Jarroba: " + entradas.size() + "\n");

            //Parseo cada una de las entradas
            for (Element elem : entradas) {
                String titulo = elem.getElementsByClass("tituloPost").text();
                String autor  = elem.getElementsByClass("autor").toString();
                String fecha  = elem.getElementsByClass("fecha").text();

                System.out.println(titulo+"\n"+autor+"\n"+fecha+"\n\n");

                //con el metodo text() obtengo el contenido que hay dentro de las etiquetas html
                //con el metodo toString() obtengo el HTML con etiquetas incluidas
            }
        } else{
            System.out.println("El Status Code no es OK\n");
        }
    }
}
