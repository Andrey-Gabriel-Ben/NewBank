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

}

public void mensagemEmLoop (Conta conta) { //para questões de segurança, é valido deixar a conta como parametro?
    int opcao;

    do {
        System.out.println("\n \n \n ==== CAIXA ELETRÔNICO NEW BANK ====");
        System.out.println("TITULAR: "+ conta.getTitular());
        System.out.println("\n 1 - Depositar");
        System.out.println("2 - Sacar");
        System.out.println("3 - Consultar saldo");
        System.out.println("0 - Sair");

        opcao = scanner.nextInt();

        switch (opcao){
            case 1:
                System.out.println("\n \n \nDigite o valor para depósito: R$ \n \n \n");
                double deposito = scanner.nextDouble();
                conta.Depositar(deposito);
                break;
            case 2:
                System.out.println("\n \n \nDigite o valor para saque: R$ \n \n \n");
                double saque = scanner.nextDouble();
                conta.Sacar(saque);
                break;
            case 3:
                System.out.println("\n \n \n O saldo atual é de: R$" + conta.getSaldo() + "\n \n \n");
                break;
            case 0:
                break;
            default:
                System.out.print("\n \n \n Opção inválida, por favor tente novamente\n \n \n");
                break;
        };
    } while (opcao !=0);
}



public class NewBank_2 {
    public static void main(String[] args) {
        
        
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