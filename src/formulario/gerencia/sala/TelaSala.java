package formulario.gerencia.sala;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;

import aplicacao.manager.FilmesManager;
import aplicacao.manager.SalasManager;
import entidades.Filme;
import entidades.Sala;
import excecoes.TelaAbertaException;
import formulario.gerencia.TelaBaseEntidadeControles;
import outrasclasses.ChecarTela;

/**
 * Tela que vai conter as opções de atualizar, deletar e cadastrar novas salas.
 * 
 * @author jfpsb
 *
 */
public class TelaSala extends TelaBaseEntidadeControles {
	private static final long serialVersionUID = 1L;

	private JInternalFrame owner = this;

	private TelaSalaCadastro cadastrarSala;
	private List<Sala> salas;
	private TelaSala telaSala = this;

	/**
	 * Chama construtor da superclasse e adiciona listeners aos botões.
	 */
	public TelaSala() {
		super("Opções de Salas");
		
		btnCadastrarNovo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					ChecarTela.checaTelaAberta(cadastrarSala);

					cadastrarSala = new TelaSalaCadastro(telaSala);

					cadastrarSala.mostrarTela();
				} catch (TelaAbertaException e1) {
					JOptionPane.showMessageDialog(owner, e1.getMessage(), "Erro em opções de cadastro de filmes!",
							JOptionPane.ERROR_MESSAGE);
				} finally {
					cadastrarSala.setState(JFrame.NORMAL);
					cadastrarSala.toFront();
				}
			}

		});
		btnDeletarSelecao.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try{
				SalasManager.removerSala(getSelectedSala(ONLYSHOW));
				createTable();
				}catch(ArrayIndexOutOfBoundsException ec){
					JOptionPane.showMessageDialog(null, "Selecione Uma Entidade",
							"Erro ao remover!", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnAlterarSelecao.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try{
					SalasManager.atualizarSala(getSelectedSala(EDITSELECTED));
					createTable();	
				}catch(ArrayIndexOutOfBoundsException ec){
					JOptionPane.showMessageDialog(null, "Selecione Uma Entidade",
							"Erro ao alterar!", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
	}
	/**
	 * Cria uma tabela para mostrar as salas cadastrados.
	 */
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
		String [] colunas = {"Nome", "Linhas", "Colunas"};
		salas = SalasManager.listarSalas();
		dados = new Object[salas.size()][colunas.length];
		int i = 0;
		for(Sala s :salas){
			dados[i][0] = s.getNome();
			dados[i][1] = s.getnLin();
			dados[i][2] = s.getnCol();
			i++;
		}
		//povoar tabela aqui
		tableEntidade = new JTable(dados, colunas);	
		updateRowHeights(tableEntidade);
		springLayout.putConstraint(SpringLayout.WEST, this, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.NORTH, this, 0, SpringLayout.NORTH, this);
		barraRolagem = new JScrollPane(tableEntidade);
		this.add(barraRolagem);
		this.validate();
		this.repaint();
	}
	/**
	 * Retorna a sala selecionada
	 * @param code se devemos ou não editar os dados
	 * @return a sala selecionada
	 */
	private Sala getSelectedSala(int code)throws ArrayIndexOutOfBoundsException{
		int row = tableEntidade.getSelectedRow();
		String nome = dados[row][0].toString();
		int l, c;
		try{
			l = Integer.parseInt(dados[row][1].toString());		
		}catch(NumberFormatException e){
			l = 0;
			
		}
		try{
			c = Integer.parseInt(dados[row][2].toString());
		}catch(NumberFormatException e){
			c = 0;			
		}
		JOptionPane.showMessageDialog(null, "Nome: " + nome + "\nLinhas: " + l + "\nColunas: "+ c);
		Sala sala = salas.get(row);
		if(code == EDITSELECTED){
			sala.setNome(nome);
			sala.setnLin(l);
			sala.setnCol(c);
		}
		return sala;
	}
	@Override
	public String retornaNomeTipoEntidade() {
		return "Salas";
	}

}
