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

    }
}
