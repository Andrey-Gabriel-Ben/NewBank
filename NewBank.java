
class Conta {

    String titular;
    double saldo;

    public Conta(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }

    public boolean  verificarValor(double valor){
        if (valor > 0){
            return true;
        } else {
            System.out.println("Valor inválido");
            return false;
        }
    }


    public void depositar(double valor) {
        if(!verificarValor(valor)){return;}
        saldo += valor;
    }

    public void sacar(double valor) {
        if(!verificarValor(valor)){return;}
        if (saldo < valor) {
            System.out.println("Saldo insuficiente, saque negado");
        } else {
            saldo -= valor;
            System.out.println("Saldo realizado de: R$" + valor);
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





    }
}
