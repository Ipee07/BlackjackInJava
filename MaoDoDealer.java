import java.util.ArrayList;

public class MaoDoDealer {

    ArrayList<Carta> mao = new ArrayList<>();

    public void receberCarta(Carta carta) {
        mao.add(carta);
    }

    public int pontuacao() {
        int soma = 0;

        for (Carta carta : mao) {
            soma += carta.getValor();
        }
        return soma;
    }

    public ArrayList<Carta> getMao() {
        return mao;
    }

}
