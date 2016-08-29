package formulario.vendaDeIngressos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import aplicacao.manager.FuncionarioManager;
import aplicacao.manager.SessaoManager;
import entidades.Funcionario;
import entidades.Reserva;
import entidades.Sessao;

public class TelaFinalizarVendaControles extends JDialog {
	private SpringLayout springLayout;

	private JPanel panelPrincipal;
	private JPanel panelSessaoEscolhida;
	private JPanel panelSuperior;
	private JPanel panelSuperior2;
	private JPanel panelInferior;
	private JPanel panelInferior2;

	private JLabel lblSessaoEscolhida;
	private JLabel lblFilme;
	private JLabel lblSala;
	private JLabel lblData;
	private JLabel lblLegendado;
	private JLabel lbl3D;
	private JLabel lblPreco;
	private JLabel lblFuncionario;
	private JLabel lblMeia;
	private JLabel lblReservasRestantes;

	protected JButton btnFinalizar;

	protected JComboBox<String> cmbFuncionarios;

	protected JCheckBox chkMeia;

	protected JTable tabelaPoltrona;

	private Sessao sessaoEscolhida;

	private ImageIcon poltronaLivreImg;
	private ImageIcon poltronaOcupadaImg;

	List<Funcionario> funcionarios;

	public TelaFinalizarVendaControles(JFrame owner, Sessao sessaoEscolhida) {
		super(owner, "Finalizar Venda de Ingresso", true);
		this.sessaoEscolhida = sessaoEscolhida;
		inicializarControles();
	}

