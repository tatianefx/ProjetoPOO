import java.awt.event.*;
import javax.swing.*;

public class JanelaSimples{
	public JanelaSimples() {
		/* Cria o botão */
		final JButton botaoLimpa = new JButton("Limpa");
		/* Cria o campo de texto */
		final JTextField campoTexto = new JTextField(10);
		/* Cria uma janela */
		final JFrame janela = new JFrame ("Janela Simples");
		janela.setSize(300,100);
		/* Adiciona os componentes na janela */
		JPanel painel = new JPanel();
		painel.add (botaoLimpa);
		painel.add (campoTexto);
		janela.getContentPane().add(painel);
		/* Quando o usuário clicar no botao, limpa o campo de texto */
		
		botaoLimpa.addActionListener (new ActionListener() {
			public void actionPerformed (ActionEvent e) {
			campoTexto.setText("");
			}
		});
		/* Exibe a janela */
		janela.setVisible(true);
	}
}