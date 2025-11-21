package Animali;

public class Main {

    public static void main(String[] args) {

        Animali gatto = new Animali(4,3,"Pippo");
        Cane cane = new Cane(4,30,"Pluto",true);

        System.out.println("\n");
        System.out.println("GATTO");
        gatto.getNome();
        gatto.mangia(2);
        gatto.zampaPersa();

        System.out.println("\n\n");
        System.out.println("CANE");
        cane.lunghezzaCoda();
        cane.mangia(2);
        cane.zampaPersa();
        cane.getNome();

    }
}
