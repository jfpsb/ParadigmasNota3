package formulario.gerencia.sessao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import excecoes.TelaAbertaException;
import formulario.gerencia.TelaBaseEntidadeControles;
import outrasclasses.ChecarTela;

/**
 * Tela que vai conter as opções de atualizar, deletar e cadastrar novas
 * sessões.
 * 
 * @author jfpsb
 *
 */
public class TelaSessao extends TelaBaseEntidadeControles {
	private static final long serialVersionUID = 1L;

	private TelaSessaoCadastro cadastrarSessao;

	/**
	 * Chama construtor da superclasse e adiciona listeners aos botões.
	 */
	public TelaSessao() {
		super("Opções de Sessão");

		btnCadastrarNovo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					ChecarTela.checaTelaAberta(cadastrarSessao);

					cadastrarSessao = new TelaSessaoCadastro();

					cadastrarSessao.mostrarTela();
				} catch (TelaAbertaException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro em opções de cadastro de filmes!",
							JOptionPane.ERROR_MESSAGE);
				} finally {
					cadastrarSessao.setState(JFrame.NORMAL);
					cadastrarSessao.toFront();
				}
			}

		});
	}

}
