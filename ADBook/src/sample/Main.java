package sample;

import java.util.HashMap;
import java.util.Scanner;
import java.util.UUID;

public class Main  {

    public static void main(String[] args) {
        UUID uuid;
        HashMap<UUID, Student> Archiv = new HashMap<>();
        Scanner vstup = new Scanner(System.in);
        String name; String Fname; String email;
        int status = 1;
        System.out.println("Vitajte:");
        while (status==1) {
            System.out.println("\n" +
                    "a meno priezvisko email   pridanie novej osoby\n" +
                    "e uuid meno priezvisko email   upravy osobu so zadanym uuid\n" +
                    "d uuid   vymaze osobu so zadanym uuid\n" +
                    "s uuid   vyhlada osobu so zadanym uuid\n" +
                    "l   vypise vsetky osoby\n" +
                    "q   koniec");
            switch (vstup.next().charAt(0)){
                case 'a':
                    uuid = UUID.randomUUID();
                    name = vstup.next(); Fname = vstup.next(); email = vstup.next();
                    Archiv.put(uuid, new Student(name,Fname,email));
                    break;
                case 'd':
                    Archiv.remove(UUID.fromString(vstup.next()));
                    break;
                case 'e':
                    uuid = UUID.fromString(vstup.next());
                    name = vstup.next(); Fname = vstup.next(); email = vstup.next();
                    Archiv.put(uuid, new Student(name,Fname,email));
                    break;
                case 's':
                    name = vstup.next();
                    System.out.println(Archiv.get(UUID.fromString(name)).getFirstName() +
                            " " + Archiv.get(UUID.fromString(name)).getLastName() +
                            " " + Archiv.get(UUID.fromString(name)).getEmail());
                    break;
                case 'l':
                    for(UUID i: Archiv.keySet())
                        System.out.println(i + " " + Archiv.get(i).getFirstName() +
                                " " + Archiv.get(i).getLastName() +
                                " " + Archiv.get(i).getEmail());
                    break;
                case 'q':
                    status++;
                    break;
                default:
                    break;
            }
        }
    }
}