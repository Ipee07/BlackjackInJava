import java.util.ArrayList;

public class MaoDoJogador {
    
    ArrayList<Carta> mao = new ArrayList<>();

    public void receberCarta(Carta carta) {
        mao.add(carta);
    }

    public int pontuacao() {
        int soma = 0;

        for (int i = 0; i < mao.size(); i++) {
            Carta carta = mao.get(i);
            soma += carta.getValor();
        }
        return soma;
    }

    public ArrayList<Carta> getMao() {
        return mao;
    }

    public void limparMao() {
        mao.clear();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Carta carta : mao) {
            sb.append(carta.getRank())
            .append(" de ")
            .append(carta.getNaipe())
            .append("; ");
        }
        return sb.toString();
}
    
}
