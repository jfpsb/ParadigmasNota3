package formulario.vendaDeIngressos;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.components.DateTimePicker;
import com.github.lgooddatepicker.components.TimePickerSettings;

import entidades.Sessao;
/**
 * Classe onde são configurados os controles da tela de escolha de sessões
 * @author Paulo
 *
 */
public class TelaVendaControles extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JPanel panelPrincipal;
	protected JPanel panelCenter;
	private JPanel panelSuperior;
	private JLabel lblData;
	protected DateTimePicker datePicker;	
	protected List<Sessao> sessoes;
	protected JTable tableSessoes;
	protected Object[][] dados;
	protected JScrollPane barraRolagem;
	private DatePickerSettings dateSettings;
	private TimePickerSettings timeSettings;
	//mudar pra Filme.
	/**
	 * Chama o método que inicializa os componentes da UI.
	 */
	public TelaVendaControles(){
		super("Venda de Ingressos");
		inicializarControles();
	}
	/**
	 * Instancia e configura elementos da UI.
	 * @param dateSettings 
	 * @param timeSettings 
	 */
	private void inicializarControles() {
		panelPrincipal = new JPanel(new BorderLayout());
		panelSuperior = new JPanel(new FlowLayout());
		panelCenter = new JPanel();		
		dateSettings = new DatePickerSettings();
		timeSettings = new TimePickerSettings();
		dateSettings.setAllowEmptyDates(false);
		timeSettings.setAllowEmptyTimes(false);
		datePicker = new DateTimePicker(dateSettings, timeSettings);
		lblData = new JLabel("Data da Sessão: ");
		lblData.setFont(lblData.getFont().deriveFont(16F));
		
		//panelSuperior
		panelSuperior.add(lblData);
		panelSuperior.add(datePicker);
		
		//panelPrincipal
		panelPrincipal.add(panelSuperior, BorderLayout.NORTH);
		//panelPrincipal.add(panelCenter, BorderLayout.CENTER);
		
		//tela
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setMinimumSize(new Dimension(1280, 720));
		//this.pack();
		this.setLocationRelativeTo(null);
		this.add(panelPrincipal);
	}
	/**
	 * Abre tela.
	 */
	public void mostrarTela() {
		this.setVisible(true);
	}
	/**
	 * Ajusta a Altura da primeira linha da tabela
	 * @param table
	 */
	protected void updateRowHeights(JTable table) {
		int rowIndex = 0;
        int tallestCellHeight = 0;
        for (int columnIndex = 0; columnIndex < table.getColumnCount(); ++columnIndex) {
            TableCellRenderer cellRenderer = table.getCellRenderer(rowIndex, columnIndex);
            Component cellContent = table.prepareRenderer(cellRenderer, rowIndex, columnIndex);
            int cellHeight = cellContent.getPreferredSize().height;
            tallestCellHeight = Math.max(tallestCellHeight, cellHeight);
        }
 
        if (tallestCellHeight != table.getRowHeight(rowIndex)) {
            table.setRowHeight(rowIndex, tallestCellHeight);
        }
    }
}