	private void inicializarControles() {
		funcionarios = FuncionarioManager.listarFuncionarios();

		String[] funcionariosArray = new String[funcionarios.size()];

		for (int i = 0; i < funcionarios.size(); i++) {
			funcionariosArray[i] = funcionarios.get(i).getNome();
		}

		springLayout = new SpringLayout();

		panelPrincipal = new JPanel(new BorderLayout());
		panelSuperior = new JPanel(new BorderLayout());
		panelSuperior2 = new JPanel();
		panelInferior2 = new JPanel(springLayout);
		panelSessaoEscolhida = new JPanel(new GridLayout(2, 3, 5, 5));
		panelInferior = new JPanel(new BorderLayout());

		cmbFuncionarios = new JComboBox<String>(funcionariosArray);
		chkMeia = new JCheckBox();

		lblSessaoEscolhida = new JLabel("Sessão escolhida:");
		lblFilme = new JLabel("Filme: " + retornaValorEmCelula(sessaoEscolhida.getFilme().getNome()));
		lblSala = new JLabel("Sala: " + retornaValorEmCelula(sessaoEscolhida.getSala().getNome()));
		lblData = new JLabel("Data: " + retornaValorEmCelula(sessaoEscolhida.getData()));
		lblLegendado = new JLabel("Legendado: " + retornaValorEmCelula(sessaoEscolhida.isLegendado()));
		lbl3D = new JLabel("3D: " + retornaValorEmCelula(sessaoEscolhida.isIs3D()));
		lblPreco = new JLabel("Preço: " + retornaValorEmCelula(sessaoEscolhida.getPreco()));
		lblFuncionario = new JLabel("Funcionário: ");
		lblMeia = new JLabel("Meia: ");
		lblReservasRestantes = new JLabel("Reservas Restantes: " + SessaoManager.reservasRestantes(sessaoEscolhida));

		btnFinalizar = new JButton("Finalizar");

		configuraTamanhoLetras(lblSessaoEscolhida, 28F);
		configuraTamanhoLetras(lblFilme, 20F);
		configuraTamanhoLetras(lblSala, 20F);
		configuraTamanhoLetras(lblData, 20F);
		configuraTamanhoLetras(lblLegendado, 20F);
		configuraTamanhoLetras(lbl3D, 20F);
		configuraTamanhoLetras(lblPreco, 20F);
		configuraTamanhoLetras(lblFuncionario, 24F);
		configuraTamanhoLetras(lblMeia, 24F);
		configuraTamanhoLetras(cmbFuncionarios, 22F);
		configuraTamanhoLetras(btnFinalizar, 28F);
		configuraTamanhoLetras(lblReservasRestantes, 20F);

		btnFinalizar.setPreferredSize(new Dimension(150, 180));

		panelSessaoEscolhida.add(lblSala);
		panelSessaoEscolhida.add(lblFilme);
		panelSessaoEscolhida.add(lblLegendado);
		panelSessaoEscolhida.add(lbl3D);
		panelSessaoEscolhida.add(lblPreco);
		panelSessaoEscolhida.add(lblData);

		panelSuperior2.add(lblSessaoEscolhida);

		panelSuperior.add(panelSuperior2, BorderLayout.NORTH);
		panelSuperior.add(panelSessaoEscolhida, BorderLayout.CENTER);
		panelSuperior.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));

		springLayout.putConstraint(SpringLayout.WEST, lblReservasRestantes, 15, SpringLayout.WEST, panelInferior2);
		springLayout.putConstraint(SpringLayout.NORTH, lblReservasRestantes, 10, SpringLayout.NORTH, panelInferior2);

		springLayout.putConstraint(SpringLayout.WEST, lblFuncionario, 50, SpringLayout.EAST, lblReservasRestantes);
		springLayout.putConstraint(SpringLayout.NORTH, lblFuncionario, 90, SpringLayout.NORTH, panelInferior2);

		springLayout.putConstraint(SpringLayout.WEST, lblMeia, 35, SpringLayout.EAST, cmbFuncionarios);
		springLayout.putConstraint(SpringLayout.NORTH, lblMeia, 90, SpringLayout.NORTH, panelInferior2);

		springLayout.putConstraint(SpringLayout.WEST, cmbFuncionarios, 10, SpringLayout.EAST, lblFuncionario);
		springLayout.putConstraint(SpringLayout.NORTH, cmbFuncionarios, 85, SpringLayout.NORTH, panelInferior2);

		springLayout.putConstraint(SpringLayout.WEST, chkMeia, 15, SpringLayout.EAST, lblMeia);
		springLayout.putConstraint(SpringLayout.NORTH, chkMeia, 95, SpringLayout.NORTH, panelInferior2);

		panelInferior2.add(lblReservasRestantes);
		panelInferior2.add(lblFuncionario);
		panelInferior2.add(lblMeia);
		panelInferior2.add(cmbFuncionarios);
		panelInferior2.add(chkMeia);

		panelInferior.add(btnFinalizar, BorderLayout.EAST);
		panelInferior.add(panelInferior2, BorderLayout.CENTER);

		poltronaLivreImg = new ImageIcon(getClass().getResource("/resources/poltrona.png"));
		poltronaOcupadaImg = new ImageIcon(getClass().getResource("/resources/poltrona-grey.png"));

		Object[] colunas = new Object[sessaoEscolhida.getSala().getnCol()];
		Object[][] data = new Object[sessaoEscolhida.getSala().getnLin()][sessaoEscolhida.getSala().getnCol()];

		for (int i = 0; i < sessaoEscolhida.getSala().getnLin(); i++) {
			for (int j = 0; j < sessaoEscolhida.getSala().getnCol(); j++) {
				data[i][j] = poltronaLivreImg;
				for (Reserva r : SessaoManager.listarReservasDaSessao(sessaoEscolhida)) {
					if (r.getLinha() == i && r.getColuna() == j && r.isReservado()) {
						data[i][j] = poltronaOcupadaImg;
						break;
					}
				}
			}
		}

		DefaultTableModel model = new DefaultTableModel(data, colunas);

		tabelaPoltrona = new JTable(model) {
			// Returning the Class of each column will allow different
			// renderers to be used based on Class
			public Class getColumnClass(int column) {
				return getValueAt(0, column).getClass();
			}

			@Override
			public boolean isCellEditable(int row, int column) {
				// all cells false
				return false;
			}
		};

		for (int i = 0; i < tabelaPoltrona.getColumnCount(); i++) {
			tabelaPoltrona.getColumnModel().getColumn(i).setMinWidth(40);
		}
		
		if(tabelaPoltrona.getColumnCount() >= 32) {
			tabelaPoltrona.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		}
		else {
			tabelaPoltrona.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		}

		tabelaPoltrona.setRowHeight(40);
		tabelaPoltrona.setMaximumSize(new Dimension(1280,720));
		tabelaPoltrona.setPreferredScrollableViewportSize(tabelaPoltrona.getPreferredSize());

		panelPrincipal.add(panelSuperior, BorderLayout.NORTH);
		panelPrincipal.add(new JScrollPane(tabelaPoltrona, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.CENTER);
		panelPrincipal.add(panelInferior, BorderLayout.SOUTH);

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setMinimumSize(new Dimension(1280, 720));
		this.setLocationRelativeTo(null);
		this.add(panelPrincipal);
	}

	/**
	 * Abre tela.
	 */
	public void mostrarTela() {
		this.setVisible(true);
	}

	private static void configuraTamanhoLetras(JComponent comp, float tam) {
		comp.setFont(comp.getFont().deriveFont(tam));
		if (comp instanceof JLabel) {
			comp = (JLabel) comp;

			((JLabel) comp).setHorizontalAlignment(SwingConstants.CENTER);
			((JLabel) comp).setVerticalAlignment((SwingConstants.CENTER));
		}
	}

	private static String retornaValorEmCelula(Object obj) {
		if (obj instanceof Boolean) {
			boolean var = (boolean) obj;

			if (var)
				return "Sim";
			else
				return "Não";
		}
		
		if(obj instanceof LocalDateTime) {
			LocalDateTime obj2 = (LocalDateTime)obj;
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
			String formattedDateTime = obj2.format(formatter); // "1986-04-08 12:30"
			return formattedDateTime;
		}

		return obj.toString();
	}
}
