package com.example.todolistfx;

import java.time.LocalDateTime;

public class TodoItem {

    private String descrizione;
    private boolean completato;
    private LocalDateTime dataCompletamento;

    public TodoItem(String descrizione){

        this.descrizione = descrizione;
        this.completato = false;
        this.dataCompletamento = null;
    }
    public TodoItem(String descrizione, boolean completato, LocalDateTime dataCompletamento) {
        this.descrizione = descrizione;
        this.completato = completato;
        this.dataCompletamento = dataCompletamento;
    }

    public String getDescrizione(){
        return descrizione;
    }

    public boolean isCompletato(){
        return completato;
    }

    // Qui sta la magia: quando completiamo, salviamo ADESSO.
    // Se togliamo la spunta, cancelliamo la data.
    public void setCompletato(boolean completato) {
        this.completato = completato;
        if (completato) {
            this.dataCompletamento = LocalDateTime.now(); // Data e ora attuali
        } else {
            this.dataCompletamento = null; // Reset
        }
    }

    public LocalDateTime getDataCompletamento(){
        return dataCompletamento;
    }

    @Override
    public String toString(){
        return descrizione;
    }


}
