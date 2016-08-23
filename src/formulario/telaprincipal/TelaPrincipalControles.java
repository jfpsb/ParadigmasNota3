package formulario.telaprincipal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

/**
 * Instancia e configura controles da tela principal da aplicação.
 * 
 * @author jfpsb
 *
 */
public class TelaPrincipalControles extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel panelPrincipal;
	private JPanel panelMenuEsquerda;
	private JPanel panelMenuEsquerda2;
	private JLabel lblOpcoes;
	private JLabel lblCinemaParadigmas;
	protected JButton btnGerencia;
	protected JButton btnVendas;

	/**
	 * Chama o método que inicializa os componentes da UI.
	 */
	public TelaPrincipalControles() {
		super("Cinema Paradigmas");
		inicializarControles();
	}

	/**
	 * Instancia e configura elementos da UI.
	 */
	private void inicializarControles() {
		panelPrincipal = new JPanel(new BorderLayout());
		panelMenuEsquerda = new JPanel();
		panelMenuEsquerda2 = new JPanel(new GridLayout(2, 1, 10, 10));
		lblOpcoes = new JLabel("Opções", SwingConstants.CENTER);
		lblCinemaParadigmas = new JLabel("Cinema Paradigmas", SwingConstants.CENTER);
		btnVendas = new JButton("Venda De Ingressos");
		btnGerencia = new JButton("Gerência");

		// lblOpcoes
		lblOpcoes.setFont(lblOpcoes.getFont().deriveFont(24F));

		// lblCinemaParadigmas
		lblCinemaParadigmas.setFont(lblCinemaParadigmas.getFont().deriveFont(64F));

		// btnVendas
		btnVendas.setFont(btnVendas.getFont().deriveFont(26F));
		btnVendas.setPreferredSize(new Dimension(300, 150));

		// btnFilmes
		btnGerencia.setFont(btnGerencia.getFont().deriveFont(26F));

		// panelMenuEsquerda2
		panelMenuEsquerda2.add(btnVendas);
		panelMenuEsquerda2.add(btnGerencia);
		panelMenuEsquerda2.setBackground(new Color(204, 255, 255));

		// panelMenuEsquerda
		panelMenuEsquerda.setBorder(BorderFactory.createTitledBorder("Opções"));
		((TitledBorder) panelMenuEsquerda.getBorder()).setTitleFont(new Font("Arial", Font.BOLD, 24));
		panelMenuEsquerda.setBackground(new Color(204, 255, 255));
		panelMenuEsquerda.add(panelMenuEsquerda2);

		// panelPrincipal
		panelPrincipal.setBackground(new Color(204, 255, 255));
		panelPrincipal.add(lblCinemaParadigmas);
		panelPrincipal.add(panelMenuEsquerda, BorderLayout.WEST);

		// telaPrincipal
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setMinimumSize(new Dimension(1000, 395));
		this.pack();
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.add(panelPrincipal);
	}

	/**
	 * Abre tela.
	 */
	public void mostrarTela() {
		this.setVisible(true);
	}
}
