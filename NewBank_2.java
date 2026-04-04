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
    private final String titular;
    private double saldo;

    public Conta(Cliente cliente, double saldo) {
        this.titular = cliente.getNome();
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
        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println("Deposito de R$" + df.format(valor) + " realizado com sucesso");
    }

    public void Sacar(double valor) {
        if (verificarValor(valor) != true) {return;}

        if (valor <= saldo) {
            saldo -= valor;
            DecimalFormat df = new DecimalFormat("#.00");
            System.out.println("Saque de R$" + df.format(valor) + " realizado com sucesso");
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
                if (verificarValor(valor) == true) {return Math.round(valor * 100.0) / 100.0;}// Arredondar para 2 casas decimais
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

}


public class NewBank_2 {
    public static void main(String[] args) {
       /*
        //Conta c001 = new Conta("Andrey", 2600);
        Conta c002 = new Conta("André", 100000000);

        //c001.mensagemEmLoop(scanner);

        c002.mensagemEmLoop();
       */ 

        Cliente cpf1 = new Cliente("Andrey", 20);
        Conta c001 = new Conta(cpf1, 2600);
        
        Cliente cpf2 = new Cliente("André", 24);
        Conta c002 = new Conta(cpf2, 100000000);

        c002.mensagemEmLoop();

        System.out.println("\n \n \n Obrigado por utilizar o caixa eletronico \n \n \n");
    }

}
