package formulario.vendaDeIngressos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
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
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import aplicacao.manager.FuncionarioManager;
import aplicacao.manager.SessaoManager;
import entidades.Funcionario;
import entidades.Reserva;
import entidades.Sessao;

public class TelaFinalizarVendaControles extends JDialog {

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

		panelPrincipal = new JPanel(new BorderLayout());
		panelSuperior = new JPanel(new BorderLayout());
		panelSuperior2 = new JPanel();
		panelInferior2 = new JPanel();
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

		btnFinalizar = new JButton("Finalizar");

		configuraTamanhoLetras(lblSessaoEscolhida, 28F);
		configuraTamanhoLetras(lblFilme, 20F);
		configuraTamanhoLetras(lblSala, 20F);
		configuraTamanhoLetras(lblData, 20F);
		configuraTamanhoLetras(lblLegendado, 20F);
		configuraTamanhoLetras(lbl3D, 20F);
		configuraTamanhoLetras(lblPreco, 20F);
		configuraTamanhoLetras(lblFuncionario, 20F);
		configuraTamanhoLetras(lblMeia, 20F);
		configuraTamanhoLetras(cmbFuncionarios, 20F);
		configuraTamanhoLetras(btnFinalizar, 28F);

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

		panelInferior2.add(lblFuncionario);
		panelInferior2.add(cmbFuncionarios);
		panelInferior2.add(lblMeia);
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
				for (Reserva r : SessaoManager.listarReservas()) {
					if (r.getLinha() == i && r.getColuna() == j) {
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
		       //all cells false
		       return false;
		    }
		};

		tabelaPoltrona.setTableHeader(null);
		tabelaPoltrona.setRowHeight(50);
		tabelaPoltrona.setPreferredScrollableViewportSize(tabelaPoltrona.getPreferredSize());

		panelPrincipal.add(panelSuperior, BorderLayout.NORTH);
		panelPrincipal.add(new JScrollPane(tabelaPoltrona), BorderLayout.CENTER);
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

		return obj.toString();
	}
}
