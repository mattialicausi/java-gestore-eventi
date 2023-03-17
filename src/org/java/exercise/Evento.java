package org.java.exercise;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {
    private String titolo;
    private LocalDate data;
    private int nPostiTotali;
    private int nPostiPrenotati;

    public Evento(String titolo, LocalDate data, int nPostiTotali) throws DataPassataException, PostiNegativiException {
        this.titolo = titolo;


        LocalDate today = LocalDate.now();
        if(data.isBefore(today)) {
            //lancio eccezione se la data è prima di oggi
            throw new DataPassataException("La data non è valida perché è già passata ");

        } else {
            this.data = data;
        }


        if(nPostiTotali > 0) {
            this.nPostiTotali = nPostiTotali;
        } else {
            //lancio eccezione se i posti totali sono negativi
            throw new PostiNegativiException("I posti totali non possono essere negativi ");

        }


        //inizializzo a 0
        this.nPostiPrenotati = 0;
    }

    //getter e setter di titolo e data
    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    //getter di nPostiTotali e nPostiPrenotati

    public int getnPostiTotali() {
        return nPostiTotali;
    }

    public int getnPostiPrenotati() {
        return nPostiPrenotati;
    }

    //metodi

    //metodo prenota
    public void prenota() throws DataPassataException, PostiNegativiException{

        LocalDate today = LocalDate.now();

        if(data.isBefore(today)) {
            throw new DataPassataException("La data non è valida perché è già passata ");
        } else if (nPostiTotali < 1) {
            throw new PostiNegativiException("I posti totali non possono essere negativi ");
        } else {
            nPostiPrenotati++;
        }
    }

    //metodo disdici
    public void disdici() throws DataPassataException, PostiNegativiException{

        LocalDate today = LocalDate.now();

        if(data.isBefore(today)) {
            throw new DataPassataException("La data non è valida perché è già passata ");
        } else if (nPostiTotali < 0) {
            throw new PostiNegativiException("I posti totali non possono essere negativi ");
        } else {
            nPostiPrenotati--;
        }
    }

    //metodo per formattare la data
    private static String formattaData(LocalDate data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return data.format(formatter);
    }

    @Override
    public String toString() {
        return this.formattaData(getData()) + "-" + getTitolo();
    }
}
