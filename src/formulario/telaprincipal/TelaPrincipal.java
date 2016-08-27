package formulario.telaprincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import excecoes.TelaAbertaException;
import formulario.gerencia.TelaGerencia;
import formulario.vendaDeIngressos.TelaVenda;

/**
 * Coloca os listeners no bot�es da tela principal.
 * 
 * @author jfpsb
 *
 */
public class TelaPrincipal extends TelaPrincipalControles {

	private static final long serialVersionUID = 1L;

	private TelaGerencia telaGerencia;
	private TelaVenda telaVenda;

	/**
	 * Construtor que configura listeners em bot�es.
	 */
	public TelaPrincipal() {
		// btnVendas
		btnVendas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					checaTelaAberta(telaVenda);
					telaVenda = new TelaVenda();
					telaVenda.mostrarTela();
				}catch (TelaAbertaException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro em op��es de ger�ncia!",
							JOptionPane.ERROR_MESSAGE);
				} finally {
					telaVenda.setState(JFrame.NORMAL);
					telaVenda.toFront();
				}
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
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro em op��es de ger�ncia!",
							JOptionPane.ERROR_MESSAGE);
				} finally {
					telaGerencia.setState(JFrame.NORMAL);
					telaGerencia.toFront();
				}
			}

		});
	}

	/**
	 * Checa se a tela est� aberta no momento. Se sim, � lan�ada a exce��o.
	 * 
	 * @throws TelaAbertaException
	 */
	private void checaTelaAberta(JFrame internalFrame) throws TelaAbertaException {
		if (internalFrame != null && (internalFrame.isVisible() || internalFrame.isDisplayable()))
			throw new TelaAbertaException("Uma inst�ncia desta tela j� est� aberta.");
	}
}
