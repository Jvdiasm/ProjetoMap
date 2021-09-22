import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner EntradaNum = new Scanner(System.in);
        ArrayList <Cliente> listaDeCliente = new ArrayList <Cliente>();
        Menu menu = new Menu();
        int opcao;
        Banco javou = new Banco();
        javou.setListaDeCliente(listaDeCliente);
        System.out.println("\n\n\t\t\t\t\tBANCO JAVOU");
        System.out.println("\n\t\t\t\t\t   MENU");
        do {
            System.out.println("\n");
            menu.mostrarMenu();
            System.out.print("\nDigite uma opcao : ");
            opcao = EntradaNum.nextInt();
            while(opcao <= 0 || opcao > 6){
                System.out.println("\nOpcao invalida, digite novamente a opcao : ");
                System.out.println("\n");
                menu.mostrarMenu();
                System.out.print("\nDigite uma opcao : ");
                opcao = EntradaNum.nextInt();
            }
            switch (opcao) {
                case 1:
                    javou.cadastrarCliente(listaDeCliente);
                    break;
                
                case 2:
                    javou.mostrarCliente(listaDeCliente);
                    break;

                case 3:
                    javou.sacarDinheiro(listaDeCliente);
                    break;
                
                case 4:
                    javou.depositarDinheiro(listaDeCliente);
                    break;

                case 5:
                    javou.trasnferirDinheiro(listaDeCliente);
                    break;
            }
        } while (opcao != 6);
        EntradaNum.close();
    }
}
