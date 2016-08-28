package formulario.gerencia.filmes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;

import aplicacao.manager.FilmesManager;
import entidades.Filme;
import excecoes.TelaAbertaException;
import formulario.gerencia.TelaBaseEntidadeControles;

/**
 * Tela que vai conter as op��es de atualizar, deletar e cadastrar novos filmes.
 * 
 * @author jfpsb
 *
 */
public class TelaFilme extends TelaBaseEntidadeControles {
	private static final long serialVersionUID = 1L;
	private static final int EDITSELECTED = 23;
	private static final int ONLYSHOW = 24;
	private JInternalFrame owner = this;
	private TelaFilmeCadastro cadastrarFilme;
	private Object [][] dados;
	private List<Filme> filmes;
	/**
	 * Chama construtor da superclasse e adiciona listeners aos bot�es.
	 */
	public TelaFilme() {
		super("Opc�es de Filmes");
		TelaFilme telaFilme = this;

		btnCadastrarNovo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					checaTelaAberta(cadastrarFilme);

					cadastrarFilme = new TelaFilmeCadastro(telaFilme);
					//cadastrarFilme	
					cadastrarFilme.mostrarTela();
				} catch (TelaAbertaException e1) {
					JOptionPane.showMessageDialog(owner, e1.getMessage(), "Erro em op��es de cadastro de filmes!",
							JOptionPane.ERROR_MESSAGE);
				} finally {
					cadastrarFilme.setState(JFrame.NORMAL);
					cadastrarFilme.toFront();
				}
			}

		});
		btnDeletarSelecao.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {					
				FilmesManager.removerFilme(getSelectedMovie(ONLYSHOW));
				createTable();
			}
		});
		btnAlterarSelecao.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {												
				FilmesManager.atualizarFilme(getSelectedMovie(EDITSELECTED));
				createTable();				
			}
		});
	}

	/**
	 * Checa se a tela est� aberta no momento. Se sim, � lan�ada a exce��o.
	 * 
	 * @throws TelaAbertaException
	 */
	private void checaTelaAberta(JFrame frame) throws TelaAbertaException {
		if (frame != null && (frame.isVisible() || frame.isDisplayable()))
			throw new TelaAbertaException("Uma inst�ncia desta tela j� est� aberta.");
	}

	@Override
	public void createTable() {
		//Esse teste � feito porque no come�o do programa, n�o h� como remover.
		try{	
			this.remove(barraRolagem);
			this.repaint();
		}catch(Exception e){
			//Nothing to do
		}
		tableEntidade = null;
		String [] colunas = {"Nome", "Sinopse", "Imagem", "Dura��o"};
		filmes = FilmesManager.listarFilmes();
		dados = new Object[filmes.size()][colunas.length];
		int i = 0;
		for(Filme f : filmes){
			dados[i][0] = f.getNome();
			dados[i][1] = f.getSinopse();
			dados[i][2] = f.getImagem();
			dados[i][3] = f.getDuracao();
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
		//this.mostrarTela();
		
		//System.out.println("chamou-------------------------------------------------"+filmes.size());
	}
	/**
	 * Mostra o selecionado, e caso necess�rio edita este
	 */
	private Filme getSelectedMovie(int code){
		int row = tableEntidade.getSelectedRow();
		String nome = dados[row][0].toString();
		String sinopse = dados[row][1].toString();
		String imagem  = dados[row][2].toString();
		int duracao = Integer.parseInt(dados[row][3].toString());
		JOptionPane.showMessageDialog(null, "Nome: " + nome + "\nSinopse: " + sinopse + "\nDura��o: "+ duracao + "\nImagem: " + imagem);
		Filme filme = filmes.get(row);
		if(code == EDITSELECTED){
			filme.setNome(nome);
			filme.setDuracao(duracao);
			filme.setImagem(imagem);
			filme.setSinopse(sinopse);
		}
		return filme;
	}
}
