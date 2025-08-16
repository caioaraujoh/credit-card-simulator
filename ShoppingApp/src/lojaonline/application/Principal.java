package lojaonline.application;

import java.util.Collections;
import java.util.Scanner;

import lojaonline.model.CartaoDeCredito;
import lojaonline.model.Compra;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //System.out.println("Digite o limite do cartão: ");
        //double limite = sc.nextDouble();
        //CartaoDeCredito cartao = new CartaoDeCredito(limite);

        CartaoDeCredito cartao = new CartaoDeCredito(10203040, 1202);
        

        boolean acessoAutorizado = false;
        while (acessoAutorizado == false) {
        System.out.println("Digite o número do cartão: ");
        int numeroCartao = sc.nextInt();
        System.out.println("Digite a senha: ");
        int senhaCartao = sc.nextInt();

        acessoAutorizado = cartao.validatePassword(cartao, numeroCartao, senhaCartao);

        if (acessoAutorizado == false) {
            System.out.println("Login incorreto. Tente novamente.");
        }
    } 
        

            
        


        //MENU
        int sair = 1;
        while(sair != 0) {
            System.out.println("Digite a descrição da compra:");
            String descricao = sc.next();

            System.out.println("Digite o valor da compra:");
            double valor = sc.nextDouble();

            Compra compra = new Compra(descricao, valor);
            boolean compraRealizada = cartao.lancaCompra(compra);

            if (compraRealizada) {
                System.out.println("Compra realizada!");
                System.out.println("Digite 0 para sair ou 1 para continuar");
                sair = sc.nextInt();
            } else {
                System.out.println("Saldo insuficiente!");
                sair = 0;
            }
        }

        System.out.println("***********************");
        System.out.println("COMPRAS REALIZADAS:\n");
        Collections.sort(cartao.getCompras());
        for (Compra c : cartao.getCompras()) {
            System.out.println(c.getDescricao() + " - " +c.getValor());
        }
        System.out.println("\n***********************");

        System.out.println("\nSaldo do cartão: " +cartao.getSaldo());
    
        
    }
}
