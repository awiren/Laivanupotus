package laivanupotuspeli.laivanupotuspeli;
import java.util.Scanner;
import java.util.ArrayList;
/**
 * Pääohjelma Laivanupotusta varten
 *
 */
public class App {
    
    private static Scanner lukija = new Scanner(System.in);
    private static ArrayList<Integer> laivat = new ArrayList<>(); //taulukko pelin laivoja varten
            //luodaan valintunlainen pelilauta:
    public static Pelilauta pelilauta;
    
    public static void main( String[] args ){
        System.out.println("Tervetuloa pelaamaan laivanupotusta!");
        System.out.println("Valitse pelin vaikeusaste:");
        System.out.println("1 - helppo");
        System.out.println("2 - normaali");
        System.out.println("3 - vaikea");
        
        int vaikeusaste=lukija.nextInt();
        /*jos pelaaja valitsee väärän vaikeusasteen, valinta pyydetään tekemään uusiksi
         * kunnes on valittu olemassaoleva vaikeus:
         */
        while(vaikeusaste>3 || vaikeusaste<1){
            System.out.println("Valitse 1, 2, tai 3:");
            vaikeusaste = lukija.nextInt();
        }
        //luodaan valintunlainen pelilauta:
        pelilauta = new Pelilauta(vaikeusaste);
        if(vaikeusaste==1){
            System.out.println("Valitsit helpon pelin!");
        }
        if(vaikeusaste==2){
            System.out.println("Valitsit normaalin pelin!");
        }
        if(vaikeusaste==3){
            System.out.println("Valitsit vaikean pelin!");
        }
        
        pelilauta.lisaaLaivat();
        //arvo vielä randomilla koneen laivat laudalle
        System.out.println("Laivat asetettu pelilaudalle. Peli alkaa!");
        }
    
}
