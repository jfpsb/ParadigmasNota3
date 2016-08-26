package formulario.gerencia.filmes;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

/**
 * Classe onde são configurados os controles da tela de cadastrar filmes.
 * 
 * @author jfpsb
 *
 */
public class TelaFilmeCadastroControles extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel panelPrincipal;
	private SpringLayout springLayout;
	private JLabel lblNome;
	private JLabel lblSinopse;
	private JLabel lblImagem;
	private JLabel lblDuracao;
	protected JTextField txtNome;
	protected JTextArea txtSinopse;
	protected JTextField txtImagem;
	protected JTextField txtDuracao;
	protected JButton btnCadastrar;
	protected JButton btnEscolherArquivo;
	private JScrollPane scrollPane;

	/**
	 * Chama construtor da superclasse e inicializa elementos da UI.
	 */
	public TelaFilmeCadastroControles() {
		super("Cadastro de Filmes");
		inicializarControles();
	}

	/**
	 * Inicializa e instancia elementos da UI.
	 */
	private void inicializarControles() {
		springLayout = new SpringLayout();
		panelPrincipal = new JPanel(springLayout);

		lblNome = new JLabel("Nome:");
		lblSinopse = new JLabel("Sinopse:");
		lblImagem = new JLabel("Imagem:");
		lblDuracao = new JLabel("Duração:");

		txtNome = new JTextField(30);
		txtSinopse = new JTextArea(5, 30);
		txtImagem = new JTextField(20);
		txtDuracao = new JTextField(10);

		txtSinopse.setLineWrap(true);

		scrollPane = new JScrollPane(txtSinopse);

		btnCadastrar = new JButton("Cadastrar");
		btnEscolherArquivo = new JButton("Escolher");

		txtImagem.setEditable(false);

		lblNome.setFont(lblNome.getFont().deriveFont(16F));
		lblSinopse.setFont(lblSinopse.getFont().deriveFont(16F));
		lblImagem.setFont(lblImagem.getFont().deriveFont(16F));
		lblDuracao.setFont(lblDuracao.getFont().deriveFont(16F));
		btnCadastrar.setFont(btnCadastrar.getFont().deriveFont(18F));
		btnEscolherArquivo.setFont(btnEscolherArquivo.getFont().deriveFont(12F));

		// txtNome e lblNome
		springLayout.putConstraint(SpringLayout.WEST, lblNome, 20, SpringLayout.WEST, panelPrincipal);
		springLayout.putConstraint(SpringLayout.NORTH, lblNome, 10, SpringLayout.NORTH, panelPrincipal);

		springLayout.putConstraint(SpringLayout.WEST, txtNome, 110, SpringLayout.WEST, panelPrincipal);
		springLayout.putConstraint(SpringLayout.NORTH, txtNome, 10, SpringLayout.NORTH, panelPrincipal);

		// txtSinopse e lblSinopse
		springLayout.putConstraint(SpringLayout.WEST, lblSinopse, 20, SpringLayout.WEST, panelPrincipal);
		springLayout.putConstraint(SpringLayout.NORTH, lblSinopse, 10, SpringLayout.SOUTH, lblNome);

		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 110, SpringLayout.WEST, panelPrincipal);
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 10, SpringLayout.SOUTH, lblNome);

		// lblImagem e txtImagem
		springLayout.putConstraint(SpringLayout.WEST, lblImagem, 20, SpringLayout.WEST, panelPrincipal);
		springLayout.putConstraint(SpringLayout.NORTH, lblImagem, 10, SpringLayout.SOUTH, scrollPane);

		springLayout.putConstraint(SpringLayout.WEST, txtImagem, 110, SpringLayout.WEST, panelPrincipal);
		springLayout.putConstraint(SpringLayout.NORTH, txtImagem, 10, SpringLayout.SOUTH, scrollPane);

		// lblDuracao e txtDuracao
		springLayout.putConstraint(SpringLayout.WEST, lblDuracao, 20, SpringLayout.WEST, panelPrincipal);
		springLayout.putConstraint(SpringLayout.NORTH, lblDuracao, 10, SpringLayout.SOUTH, lblImagem);

		springLayout.putConstraint(SpringLayout.WEST, txtDuracao, 110, SpringLayout.WEST, panelPrincipal);
		springLayout.putConstraint(SpringLayout.NORTH, txtDuracao, 10, SpringLayout.SOUTH, txtImagem);

		// btnCadastrar
		springLayout.putConstraint(SpringLayout.WEST, btnCadastrar, 186, SpringLayout.WEST, panelPrincipal);
		springLayout.putConstraint(SpringLayout.NORTH, btnCadastrar, 15, SpringLayout.SOUTH, txtDuracao);

		// btnEscolherArquivo
		springLayout.putConstraint(SpringLayout.WEST, btnEscolherArquivo, 5, SpringLayout.EAST, txtImagem);
		springLayout.putConstraint(SpringLayout.NORTH, btnEscolherArquivo, 6, SpringLayout.SOUTH, scrollPane);

		panelPrincipal.setBorder(BorderFactory.createTitledBorder("CADASTRO DE FILME"));

		panelPrincipal.add(lblNome);
		panelPrincipal.add(txtNome);
		panelPrincipal.add(lblSinopse);
		panelPrincipal.add(scrollPane);
		panelPrincipal.add(lblImagem);
		panelPrincipal.add(txtImagem);
		panelPrincipal.add(lblDuracao);
		panelPrincipal.add(txtDuracao);
		panelPrincipal.add(btnCadastrar);
		panelPrincipal.add(btnEscolherArquivo);

		// telaFilmeCadastro
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setMinimumSize(new Dimension(490, 300));
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
