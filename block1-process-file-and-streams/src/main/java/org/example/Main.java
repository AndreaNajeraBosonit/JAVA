package org.example;
import javax.swing.text.html.Option;
import java.util.Optional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Main {
    List<Person> personList = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        Main m = new Main();


    }

    public Main() {

        leerFichero();

        System.out.println("----- menores de 25 ---elimine las personas cuyo nombre empiece con la letra A-");
        personList.stream()
                .filter(p -> p.getEdad() < 25 && p.getEdad() != 0)
                .filter(p -> p.getNombre().startsWith("A"))
                .forEach(p -> System.out.println(p));


        System.out.println("-----  las personas cuya ciudades Madrid ----");
        personList.stream()

                .filter(p -> p.getCiudad().equals("Madrid"))
                .forEach(p -> System.out.println(p));
        System.out.println("----- obtener el primer elemento cuya ciudad sea Barcelona ----");
        personList.stream()

                .filter(p -> p.getCiudad().equals("Barcelona"))
                .forEach(p -> System.out.println(p));


        //Revisar los opcionales
        if (personList.isEmpty()) {
            System.out.println("unknown");
        } else {
            List<String> cities = new ArrayList<>();
            for (Person person : personList) {
                cities.add(person.getCiudad() != null ? person.getCiudad() : "unknown");
            }
            System.out.println(cities);
        }


    }


    //.collect(Collectors.toList());

    //listPersonas(filteredPeople);


    public void listPersonas(List<Person> lista)
    {
        // Imprimir la lista
;
        lista.stream().forEach(p->     System.out.println(p));


    }

    public void leerFichero()
    {

        try {
            List<String> texto = Files.readAllLines(Path.of("block1-process-file-and-streams/src/main/People.csv"));

            int nl=0;
            for (String cadena : texto) {
                nl++;
                if (nl==1)
                    continue;
                String[] pers=cadena.split(":");
                Person person;//= new Person();
                if (pers.length>2)
                    person=new Person(pers[0],pers[1],pers[2]);

                else
                    person=new Person(pers[0],pers[1],"0");
                personList.add(person);


            }


                    System.out.printf("Todas  las personas leidas");
                    listPersonas(personList);


        } catch (IOException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }



    }
}




