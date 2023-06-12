import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExibirInformacoesClienteInterface extends JFrame {

    private JTextField campoCPF;

    public ExibirInformacoesClienteInterface() {
        setTitle("Buscar Cliente");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel labelCPF = new JLabel("CPF do Cliente:");
        campoCPF = new JTextField(20);

        JButton botaoBuscar = new JButton("Buscar");
        botaoBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarCliente();
            }
        });

        add(labelCPF);
        add(campoCPF);
        add(botaoBuscar);

        pack();
        setVisible(true);
    }

    private void buscarCliente() {
        String cpf = campoCPF.getText();

        try (BufferedReader reader = new BufferedReader(new FileReader("clientes.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] clienteData = line.split(";");
                if (clienteData.length >= 4 && clienteData[0].equals(cpf)) {
                    String nome = clienteData[1];
                    String dataNascimento = clienteData[2];
                    String telefone = clienteData[3];
                    Cliente cliente = new Cliente(nome, cpf, dataNascimento, telefone);
                    JOptionPane.showMessageDialog(this, cliente.toString());
                    return; // Sai do método após encontrar o cliente
                }
            }

            JOptionPane.showMessageDialog(this, "Cliente não encontrado.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Erro ao buscar o cliente: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new ExibirInformacoesClienteInterface();
    }
}
