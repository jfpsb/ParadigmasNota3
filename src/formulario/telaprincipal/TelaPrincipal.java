package formulario.telaprincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import formulario.gerencia.TelaGerencia;

/**
 * Coloca os listeners no botões da tela principal.
 * 
 * @author jfpsb
 *
 */
public class TelaPrincipal extends TelaPrincipalControles {

	private JFrame owner = this;

	private static final long serialVersionUID = 1L;

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
				TelaGerencia telaGerencia = new TelaGerencia(owner);
				telaGerencia.mostrarTela();
			}

		});
	}
}
