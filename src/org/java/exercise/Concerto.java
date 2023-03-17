package org.java.exercise;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concerto extends Evento{
   private LocalTime ora;
   private BigDecimal prezzo;

    public Concerto(String titolo, LocalDate data, int nPostiTotali, LocalTime ora, BigDecimal prezzo) throws DataPassataException, PostiNegativiException {
        super(titolo, data, nPostiTotali);
        this.ora = ora;
        this.prezzo = prezzo;
    }

    public LocalTime getOra() {
        return ora;
    }

    public void setOra(LocalTime ora) {
        this.ora = ora;
    }

    public BigDecimal getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(BigDecimal prezzo) {
        this.prezzo = prezzo;
    }



    //metodo per restituire data e ora formattata
    public String getFormattedTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return ora.format(formatter);
    }


    //metodo per restituire il prezzo formattato
    public String getFormattedPrice() {
        return String.format("%.2f€", prezzo);
    }

    //override metodo toString toString() in modo che venga restituita una stringa del tipo: data e ora formattata - titolo - prezzo formattato
    @Override
    public String toString() {
        return super.formattaData(getData()) + " - " + getFormattedTime() + " - " + getTitolo() + " - " + getFormattedPrice();
    }

}
