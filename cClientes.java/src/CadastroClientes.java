import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class CadastroClientes {
    private List<Cliente> clientes;
    private String arquivo;

    public CadastroClientes(String arquivo) {
        this.arquivo = arquivo;
        clientes = lerClientesDoArquivo();
    }

    public void cadastrarCliente(Cliente cliente) throws CPFJaCadastradoException {
        for (Cliente c : clientes) {
            if (c.getCpf().equals(cliente.getCpf())) {
                throw new CPFJaCadastradoException("CPF já cadastrado." +"\n"+ "Consulte o cliente em Exibir Informações ao Cliente.");
            }
        }
        clientes.add(cliente);
        salvarClientesNoArquivo();
    }

    public Cliente buscarCliente(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }

    public boolean excluirCliente(String cpf) {
        Cliente cliente = buscarCliente(cpf);
        if (cliente != null) {
            clientes.remove(cliente);
            salvarClientesNoArquivo();
            return true;
        }
        return false;
    }

    public void exibirListaClientes() {
        System.out.println("\n----- Lista de Clientes -----");
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            for (Cliente cliente : clientes) {
                System.out.println("Nome: " + cliente.getNome());
            }
        }
    }

    private List<Cliente> lerClientesDoArquivo() {
        List<Cliente> clientesLidos = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(arquivo))) {
            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                String[] dados = linha.split(",");
                if (dados.length == 4) {
                    String cpf = dados[0].trim();
                    String nome = dados[1].trim();
                    String dataNascimento = dados[2].trim();
                    String telefone = dados[3].trim();
                    Cliente cliente = new ClientePessoaFisica(cpf, nome, dataNascimento, telefone);
                    clientesLidos.add(cliente);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo vazio. Será criado um novo arquivo ao salvar os clientes.");
        }
        return clientesLidos;
    }

    private void salvarClientesNoArquivo() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(arquivo))) {
            for (Cliente cliente : clientes) {
                writer.println(cliente);
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar clientes no arquivo.");
        }
    }
}
