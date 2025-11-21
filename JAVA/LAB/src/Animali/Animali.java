package Animali;

public class Animali {
    private int zampe;
    private int peso;
    private String nome;

    public Animali(int zampe,int peso,String nome){
        this.zampe = zampe;
        this.peso = peso;
        this.nome = nome;
    }

    public void zampaPersa(){
        if(this.zampe > 0){
            this.zampe--;
            System.out.println("Hai perso una zampa :(");
        }
    }

    public int mangia( int aumentoPeso){
        if (aumentoPeso > 0) {
            this.peso += aumentoPeso;
            System.out.println("Sei ingrassato di: "+ aumentoPeso + " KG, ora pesi: "+ this.peso + " KG");
            return this.peso;
        } else {
            System.out.println("Non hai mangiato nulla o la quantità non è valida.");
            return this.peso;
        }
    }

    public int getZampe() {
        return zampe;
    }

    public void setZampe(int zampe) {
        this.zampe = zampe;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getNome() {
        System.out.println(this.nome);
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
