package formulario.gerencia.sala;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

/**
 * Tela onde ficarão controles das opções de salas (cadastro, atualizar, etc).
 * Estende de JInteralFrame porque vai ser um formulário que vai abrir dentro de
 * outro (MDI)
 * 
 * @author jfpsb
 *
 */
public class TelaSalaControles extends JInternalFrame {
	private static final long serialVersionUID = 1L;

	private JPanel panelPrincipalTelaSala;

	public TelaSalaControles() {
		super("Opções De Salas");
		inicializarControles();
	}

	public void inicializarControles() {
		panelPrincipalTelaSala = new JPanel();

		panelPrincipalTelaSala.add(new JButton("AEHOOOOOO"));

		// telaFilmes
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(new Dimension(640, 360));
		this.setClosable(true);
		this.add(panelPrincipalTelaSala);
	}

	/**
	 * Abre tela.
	 */
	public void mostrarTela() {
		this.setVisible(true);
	}
}
