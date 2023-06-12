import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Menu extends JFrame {

    public Menu() {
        setTitle("Exemplo de Lista de Botões");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Criação dos botões
        JButton botao1 = new JButton("Cadastrar cliente");
        JButton botao2 = new JButton("Exibir informações do cliente");
        JButton botao3 = new JButton("Excluir cliente");

        // Adiciona os botões ao JFrame
        add(botao1);
        add(botao2);
        add(botao3);

        pack();
        setVisible(true);



        botao1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new programa().cadastrarCliente();
            }
        });

        botao2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new programa().exibirInformacoesCliente();
            }
        });

        botao3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new programa().excluirCliente();
            }
        });

    }


    public static void main(String[] args) {
        new Menu() ;
    }
}
