public class Data {
    public final String CLASS_TABLA_GENERAL = "tablas-planestudios2";
    public final String CLASS_NIVEL         = "tabla-estu-wrapper";
    public final String CLASS_NIVEL_NOMBRE  = "titulo-tabla";
    public final String CLASS_CURSO         = "tabla-estu-modu";
    public final String ATRIB_CURSO_LINK    = "data-target";
    public final String CLASS_CURSO_NOMBRE  = "tabla-estu-modu-content";

/*
DE ESTE OBTENEMOS EL LINK, NO LO TOMAMOS SI ES UN ELECTIVO, SE PENSARA LUEGO EN ESOS CURSOS LIBRES
--TABLA--
<div class="CLASS_TABLA_GENERAL">
    --NIVEL--
    <div class="CLASS_NIVEL">
        <div class="CLASS_NIVEL_NOMBRE">Nivel 5</div>
        <div ATRIB_CURSO_LINK="www" class="CLASS_CURSO">
            <div class="CLASS_CURSO_NOMBRE">Estructura de datos y programación metódica
                <div class="planestu-sub">(4.50 Cr�ditos)</div>
            </div>
        </div>
    </div>
    --NIVEL--
</div>
--TABLA--
*/

    public final String CLASS_TABLA_CURSO_X             = "cuerpo";             // TOMAR EL PRIMER H1
    public final String CLASS_TABLA_CURSO_X_CONTENIDO   = "doc-intern-content"; // buscar desde aqui los datos del curso: ul y tbody
    public final String CLASS_DATOS_CURSO_X             = "inter-intern";       // TOMAR LOS HIJOS DE UL (LI), DATOS OBTENIDOS: CREDITOS Y CODIGO
    public final String TAG_TABLA_CURSO_X_CONTENIDO     = "tbody";              // BUSCAR DESDE EL PRIMER CHILD A LA FILA CORRECTA DE LA CARRERA

    public final String TAG_FILA_CURSO_X_CONTENIDO      = "tr";                 // BUSCAR DESDE AQUI EN FORMA ITERATIVA LA CARRERA DENTRO DE LOS td // en el primer td debe estar el nombre, sino, pasar
    // CARRERA NIVEL TIPO REQUISITO
}
