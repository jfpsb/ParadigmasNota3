package formulario.gerencia.filmes;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class TelaFilmeCadastro extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel panelPrincipal;
	private SpringLayout springLayout;
	private JLabel lblNome;
	private JLabel lblSinopse;
	private JLabel lblImagem;
	private JLabel lblDuracao;
	protected JTextField txtNome;
	protected JTextField txtSinopse;
	protected JTextField txtImagem;
	protected JTextField txtDuracao;

	public TelaFilmeCadastro() {
		super("Cadastro de Filmes");
		inicializarControles();
	}

	private void inicializarControles() {
		springLayout = new SpringLayout();
		panelPrincipal = new JPanel(springLayout);
		
		lblNome = new JLabel("Nome:");
		lblSinopse = new JLabel("Sinopse:");
		lblImagem = new JLabel("Imagem:");
		lblDuracao = new JLabel("Duração:");
		
		txtNome = new JTextField(45);
		txtSinopse = new JTextField(200);
		txtImagem = new JTextField(250);
		txtDuracao = new JTextField(3);
		
		lblNome.setFont(lblNome.getFont().deriveFont(16F));
		lblSinopse.setFont(lblSinopse.getFont().deriveFont(16F));
		lblImagem.setFont(lblImagem.getFont().deriveFont(16F));
		lblDuracao.setFont(lblDuracao.getFont().deriveFont(16F));
		
		// txtNome e lblNome
		springLayout.putConstraint(SpringLayout.WEST, lblNome, 20, SpringLayout.WEST, panelPrincipal);
		springLayout.putConstraint(SpringLayout.NORTH, lblNome, 10, SpringLayout.NORTH, panelPrincipal);
		
		springLayout.putConstraint(SpringLayout.WEST, txtNome, 20, SpringLayout.EAST, lblNome);
		springLayout.putConstraint(SpringLayout.NORTH, txtNome, 10, SpringLayout.NORTH, panelPrincipal);
		
		// txtSinopse e lblSinopse
		springLayout.putConstraint(SpringLayout.WEST, lblSinopse, 20, SpringLayout.WEST, panelPrincipal);
		springLayout.putConstraint(SpringLayout.NORTH, lblSinopse, 10, SpringLayout.SOUTH, lblNome);
		
		springLayout.putConstraint(SpringLayout.WEST, txtSinopse, 20, SpringLayout.EAST, lblSinopse);
		springLayout.putConstraint(SpringLayout.NORTH, lblSinopse, 10, SpringLayout.SOUTH, txtNome);
		
		springLayout.putConstraint(SpringLayout.WEST, lblImagem, 20, SpringLayout.WEST, panelPrincipal);
		springLayout.putConstraint(SpringLayout.NORTH, lblImagem, 10, SpringLayout.SOUTH, lblSinopse);
		
		springLayout.putConstraint(SpringLayout.WEST, lblDuracao, 20, SpringLayout.WEST, panelPrincipal);
		springLayout.putConstraint(SpringLayout.NORTH, lblDuracao, 10, SpringLayout.SOUTH, lblImagem);
		
		panelPrincipal.setBorder(BorderFactory.createTitledBorder("CADASTRO DE FILME"));
		
		panelPrincipal.add(lblNome);
		panelPrincipal.add(txtNome);
		panelPrincipal.add(lblSinopse);
		panelPrincipal.add(txtSinopse);
		panelPrincipal.add(lblImagem);
		panelPrincipal.add(txtImagem);
		panelPrincipal.add(lblDuracao);
		panelPrincipal.add(txtDuracao);

		// telaFilmeCadastro
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(new Dimension(640, 360));
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
