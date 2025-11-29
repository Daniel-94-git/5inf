package com.example.todolistfx;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class HelloController {

    // Colleghiamo il campo di testo dell'FXML
    @FXML
    private TextField inputField;

    // Colleghiamo la lista dell'FXML
    @FXML
    private ListView<TodoItem> todoListView;

    // Creiamo un formato carino per la data: Giorno/Mese Ora:Minuti
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM HH:mm");

    @FXML
    public void initialize() {
        // 1. Definiamo come deve apparire ogni riga (Cella)
        todoListView.setCellFactory(param -> new javafx.scene.control.ListCell<TodoItem>() {
            private final javafx.scene.control.CheckBox checkBox = new javafx.scene.control.CheckBox();

            @Override
            protected void updateItem(TodoItem item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null) {
                    setGraphic(null); // Se la riga è vuota, non mostrare nulla
                } else {
                    // Impostiamo il testo e lo stato della checkbox
                    checkBox.setSelected(item.isCompletato());
                    aggiornaTestoCheckBox(checkBox, item); // Funzione creata sotto per pulizia
                    // Quando l'utente clicca la checkbox, aggiorniamo il nostro oggetto
                    checkBox.setOnAction(event -> {
                        item.setCompletato(checkBox.isSelected());
                        aggiornaTestoCheckBox(checkBox, item);
                        salvaSuFile(); // Salviamo subito il cambiamento!
                    });

                    setGraphic(checkBox); // Mostra la checkbox al posto del testo semplice
                }
            }
        });

        // 2. Carichiamo i dati
        caricaDaFile();
    }

    // Metodo di aiuto per scrivere il testo giusto
    private void aggiornaTestoCheckBox(javafx.scene.control.CheckBox chk, TodoItem item) {
        if (item.isCompletato() && item.getDataCompletamento() != null) {
            String dataFormattata = item.getDataCompletamento().format(formatter);
            chk.setText(item.getDescrizione() + " (Fatto il " + dataFormattata + ")");
        } else {
            chk.setText(item.getDescrizione());
        }
    }

    @FXML
    protected void onHelloButtonClick() {
        String testo = inputField.getText();
        if (!testo.isEmpty()) {
            // Usiamo il costruttore semplice
            todoListView.getItems().add(new TodoItem(testo));
            inputField.clear();
            salvaSuFile();
        }
    }


    @FXML
    protected void onDeleteButtonClick() {
        // 1. Chiediamo alla lista: "Qual è l'indice (la posizione) dell'elemento selezionato?"
        int indiceSelezionato = todoListView.getSelectionModel().getSelectedIndex();

        // 2. Controlliamo se c'è davvero qualcosa selezionato.
        // Se non è selezionato nulla, l'indice è -1.
        if (indiceSelezionato != -1) {

            // 3. Rimuoviamo l'elemento che si trova in quella posizione
            todoListView.getItems().remove(indiceSelezionato);
        } else {
            // (Opzionale) Potremmo stampare un messaggio nella console per debug
            System.out.println("Nessuna attività selezionata!");
        }
        salvaSuFile();
    }


    private void salvaSuFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("todo.txt"));
            for (TodoItem item : todoListView.getItems()) {
                // Salviamo la data come stringa ISO standard (facile da rileggere)
                String dataStr = (item.getDataCompletamento() != null) ? item.getDataCompletamento().toString() : "null";

                writer.write(item.getDescrizione() + ";" + item.isCompletato() + ";" + dataStr);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void caricaDaFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("todo.txt"));
            String riga;
            while ((riga = reader.readLine()) != null) {
                String[] parti = riga.split(";");
                // Ora ci aspettiamo 3 parti
                if (parti.length == 3) {
                    String descrizione = parti[0];
                    boolean completato = Boolean.parseBoolean(parti[1]);

                    LocalDateTime data = null;
                    if (!parti[2].equals("null")) {
                        data = LocalDateTime.parse(parti[2]);
                    }

                    // Usiamo il costruttore completo
                    todoListView.getItems().add(new TodoItem(descrizione, completato, data));
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Nessun salvataggio precedente.");
        }
    }
}