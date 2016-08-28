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
	}
	@Override
	public void createTable() {
		tableEntidade = null;
		String [] colunas = {"Sala", "Filme", "Data", "Legendado", "3D", "Preço"};
		Object [][] dados;
		dados = new Object[3][colunas.length];
		//povoar tabela aqui
		tableEntidade = new JTable(dados, colunas);	
		springLayout.putConstraint(SpringLayout.WEST, this, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.NORTH, this, 0, SpringLayout.NORTH, this);
		barraRolagem = new JScrollPane(tableEntidade);
		this.add(barraRolagem);
	
	}
}
