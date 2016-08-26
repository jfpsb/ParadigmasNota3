package formulario.gerencia.sala;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

/**
 * Classe onde são configurados os controles da tela de cadastrar salas.
 * 
 * @author jfpsb
 *
 */
public class TelaSalaCadastroControles extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel panelPrincipal;
	private SpringLayout springLayout;
	private JLabel lblNome;
	private JLabel lblColunas;
	private JLabel lblLinhas;
	protected JTextField txtNome;
	protected JTextField txtColunas;
	protected JTextField txtLinhas;
	protected JButton btnCadastrar;

	/**
	 * Chama construtor da superclasse e inicializa elementos da UI.
	 */
	public TelaSalaCadastroControles() {
		super("Cadastro de Salas");
		inicializarControles();
	}

	/**
	 * Inicializa e instancia elementos da UI.
	 */
	private void inicializarControles() {
		springLayout = new SpringLayout();
		panelPrincipal = new JPanel(springLayout);

		lblNome = new JLabel("Nome:");
		lblColunas = new JLabel("Nº Colunas:");
		lblLinhas = new JLabel("Nº Linhas:");

		txtNome = new JTextField(20);
		txtColunas = new JTextField(20);
		txtLinhas = new JTextField(20);

		btnCadastrar = new JButton("Cadastrar");

		lblNome.setFont(lblNome.getFont().deriveFont(16F));
		lblColunas.setFont(lblColunas.getFont().deriveFont(16F));
		lblLinhas.setFont(lblLinhas.getFont().deriveFont(16F));
		btnCadastrar.setFont(btnCadastrar.getFont().deriveFont(18F));

		// lblNome e txtNome
		springLayout.putConstraint(SpringLayout.WEST, lblNome, 20, SpringLayout.WEST, panelPrincipal);
		springLayout.putConstraint(SpringLayout.NORTH, lblNome, 10, SpringLayout.NORTH, panelPrincipal);

		springLayout.putConstraint(SpringLayout.WEST, txtNome, 120, SpringLayout.WEST, panelPrincipal);
		springLayout.putConstraint(SpringLayout.NORTH, txtNome, 10, SpringLayout.NORTH, panelPrincipal);

		// lblColunas e txtColunas
		springLayout.putConstraint(SpringLayout.WEST, lblColunas, 20, SpringLayout.WEST, panelPrincipal);
		springLayout.putConstraint(SpringLayout.NORTH, lblColunas, 10, SpringLayout.SOUTH, lblNome);

		springLayout.putConstraint(SpringLayout.WEST, txtColunas, 120, SpringLayout.WEST, panelPrincipal);
		springLayout.putConstraint(SpringLayout.NORTH, txtColunas, 10, SpringLayout.SOUTH, lblNome);

		// lblLinhas e txtLinhas
		springLayout.putConstraint(SpringLayout.WEST, lblLinhas, 20, SpringLayout.WEST, panelPrincipal);
		springLayout.putConstraint(SpringLayout.NORTH, lblLinhas, 10, SpringLayout.SOUTH, lblColunas);

		springLayout.putConstraint(SpringLayout.WEST, txtLinhas, 120, SpringLayout.WEST, panelPrincipal);
		springLayout.putConstraint(SpringLayout.NORTH, txtLinhas, 10, SpringLayout.SOUTH, lblColunas);

		// btnCadastrar
		springLayout.putConstraint(SpringLayout.WEST, btnCadastrar, 186, SpringLayout.WEST, panelPrincipal);
		springLayout.putConstraint(SpringLayout.NORTH, btnCadastrar, 15, SpringLayout.SOUTH, txtLinhas);

		panelPrincipal.setBorder(BorderFactory.createTitledBorder("CADASTRO DE SALA"));

		panelPrincipal.add(lblNome);
		panelPrincipal.add(txtNome);
		panelPrincipal.add(lblColunas);
		panelPrincipal.add(txtColunas);
		panelPrincipal.add(lblLinhas);
		panelPrincipal.add(txtLinhas);
		panelPrincipal.add(btnCadastrar);

		// telaSalaCadastro
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setMinimumSize(new Dimension(400, 250));
		this.setLocationRelativeTo(null);
		this.add(panelPrincipal);
	}

	/**
	 * Abre tela.
	 */
	public void mostrarTela() {
		this.setVisible(true);
	}
}
