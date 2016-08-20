package formulario;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Primeira tela da aplicação.
 * 
 * @author jfpsb
 *
 */
public class TelaPrincipal extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel panelPrincipal;
	private JPanel panelMenuEsquerda;
	private JLabel lblOpcoes;
	private JLabel lblCinemaParadigmas;
	private JButton btnVendas;
	private JButton btnFilmes;
	private JButton btnFuncionarios;
	private JButton btnClientes;

	/**
	 * Chama o método que inicializa os componentes da UI.
	 */
	public TelaPrincipal() {
		super("Cinema Paradigmas");
		inicializarControles();
	}

	/**
	 * Instancia e configura elementos da UI.
	 */
	private void inicializarControles() {
		panelPrincipal = new JPanel(new BorderLayout());
		panelMenuEsquerda = new JPanel(new GridLayout(5, 1, 3, 3));
		lblOpcoes = new JLabel("Opções", SwingConstants.CENTER);
		lblCinemaParadigmas = new JLabel("Cinema Paradigmas", SwingConstants.CENTER);
		btnVendas = new JButton("Venda De Ingressos");
		btnFilmes = new JButton("Filmes");
		btnFuncionarios = new JButton("Funcionários");
		btnClientes = new JButton("Clientes");

		// lblOpcoes
		lblOpcoes.setFont(lblOpcoes.getFont().deriveFont(24F));

		// lblCinemaParadigmas
		lblCinemaParadigmas.setFont(lblCinemaParadigmas.getFont().deriveFont(64F));

		// btnVendas
		btnVendas.setFont(btnVendas.getFont().deriveFont(20F));

		// btnFilmes
		btnFilmes.setFont(btnFilmes.getFont().deriveFont(20F));

		// btnFuncionarios
		btnFuncionarios.setFont(btnFuncionarios.getFont().deriveFont(20F));

		// btnClientes
		btnClientes.setFont(btnClientes.getFont().deriveFont(20F));

		// panelMenuEsquerda
		panelMenuEsquerda.add(lblOpcoes);
		panelMenuEsquerda.add(btnVendas);
		panelMenuEsquerda.add(btnFilmes);
		panelMenuEsquerda.add(btnFuncionarios);
		panelMenuEsquerda.add(btnClientes);
		panelMenuEsquerda.setBackground(new Color(204, 255, 255));
		panelMenuEsquerda.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		// panelPrincipal
		panelPrincipal.setBackground(new Color(204, 255, 255));
		panelPrincipal.add(lblCinemaParadigmas);
		panelPrincipal.add(panelMenuEsquerda, BorderLayout.WEST);

		// telaPrincipal
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setMinimumSize(new Dimension(900, 360));
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
