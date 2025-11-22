package Animali;

public interface AzioniAnimali {

    void mangia();
    void zampaPersa();
    default void verso(){
        System.out.println(
                "L'animale ringhia"
        );
    };
    default void dormi(){
      System.out.println(
              "L'animale sta dormendo"
      );
    };
}
