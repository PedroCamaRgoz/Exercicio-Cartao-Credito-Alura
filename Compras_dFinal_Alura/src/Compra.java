public class Compra implements Comparable<Compra>{

    private String descricao;
    private double valor;


    public Compra(String descricao,double valor ) {
        this.valor = valor;
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Descricao: " + descricao + " | " +
                "valor: " + valor;
    }

    @Override
    public int compareTo(Compra o) {
        return Double.valueOf(this.valor).compareTo(Double.valueOf(o.valor));
    }

}
