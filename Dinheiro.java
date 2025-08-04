import java.util.Scanner;

public class Dinheiro {

    double saldo = 0.0;
    double aposta = 0.0;
    Scanner scanner = new Scanner(System.in);

    public Dinheiro(Double saldo) {
        this.saldo = saldo;
    }

    public double depositar() {

        System.out.println("Quanto deseja depositar");
        Double montante = scanner.nextDouble();
        saldo += montante;
        return saldo;


    }

    public double receber(Double valorApostado) {
        saldo += valorApostado;
        return saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public double retirar(double sacoDeposito) {

        if (sacoDeposito > saldo) {
            System.out.println("Saldo insuficiente para retirar " + sacoDeposito);
            return saldo;
            }
        saldo -= sacoDeposito;
        return saldo;
    }

    public double apostar() {

        System.out.print("Quanto deseja apostar? ");
        aposta = scanner.nextDouble();

         while (aposta > saldo || aposta <= 0) {
            System.out.println("Aposta inválida. Insira um valor positivo e menor ou igual ao saldo (" + saldo + "):");
            aposta = scanner.nextDouble();
        }
        retirar(aposta);

        return aposta;
    }

    
}
