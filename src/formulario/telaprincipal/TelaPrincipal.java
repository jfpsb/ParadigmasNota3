package formulario.telaprincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import excecoes.TelaAbertaException;
import formulario.gerencia.TelaGerencia;

/**
 * Coloca os listeners no botões da tela principal.
 * 
 * @author jfpsb
 *
 */
public class TelaPrincipal extends TelaPrincipalControles {

	private static final long serialVersionUID = 1L;

	private TelaGerencia telaGerencia;

	/**
	 * Construtor que configura listeners em botões.
	 */
	public TelaPrincipal() {
		// btnVendas
		btnVendas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TelaGerencia telaGerencia = new TelaGerencia(owner);
				// telaGerencia.mostrarTela();
			}

		});

		// btnGerencia
		btnGerencia.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					checaTelaAberta(telaGerencia);

					telaGerencia = new TelaGerencia();

					telaGerencia.mostrarTela();
				} catch (TelaAbertaException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro em opções de gerência!",
							JOptionPane.ERROR_MESSAGE);
				} finally {
					telaGerencia.setState(JFrame.NORMAL);
					telaGerencia.toFront();
				}
			}

		});
	}

	/**
	 * Checa se a tela está aberta no momento. Se sim, é lançada a exceção.
	 * 
	 * @throws TelaAbertaException
	 */
	private void checaTelaAberta(JFrame internalFrame) throws TelaAbertaException {
		if (internalFrame != null && (internalFrame.isVisible() || internalFrame.isDisplayable()))
			throw new TelaAbertaException("Uma instância desta tela já está aberta.");
	}
}
