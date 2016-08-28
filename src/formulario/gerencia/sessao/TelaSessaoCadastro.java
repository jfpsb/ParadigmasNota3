package formulario.gerencia.sessao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

import javax.swing.JOptionPane;

/**
 * Classe onde são configurados os listeners da tela de cadastro de sessões.
 * 
 * @author jfpsb
 *
 */
public class TelaSessaoCadastro extends TelaSessaoCadastroControles {
	private static final long serialVersionUID = 1L;

	/**
	 * Chama construtor da superclasse e adiciona listeners aos botões.
	 */
	public TelaSessaoCadastro(TelaSessao telaSessao) {
		super();

		btnCadastrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int idSala, idFilme;
				LocalDateTime data;
				boolean legendado, tresD;
				double preco;

				try {
					idSala = cmbSala.getSelectedIndex();
					idFilme = cmbFilme.getSelectedIndex();
					data = datePicker.getDateTimeStrict();
					legendado = chkLegendado.isSelected();
					tresD = chk3D.isSelected();
					preco = Double.parseDouble(txtPreco.getText());

					// TODO colocar o método de salvar em BD

					JOptionPane.showMessageDialog(null, "Sala: " + idSala + "\nFilme: " + idFilme + "\nData: " + data
							+ "\nLegendado: " + legendado + "\n3D: " + tresD + "\nPreço: " + preco);
					telaSessao.createTable();
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
