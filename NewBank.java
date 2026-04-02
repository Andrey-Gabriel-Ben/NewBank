class Conta {
    String titular;
    double saldo;

    public Conta (String titular, double saldo) {
        this.titular =  titular;
        this.saldo =  saldo;
    }


    public void depositar(double valor){
        saldo += valor;
    }

    public void sacar(double valor){
        if (saldo < valor) {
            System.out.println("Saldo insuficiente, saque negado");
        } else {
            saldo -= valor;
        }
    }

    public String getTitular(){
        return titular;
    }

    public double getSaldo(){
        return saldo;
    }
}






public class NewBank{
    public static void main(String[] args) {
        
    }
}