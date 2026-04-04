
import java.util.Scanner;

class Conta {

    String titular;
    double saldo;

    public Conta(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }

    public boolean verificarValor(double valor) {
        if (valor > 0) {
            return true;
        } else {
            System.out.println("Valor inválido");
            return false;
        }
    }

    public void depositar(double valor) {
        if (!verificarValor(valor)) {
            return;
        }
        saldo += valor;
        System.out.println("\n \n \n Deposito realizado com sucesso \n \n \n");
    }

    public void sacar(double valor) {
        if (!verificarValor(valor)) {
            return;
        }
        if (saldo < valor) {
            System.out.println("\n \n \n Saldo insuficiente, saque negado\n \n \n" );
        } else {
            saldo -= valor;
            System.out.println("\n \n \n Saldo realizado de: R$" + valor + "\n \n \n");
        }
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }
}

public class NewBank {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Conta c001 = new Conta("Andrey", 2600);

        int opcao;

        do {

            System.out.println("\n ==== CAIXA ELETRÔNICO NEW BANK ====");
            System.out.println("TITULAR: " + c001.getTitular());
            System.out.println("1 - Depositar");
            System.out.println("2 - Sacar");
            System.out.println("3 - Consultar saldo");
            System.out.println("0 - Sair");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("\n \n \nDigite o valor para depósito: R$ \n \n \n");
                    double deposito = scanner.nextDouble();
                    c001.depositar(deposito);
                    break;
                case 2:
                    System.out.print("\n \n \nDigite o valor para saque: R$ \n \n \n");
                    double saque = scanner.nextDouble();
                    c001.depositar(saque);
                    break;
                case 3:
                    System.out.print("\n \n \nO saldo atual da Conta é de: R$" + c001.getSaldo() + "\n \n \n");
                    break;
                case 0:
                    break;
                default:
                    System.out.print("\n \n \n Opção inválida, por favor tente novamente\n \n \n");
                    break;

            }

        } while (opcao != 0);

        System.out.println("\n \n \n obrigado por utilizar o caixa eletronico \n \n \n");
        scanner.close();
    }
}
