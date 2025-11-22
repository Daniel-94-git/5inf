package ToDo;

public class Azione {

    private String descrizione;
    private boolean statoToDo;

    public Azione(String descrizione) {
        this.descrizione = descrizione;
        this.statoToDo = false; // Di default è "da fare"
    }

    // METODI FATTI DA ME
    @Override
    public String toString() {
        String spunta = statoToDo ? "[X]" : "[ ]";
        return spunta + " " + descrizione;
    }

    // METODI GETTER AND SETTER

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public boolean getStatoToDo() {
        return statoToDo;
    }

    public void setStatoToDo(boolean statoToDo) {
        this.statoToDo = statoToDo;
    }
}