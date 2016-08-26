package formulario.gerencia.funcionarios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import excecoes.TelaAbertaException;
import formulario.gerencia.TelaBaseEntidadeControles;

/**
 * Tela que vai conter as opções de atualizar, deletar e cadastrar novos funcionários.
 * 
 * @author jfpsb
 *
 */
public class TelaFuncionario extends TelaBaseEntidadeControles {
	private static final long serialVersionUID = 1L;
	
	private TelaFuncionarioCadastro cadastrarFuncionario;

	/**
	 * Chama construtor da superclasse e adiciona listeners aos botões.
	 */
	public TelaFuncionario() {
		super("Opcões de Funcionários");

		btnCadastrarNovo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					checaTelaAberta(cadastrarFuncionario);

					cadastrarFuncionario = new TelaFuncionarioCadastro();

					cadastrarFuncionario.mostrarTela();
				} catch (TelaAbertaException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro em opções de cadastro de filmes!",
							JOptionPane.ERROR_MESSAGE);
				} finally {
					cadastrarFuncionario.setState(JFrame.NORMAL);
					cadastrarFuncionario.toFront();
				}
			}

		});
	}

	/**
	 * Checa se a tela está aberta no momento. Se sim, é lançada a exceção.
	 * 
	 * @throws TelaAbertaException
	 */
	private void checaTelaAberta(JFrame frame) throws TelaAbertaException {
		if (frame != null && (frame.isVisible() || frame.isDisplayable()))
			throw new TelaAbertaException("Uma instância desta tela já está aberta.");
	}

}
