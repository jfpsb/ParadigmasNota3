package formulario.gerencia.sala;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

import excecoes.TelaAbertaException;
import formulario.gerencia.TelaBaseEntidadeControles;
import outrasclasses.ChecarTela;

/**
 * Tela que vai conter as op��es de atualizar, deletar e cadastrar novas salas.
 * 
 * @author jfpsb
 *
 */
public class TelaSala extends TelaBaseEntidadeControles {
	private static final long serialVersionUID = 1L;
	
	private JInternalFrame owner = this;

	private TelaSalaCadastro cadastrarSala;

	/**
	 * Chama construtor da superclasse e adiciona listeners aos bot�es.
	 */
	public TelaSala() {
		super("Op��es de Salas");
		
		btnCadastrarNovo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					ChecarTela.checaTelaAberta(cadastrarSala);

					cadastrarSala = new TelaSalaCadastro();

					cadastrarSala.mostrarTela();
				} catch (TelaAbertaException e1) {
					JOptionPane.showMessageDialog(owner, e1.getMessage(), "Erro em op��es de cadastro de filmes!",
							JOptionPane.ERROR_MESSAGE);
				} finally {
					cadastrarSala.setState(JFrame.NORMAL);
					cadastrarSala.toFront();
				}
			}

		});
	}

}
