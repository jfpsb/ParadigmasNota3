package formulario.gerencia.sessao;

import java.awt.Dimension;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.components.DateTimePicker;
import com.github.lgooddatepicker.components.TimePickerSettings;

import aplicacao.manager.FilmesManager;
import aplicacao.manager.SalasManager;
import entidades.Filme;
import entidades.Sala;

/**
 * Classe onde são configurados os controles da tela de cadastrar sessões.
 * 
 * @author jfpsb
 *
 */
public class TelaSessaoCadastroControles extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel panelPrincipal;
	private SpringLayout springLayout;
	private JLabel lblSala;
	private JLabel lblFilme;
	private JLabel lblData;
	private JLabel lblLegendado;
	private JLabel lbl3D;
	private JLabel lblPreco;
	protected JComboBox<String> cmbSala;
	protected JComboBox<String> cmbFilme;
	protected DateTimePicker datePicker;
	private DatePickerSettings dateSettings;
	private TimePickerSettings timeSettings;
	protected JCheckBox chkLegendado;
	protected JCheckBox chk3D;
	protected JTextField txtPreco;
	protected JButton btnCadastrar;
	protected List<Filme> filmes;
	protected List<Sala> salas;

	/**
	 * Chama construtor da superclasse e inicializa elementos da UI.
	 */
	public TelaSessaoCadastroControles() {
		super("Cadastro de Sessões");
		inicializarControles();
	}

	/**
	 * Inicializa e instancia elementos da UI.
	 */
	private void inicializarControles() {
		filmes = FilmesManager.listarFilmes();
		salas = SalasManager.listarSalas();
		
		springLayout = new SpringLayout();
		panelPrincipal = new JPanel(springLayout);

		String[] placeholder1 = new String[salas.size()];
		int i = 0;
		for(Sala s : salas){
			placeholder1[i] = s.getNome();
			i++;
		}
		String[] placeholder2 = new String[filmes.size()];
		i = 0;
		for(Filme f : filmes){
			placeholder2[i] = f.getNome();
			i++;
		}

		dateSettings = new DatePickerSettings();
		timeSettings = new TimePickerSettings();
		dateSettings.setAllowEmptyDates(false);
		timeSettings.setAllowEmptyTimes(false);

		lblSala = new JLabel("Sala:");
		lblFilme = new JLabel("Filme:");
		lblData = new JLabel("Data:");
		lblLegendado = new JLabel("Legendado:");
		lbl3D = new JLabel("3D:");
		lblPreco = new JLabel("Preço:");
		cmbSala = new JComboBox<String>(placeholder1);
		cmbFilme = new JComboBox<String>(placeholder2);
		datePicker = new DateTimePicker(dateSettings, timeSettings);
		dateSettings = new DatePickerSettings();
		chkLegendado = new JCheckBox();
		chk3D = new JCheckBox();
		txtPreco = new JTextField(10);
		btnCadastrar = new JButton("Cadastrar");

		cmbSala.setPrototypeDisplayValue("---------------------------");
		cmbFilme.setPrototypeDisplayValue("---------------------------");

		lblSala.setFont(lblSala.getFont().deriveFont(16F));
		lblFilme.setFont(lblFilme.getFont().deriveFont(16F));
		lblData.setFont(lblData.getFont().deriveFont(16F));
		lblLegendado.setFont(lblLegendado.getFont().deriveFont(16F));
		lbl3D.setFont(lbl3D.getFont().deriveFont(16F));
		lblPreco.setFont(lblPreco.getFont().deriveFont(16F));
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

		// lblData e datePicker
		springLayout.putConstraint(SpringLayout.WEST, lblData, 20, SpringLayout.WEST, panelPrincipal);
		springLayout.putConstraint(SpringLayout.NORTH, lblData, 10, SpringLayout.SOUTH, cmbFilme);

		springLayout.putConstraint(SpringLayout.WEST, datePicker, 80, SpringLayout.WEST, panelPrincipal);
		springLayout.putConstraint(SpringLayout.NORTH, datePicker, 10, SpringLayout.SOUTH, cmbFilme);

		// lblLegendado e chkLegendado
		springLayout.putConstraint(SpringLayout.WEST, lblLegendado, 20, SpringLayout.WEST, panelPrincipal);
		springLayout.putConstraint(SpringLayout.NORTH, lblLegendado, 10, SpringLayout.SOUTH, datePicker);

		springLayout.putConstraint(SpringLayout.WEST, chkLegendado, 135, SpringLayout.WEST, panelPrincipal);
		springLayout.putConstraint(SpringLayout.NORTH, chkLegendado, 10, SpringLayout.SOUTH, datePicker);

		// lbl3D e chk3D
		springLayout.putConstraint(SpringLayout.WEST, lbl3D, 20, SpringLayout.WEST, panelPrincipal);
		springLayout.putConstraint(SpringLayout.NORTH, lbl3D, 10, SpringLayout.SOUTH, chkLegendado);

		springLayout.putConstraint(SpringLayout.WEST, chk3D, 135, SpringLayout.WEST, panelPrincipal);
		springLayout.putConstraint(SpringLayout.NORTH, chk3D, 10, SpringLayout.SOUTH, chkLegendado);

		// lblPreco e txtPreco
		springLayout.putConstraint(SpringLayout.WEST, lblPreco, 20, SpringLayout.WEST, panelPrincipal);
		springLayout.putConstraint(SpringLayout.NORTH, lblPreco, 10, SpringLayout.SOUTH, chk3D);

		springLayout.putConstraint(SpringLayout.WEST, txtPreco, 135, SpringLayout.WEST, panelPrincipal);
		springLayout.putConstraint(SpringLayout.NORTH, txtPreco, 10, SpringLayout.SOUTH, chk3D);

		// btnCadastrar
		springLayout.putConstraint(SpringLayout.WEST, btnCadastrar, 191, SpringLayout.WEST, panelPrincipal);
		springLayout.putConstraint(SpringLayout.NORTH, btnCadastrar, 15, SpringLayout.SOUTH, txtPreco);

		panelPrincipal.setBorder(BorderFactory.createTitledBorder("CADASTRO DE SESSÃO"));

		panelPrincipal.add(lblSala);
		panelPrincipal.add(cmbSala);
		panelPrincipal.add(lblFilme);
		panelPrincipal.add(cmbFilme);
		panelPrincipal.add(lblData);
		panelPrincipal.add(datePicker);
		panelPrincipal.add(lblLegendado);
		panelPrincipal.add(chkLegendado);
		panelPrincipal.add(lbl3D);
		panelPrincipal.add(chk3D);
		panelPrincipal.add(lblPreco);
		panelPrincipal.add(txtPreco);
		panelPrincipal.add(btnCadastrar);

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setMinimumSize(new Dimension(500, 325));
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
