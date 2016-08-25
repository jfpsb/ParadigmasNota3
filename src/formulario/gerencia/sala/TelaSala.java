package formulario.gerencia.sala;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

import excecoes.TelaAbertaException;
import formulario.gerencia.TelaBaseEntidadeControles;

public class TelaSala extends TelaBaseEntidadeControles {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JInternalFrame owner = this;

	private TelaSalaCadastro cadastrarSala;

	public TelaSala() {
		super("Op��es de Salas");
		
		btnCadastrarNovo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					checaTelaAberta(cadastrarSala);

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
