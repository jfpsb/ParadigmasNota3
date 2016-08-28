package formulario.gerencia.sessao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;

import aplicacao.manager.FilmesManager;
import aplicacao.manager.SalasManager;
import aplicacao.manager.SessaoManager;
import entidades.Filme;
import entidades.Sala;
import entidades.Sessao;
import excecoes.TelaAbertaException;
import formulario.gerencia.TelaBaseEntidadeControles;
import outrasclasses.ChecarTela;

/**
 * Tela que vai conter as opções de atualizar, deletar e cadastrar novas
 * sessões.
 * 
 * @author jfpsb
 *
 */
public class TelaSessao extends TelaBaseEntidadeControles {
	private static final long serialVersionUID = 1L;

	private TelaSessaoCadastro cadastrarSessao;
	private TelaSessao telaSessao = this;
	private List<Sessao> sessoes;	

	/**
	 * Chama construtor da superclasse e adiciona listeners aos botões.
	 */
	public TelaSessao() {
		super("Opções de Sessão");
		btnCadastrarNovo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					ChecarTela.checaTelaAberta(cadastrarSessao);

					cadastrarSessao = new TelaSessaoCadastro(telaSessao);

					cadastrarSessao.mostrarTela();
				} catch (TelaAbertaException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro em opções de cadastro de filmes!",
							JOptionPane.ERROR_MESSAGE);
				} finally {
					cadastrarSessao.setState(JFrame.NORMAL);
					cadastrarSessao.toFront();
				}
			}

		});
		btnDeletarSelecao.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!SessaoManager.removerSessao(getSelectedSessao(), false)){
					JOptionPane.showMessageDialog(null,  "Erro ao remover sessao. Ela deve ter reservas!", "Erro ao Remover",
							JOptionPane.ERROR_MESSAGE);
					return ;
				}
				createTable();
				JOptionPane.showMessageDialog(null, "Removido", "Removido com Sucesso",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnAlterarSelecao.setEnabled(false);
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
		String [] colunas = {"Sala", "Filme", "Data", "Legendado", "3D", "Preço"};
		sessoes = SessaoManager.listarSessao();
		dados = new Object[sessoes.size()][colunas.length];
		int i = 0;
		for(Sessao s:sessoes){
			dados[i][0] = s.getSala().getNome();
			dados[i][1] = s.getFilme().getNome();
			dados[i][2] = s.getData().toString();
			dados[i][3] = s.isLegendado();
			dados[i][4] = s.isIs3D();
			dados[i][5] = s.getPreco();
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
	private Sessao getSelectedSessao(){
		return sessoes.get(tableEntidade.getSelectedRow());
	}
}
