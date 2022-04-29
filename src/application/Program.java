package application;

import entities.Cliente;
import entities.Pedido;
import entities.PedidoItem;
import entities.Produto;
import entities.enums.StatusPedido;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Dados do cliente:");
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.next();
        System.out.print("Data de nascimento: ");
        Date data = sdf.parse(sc.next());
        System.out.println();

        Cliente cliente = new Cliente(nome, email, data);

        System.out.println("Dados do pedido:");
        System.out.print("Status: ");
        StatusPedido statusPedido = StatusPedido.valueOf(sc.next());

        Pedido pedido = new Pedido(new Date(), statusPedido, cliente);

        System.out.print("Quantos itens tem o pedido? ");
        int n = sc.nextInt();
        System.out.println();
        for (int i = 1; i <= n; i++){
            System.out.println("Dodos do item #" + i + ":");
            System.out.print("Nome do produto: ");
            sc.nextLine();
            String nomeProduto = sc.nextLine();
            System.out.print("Preço do produto: ");
            double precoProduto = sc.nextDouble();
            System.out.print("Quantidade: ");
            int qtd = sc.nextInt();

            Produto produto = new Produto(nomeProduto, precoProduto);

            PedidoItem pedidoItem = new PedidoItem(qtd, precoProduto, produto);

            pedido.addItem(pedidoItem);
        }

        System.out.println();
        System.out.println("Resumo do pedido");
        System.out.println(pedido);
    }
}
