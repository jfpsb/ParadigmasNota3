package formulario.gerencia.filmes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;

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

	private JInternalFrame owner = this;

	private TelaFilmeCadastro cadastrarFilme;
	
	/**
	 * Chama construtor da superclasse e adiciona listeners aos bot�es.
	 */
	public TelaFilme() {
		super("Opc�es de Filmes");

		btnCadastrarNovo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					checaTelaAberta(cadastrarFilme);

					cadastrarFilme = new TelaFilmeCadastro();

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
		tableEntidade = null;
		String [] colunas = {"Nome", "Sinopse", "Dura��o"};
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
