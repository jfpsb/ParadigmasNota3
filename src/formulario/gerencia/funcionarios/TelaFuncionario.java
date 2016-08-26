package formulario.gerencia.funcionarios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import excecoes.TelaAbertaException;
import formulario.gerencia.TelaBaseEntidadeControles;

/**
 * Tela que vai conter as op��es de atualizar, deletar e cadastrar novos funcion�rios.
 * 
 * @author jfpsb
 *
 */
public class TelaFuncionario extends TelaBaseEntidadeControles {
	private static final long serialVersionUID = 1L;
	
	private TelaFuncionarioCadastro cadastrarFuncionario;

	/**
	 * Chama construtor da superclasse e adiciona listeners aos bot�es.
	 */
	public TelaFuncionario() {
		super("Opc�es de Funcion�rios");

		btnCadastrarNovo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					checaTelaAberta(cadastrarFuncionario);

					cadastrarFuncionario = new TelaFuncionarioCadastro();

					cadastrarFuncionario.mostrarTela();
				} catch (TelaAbertaException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro em op��es de cadastro de filmes!",
							JOptionPane.ERROR_MESSAGE);
				} finally {
					cadastrarFuncionario.setState(JFrame.NORMAL);
					cadastrarFuncionario.toFront();
				}
			}

		});
	}

	/**
	 * Checa se a tela est� aberta no momento. Se sim, � lan�ada a exce��o.
	 * 
	 * @throws TelaAbertaException
	 */
	private void checaTelaAberta(JFrame frame) throws TelaAbertaException {
		if (frame != null && (frame.isVisible() || frame.isDisplayable()))
			throw new TelaAbertaException("Uma inst�ncia desta tela j� est� aberta.");
	}

}
