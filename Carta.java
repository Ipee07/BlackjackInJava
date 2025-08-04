public class Carta {

    private String rank;
    private String naipe;

    public Carta(String rank, String naipe) {
        this.rank = rank;
        this.naipe = naipe;
    }

    public String getRank() {
        return rank;
    }

    public String getNaipe() {
        return naipe;
    }

    public int getValor() {

        if (rank.equals("Ás")) {
            return 11; // Valor especial para o Ás
        } else if (rank.equals("Valete") || rank.equals("Dama") || rank.equals("Rei")) {
            return 10; // Valor para figuras
        } else {
            return Integer.parseInt(rank); // Converte o número de carta para inteiro
        }
    }


}
