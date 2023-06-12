import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class App extends JFrame {
    private JTextField campoLogin;
    private JPasswordField campoSenha;
    private JButton botaoEntrar;

    public App () {
        setTitle("Autenticação");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel labelLogin = new JLabel("Login:");
        campoLogin = new JTextField(20);

        JLabel labelSenha = new JLabel("Senha:");
        campoSenha = new JPasswordField(20);

        botaoEntrar = new JButton("Entrar");
        botaoEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = campoLogin.getText();
                String senha = new String(campoSenha.getPassword());

                programa programa = new programa();

                programa.programa();

                programa.exibirMenu();
            }
        });

        add(labelLogin);
        add(campoLogin);
        add(labelSenha);
        add(campoSenha);
        add(botaoEntrar);

        pack();
        setVisible(true);
    }


        public static void main (String[]args){
        new App();
            programa programa = new programa();
            programa.executar();
        }
    }