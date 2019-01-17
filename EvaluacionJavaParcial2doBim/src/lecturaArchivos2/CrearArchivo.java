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
import java.util.Formatter;

/**
 *
 * @author isral
 */
public class CrearArchivo {

    FileWriter fichero = null;
    PrintWriter pw = null;

    public void escribirArchivo(ArrayList<Profesor> lista) throws IOException {
        String ruta = "data/Lista.txt";
        File archivo = new File(ruta);
        if (!archivo.exists()) {
            archivo.createNewFile();
        }
        BufferedWriter bw = null;
        String cadena = "";
        try {

            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write("El fichero ya esta creado");

            bw = new BufferedWriter(new FileWriter(archivo));
            for (int i = 0; i < lista.size(); i++) {
                Profesor prof = lista.get(i);
                cadena = String.format("%s|%s|%s|%s|%s|%s|%s|%s\n",
                        prof.getCedula(), prof.getNombres(), prof.getZona(), prof.getProvincia(), prof.getCanton(),
                        prof.getPersonalidad(), prof.getRazonamiento(), prof.getDictamenIdoniedad());
                bw.write(cadena);
            }

            bw.close();
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

}
