import java.util.Scanner;

public class Jogador {

    Scanner scanner = new Scanner(System.in);

    public String nome() {

        String nome;

        do {
            System.out.print("Qual o seu nome? ");
            nome = scanner.nextLine();
        } while (nome.isEmpty());

        return nome;
    }

    public Boolean pedirCarta() {
        
        String escolha;
        
        do {

        System.out.println("Deseja (H)it ou (S)tand?");
        escolha = scanner.nextLine().toUpperCase();

        
        } while (!escolha.equals("H") && !escolha.equals("S"));

        if (escolha.equals("H")) {
            return true;
        }
        else {
            System.out.println("end of the game");
            return false;
        }
    }


}
