import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class Parse2 {
    public static void main(String[] args) throws IOException {
        String url = "http://facultad.pucp.edu.pe/ingenieria/plan-de-estudios-de-carreras/?carrera=ingenieria-informatica";
        Document doc = Jsoup.connect(url).get();
        Elements niveles = doc.getElementsByClass("tabla-estu-wrapper");
        ArrayList<Curso> cursos = new ArrayList<Curso>();
        for(Element nivel : niveles){
            for(Element referencia : nivel.getElementsByClass("tabla-estu-modu")) {
                String urlCurso  = referencia.attr("data-target");
                String nombreCurso = referencia.getElementsByClass("tabla-estu-modu-content").first().text();
                if(!esElectivo(nombreCurso)){
                    Curso curso = obtenerCurso(urlCurso);
                    cursos.add(curso);
                }
            }
        }

        for(Curso c : cursos){
            c.printCurso();
        }
    }

    private static Curso obtenerCurso(String url) throws IOException {
        Curso curso = new Curso();
        String contenedorStr = "cuerpo";
        Document doc = Jsoup.connect(url).get();
        Element contenedor = doc.getElementsByClass(contenedorStr).first();

        String nombre = contenedor.getElementsByTag("h1").get(0).text();
        curso.setNombre(nombre);

        Element ul = contenedor.getElementsByClass("inter-intern").first();
        curso.setCreditos(ul.child(0).child(0).text());
        curso.setCodigo(ul.child(0).child(1).text());

        Element tr = contenedor.getElementsByTag("tr").get(1);
        curso.setCarrera(tr.child(0).text());
        curso.setNivel(tr.child(1).text());
        curso.setTipo(tr.child(2).text());
        curso.setRequisitos(tr.child(3).text());
        return curso;
    }

    private static boolean esElectivo(String nombre){
        return nombre.contains("electivo");
    }


}
