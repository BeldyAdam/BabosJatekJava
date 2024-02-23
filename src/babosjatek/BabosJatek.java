package babosjatek;

import java.util.Random;
import java.util.Scanner;

public class BabosJatek {
    
    static Random rnd = new Random();
    static Scanner sc = new Scanner(System.in);
    static int jLepesSzam;
    static int gLepesSzam;
    static int babok;
    
    public static void main(String[] args) {
        Jatek(20);
    }

    private static int JatekosLepes() {
        System.out.println("Hány babot szeretnél elvenni?");
        jLepesSzam = sc.nextInt();
        while (jLepesSzam > 2 || jLepesSzam <= 0 || jLepesSzam > babok) {
            System.out.println("Hibás lépés");
            jLepesSzam = sc.nextInt();
        }
        return jLepesSzam;
    }

    private static int GepLepes() {
        gLepesSzam = rnd.nextInt(1, 3);
        System.out.printf("Gép lépése %d\n", gLepesSzam);
        return gLepesSzam;
    }

    private static void Jatek(int szam) {
        babok = szam;
        while (babok > 0) {
            System.out.println("Hátralévő babok: "+babok);
            babok -= JatekosLepes();
            if (babok <= 0) {
                System.out.println("Játékos győzött");
                return;
            } else {
                babok -= GepLepes();
                if (babok <= 0) {
                    System.out.println("Gép győzött");
                    return;
                }
            }
        }
        System.out.println("Negatív babok száma!");
    }
}
