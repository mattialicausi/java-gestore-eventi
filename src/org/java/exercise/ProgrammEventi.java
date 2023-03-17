package org.java.exercise;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProgrammEventi {
    private String titolo;
    private List<Evento> eventi;

    public ProgrammEventi(String titolo, List<Evento> eventi) {
        this.titolo = titolo;

        //creo una nuova lista e inserisco i dati passati come parametro
        this.eventi = new ArrayList<>();
        this.eventi.addAll(eventi);
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public List<Evento> getEventi() {
        return eventi;
    }

    public void setEventi(List<Evento> eventi) {
        this.eventi = eventi;
    }

    //metodi

    //metodo che aggiunge alla lista un evento passato come parametro
    public void aggiungiElemento(Evento evento) {
        this.eventi.add(evento);
    }

    //metodo che restituisce tutti gli eventi di una certa data
    public List<Evento> eventiInData(LocalDate data) {

        List<Evento> eventiInData = new ArrayList<>();

        for (Evento evento : eventi) {
            if (evento.getData().isEqual(data)) {
                eventiInData.add(evento);
            }
        }
        return eventiInData;
    }

    //metodo che restituisce quanti eventi sono compresi nella lista
    public int contaEventi() {
        return eventi.size();
    }

    //metodo che svuota la lista di eventi
    public void svuotaLista() {
        eventi.clear();
    }

    //metodo che mostra una stringa con eventi ordinati per data
    public String mostraEventiOrdinatiPerData() {

        // Ordina gli eventi per data
        Collections.sort(eventi, Comparator.comparing(Evento::getData));

        StringBuilder sb = new StringBuilder();
        sb.append(titolo).append("\n");

        for (Evento evento : eventi) {
            sb.append(evento.getData()).append(" - ").append(evento.getTitolo()).append("\n");
        }

        return sb.toString();
    }

}
