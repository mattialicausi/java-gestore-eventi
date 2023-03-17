package org.java.exercise;

import java.time.LocalDate;
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
                    System.out.print("Arrivederci ");
                    stop = true;
                    break;
                }
                default: {
                    break;
                }
            }
        }
    }
}
