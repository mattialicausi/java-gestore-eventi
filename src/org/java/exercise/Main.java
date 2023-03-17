package org.java.exercise;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Titolo ");
        String titolo = scan.nextLine();

        System.out.println();

        System.out.print("Data evento (formato dd/MM/yyyy): ");
        String dataStr = scan.nextLine();
        LocalDate data = LocalDate.parse(dataStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.println();

        System.out.print("Numero totale di posti ");
        int nPostiTotali = Integer.parseInt(scan.nextLine());

        Evento evento1 = new Evento(titolo, data, nPostiTotali);

        System.out.println("Evento  " + evento1);

        //chiedo all'utente se vuole effettuare delle prenotazioni


        boolean stop = false;
        while (!stop) {
            System.out.print("Vuoi effettuare una prenotazione/disdetta/uscire ? (p/d/u)");

            String choice = scan.nextLine();

            switch (choice) {
                case ("p"): {

                    //prenotazioni

                    System.out.print("Quante prenotazioni vuoi effettuare? ");
                    int counterPrenotazioni = Integer.parseInt(scan.nextLine());
                    int i = 0;

                    if (evento1.getnPostiTotali() > evento1.getnPostiPrenotati() + counterPrenotazioni) {
                        while (i < counterPrenotazioni) {
                            evento1.prenota();
                            i++;
                        }
                    } else {
                        System.out.println("Non puoi prenotare " + counterPrenotazioni + " posti" + ", il massimo è di " + (evento1.getnPostiTotali() - evento1.getnPostiPrenotati()));
                    }

                    System.out.println("Posti prenotati " + evento1.getnPostiPrenotati() + " / " + evento1.getnPostiTotali());
                    break;
                }
                case("d"): {

                    //disdette

                    System.out.print("Quante disdette vuoi effettuare? ");
                    int counterDisdette = Integer.parseInt(scan.nextLine());
                    int i = 0;

                    if (counterDisdette <= evento1.getnPostiPrenotati()) {
                        while (i < counterDisdette) {
                            evento1.disdici();
                            i++;
                        }
                    } else {
                        System.out.println("Non puoi effettuare " + counterDisdette + " disdette" + ", il massimo è di " + evento1.getnPostiPrenotati());
                    }

                    System.out.println("Posti prenotati " + evento1.getnPostiPrenotati() + " / " + evento1.getnPostiTotali());
                    break;

                }
                case("u"): {

                    //esci

                    System.out.print("Arrivederci ");
                    stop = true;
                    break;
                }
                default: {
                    break;
                }
            }
        }


        System.out.println();


        //provo la classe concerto

        System.out.print("Titolo concerto ");
        String titoloConcerto = scan.nextLine();

        System.out.println();

        System.out.print("Data concerto (formato dd/MM/yyyy): ");
        String dataConcertoStr = scan.nextLine();
        LocalDate dataConcerto = LocalDate.parse(dataConcertoStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.println();

        System.out.print("Numero totale di posti ");
        int nPostiTotaliConcerto = Integer.parseInt(scan.nextLine());

        System.out.print("Inserisci l'ora");
        String oraStr = scan.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime oraConcerto = LocalTime.parse(oraStr, formatter);


        System.out.print("Prezzo ");
        BigDecimal prezzoConcerto = new BigDecimal(scan.nextLine());

       Concerto concerto1 = new Concerto(titoloConcerto, dataConcerto, nPostiTotaliConcerto, oraConcerto, prezzoConcerto);

        System.out.println("Concerto  " + concerto1);

        //chiedo all'utente se vuole effettuare delle prenotazioni




        boolean stopConcerto = false;
        while (!stopConcerto) {
            System.out.print("Vuoi effettuare una prenotazione/disdetta/uscire ? (p/d/u)");

            String choice = scan.nextLine();

            switch (choice) {
                case ("p"): {

                    //prenotazioni

                    System.out.print("Quante prenotazioni vuoi effettuare? ");
                    int counterPrenotazioniConcerto = Integer.parseInt(scan.nextLine());
                    int n = 0;

                    if (concerto1.getnPostiTotali() > concerto1.getnPostiPrenotati() + counterPrenotazioniConcerto) {
                        while (n < counterPrenotazioniConcerto) {
                            concerto1.prenota();
                            n++;
                        }
                    } else {
                        System.out.println("Non puoi prenotare " + counterPrenotazioniConcerto + " posti" + ", il massimo è di " + (concerto1.getnPostiTotali() - concerto1.getnPostiPrenotati()));
                    }

                    System.out.println("Posti prenotati " + concerto1.getnPostiPrenotati() + " / " + concerto1.getnPostiTotali());
                    break;
                }
                case("d"): {

                    //disdette

                    System.out.print("Quante disdette vuoi effettuare? ");
                    int counterDisdetteConcerto = Integer.parseInt(scan.nextLine());
                    int n = 0;

                    if (counterDisdetteConcerto <= concerto1.getnPostiPrenotati()) {
                        while (n < counterDisdetteConcerto) {
                            concerto1.disdici();
                            n++;
                        }
                    } else {
                        System.out.println("Non puoi effettuare " + counterDisdetteConcerto + " disdette" + ", il massimo è di " + concerto1.getnPostiPrenotati());
                    }

                    System.out.println("Posti prenotati " + concerto1.getnPostiPrenotati() + " / " + concerto1.getnPostiTotali());
                    break;

                }
                case("u"): {

                    //esci

                    System.out.print("Arrivederci ");
                    stopConcerto = true;
                    break;
                }
                default: {
                    break;
                }
            }
        }

    }
}
