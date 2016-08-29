package formulario.vendaDeIngressos;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import com.github.lgooddatepicker.optionalusertools.DateChangeListener;
import com.github.lgooddatepicker.optionalusertools.DateTimeChangeListener;
import com.github.lgooddatepicker.zinternaltools.DateChangeEvent;
import com.github.lgooddatepicker.zinternaltools.DateTimeChangeEvent;

import aplicacao.manager.SessaoManager;
import entidades.Sessao;

/**
 * Tela que mostra as sessões cadastradas. Nela o usuário pode escolher a sessão
 * para comprar um ingresso.
 * 
 * @author Paulo
 *
 */
public class TelaVenda extends TelaVendaControles {
	private static final long serialVersionUID = 1L;
	private MouseAdapter JTableClick;
	private Sessao sessaoEscolhida = null;
	private JFrame owner = this;

	/**
	 * É chamado o construtor da superclasse, que inicializa os controles e
	 * adicionado um evento ao DateTime.
	 */
	public TelaVenda() {
		super();

		datePicker.addDateChangeListener(new DateChangeListener() {
			
			@Override
			public void dateChanged(DateChangeEvent arg0) {
				geraTabela();
				
			}
		});

		JTableClick = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				sessaoEscolhida = sessoes.get(tableSessoes.getSelectedColumn());
			}
		};

		btnFinalizar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (sessaoEscolhida != null) {
					TelaFinalizarVenda telaFinalizarVenda = new TelaFinalizarVenda(owner, sessaoEscolhida);
					telaFinalizarVenda.mostrarTela();
				}
			}

		});

		geraTabela();
	}

	/**
	 * Mostra as Sessões disponíveis na data escolhida
	 */
	private void geraTabela() {
		try {
			panelPrincipal.remove(barraRolagem);
		} catch (Exception e) {
			// Do nothing
		}
		LocalDate data = datePicker.getDate();
		sessoes = SessaoManager.listarSessaoPorDia(data);
		if (!sessoes.isEmpty()) {
			String[] colunas = new String[sessoes.size()];
			dados = new Object[5][sessoes.size()];
			int i = 0;
			for (Sessao s : sessoes) {
				colunas[i] = "Sessao " + (i + 1);
				dados[0][i] = new ImageIcon(s.getFilme().getImagem());
				dados[1][i] = "Filme: " + s.getFilme().getNome();
				dados[2][i] = "Preço: " + s.getPreco();
				dados[3][i] = "\nSala: " + s.getSala().getNome();
				dados[4][i] = "\nData: " + s.getData().toString();
				i++;
			}
			tableSessoes = new JTable(dados, colunas) {
				public TableCellRenderer getCellRenderer(int row, int column) {
					if (row == 0) {
						Class cellClass = getValueAt(row, column).getClass();
						return getDefaultRenderer(cellClass);
					}

					return super.getCellRenderer(row, column);
				}

				public boolean isCellEditable(int row, int column) {
					return false;
				}

				public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
					Component component = super.prepareRenderer(renderer, row, column);
					int rendererWidth = component.getPreferredSize().width;
					TableColumn tableColumn = getColumnModel().getColumn(column);
					tableColumn.setPreferredWidth(
							Math.max(rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
					return component;
				}
			};
			
			tableSessoes.addMouseListener(JTableClick);
			tableSessoes.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			tableSessoes.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			tableSessoes.setCellSelectionEnabled(true);
			updateRowHeights(tableSessoes);
			barraRolagem = new JScrollPane(tableSessoes);
			barraRolagem.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			panelPrincipal.add(barraRolagem, BorderLayout.CENTER);
		}
		panelPrincipal.validate();
		panelPrincipal.repaint();
	}

}
