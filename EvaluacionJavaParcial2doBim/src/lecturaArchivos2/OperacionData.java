/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturaArchivos2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author reroes
 */
public class OperacionData {

    Scanner entrada = new Scanner(System.in);
    ArrayList<Profesor> informacion = new ArrayList<>();

    public void agregarInformacion(ArrayList<Profesor> info) {
        informacion = info;
    }

    public ArrayList<Profesor> obtenerInformacion() {
        return informacion;
    }

    // Método para ordenar por el Canton usando Collections
    public void ordenarPorCanton() {
        ArrayList<Profesor> dataPorCantones = new ArrayList<>();
        dataPorCantones.addAll(informacion);
        Collections.sort(dataPorCantones,
                (o1, o2) -> o1.canton.compareTo(o2.canton));
        for (int i = 0; i < dataPorCantones.size(); i++) {
            System.out.println(dataPorCantones.get(i));
        }
    }

    // Método para ordenar por nombres usando Collections
    public ArrayList<Profesor> ordenarPorNombres() {
        ArrayList<Profesor> dataPorNombres = new ArrayList<>();
        dataPorNombres.addAll(informacion);
        Collections.sort(dataPorNombres,
                (o1, o2) -> o1.nombres.compareTo(o2.nombres));
        return dataPorNombres;
    }

    // Método para contar los participantes que son adeacuados y los q no son convocados
    public void cantidad_por_personalidad() {
        // Definimos 2 contadores, uno para cada caso
        int cont = 0;
        int cont1 = 0;
        // Ciclo for para comparar cada participante con la condicion
        for (int i = 0; i < this.informacion.size(); i++) {
            if (this.informacion.get(i).getPersonalidad().equals("ADECUADO")) {
                cont = cont + 1;
            } else if (this.informacion.get(i).getPersonalidad().equals("POR CONVOCAR")) {
                cont1 = cont1 + 1;
            }
        }
        // Presentación de resultados
        System.out.printf("La cantidad de participantes ADECUADOS es %d\n", cont);
        System.out.printf("La cantidad de participantes POR CONVOCAR es %d\n", cont1);
    }

    // Método apra obtener el número de participantes idoneos y no idoneos
    public void cantidad_por_idoneidad() {
        // Definimos 2 contadores, uno para cada caso
        int cont = 0;
        int cont1 = 0;
        // Ciclo for para comparar cada participante con la condicion
        for (int i = 0; i < this.informacion.size(); i++) {
            if (this.informacion.get(i).getDictamenIdoniedad().equals("IDONEO")) {
                cont = cont + 1;
            } else if (this.informacion.get(i).getDictamenIdoniedad().equals("NO IDONEO")) {
                cont1 = cont1 + 1;
            }
        }
        // Presentación de resultados
        System.out.printf("La cantidad de participantes IDONEO es %d\n", cont);
        System.out.printf("La cantidad de participantes NO IDONEO es %d\n", cont1);
    }

    // Método para leer
    public void lecturaData() {
        for (int i = 0; i < obtenerInformacion().size(); i++) {
            System.out.println(obtenerInformacion().get(i));

        }
    }
}
