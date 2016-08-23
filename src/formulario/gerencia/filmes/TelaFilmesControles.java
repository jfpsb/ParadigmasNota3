package formulario.gerencia.filmes;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

/**
 * Tela onde ficarão controles das opções de filme (cadastro, atualizar, etc).
 * Estende de JInteralFrame porque vai ser um formulário que vai abrir dentro de
 * outro (MDI)
 * 
 * @author jfpsb
 *
 */
public class TelaFilmesControles extends JInternalFrame {
	private static final long serialVersionUID = 1L;

	private JPanel panelPrincipalTelaFilmes;

	public TelaFilmesControles() {
		super("Opções De Filmes");
		inicializarControles();
	}

	/**
	 * Instancia e configura elementos da UI.
	 */
	private void inicializarControles() {
		panelPrincipalTelaFilmes = new JPanel();

		panelPrincipalTelaFilmes.add(new JButton("AEHOOOOOO"));

		// telaFilmes
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(new Dimension(640, 360));
		this.setClosable(true);
		this.add(panelPrincipalTelaFilmes);
	}

	/**
	 * Abre tela.
	 */
	public void mostrarTela() {
		this.setVisible(true);
	}
}
