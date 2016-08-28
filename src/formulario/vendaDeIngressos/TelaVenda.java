package formulario.vendaDeIngressos;

import java.awt.BorderLayout;
import java.awt.Component;
import java.time.LocalDateTime;

import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import com.github.lgooddatepicker.optionalusertools.DateTimeChangeListener;
import com.github.lgooddatepicker.zinternaltools.DateTimeChangeEvent;

import aplicacao.manager.SessaoManager;
import entidades.Sessao;

public class TelaVenda extends TelaVendaControles{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TelaVenda(){
		super();		
		
		datePicker.addDateTimeChangeListener(new DateTimeChangeListener() {
			
			@Override
			public void dateOrTimeChanged(DateTimeChangeEvent arg0) {
				geraTabela();				
			}
		});
		geraTabela();
	}

	private void geraTabela() {
		try{
			panelPrincipal.remove(barraRolagem);
		}catch(Exception e){
			//Do nothing
		}
		LocalDateTime data = datePicker.getDateTimeStrict();
		sessoes = SessaoManager.listarSessaoPorHorario(data);
		
		String[] colunas = new String[sessoes.size()];
		dados = new Object[5][sessoes.size()];	
		int i = 0;
		for(Sessao s:sessoes){
			colunas[i] = "Sessao "+(i+1);
			dados[0][i] = new ImageIcon(s.getFilme().getImagem());
			dados[1][i] = "Filme: "+s.getFilme().getNome();
			dados[2][i] = "Preço: "+s.getPreco();
			dados[3][i] = "\nSala: "+s.getSala().getNome();
			dados[4][i] = "\nData: "+s.getData().toString();
			i++;
		}
		tableSessoes = new JTable(dados, colunas){
		    public TableCellRenderer getCellRenderer(int row, int column)
		    {
		        if (row == 0)
		        {
		            Class cellClass = getValueAt(row, column).getClass();
		            return getDefaultRenderer( cellClass );
		        }

		        return super.getCellRenderer(row, column);
		    }
		    public boolean isCellEditable(int row, int column){  
		        return false;  
		    }  
		    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		           Component component = super.prepareRenderer(renderer, row, column);
		           int rendererWidth = component.getPreferredSize().width;
		           TableColumn tableColumn = getColumnModel().getColumn(column);
		           tableColumn.setPreferredWidth(Math.max(rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
		           return component;
		      }
		};
		tableSessoes.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableSessoes.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tableSessoes.setCellSelectionEnabled(true);
		updateRowHeights(tableSessoes);         
		barraRolagem = new JScrollPane(tableSessoes);
		barraRolagem.setHorizontalScrollBarPolicy(
				   JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		panelPrincipal.add(barraRolagem, BorderLayout.CENTER);
		panelPrincipal.validate();
		panelPrincipal.repaint();
	}
	
}
