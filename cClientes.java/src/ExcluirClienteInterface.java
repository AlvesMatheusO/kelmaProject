import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ExcluirClienteInterface extends JFrame {

    private JTextField campoCPF;

    public ExcluirClienteInterface() {
        setTitle("Excluir Cliente");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel labelCPF = new JLabel("CPF do Cliente:");
        campoCPF = new JTextField(20);

        JButton botaoExcluir = new JButton("Excluir");
        botaoExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                excluirCliente();
            }
        });

        add(labelCPF);
        add(campoCPF);
        add(botaoExcluir);

        pack();
        setVisible(true);
    }

    private void excluirCliente() {
        String cpf = campoCPF.getText();

        List<String> linhas = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("clientes.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] clienteData = linha.split(";");
                if (clienteData.length >= 1 && !clienteData[0].equals(cpf)) {
                    linhas.add(linha);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Erro ao buscar o cliente: " + e.getMessage());
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("clientes.txt"))) {
            for (String linha : linhas) {
                writer.write(linha);
                writer.newLine();
            }
            JOptionPane.showMessageDialog(this, "Cliente excluído com sucesso.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Erro ao excluir o cliente: " + e.getMessage());
        }

    }

    public static void main(String[] args) {
        new ExcluirClienteInterface();
    }
}
