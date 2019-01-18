/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturaArchivos2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author isral
 */
public class CrearArchivo {
    // Atributos para el archivo
    FileWriter fichero = null;
    PrintWriter pw = null;
    // Mètodo para escribir el archivo que recibe una lista
    public void escribirArchivo(ArrayList<Profesor> lista) throws IOException {
        // String que sera el nombre del archivo
        String ruta = "data/Lista.txt";
        // Creamos un objeto de tupo file
        File archivo = new File(ruta);
        // Creamos el archivp
        if (!archivo.exists()) {
            archivo.createNewFile();
        }
        BufferedWriter bw = null;
        String cadena = "";
        // Try para empezar a escribir
        try {
            // Escribimos en el archivo
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write("El fichero ya esta creado");
            bw = new BufferedWriter(new FileWriter(archivo));
            // For para recorrer la lista que ingresamos y guardar los datos ahi
            for (int i = 0; i < lista.size(); i++) {
                Profesor prof = lista.get(i);
                cadena = String.format("%s|%s|%s|%s|%s|%s|%s|%s\n",
                        prof.getCedula(), prof.getNombres(), prof.getZona(), prof.getProvincia(), prof.getCanton(),
                        prof.getPersonalidad(), prof.getRazonamiento(), prof.getDictamenIdoniedad());
                // Ingresamos la cadena en el archivo
                bw.write(cadena);
            }
            // Cerramos el archivo
            bw.close();
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

}
