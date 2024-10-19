import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner leitura = new Scanner(System.in);
        double limite = 0;

        boolean limiteValido = false;

        while (!limiteValido) {
            System.out.println("Digite o limite do cartão: ");
            try {
                limite = leitura.nextDouble();
                limiteValido = true;
            } catch (InputMismatchException e) {
                System.out.println("Digite um número valido");
                leitura.next();
            }
        }
        CartaoCredito cartao = new CartaoCredito(limite);

        int sair = 1;
        while (sair == 1) {
            System.out.println("Digite a descrição da compra");
            String descricao = leitura.next();
            System.out.println("Digite o valor da compra");
            double valor = 0;
            boolean valorValido = false;

            while (!valorValido){
                try {
                   valor = leitura.nextDouble();
                   valorValido = true;

                } catch (InputMismatchException e) {
                    System.out.println("Digite um número valido");
                    leitura.next();
                }
            }

            Compra compra = new Compra(descricao, valor);
            boolean resultado = cartao.lancamentoCartao(compra);

            if (resultado) {
                System.out.println("Compra realizada!");
                System.out.println("Digite 1 para continuar e 0 para sair");
                sair = leitura.nextInt();
            }
            else {
                System.out.println("Saldo Insuficiente!");
                sair = 0;
            }
        }

        System.out.println("***************************");
        System.out.println("Compra Realizada: \n");
        Collections.sort(cartao.getCompras());

        for ( Compra  c : cartao.getCompras()){
            System.out.println(c);
        }

        System.out.println("\n***************************");

        System.out.println("\nSaldo do cartão :"+cartao.getSaldo());

    }
}