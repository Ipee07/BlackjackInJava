
public class Jogo {
    
    Baralho baralho = new Baralho();
    
    Jogador jogador = new Jogador();

    String nome = jogador.nome();
       
    MaoDoJogador maojogador = new MaoDoJogador();
    MaoDoJogador maodealer = new MaoDoJogador();
    
    private Dinheiro dinheiro;

    public Jogo(Dinheiro dinheiro) {
        this.dinheiro = dinheiro;
    }
    
    public void iniciar() {
        
        baralho.baralhar();

        System.out.println("Bem vindo ao BlackJack " + nome);
        esperar();

        double valorApostado = dinheiro.apostar();

        System.out.println("Você apostou: " + valorApostado);


        for (int i = 0; i < 2; i++) {
            maojogador.receberCarta(baralho.darCarta());
        }
        maodealer.receberCarta(baralho.darCarta());

        mostrarEstado(nome, maojogador);

        mostrarEstado("Dealer", maodealer);

        esperar();

        while (jogador.pedirCarta()) {
            
            Carta novaCarta = baralho.darCarta();
            maojogador.receberCarta(novaCarta);

            System.out.println("Recebeu: " + novaCarta.toString());
            mostrarEstado(nome, maojogador);
            esperar();

            if (maojogador.pontuacao() > 21) {
                break;
            }
        }
        while (maodealer.pontuacao() < 17) {
            
            maodealer.receberCarta(baralho.darCarta());
            mostrarEstado("Dealer", maodealer);
        }
        
        if (maojogador.pontuacao() > 21) {
            System.out.println("Você estourou. Dealer vence!");
        } else if (maodealer.pontuacao() > 21) {
            dinheiro.receber(valorApostado * 2);
            System.out.println("Dealer estourou. Você vence!");
        } else if (maojogador.pontuacao() > maodealer.pontuacao()) {
            dinheiro.receber(valorApostado * 2);
            System.out.println("Você venceu!");
        } else if (maojogador.pontuacao() < maodealer.pontuacao()) {
            System.out.println("Dealer venceu!");
        } else {
            System.out.println("Empate!");
            dinheiro.receber(valorApostado);
        }
    }
    

    private void mostrarEstado(String nome, MaoDoJogador mao) {
        System.out.println(nome + ": " + mao.toString() + " | Pontuação: " + mao.pontuacao());
    }

    private void esperar() {
        try {
            Thread.sleep(1500); 
        } 
        catch (InterruptedException e) {
            System.out.println("O programa foi interrompido!");
        }
    }
}
 