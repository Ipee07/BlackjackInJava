import java.util.Random;
import java.util.ArrayList;

public class Baralho {
    
    ArrayList<Carta> baralhoatual = new ArrayList<>();

    String[] naipes = {"Paus", "Espadas", "Copas", "Ouros"};
    
    String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Valete", "Dama", "Rei", "Ás"};

    public Baralho() {
        
        resetar();
    }

    public void baralhar(){
        Random random = new Random();
        
        int n = baralhoatual.size();

        for (int i = 0; i < n; i++) {

            int j = random.nextInt(n);

            Carta temp = baralhoatual.get(i);
            baralhoatual.set(i, baralhoatual.get(j));
            baralhoatual.set(j, temp);
        }
    }

    public ArrayList<Carta> getTodasCartas() {
        
        return baralhoatual;
    }
    
    public Carta darCarta() {

        Carta cartadada = baralhoatual.remove(0);

        return cartadada;
     }

    public void resetar() {
        baralhoatual.clear();  // limpa o baralho atual
        
        for (String rank : ranks) {
            for (String naipe : naipes) {
                baralhoatual.add(new Carta(rank, naipe));
            }
        }
    }

}
