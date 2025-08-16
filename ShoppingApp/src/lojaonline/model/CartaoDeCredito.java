package lojaonline.model;
import java.util.ArrayList;
import java.util.List;

public class CartaoDeCredito implements CardValidator {
    private int numeroCartao;
    private int senhaCartao;

    private double limite;
    private double saldo;
    private List<Compra> compras;

    /*public CartaoDeCredito(double limite) {
        this.limite = limite;
        this.saldo = limite;
        this.compras = new ArrayList<>();
    }*/
    

    

    
    

    public CartaoDeCredito() {
    }




    public CartaoDeCredito(int numeroCartao, int senhaCartao) {
        this.numeroCartao = numeroCartao;
        this.senhaCartao = senhaCartao;
    }




    public int getNumeroCartao() {
        return numeroCartao;
    }

    public int getSenhaCartao() {
        return senhaCartao;
    }

    public double getLimite() {
        return limite;
    }

    public double getSaldo() {
        return saldo;
    }

    public List<Compra> getCompras() {
        return compras;
    }

    //METODOS


    public boolean lancaCompra(Compra compra) {
        if(this.saldo >= compra.getValor()){
            this.saldo -= compra.getValor();
            this.compras.add(compra);
            return true;
        }

        return false;
    }

    @Override
    public boolean validatePassword(CartaoDeCredito cartao, int numeroCartao, int senhaCartao ) {
        if (cartao.getNumeroCartao() == numeroCartao && cartao.getSenhaCartao() == senhaCartao) {
            System.out.println("Acesso Autorizado!");
            return true;
        }else{
            return false;
        }
    }
}