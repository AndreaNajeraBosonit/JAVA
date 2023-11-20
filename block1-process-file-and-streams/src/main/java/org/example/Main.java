package org.example;
import java.util.Optional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;


public class Main {
    List<Person> personList = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        Main m = new Main();
    }

    public Main() {

        leerFichero();

        System.out.println("----- menores de 25-----");
        personList.stream()
                .filter(p -> p.getEdad() < 25 && p.getEdad() != 0)
                .forEach(p -> System.out.println(p));


        System.out.println("-----  las personas cuyo nombre empiece con la letra A-");
        List<Person> filteredPeople = new ArrayList<>();
        for (Person person : personList) {
            if (person.getNombre() == null || !person.getNombre().startsWith("A")) {
                filteredPeople.add(person);
            }

        }
        for (Person person : filteredPeople) {
            System.out.println(person);
        }


        System.out.println("-----  la primera  personas cuya ciudad es Madrid ----");
        Optional<Person> personOption=personList.stream()
                .filter(p -> p.getCiudad().equals("Madrid"))
//                .limit(1)
                .findFirst();
        if (personOption.isEmpty())
            System.out.println("No hay personas en madrid");
        else
            System.out.println(personOption.get());

       /*
        List<Person> persons=personList.stream()
                .filter(p -> p.getCiudad().equals("Madrid"))
//                .limit(1)
                .toList();
        Optional<Person> pOption = getFirstElement(persons);
        Person p1 = pOption.get();
        System.out.println("El granador es: "+p1.getNombre());

                //.forEach(p -> System.out.println(p));
        System.out.println("----- obtener el primer elemento cuya ciudad sea Barcelona ----");
        personList.stream()
                .filter(p -> p.getCiudad().equals("Barcelona"))
                .forEach(p -> System.out.println(p));
*/
        System.out.println("-----  la primera  personas cuya ciudad es Barcelona ----");
        Optional<Person> personOptionB=personList.stream()
                .filter(p -> p.getCiudad().equals("Barcelona"))
//                .limit(1)
                .findFirst();
        if (personOptionB.isEmpty())
            System.out.println("No hay personas en Barcelona");
        else
            System.out.println(personOptionB.get());

    }
  /*  Optional<Person> getFirstElement(List<Person> personList)
    {
        return  personList.size()==0? Optional.empty():Optional.of(personList.get(0));
    }

*/
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
                String ciudad = pers[1].isEmpty()?"Unknown":pers[1];
//                if (ciudad.isEmpty())
//                    ciudad="unknow";
                if (pers.length>2) {

                    person = new Person(pers[0], ciudad, pers[2]);

                }
                else
                    person=new Person(pers[0],ciudad,"0");
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




