package entities;

import entities.enums.StatusPedido;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {

    private Date data;
    private StatusPedido status;
    private Cliente cliente;

    List<PedidoItem> listaItens = new ArrayList<>();

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy ");


    public Pedido(Date data, StatusPedido status, Cliente cliente) {
        this.data = data;
        this.status = status;
        this.cliente = cliente;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void addItem(PedidoItem itens){
        listaItens.add(itens);
    }

    public void removerItem(PedidoItem itens){
        listaItens.remove(itens);
    }

    public Double total(){
        double soma = 0.0;
        for (PedidoItem item : listaItens){
            soma += item.subTotal();
        }
        return soma;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append("Data do pedido: " + sdf.format(data) + "\n");
        sb.append("Status do pedido: " + status + "\n");
        sb.append("Cliente: " + cliente + "\n");
        sb.append("Itens do pedido: \n");
        for (PedidoItem item : listaItens){
            sb.append(item + "\n");
        }
        sb.append("Valor total: $" + String.format("%.2f",total()));

        return sb.toString();
    }
}
