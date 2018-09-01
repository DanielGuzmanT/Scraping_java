import com.google.gson.Gson;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;

public class Scrapping {
    private static Data d = new Data();
    private static String nombre_carrera = "Ingeniería Informática";

    public static void main(String[] args) throws IOException {
        String url = "http://facultad.pucp.edu.pe/ingenieria/plan-de-estudios-de-carreras/?carrera=ingenieria-informatica";
        Document doc = Jsoup.connect(url).get();
        Element elem_tabla = doc.getElementsByClass(d.CLASS_TABLA_GENERAL).first();
        ArrayList<Curso> cursos = new ArrayList<Curso>();

        /* PARA CADA NIVEL */
        for(Element elem_nivel : elem_tabla.getElementsByClass(d.CLASS_NIVEL)){
            /* OBTENER CURSOS POR NIVEL*/
            for(Element elem_curso : elem_nivel.getElementsByClass(d.CLASS_CURSO)){
                /* EVITAMOS LOS CURSOS ELECTIVOS, PUES NO POSEE FORMATO COMUN A LOS CURSOS OBLIGATORIOS*/
                if(esElectivo(elem_curso)) continue;

                Curso curso = obtenerCurso(elem_curso.attr(d.ATRIB_CURSO_LINK));
                cursos.add(curso);
            }
        }

        Gson convert = new Gson();
        for(Curso c : cursos){
            System.out.println(convert.toJson(c));
        }
    }

    /* ARMAMOS UN CURSO CON LOS DATOS OBTENIDOS POR SCRAPPING A LA PAG WEB SEGUN LA URL PASADA */
    private static Curso obtenerCurso(String url) throws IOException {
        // creacion del curso a devolver
        Curso curso = new Curso();

        // definimos zona de html a moverse
        Document doc = Jsoup.connect(url).get();
        Element elem_cuerpo = doc.getElementsByClass(d.CLASS_TABLA_CURSO_X).first();

        // obtenemos el nombre del curso
        curso.setNombre(elem_cuerpo.getElementsByTag("h1").first().text());

        Element elem_ul = elem_cuerpo.getElementsByClass(d.CLASS_DATOS_CURSO_X).first();
        curso.setCreditos   (elem_ul.child(0).text());
        curso.setCodigo     (elem_ul.child(1).text());

        /* OBTENEMOS LOS DATOS DENTRO DE LA TABLA DE CARRERAS QUE COMPARTEN EL MISMO CURSO */
        Element elem_tbody = elem_cuerpo.getElementsByTag(d.TAG_TABLA_CURSO_X_CONTENIDO).first();
        for(Element elem_tr : elem_tbody.getElementsByTag(d.TAG_FILA_CURSO_X_CONTENIDO)){
            if(elem_tr.child(0).text().contains(nombre_carrera)){
                curso.setCarrera    (elem_tr.child(0).text());
                curso.setNivel      (elem_tr.child(1).text());
                curso.setTipo       (elem_tr.child(2).text());
                curso.setRequisitos (elem_tr.child(3).text());
            }
        }
        return curso;
    }

    /* BUSCAMOS EL NOMBRE DEL CURSO Y, SI POSEE "ELECTIVO" EN SU NOMBRE, SE EVITA PROCESARLO */
    private static boolean esElectivo(Element elem_curso){
        String nombre_elem_curso = elem_curso.child(0).text();
        System.out.println(nombre_elem_curso);
        return nombre_elem_curso.contains("electivo") || nombre_elem_curso.contains("Idioma");
    }
}
