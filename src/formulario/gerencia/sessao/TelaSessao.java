package formulario.gerencia.sessao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import excecoes.TelaAbertaException;
import formulario.gerencia.TelaBaseEntidadeControles;
import outrasclasses.ChecarTela;

/**
 * Tela que vai conter as op��es de atualizar, deletar e cadastrar novas
 * sess�es.
 * 
 * @author jfpsb
 *
 */
public class TelaSessao extends TelaBaseEntidadeControles {
	private static final long serialVersionUID = 1L;

	private TelaSessaoCadastro cadastrarSessao;

	/**
	 * Chama construtor da superclasse e adiciona listeners aos bot�es.
	 */
	public TelaSessao() {
		super("Op��es de Sess�o");

		btnCadastrarNovo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					ChecarTela.checaTelaAberta(cadastrarSessao);

					cadastrarSessao = new TelaSessaoCadastro();

					cadastrarSessao.mostrarTela();
				} catch (TelaAbertaException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro em op��es de cadastro de filmes!",
							JOptionPane.ERROR_MESSAGE);
				} finally {
					cadastrarSessao.setState(JFrame.NORMAL);
					cadastrarSessao.toFront();
				}
			}

		});
	}

}
