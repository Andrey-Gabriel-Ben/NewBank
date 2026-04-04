import java.util.Scanner;

class Conta {
    private final String titular;
    private double saldo;

    public Conta(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }

    public boolean verificarValor(double valor) {
        if (valor > 0) {
            return true;
        } else {
            System.out.println("O valor digitado é invalido, por favor tente novamente");
            return false;
        }
    }

    public void Depositar(double valor) {
        if (verificarValor(valor) != true) {return;}
        saldo += valor;
        System.out.println("Deposito de R$" + valor + " realizado com sucesso");
    }

    public void Sacar(double valor) {
        if (verificarValor(valor) != true) {return;}

        if (valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso");
        } else {
            System.out.println("Saldo indisponivel");
        }
    }

    public String getTitular(){
        return titular;
    }

    public double getSaldo(){
        return saldo;
    }

    public void mensagemEmLoop (Scanner scanner) { 
    int opcao;

    do {
        System.out.println("\n \n \n ==== CAIXA ELETRÔNICO NEW BANK ====");
        System.out.println("TITULAR: "+ this.getTitular());
        System.out.println("\n 1 - Depositar");
        System.out.println("2 - Sacar");
        System.out.println("3 - Consultar saldo");
        System.out.println("0 - Sair");

        opcao = scanner.nextInt();

        switch (opcao) {
            case 1 -> {
                System.out.print("\n \n \nDigite o valor para depósito: R$");
                double deposito = scanner.nextDouble();
                this.Depositar(deposito);
            }
            case 2 -> {
                System.out.print("\n \n \nDigite o valor para saque: R$");
                double saque = scanner.nextDouble();
                this.Sacar(saque);
            }
            case 3 -> {
                System.out.println("\n \n \n O saldo atual é de: R$" + this.getSaldo() + "\n ");
            }
            case 0 -> {}
            default -> {
                System.out.print("\n \n \n Opção inválida, por favor tente novamente\n ");
            }
        }
    } while (opcao != 0);
}

}


public class NewBank_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        //Conta c001 = new Conta("Andrey", 2600);
        Conta c002 = new Conta("André", 100000000);

        //c001.mensagemEmLoop(scanner);

        c002.mensagemEmLoop(scanner);

        System.out.println("\n \n \n Obrigado por utilizar o caixa eletronico \n \n \n");
        scanner.close();
    }

}

/*
 


    criar uma classe conta com titular e saldo
    seu metodoconstrutor
    um verificador de valor
    o metodo depositar
    o metodo sacar
    os getters

    a função "do" em u mmetodo a ser chamado

chamar o scanner ( Scanner scanner = new Scanner(System.in);)

lembrar de fechar o scanner no final ( scanner.close();)

 */