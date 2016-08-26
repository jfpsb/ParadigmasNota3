package formulario.gerencia.sala;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

/**
 * Classe onde são configurados os listeners da tela de cadastro de salas.
 * 
 * @author jfpsb
 *
 */
public class TelaSalaCadastro extends TelaSalaCadastroControles {
	private static final long serialVersionUID = 1L;

	/**
	 * Chama construtor da superclasse e adiciona listeners aos botões.
	 */
	public TelaSalaCadastro() {
		super();

		btnCadastrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String nome;
				int nCol, nLin;

				try {
					nome = txtNome.getText();
					nCol = Integer.parseInt(txtColunas.getText());
					nLin = Integer.parseInt(txtLinhas.getText());

					if (nome.isEmpty())
						throw new IllegalArgumentException("O nome tem que ser informado.");

					// TODO Implementar o código para salvar no BD

					JOptionPane.showMessageDialog(null, "Nome: " + nome + "\nColunas: " + nCol + "\nLinhas: " + nLin);
				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null, "Número informado inválido.", "Erro em dados digitados!",
							JOptionPane.ERROR_MESSAGE);
				} catch (IllegalArgumentException iae) {
					JOptionPane.showMessageDialog(null, iae.getMessage(), "Erro em dados digitados!",
							JOptionPane.ERROR_MESSAGE);
				}
			}

		});
	}

}
