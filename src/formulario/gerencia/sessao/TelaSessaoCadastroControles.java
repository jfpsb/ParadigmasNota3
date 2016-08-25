package formulario.gerencia.sessao;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import com.github.lgooddatepicker.components.DateTimePicker;

public class TelaSessaoCadastroControles extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel panelPrincipal;
	private SpringLayout springLayout;
	private JLabel lblSala;
	private JLabel lblFilme;
	private JLabel lblData;
	private JLabel legendado;
	private JLabel tresD;
	private JLabel preco;
	protected JComboBox cmbSala;
	protected JComboBox cmbFilme;
	protected DateTimePicker datePicker;
	protected JCheckBox chkLegendado;
	protected JCheckBox chkTresD;
	protected JTextField txtPreco;
	protected JButton btnCadastrar;

	public TelaSessaoCadastroControles() {
		super("Cadastro de Sessões");
		inicializarControles();
	}

	/**
	 * Inicializa e instancia elementos da UI.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void inicializarControles() {
		springLayout = new SpringLayout();
		panelPrincipal = new JPanel(springLayout);

		String[] placeholder1 = { "placeholder1", "placeholder1", "placeholder1", "placeholder1" };
		String[] placeholder2 = { "placeholder2", "placeholder2", "placeholder2", "placeholder2" };

		lblSala = new JLabel("Sala:");
		lblFilme = new JLabel("Filme:");
		lblData = new JLabel("Data:");
		legendado = new JLabel("Legendado:");
		tresD = new JLabel("3D:");
		preco = new JLabel("Preço:");
		cmbSala = new JComboBox(placeholder1);
		cmbFilme = new JComboBox(placeholder2);
		datePicker = new DateTimePicker();
		chkLegendado = new JCheckBox();
		chkTresD = new JCheckBox();
		txtPreco = new JTextField(20);
		btnCadastrar = new JButton("Cadastrar");
		
		cmbSala.setPrototypeDisplayValue("----------------------");
		cmbFilme.setPrototypeDisplayValue("----------------------");
		
		lblSala.setFont(lblSala.getFont().deriveFont(16F));
		lblFilme.setFont(lblFilme.getFont().deriveFont(16F));
		lblData.setFont(lblData.getFont().deriveFont(16F));
		btnCadastrar.setFont(btnCadastrar.getFont().deriveFont(18F));

		// lblSala e cmbSala
		springLayout.putConstraint(SpringLayout.WEST, lblSala, 20, SpringLayout.WEST, panelPrincipal);
		springLayout.putConstraint(SpringLayout.NORTH, lblSala, 10, SpringLayout.NORTH, panelPrincipal);

		springLayout.putConstraint(SpringLayout.WEST, cmbSala, 80, SpringLayout.WEST, panelPrincipal);
		springLayout.putConstraint(SpringLayout.NORTH, cmbSala, 10, SpringLayout.NORTH, panelPrincipal);

		// lblFilme e cmbFilme
		springLayout.putConstraint(SpringLayout.WEST, lblFilme, 20, SpringLayout.WEST, panelPrincipal);
		springLayout.putConstraint(SpringLayout.NORTH, lblFilme, 10, SpringLayout.SOUTH, cmbSala);

		springLayout.putConstraint(SpringLayout.WEST, cmbFilme, 80, SpringLayout.WEST, panelPrincipal);
		springLayout.putConstraint(SpringLayout.NORTH, cmbFilme, 10, SpringLayout.SOUTH, cmbSala);

		panelPrincipal.setBorder(BorderFactory.createTitledBorder("CADASTRO DE SESSÃO"));

		panelPrincipal.add(lblSala);
		panelPrincipal.add(cmbSala);
		panelPrincipal.add(lblFilme);
		panelPrincipal.add(cmbFilme);
		// panelPrincipal.add(btnCadastrar);

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setMinimumSize(new Dimension(550, 350));
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
