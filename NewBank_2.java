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

public class NewBank_2 {

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