package formulario.gerencia;

import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class TelaBaseEntidadeControles extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel panelPrincipal;
	private JButton btnCadastrarNovo;
	private JMenuBar menuBar;

	public TelaBaseEntidadeControles(String titulo) {
		super(titulo);
		inicializarControles();
	}

	/**
	 * Instancia e configura elementos da UI.
	 */
	private void inicializarControles() {
		panelPrincipal = new JPanel(new GridBagLayout());
		menuBar = new JMenuBar();
		btnCadastrarNovo = new JButton("Cadastrar Novo");

		btnCadastrarNovo.setBackground(new Color(240, 240, 240));
		btnCadastrarNovo.setFont(btnCadastrarNovo.getFont().deriveFont(14f));

		menuBar.add(btnCadastrarNovo);

		this.setJMenuBar(menuBar);

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.pack();
		this.setClosable(true);
		this.setIconifiable(true);
		this.add(panelPrincipal);
	}

	/**
	 * Abre tela.
	 */
	public void mostrarTela() {
		this.setVisible(true);
	}
}
