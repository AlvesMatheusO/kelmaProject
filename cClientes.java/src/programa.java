import java.util.InputMismatchException;
import java.util.Scanner;

class programa {
    private CadastroClientes cadastro;
    private Scanner scanner;
    private String login;
    private String senha;

    public void programa() {
        cadastro = new CadastroClientes("clientes.txt");
        login = "ADMIN";
        senha = "123456";
    }

    public void executar() {
        if (fazerLogin()) {
            new Menu();
            int opcao = lerOpcao();

            while (opcao != 4 ) {
                switch (opcao) {
                    case 1:
                        cadastrarCliente();
                        break;
                    case 2:
                        exibirInformacoesCliente();
                        break;
                    case 3:
                        excluirCliente();
                        break;
                    default:
                        System.out.println("Opção inválida. Digite novamente.");
                        break;
                }

                new Menu();
                opcao = lerOpcao();
            }
        } else {
            System.out.println("Login e/ou senha incorretos.");
            fazerLogin();
        }
    }

    private boolean fazerLogin() {
        System.out.print("Digite seu login: ");
        String inputLogin = scanner.nextLine();
        System.out.print("Digite sua senha: ");
        String inputSenha = scanner.nextLine();

        return login.equals(inputLogin) && senha.equals(inputSenha);
    }

    public void exibirMenu() {

        new Menu();
    }

    private int lerOpcao() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Opção inválida. Digite novamente.");
            scanner.next();
            return lerOpcao();
        }
    }

    public void cadastrarCliente() {
      new CadastroClientesInterface();
    }

    public void exibirInformacoesCliente() {
        new ExibirInformacoesClienteInterface();
    }

    public void excluirCliente() {
       new ExcluirClienteInterface();
    }
}
