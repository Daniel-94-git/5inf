package ToDo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Quaderno ilMioQuaderno = new Quaderno();
        Scanner scanner = new Scanner(System.in);
        boolean continua = true; // flag per ill while

        System.out.println("BENVENUTO NEL TUO TO-DO LIST!");

        while (continua){
            System.out.println("\nSCEGLI FRA LE OPZIONI : ");
            System.out.println("1) Scrivi una nota: ");
            System.out.println("2) Leggi le note: ");
            System.out.println("3) Cancella una nota: ");
            System.out.println("4) Spunta nota completata: ");
            System.out.println("5) Esci dal programma: ");
            System.out.println("\nINSERISCI IL NUMERO: ");
            int scelta = scanner.nextInt();
            scanner.nextLine();

            switch (scelta){
                case 1:
                    System.out.println("Scrvi qui la nota: ");
                    String descrizione = scanner.nextLine();
                    ilMioQuaderno.aggiungi(descrizione);
                    break;

                case 2:
                    ilMioQuaderno.leggiTutto();
                    break;

                case 3:
                    ilMioQuaderno.leggiTutto();
                    System.out.println("Inserisci il numero della nota che vuoi cancellare: ");
                    int numero = scanner.nextInt();
                    scanner.nextLine();
                    ilMioQuaderno.rimuovi(numero);
                    break;

                case 4:
                    ilMioQuaderno.leggiTutto();
                    System.out.println("Inserisci il numero della nota da segnare come eseguita: ");
                    int finita = scanner.nextInt();
                    scanner.nextLine();
                    ilMioQuaderno.completaAzione(finita);
                    break;

                case 5:
                    System.out.println("Uscita in corso.... alla prossima!");
                    continua = false;
                    break;

                default:
                    System.out.println("Scelta non valida, riprova.");
            }
        }
        scanner.close();
    }
}
