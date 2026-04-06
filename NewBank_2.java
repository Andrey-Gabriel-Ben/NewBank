import java.util.Scanner;
import java.text.DecimalFormat;

class Cliente {
    protected String nome;
    protected int idade;

    public Cliente(String nome, int idade) {
        this.nome = nome;
        if (idade >= 16) {
            this.idade = idade;
        } else {System.out.println("O cliente é menor de idade, não pode criar uma conta");}
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }
    
}



class Conta {
    protected final String titular;
    protected double saldo;
    // private String Patamar;

    public Conta(Cliente cliente, double saldo /*, String Patamar */) {
        this.titular = cliente.getNome();
        this.saldo = saldo;
    }

    public boolean verificarValorPositivo(double valor) {
        if (valor > 0) {
            return true;
        } else {
            System.out.println("O valor digitado é invalido, por favor tente novamente");
            return false;
        }
    }

    public boolean verificarValorLimite (double valor){
        if (valor < 1000) {
            return true;
        } else {
            System.out.println("O limite diario para saques e tranferencias é de apenas R$1.000,00");
            return false;
        }
    }

    public boolean verificarSaldo (double valor){
        if (saldo >= valor) {
           return true;
        } else {
           System.out.println("Saldo indisponivel, por favor verifique e tente novamente");
        return false;
        }
    }

    

    public void Depositar(double valor) {
        if (verificarValorPositivo(valor) != true) {return;}
        saldo += valor;
        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println("Deposito de R$" + df.format(valor) + " realizado com sucesso");
    }

    public void Sacar(double valor) {
        if (verificarValorPositivo(valor) != true) {return;}
        if (verificarSaldo(valor) != true) {return;}
        
        saldo -= valor;

        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println("Saque de R$" + df.format(valor) + " realizado com sucesso");
    }

    public String getTitular(){
        return titular;
    }

    public double getSaldo(){
        return saldo;
    }

    private double lerValorComValidacao(Scanner scanner, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String entrada = scanner.nextLine().trim();

            // Verificar se tem no máximo 2 casas decimais
            if (entrada.contains(".")) {
                String[] partes = entrada.split("\\.");
                if (partes.length == 2 && partes[1].length() > 2) {
                    System.out.println("Valor deve ter no máximo 2 casas decimais. Tente novamente.");
                    continue;
                }
            } else if (entrada.contains(",")) {
                String[] partes = entrada.split(",");
                if (partes.length == 2 && partes[1].length() > 2) {
                    System.out.println("Valor deve ter no máximo 2 casas decimais. Tente novamente.");
                    continue;
                }
                // Converter vírgula para ponto
                entrada = entrada.replace(",", ".");
            }

            try {
                double valor = Double.parseDouble(entrada);
                if (verificarValorPositivo(valor) == true) {return Math.round(valor * 100.0) / 100.0;}// Arredondar para 2 casas decimais
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido. Digite apenas números. Tente novamente.");
            }
        }
    } 

    public void mensagemEmLoop() {
        try (Scanner scanner = new Scanner(System.in)) {
            int opcao;

            do {
                System.out.println("\n \n \n ==== CAIXA ELETRÔNICO NEW BANK ====");
                System.out.println("TITULAR: "+ this.getTitular());
                System.out.println("\n1 - Depositar");
                System.out.println("2 - Sacar");
                System.out.println("3 - Consultar saldo");
                System.out.println("0 - Sair");

                System.out.print("Escolha uma opção: ");
                String entradaOpcao = scanner.nextLine().trim();
                try {
                    opcao = Integer.parseInt(entradaOpcao);
                } catch (NumberFormatException e) {
                    System.out.println("Opção inválida. Digite apenas números.");
                    opcao = -1;
                    continue;
                }

                switch (opcao) {
                    case 1 -> {
                        double deposito = lerValorComValidacao(scanner, "\n \n \nDigite o valor para depósito: R$");
                        this.Depositar(deposito);
                    }
                    case 2 -> {
                        double saque = lerValorComValidacao(scanner, "\n \n \nDigite o valor para saque: R$");
                        this.Sacar(saque);
                    }
                    case 3 -> {
                        DecimalFormat df = new DecimalFormat("#.00");
                        System.out.println("\n \n \n O saldo atual é de: R$" + df.format(this.getSaldo()) + "\n ");
                    }
                    case 0 -> {}
                    default -> {
                        System.out.print("\n \n \n Opção inválida, por favor tente novamente\n ");
                    }
                }
            } while (opcao != 0);
        }
    }

    public void transferir(Conta destino, double valor) {
        if (verificarValorPositivo(valor) != true) {return;}
        if (verificarValorLimite(valor) != true) {return;}
        if (verificarSaldo (valor) != true) {return;}
        
        saldo -= valor;

        destino.saldo += valor;

        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println("Transferencia de R$" + df.format(valor) + " realizada com sucesso para:" + destino.getTitular());
    
    }

}

class ContaCorrente extends Conta{

    public ContaCorrente(Cliente cliente, double saldo) {
        super(cliente, saldo);
    }

    @Override
    public void Sacar(double valor) {
        if (verificarValorPositivo(valor) != true) {return;}
        if (verificarSaldo(valor) != true) {return;}

        saldo -= valor*1.05; // taxa de 5%

        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println("Saque de R$" + df.format(valor) + " realizado com sucesso");
    }
}
/*
public class NewBank_2 {
    public static void main(String[] args) {


        Cliente cpf1 = new Cliente("Andrey", 20);
        Conta c001 = new Conta(cpf1, 2600);
        
        Cliente cpf2 = new Cliente("André", 24);
        ContaCorrente c002 = new ContaCorrente(cpf2, 100000000);

        c002.mensagemEmLoop();

        System.out.println("\n \n \n Obrigado por utilizar o caixa eletronico \n \n \n");
    }

}




Parte 2 - Questões Práticas
1. Implemente um método transferir entre contas.
public boolean transferir(Conta destino, double valor) {
    // implemente
}
2. Crie validação com exceção no método depositar.


3. Crie ContaCorrente com taxa de saque.
4. Implemente histórico com ArrayList.
5. Crie menu interativo com Scanner


*/