package formulario.gerencia.sala;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import aplicacao.manager.SalasManager;

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
	public TelaSalaCadastro(TelaSala telaSala) {
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
					SalasManager.criarSala(nome, nLin, nCol);
					JOptionPane.showMessageDialog(null, "Nome: " + nome + "\nColunas: " + nCol + "\nLinhas: " + nLin);
					telaSala.createTable();
					dispose();
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
