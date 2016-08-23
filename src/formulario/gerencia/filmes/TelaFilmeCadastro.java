package formulario.gerencia.filmes;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaFilmeCadastro extends JInternalFrame {
	private static final long serialVersionUID = 1L;

	private JPanel panelPrincipal;

	public TelaFilmeCadastro() {
		super("Cadastro de Filme");
		inicializarControles();
	}

	private void inicializarControles() {
		panelPrincipal = new JPanel();

		panelPrincipal.add(new JLabel("CADASTRO"));

		// telaFilmeCadastro
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(new Dimension(640, 360));
		this.setClosable(true);
		this.add(panelPrincipal);
	}

	/**
	 * Abre tela.
	 */
	public void mostrarTela() {
		this.setVisible(true);
	}
}
