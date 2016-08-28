package formulario.gerencia.funcionarios;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;

import aplicacao.manager.FuncionarioManager;
import entidades.Filme;
import entidades.Funcionario;
import excecoes.TelaAbertaException;
import formulario.gerencia.TelaBaseEntidadeControles;

/**
 * Tela que vai conter as opções de atualizar, deletar e cadastrar novos funcionários.
 * 
 * @author jfpsb
 *
 */
public class TelaFuncionario extends TelaBaseEntidadeControles {
	private static final long serialVersionUID = 1L;
	private TelaFuncionario telaFuncionario = this; 

	private TelaFuncionarioCadastro cadastrarFuncionario;
	private Object [][] dados;
	private List<Funcionario> funcionarios;
	/**
	 * Chama construtor da superclasse e adiciona listeners aos botões.
	 */
	public TelaFuncionario() {
		super("Opcões de Funcionários");

		btnCadastrarNovo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					checaTelaAberta(cadastrarFuncionario);

					cadastrarFuncionario = new TelaFuncionarioCadastro(telaFuncionario);

					cadastrarFuncionario.mostrarTela();
				} catch (TelaAbertaException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro em opções de cadastro de filmes!",
							JOptionPane.ERROR_MESSAGE);
				} finally {
					cadastrarFuncionario.setState(JFrame.NORMAL);
					cadastrarFuncionario.toFront();
				}
			}

		});
	}

	/**
	 * Checa se a tela está aberta no momento. Se sim, é lançada a exceção.
	 * 
	 * @throws TelaAbertaException
	 */
	private void checaTelaAberta(JFrame frame) throws TelaAbertaException {
		if (frame != null && (frame.isVisible() || frame.isDisplayable()))
			throw new TelaAbertaException("Uma instância desta tela já está aberta.");
	}
	@Override
	public void createTable() {
		//Esse teste é feito porque no começo do programa, não há como remover.
		try{	
			this.remove(barraRolagem);
			this.repaint();
		}catch(Exception e){
			//Nothing to do
		}
		tableEntidade = null;
		String [] colunas = {"Nome"};		
		funcionarios  = FuncionarioManager.listarFuncionarios();
		dados = new Object[funcionarios.size()][colunas.length];
		int i = 0;
		for(Funcionario f : funcionarios){
			dados[i][0] = f.getNome();
			i++;
		}
		tableEntidade = new JTable(dados, colunas);
		updateRowHeights(tableEntidade);
		springLayout.putConstraint(SpringLayout.WEST, this, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.NORTH, this, 0, SpringLayout.NORTH, this);
		barraRolagem = new JScrollPane(tableEntidade);
		this.add(barraRolagem);		
		this.validate();
		this.repaint();
	}
	private Funcionario getSelectedFuncionario(int code){
		int row = tableEntidade.getSelectedRow();
		String nome = dados[row][0].toString();			
		JOptionPane.showMessageDialog(null, "Nome: "+nome);
		Funcionario funcionario = funcionarios.get(row);
		if(code == EDITSELECTED){
			funcionario.setNome(nome);
		}
		return funcionario;
	}

}
