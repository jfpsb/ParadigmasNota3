package formulario.gerencia;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;
import javax.swing.filechooser.FileNameExtensionFilter;

import arquivo.CriaRelatorio;

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
	protected static JTable tableEntidade; // Posição, tamanho, quantidade de linhas e
	protected JScrollPane barraRolagem; // colunas desta tabela será configurada
	// na
	// tela que herdar esta classe
	private JMenuBar menuBar;
	protected Object [][] dados;//dados da tabela
	protected static final int EDITSELECTED = 23;
	protected static final int ONLYSHOW = 24;
	
	ActionListener btnRelatorioListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (tableEntidade.getRowCount() != 0) {
				JFileChooser fileSaver = new JFileChooser();

				fileSaver.setDialogType(JFileChooser.SAVE_DIALOG);

				fileSaver.setSelectedFile(new File("Relatório - " + retornaNomeTipoEntidade() + ".xls"));

				FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos Excel", "xls", "xlsx");

				fileSaver.setFileFilter(filter);

				int result = fileSaver.showSaveDialog(null);

				if (result == JFileChooser.APPROVE_OPTION) {
					File destino = fileSaver.getSelectedFile();

					if (destino.exists()) {
						int resultRepetido = JOptionPane.showConfirmDialog(null,
								"Um arquivo com este mesmo nome já existe. Deseja substituí-lo?",
								"Arquivo já existente", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

						if (resultRepetido != JOptionPane.YES_OPTION)
							return;

						chamaEscreveRelatorio(destino, fileSaver, retornaNomeTipoEntidade());

					} else {
						chamaEscreveRelatorio(destino, fileSaver, retornaNomeTipoEntidade());
					}
				}
			}
		}
	};
	
	
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
		
		btnGerarRelatorio.addActionListener(btnRelatorioListener);

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
	
	/**
	 * Nome do tipo de entidade sendo salva.
	 * 
	 * @return Nome da entidade.
	 */
	public abstract String retornaNomeTipoEntidade();

	/**
	 * Faz os testes de extensão do arquivo e chama o método de escrever
	 * relatório.
	 * 
	 * @param destino
	 *            Caminho onde será salvo o arquivo.
	 * @param fileSaver
	 *            Instância do JFileChosser utilizada.
	 * @param nomeTipoEntidade
	 *            Nome do tipo de entidade sendo salva.
	 */
	private static void chamaEscreveRelatorio(File destino, JFileChooser fileSaver, String nomeTipoEntidade) {
		if (!destino.toString().endsWith(".xls") && !destino.toString().endsWith(".xlsx"))
			destino = new File(fileSaver.getSelectedFile().toString() + ".xls");
		try {
			CriaRelatorio.escreveRelatorio(tableEntidade, destino, nomeTipoEntidade);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
