/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package laivanupotuspeli.laivanupotuspeli;

import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Anniina
 */
public class Pelilauta {
    
    //luodaan vaikeusastetta vastaava pelilauta
    // ja asetetaan kaikki ruudut tyhjiksi
    public static ArrayList<ArrayList<Integer>> pelilauta = new ArrayList<ArrayList<Integer>>();
    private static ArrayList<Integer> laivat = new ArrayList<>(); //taulukko pelin laivoja varten
    public int laudankoko, pituus;
    Scanner lukija = new Scanner(System.in);
            
    public Pelilauta(int vaikeusaste){ 
        if(vaikeusaste==1){
            luoPeli(10);
            laudankoko=10;
        }
        if(vaikeusaste==2){
            luoPeli(12);
            laudankoko=12;
        }
        if(vaikeusaste==3){
            luoPeli(20);
            laudankoko=20;
        }
        
    }
    
    public void luoPeli(int laudankoko){
        //lauta = laudankokoxlaudankoko
        for(int rivi=0; rivi<laudankoko; rivi++){
            ArrayList<Integer> vaakarivi = new ArrayList<Integer>();
            pelilauta.add(rivi, vaakarivi);
            for(int pysty=0; pysty<laudankoko; pysty++){
                vaakarivi.add(pysty, 0); //asetetaan tyhjät ruudut nolliksi alussa
            }
        }
        //testaus:
        for (int row = 0; row <laudankoko; row++) {
            for (int col = 0; col <laudankoko; col++) {
                System.out.print("["+ row+","+col+"]");
                System.out.print("="+pelilauta.get(row).get(col).toString()+" "); //sisältö
            }
            System.out.println("\n");
        }
        System.out.println("\n");
        
    }
    
    public void lisaaLaivat(){

        //luodaan pelin laivat: 
        laivat.add(5); //lentotukialus
        laivat.add(4); //taistelulaiva
        laivat.add(3); //risteilijä
        laivat.add(3); //risteilijä
        laivat.add(2); //hävittäjä
        laivat.add(2); //hävittäjä
        
        System.out.println("Syötettävissä olevien laivojen määrä: "+laivat.size());
        while (laivat.size()>0){
            laivanLisays();
            while(laivat.contains(pituus)==false){
                System.out.println("Valitun tyyppiset laivat on jo syötetty!");
                laivanLisays();
            }
            Laiva laiva = new Laiva(pituus);
            pyydaKoordinaatit();
            
            int poistetaan=laivat.indexOf(pituus);
            laivat.remove(poistetaan);
            /*Tänne pitäisi saada vielä määriteltyä mihin kohtaan lautaa laiva syötetään.
             *Aluksi voisi hoitaa sijoituksen esim. vain vaakatasossa  ja miettiä sen 
             *jälkeen miten suuntaa voi muuttaa..
             */
            System.out.println("Aseta laudalle vielä "+laivat.size()+" laivaa.");
         }
    }
    
    public void laivanLisays(){
        System.out.println("Mikä laiva lisätään laudalle: ");
            System.out.println("1 - lentotukialus (pituus 5)");
            System.out.println("2 - taistelulaiva (pituus 4)");
            System.out.println("3 - risteilijä (pituus 3)");
            System.out.println("4 - hävittäjä (pituus 2)");
            
            int lisattava=lukija.nextInt();
            
            while(lisattava<1 || lisattava>4){
                System.out.println("Virheellinen valinta! Valitse 1-4:");
                lisattava=lukija.nextInt();
            }
            if(lisattava==1){
                pituus=5;
            }
            if(lisattava==2){
                pituus=4;
            }
            if(lisattava==3){
                pituus=3;
            }
            if(lisattava==4){
                pituus=2;
            }

    }
    
    public void pyydaKoordinaatit(){
        System.out.println("Anna syöttökohdan koordinaatit: vaaka 0-"+(laudankoko-1)+", pysty 0-"+(laudankoko-1));
        int vaakarivi=lukija.nextInt();
        int pystyrivi=lukija.nextInt();
        while(vaakarivi>=laudankoko || pystyrivi>=laudankoko){
            System.out.println("Väärä valinta! Anna syöttökohdan koordinaatit: vaaka 0-"+(laudankoko-1)+", pysty 0-"+(laudankoko-1));
            vaakarivi=lukija.nextInt();
            pystyrivi=lukija.nextInt();
           
        }
        asetaLaiva(vaakarivi, pystyrivi);
    }
    

    public void asetaLaiva(int vaaka, int pysty){
        //haetaan lista vaakariviltä 2 ja sitten pystylistasta muutetaan oikea kohta ykköseksi
        pelilauta.get(vaaka).set(pysty,Integer.valueOf(1));
        //testataan:
        for (int row = 0; row <laudankoko; row++) {
            for (int col = 0; col <laudankoko; col++) {
                System.out.print("["+ row+","+col+"]");
                System.out.print("="+pelilauta.get(row).get(col).toString()+" "); //sisältö
            }
            System.out.println("\n");
        }
        System.out.println("\n");    
    }
        
}
