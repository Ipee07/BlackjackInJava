import java.util.Scanner;

public class Blackjack {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        
        Dinheiro dinheiro = new Dinheiro(0.0);
        
        System.out.println("♦️♣️♥️♠️ Bem vindo ao BlackJack! ♦️♣️♥️♠️");
        esperar();
        int acao;

        do {
        System.out.println("\n\n1. Deseja depositar dinheiro (1)");
        System.out.println("2. Deseja jogar (2)");
        System.out.println("3. Ver saldo (3)");
        System.out.println("4. Deseja sair (4)");

        acao = scanner.nextInt();

        switch (acao) {
            case 1:

            dinheiro.depositar();
                
                break;
        
            case 2:
                if (dinheiro.getSaldo() <= 0) {
                        System.out.println("Saldo insuficiente. Deposite primeiro.");
                    } else {
                        Jogo jogo = new Jogo(dinheiro);
                        jogo.iniciar();
                    }
                break;
        
            case 3:
            double saldo = dinheiro.getSaldo();
            System.out.println("O seu saldo é " + saldo);
                }
        } while (acao != 4);

        scanner.close();
    }

    private static void esperar() {
        try {
            Thread.sleep(1500); 
        } 
        catch (InterruptedException e) {
            System.out.println("O programa foi interrompido!");
        }
    }
}