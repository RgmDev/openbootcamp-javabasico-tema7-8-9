package org.example;

import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {

        // Funcion Reverse
        System.out.println("FUNCION REVERSE");
        System.out.println(reverse("hola mundo"));

        // Punto 1
        System.out.println("\nPUNTO 1");
        String[] arrString = new String[]{"Perro", "Gato", "Pez", "Pajaro"};
        for(int i = 0; i < arrString.length; i++) {
            System.out.println(arrString[i]);
        }

        // Punto 2
        System.out.println("\nPUNTO 2");
        int[][] arrEnteros = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        for(int i = 0; i < arrEnteros.length; i++) {
            for(int j = 0; j < arrEnteros[i].length; j++) {
                System.out.println("El numero "+arrEnteros[i][j]+" está en la posición i="+i+" j="+j);
            }
        }

        // Punto 3
        System.out.println("\nPUNTO 3");
        Vector<String> vector = new Vector<String>();
        vector.addElement("Perro");
        vector.addElement("Gato");
        vector.addElement("Pez");
        vector.addElement("Serpiente");
        vector.addElement("Mono");
        vector.remove(2);
        vector.remove(1);
        System.out.println("EL vector contiene: "+vector);

        // Punto 4
        System.out.println("\nPUNTO 4");
        System.out.println("No hay problema, el vector agregará los 1000 elemntos");

        // Punto 5
        System.out.println("\nPUNTO 5");
        ArrayList<String> myArrList = new ArrayList<String>();
        myArrList.add("Perro");
        myArrList.add("Gato");
        myArrList.add("Pez");
        myArrList.add("Pájaro");
        LinkedList<String> myLinkList = new LinkedList<String>();
        for(String elem : myArrList) {
            System.out.println(elem);
            myLinkList.add(elem);
        }
        for(String elem : myLinkList) {
            System.out.println(elem);
        }

        // Punto 6
        System.out.println("\nPUNTO 6");
        ArrayList<Integer> myIntArrList = new ArrayList<Integer>();
        for(int i = 1; i <= 10; i++) {
            myIntArrList.add(i);
        }
        for (int i = myIntArrList.size() - 1; i >= 0; i--) {
            if(myIntArrList.get(i) % 2 == 0) {
                myIntArrList.remove(i);
            }
        }
        System.out.println(myIntArrList);

        // Punto 7
        System.out.println("\nPUNTO 7");
        try {
            dividePorCero();
        } catch (ArithmeticException e) {
            System.out.println("Esto no puede hacerse");
        } finally {
            System.out.println("Demo de código");
        }

        // Punto 8
        System.out.println("\nPUNTO 8");
        copiarFichero("archivoParaCopiar.txt", "archivoCopiado.txt");

        // Punto 9
        HashMap<String, String> heroList = new HashMap<String, String>();
        heroList.put("batman", "joker");
        heroList.put("superman", "kriptonita");
        heroList.put("lobezno", "magneto");
        heroList.put("spiderman", "venom");

        System.out.println("Introduce los heroes que quieres que salgan en el fichero.");
        System.out.println("Escribe 'fin' cuando quieras finalizar");
        System.out.println("[Opciones]:");

        for (String i : heroList.keySet()) {
            System.out.println("- "+i);
        }

        try {
            BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

            String out = "";
            String hero = "";
            while(!hero.equalsIgnoreCase("fin")) {
                hero = br.readLine();
                if(hero.equalsIgnoreCase("fin")) {
                    break;
                }
                if (heroList.get(hero) == null) {
                    System.out.println(hero + " no esta en la lista");
                    continue;
                }
                out += "El villano de " + hero + " es " + heroList.get(hero) + "\n";
                System.out.println("El villano de " + hero + " es " + heroList.get(hero));
            }

            try (PrintStream ficheroHeroes = new PrintStream("heroes.txt")) {
                ficheroHeroes.println(out);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static String reverse(@NotNull String texto) {
        String textoAlReves = "";
        for(int i = texto.length() - 1; i >= 0; i--) {
            textoAlReves += texto.charAt(i);
        }
        return textoAlReves;
    }

    public static void dividePorCero() {
        throw new ArithmeticException("Esto no puede hacerse");
    }

    public static void copiarFichero(String fileIn, String fileOut) {
        try {
            InputStream fichero = new FileInputStream(fileIn);
            PrintStream nuevoFichero = new PrintStream(fileOut);
            int c;
            while((c = fichero.read()) != -1) {
                nuevoFichero.write(c);
            }
        } catch(Exception e) {
            System.out.println("Error");
        }
    }


}