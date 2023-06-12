import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CadastroClientesInterface extends JFrame {

    private JTextField campoCPF;
    private JTextField campoNome;
    private JTextField campoDataNascimento;
    private JTextField campoTelefone;

    public CadastroClientesInterface() {
        setTitle("Cadastro de Cliente");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel labelCPF = new JLabel("CPF:");
        campoCPF = new JTextField(20);

        JLabel labelNome = new JLabel("Nome:");
        campoNome = new JTextField(20);

        JLabel labelDataNascimento = new JLabel("Data de Nascimento:");
        campoDataNascimento = new JTextField(20);

        JLabel labelTelefone = new JLabel("Telefone:");
        campoTelefone = new JTextField(20);

        JButton botaoCadastrar = new JButton("Cadastrar");
        botaoCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarCliente();
            }
        });

        add(labelCPF);
        add(campoCPF);
        add(labelNome);
        add(campoNome);
        add(labelDataNascimento);
        add(campoDataNascimento);
        add(labelTelefone);
        add(campoTelefone);
        add(botaoCadastrar);

        pack();
        setVisible(true);
    }

    private void cadastrarCliente() {
        String cpf = campoCPF.getText();
        String nome = campoNome.getText();
        String dataNascimento = campoDataNascimento.getText();
        String telefone = campoTelefone.getText();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("clientes.txt", true))) {
            writer.write("CPF: " + cpf + ";"+ "NOME: " + nome + ";" + "DATA DE NASCIMENTO: " + dataNascimento +"TELEFONE: " + ";" + telefone);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar o cliente: " + e.getMessage());
        }

        JOptionPane.showMessageDialog(this, "Cliente cadastrado com sucesso.");
    }

    public static void main(String[] args) {
        new CadastroClientesInterface();
    }
}
