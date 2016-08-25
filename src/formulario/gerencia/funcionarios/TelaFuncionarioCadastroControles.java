package formulario.gerencia.funcionarios;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class TelaFuncionarioCadastroControles extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel panelPrincipal;
	private SpringLayout springLayout;
	private JLabel lblNome;
	protected JTextField txtNome;
	protected JButton btnCadastrar;

	public TelaFuncionarioCadastroControles() {
		super("Cadastro de Funcionários");
		inicializarControles();
	}

	/**
	 * Inicializa e instancia elementos da UI.
	 */
	private void inicializarControles() {
		springLayout = new SpringLayout();
		panelPrincipal = new JPanel(springLayout);

		lblNome = new JLabel("Nome:");
		txtNome = new JTextField(20);
		btnCadastrar = new JButton("Cadastrar");

		lblNome.setFont(lblNome.getFont().deriveFont(16F));
		btnCadastrar.setFont(btnCadastrar.getFont().deriveFont(18F));

		// lblNome e txtNome
		springLayout.putConstraint(SpringLayout.WEST, lblNome, 20, SpringLayout.WEST, panelPrincipal);
		springLayout.putConstraint(SpringLayout.NORTH, lblNome, 10, SpringLayout.NORTH, panelPrincipal);

		springLayout.putConstraint(SpringLayout.WEST, txtNome, 120, SpringLayout.WEST, panelPrincipal);
		springLayout.putConstraint(SpringLayout.NORTH, txtNome, 10, SpringLayout.NORTH, panelPrincipal);

		// btnCadastrar
		springLayout.putConstraint(SpringLayout.WEST, btnCadastrar, 141, SpringLayout.WEST, panelPrincipal);
		springLayout.putConstraint(SpringLayout.NORTH, btnCadastrar, 15, SpringLayout.SOUTH, txtNome);
		
		panelPrincipal.setBorder(BorderFactory.createTitledBorder("CADASTRO DE FUNCIONÁRIO"));
		
		panelPrincipal.add(lblNome);
		panelPrincipal.add(txtNome);
		panelPrincipal.add(btnCadastrar);
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setMinimumSize(new Dimension(400, 150));
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
