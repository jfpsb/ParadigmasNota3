package formulario.gerencia.sessao;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

/**
 * Tela onde ficarão controles das opções de sessões (cadastro, atualizar, etc).
 * Estende de JInteralFrame porque vai ser um formulário que vai abrir dentro de
 * outro (MDI)
 * 
 * @author jfpsb
 *
 */
public class TelaSessaoControles extends JInternalFrame {
	private static final long serialVersionUID = 1L;

	private JPanel panelPrincipalTelaSessao;

	public TelaSessaoControles() {
		super("Opções De Sessões");
		inicializarControles();
	}

	public void inicializarControles() {
		panelPrincipalTelaSessao = new JPanel();

		panelPrincipalTelaSessao.add(new JButton("AEHOOOOOO"));

		// telaFilmes
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(new Dimension(640, 360));
		this.setClosable(true);
		this.add(panelPrincipalTelaSessao);
	}

	/**
	 * Abre tela.
	 */
	public void mostrarTela() {
		this.setVisible(true);
	}
}
