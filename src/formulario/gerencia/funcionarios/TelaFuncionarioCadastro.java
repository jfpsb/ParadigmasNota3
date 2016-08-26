package formulario.gerencia.funcionarios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

/**
 * Classe onde s�o configurados os listeners da tela de cadastro de
 * funcion�rios.
 * 
 * @author jfpsb
 *
 */
public class TelaFuncionarioCadastro extends TelaFuncionarioCadastroControles {
	private static final long serialVersionUID = 1L;

	/**
	 * Chama construtor da superclasse e adiciona listeners aos bot�es.
	 */
	public TelaFuncionarioCadastro() {
		super();

		btnCadastrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String nome;

				try {
					nome = txtNome.getText();

					if (nome.isEmpty())
						throw new IllegalArgumentException("O nome tem que ser informado.");

					// TODO Implementar o c�digo para salvar no BD

					JOptionPane.showMessageDialog(null, "Nome: " + nome);
				} catch (IllegalArgumentException iae) {
					JOptionPane.showMessageDialog(null, iae.getMessage(), "Erro em dados digitados!",
							JOptionPane.ERROR_MESSAGE);
				}
			}

		});
	}

}
