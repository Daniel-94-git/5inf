package ToDo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Quaderno {
    private ArrayList<Azione> listaAzioni;
    private final String NOME_FILE = "lista_TODO.txt";

    public Quaderno() {
        this.listaAzioni = new ArrayList<>();
        caricaDaFile();
    }

    public void aggiungi(String descrizione) {
        Azione nuovaAzione = new Azione(descrizione);
        listaAzioni.add(nuovaAzione);
        salvaSuFile();
        System.out.println("Nota aggiunta e salvata");
    }

    public void rimuovi(int indice) {
        if (indice >= 0 && indice < listaAzioni.size()) {
            listaAzioni.remove(indice);
            salvaSuFile();
            System.out.println("Nota rimossa");
        } else {
            System.out.println("Indice non valido!");
        }
    }

    public void leggiTutto() {
        System.out.println("--------- LE TUE NOTE -----------");
        if (listaAzioni.isEmpty()) {
            System.out.println("La tua lista è vuota.");
        } else {
            for (int i = 0; i < listaAzioni.size(); i++) {
                System.out.println(i + ". " + listaAzioni.get(i));
            }
        }
        System.out.println("----------------------------------");
    }

    public void completaAzione(int indice){
        if (indice >= 0 && indice < listaAzioni.size()) {
            Azione azioneDaCompletare = listaAzioni.get(indice);
            azioneDaCompletare.setStatoToDo(true);
            salvaSuFile();
            System.out.println("Bravo una cosa da fare in meno , lo segnalo cosi [X] sulla lista! ");
        }
        else{
            System.out.println("Numero nota non valido!");
        }

    }


    // METODI SALVA/CARICA

    public void salvaSuFile() {
        try {
            FileWriter writer = new FileWriter(NOME_FILE);
            for (Azione azione : listaAzioni) {

                writer.write(azione.getDescrizione() + ";" + azione.getStatoToDo() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Errore durante il salvataggio: " + e.getMessage());
        }
    }

    public void caricaDaFile() {
        File file = new File(NOME_FILE);
        try {
            if (file.exists()) {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String riga = scanner.nextLine();
                    String[] parti = riga.split(";");

                    if (parti.length == 2) {
                        String descrizione = parti[0];
                        boolean completata = Boolean.parseBoolean(parti[1]);


                        Azione nuovaAzione = new Azione(descrizione);
                        nuovaAzione.setStatoToDo(completata);

                        listaAzioni.add(nuovaAzione);
                    }
                }
                scanner.close();
            }
        } catch (IOException e) {
            System.out.println("Errore durante il caricamento: " + e.getMessage());
        }
    }
}