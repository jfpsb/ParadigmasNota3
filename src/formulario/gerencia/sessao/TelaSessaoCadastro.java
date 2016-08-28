package formulario.gerencia.sessao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

import javax.swing.JOptionPane;

import aplicacao.manager.SessaoManager;

/**
 * Classe onde s�o configurados os listeners da tela de cadastro de sess�es.
 * 
 * @author jfpsb
 *
 */
public class TelaSessaoCadastro extends TelaSessaoCadastroControles {
	private static final long serialVersionUID = 1L;

	/**
	 * Chama construtor da superclasse e adiciona listeners aos bot�es.
	 */
	public TelaSessaoCadastro(TelaSessao telaSessao) {
		super();

		btnCadastrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int idSala, idFilme;
				LocalDateTime data;
				boolean isLegendado, is3d;
				double preco;

				try {
					idSala = cmbSala.getSelectedIndex();
					idFilme = cmbFilme.getSelectedIndex();
					data = datePicker.getDateTimeStrict();
					isLegendado = chkLegendado.isSelected();
					is3d = chk3D.isSelected();
					preco = Double.parseDouble(txtPreco.getText());

					if(!SessaoManager.criarSess�o(salas.get(idSala), filmes.get(idFilme), data, isLegendado, is3d, preco)){
						JOptionPane.showMessageDialog(null, "Conflito de Hor�rios!","Erro ao Inserir", 
								JOptionPane.ERROR_MESSAGE);
						return ;
					}

					JOptionPane.showMessageDialog(null, "Sala: " + idSala + "\nFilme: " + idFilme + "\nData: " + data
							+ "\nLegendado: " + isLegendado + "\n3D: " + is3d + "\nPre�o: " + preco);
					telaSessao.createTable();
					dispose();
				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null, "N�mero informado inv�lido.", "Erro em dados digitados!",
							JOptionPane.ERROR_MESSAGE);
				} catch (IllegalArgumentException iae) {
					JOptionPane.showMessageDialog(null, iae.getMessage(), "Erro em dados digitados!",
							JOptionPane.ERROR_MESSAGE);
				}
			}

		});
	}
}
