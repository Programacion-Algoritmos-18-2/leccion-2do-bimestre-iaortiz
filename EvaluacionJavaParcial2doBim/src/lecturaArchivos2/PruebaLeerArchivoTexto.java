package lecturaArchivos2;

// Fig. 14.12: PruebaLeerArchivoTexto.java
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PruebaLeerArchivoTexto {

    public static void main(String args[]) throws IOException {
        LeerArchivoTexto aplicacion = new LeerArchivoTexto();
        OperacionData operacion = new OperacionData();
        CrearArchivo ca = new CrearArchivo();
        // Abrimos el archivo y leemos los registros de cada uno
        aplicacion.abrirArchivo("data/data1.csv");
        ArrayList<Profesor> lista_csv = aplicacion.leer_registros_csv();
        aplicacion.abrirArchivo("data/data2.txt");
        ArrayList<Profesor> lista_txt = aplicacion.leer_registros_txt();
        // Creamos una nueva lista
        ArrayList<Profesor> lista_participantes = new ArrayList<>();
        // Agregamos cada objeto la lista_csv y lista_txt a la lista_participantes
        for (int i = 0; i < lista_csv.size(); i++) {
            lista_participantes.add(lista_csv.get(i));
        }
        for (int i = 0; i < lista_txt.size(); i++) {
            lista_participantes.add(lista_txt.get(i));
        }
        operacion.agregarInformacion(lista_participantes);

        operacion.ordenarPorCanton();
        System.out.println("***************************************");
        operacion.cantidad_por_idoneidad();
        operacion.cantidad_por_personalidad();

        ArrayList<Profesor> lista_ordenada = operacion.ordenarPorNombres();
        ca.escribirArchivo(lista_ordenada);

        aplicacion.cerrarArchivo();
    }
}
