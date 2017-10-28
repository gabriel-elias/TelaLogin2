package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import etec.persistence.LoginDAO;

public class Login extends JFrame {

	private JLabel usuario = new JLabel("Usuario");
	private JTextField CampoLogin = new JTextField();
	private JLabel senha = new JLabel("Senha");
	private JPasswordField campoSenha = new JPasswordField();
	private JButton btnEntrar = new JButton("ENTRAR");

	public Login() throws ClassNotFoundException, SQLException {

		super("TELA DE LOGIN");
		Container paine = this.getContentPane();
		paine.setLayout(null);

		paine.add(usuario);
		paine.add(CampoLogin);
		paine.add(senha);
		paine.add(campoSenha);
		paine.add(btnEntrar);

		usuario.setBounds(10, 20, 150, 25);
		CampoLogin.setBounds(60, 20, 150, 25);
		senha.setBounds(10, 50, 150, 25);
		campoSenha.setBounds(60, 50, 150, 25);
		btnEntrar.setBounds(80, 100, 100, 25);

		this.setVisible(true);
		this.setSize(250, 200);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		btnEntrar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				LoginDAO dao = new LoginDAO(null);
				try {
					if (dao.checkLogin(CampoLogin.getText(), String.valueOf(campoSenha.getPassword()))) {
						dispose();
						
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao validar: " + e1);
				}

			}
		});
	}
}
