package formulario.gerencia;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Instancia e configura controles de tela de gerência.
 * 
 * @author jfpsb
 *
 */
public class TelaGerenciaControles extends JDialog {
	private static final long serialVersionUID = 1L;

	private JPanel panelPrincipalGerencia;
	private JPanel panelOpcoesSuperior;
	protected JButton btnFilmes;
	protected JButton btnFuncionarios;
	protected JButton btnSala;
	protected JButton btnSessao;
	protected JDesktopPane desktopPane;

	/**
	 * Chama o método que inicializa os componentes da UI.
	 */
	public TelaGerenciaControles(JFrame frame) {
		super(frame, "Opções De Gerência", true); // Determina owner, mensagem e
													// que o frame é modal
		inicializarControles();
	}

	/**
	 * Instancia e configura elementos da UI.
	 */
	private void inicializarControles() {
		panelPrincipalGerencia = new JPanel(new BorderLayout());
		panelOpcoesSuperior = new JPanel(new GridLayout(1, 4, 5, 5));

		desktopPane = new JDesktopPane();

		btnFilmes = new JButton("Filmes");
		btnFuncionarios = new JButton("Funcionários");
		btnSala = new JButton("Salas");
		btnSessao = new JButton("Sessões");

		// btnFilmes
		btnFilmes.setFont(btnFilmes.getFont().deriveFont(20F));

		// btnFuncionarios
		btnFuncionarios.setFont(btnFuncionarios.getFont().deriveFont(20F));

		// btnSala
		btnSala.setFont(btnSala.getFont().deriveFont(20F));

		// btnSessao
		btnSessao.setFont(btnSessao.getFont().deriveFont(20F));

		// panelOpcoesSuperior
		panelOpcoesSuperior.add(btnFilmes);
		panelOpcoesSuperior.add(btnFuncionarios);
		panelOpcoesSuperior.add(btnSala);
		panelOpcoesSuperior.add(btnSessao);

		panelPrincipalGerencia.add(panelOpcoesSuperior, BorderLayout.NORTH);
		panelPrincipalGerencia.add(desktopPane, BorderLayout.CENTER);

		// telaGerencia
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setMinimumSize(new Dimension(1280, 720));
		this.pack();
		this.setLocationRelativeTo(null);
		this.add(panelPrincipalGerencia);
	}

	/**
	 * Abre tela.
	 */
	public void mostrarTela() {
		this.setVisible(true);
	}
}
