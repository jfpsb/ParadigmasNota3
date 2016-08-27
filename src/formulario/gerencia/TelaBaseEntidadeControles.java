package formulario.gerencia;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;

/**
 * Tela base com controles comuns das telas de manipular entidades.
 * 
 * @author jfpsb
 *
 */
public abstract class TelaBaseEntidadeControles extends JInternalFrame {
	private static final long serialVersionUID = 1L;

	private JPanel panelPrincipal;
	protected SpringLayout springLayout;
	protected JButton btnCadastrarNovo;
	protected JButton btnDeletarSelecao;
	protected JButton btnAlterarSelecao;
	protected JButton btnGerarRelatorio;
	protected JTable tableEntidade; // Posição, tamanho, quantidade de linhas e
	protected JScrollPane barraRolagem; // colunas desta tabela será configurada
	// na
	// tela que herdar esta classe
	private JMenuBar menuBar;

	public TelaBaseEntidadeControles(String titulo) {
		super(titulo);
		inicializarControles();
	}

	/**
	 * Instancia e configura elementos da UI.
	 */
	private void inicializarControles() {
		springLayout = new SpringLayout();
		panelPrincipal = new JPanel(springLayout);
		menuBar = new JMenuBar();
		btnCadastrarNovo = new JButton("Cadastrar Novo");
		btnDeletarSelecao = new JButton("Deletar Selecionado");
		btnAlterarSelecao = new JButton("Atualizar Selecionado");
		btnGerarRelatorio = new JButton("Gerar Relatório");

		this.applyButtonTheme(btnCadastrarNovo);
		this.applyButtonTheme(btnDeletarSelecao);
		this.applyButtonTheme(btnAlterarSelecao);
		this.applyButtonTheme(btnGerarRelatorio);

		menuBar.add(btnCadastrarNovo);
		menuBar.add(btnAlterarSelecao);
		menuBar.add(btnDeletarSelecao);
		menuBar.add(btnGerarRelatorio);

		this.setJMenuBar(menuBar);

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.pack();
		this.setClosable(true);
		this.setIconifiable(true);
		this.add(panelPrincipal);
		this.createTable();

	}

	/**
	 * Aplica o Tema desejado a um botão.
	 */

	private void applyButtonTheme(JButton btn) {
		btn.setBackground(new Color(240, 240, 240));
		btn.setFont(btnCadastrarNovo.getFont().deriveFont(14f));
	}

	/**
	 * Abre tela.
	 */
	public void mostrarTela() {
		this.setVisible(true);
	}

	/**
	 * Cria a Tabela que mostra os elementos
	 */
	public abstract void createTable();
	/**
	 * 
	 * @param table
	 * Função que organiza a altura das linhas
	 */
	protected void updateRowHeights(JTable table){
	    for (int row = 0; row < table.getRowCount(); row++)
	    {
	        int rowHeight = table.getRowHeight();
	        for (int column = 0; column < table.getColumnCount(); column++){
	            Component comp = table.prepareRenderer(table.getCellRenderer(row, column), row, column);
	            rowHeight = Math.max(rowHeight, comp.getPreferredSize().height);
	        }

	        table.setRowHeight(row, rowHeight);
	    }
	}
}
