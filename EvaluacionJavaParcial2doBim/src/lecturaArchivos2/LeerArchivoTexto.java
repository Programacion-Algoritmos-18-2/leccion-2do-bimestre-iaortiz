package lecturaArchivos2;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.IllegalStateException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import com.google.gson.Gson;

public class LeerArchivoTexto {
    // Objeto de tipo Scanner
    private Scanner entrada;
    // Métoddo para abrir un archivo que recibe como parametro una dirección
    public void abrirArchivo(String direccion) {
        try {
            entrada = new Scanner(new File(direccion));
        } 
        catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Error al abrir el archivo.");
            System.exit(1);
        } 
    } 
    // Método para leer los archivos de tipo txt
    public ArrayList<Profesor> leer_registros_txt() {
        ArrayList<Profesor> lista = new ArrayList<>();
        try 
        {
            entrada.nextLine();
            while (entrada.hasNext()) {
                // se crea el objeto para leer Json
                Gson g = new Gson();
                String linea = entrada.nextLine();
                // se hace el proceso de transformación
                Profesor p = g.fromJson(linea, Profesor.class);
                lista.add(p);
            } 
        }
        // Catch's para ver los errores en la ejecuciión
        catch (NoSuchElementException elementException) {
            System.err.println("El archivo no esta bien formado.");
            entrada.close();
            System.exit(1);
        } 
        catch (IllegalStateException stateException) {
            System.err.println("Error al leer del archivo.");
            System.exit(1);
        } 
        return lista;
    } 
    // Método para leer los archivos de tipo csv
   public ArrayList<Profesor> leer_registros_csv() {
       // Creación de una lista para almacenar los datos
        ArrayList<Profesor> lista = new ArrayList<>();
        // lee registros del archivo, usando el objeto Scanner
        try{
            String linea = entrada.nextLine();
            while (entrada.hasNext()) {
                linea = entrada.nextLine();
                // Hacemos un split al ArrayList
                ArrayList<String> lineas = new ArrayList<String>(Arrays.asList(linea.split(",")));
                Profesor prof = new Profesor();        
                prof.setCedula(lineas.get(0));   
                prof.setNombres(lineas.get(1));
                prof.setZona(lineas.get(2));
                prof.setProvincia(lineas.get(3));
                prof.setCanton(lineas.get(4));
                prof.setPersonalidad(lineas.get(5));
                prof.setRazonamiento(lineas.get(6));
                prof.setDictamenIdoniedad(lineas.get(7));
                // Agregamos cada objeto en el ArrayList
                lista.add(prof);
            } 
        }
        //Catchs para ver los errores en la ejecución
        catch (NoSuchElementException elementException) {           
            System.err.println("El archivo no esta bien formado.");
            entrada.close();
            System.exit(1);
        } 
        catch (IllegalStateException stateException) {
            System.err.println("Error al leer del archivo.");
            System.exit(1);
        } 
        return lista;                               
    } 

    // Método para cerrar el archivo
    public void cerrarArchivo() {
        if (entrada != null) {
            entrada.close(); 
        }
    } 
} 


