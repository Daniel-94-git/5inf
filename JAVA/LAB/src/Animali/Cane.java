package Animali;

public class Cane extends Animali {

    private Boolean codaLunga;

    public  Cane(int zampe,int peso , String nome,boolean codaLunga){
        super(zampe, peso, nome);
        this.codaLunga = codaLunga;
    }

    public  Boolean lunghezzaCoda(){
        if(codaLunga){
            System.out.println("Ha la coda lunga");
        }
        else {
            System.out.println("Ha la coda corta");
        }
        return this.codaLunga;
    }

    public Boolean getCodaLunga() {
        return codaLunga;
    }

    public void setCodaLunga(Boolean codaLunga) {
        this.codaLunga = codaLunga;
    }
}
