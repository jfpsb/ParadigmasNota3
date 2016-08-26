package formulario.gerencia.sala;

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

					cadastrarSala = new TelaSalaCadastro();

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
	}
	@Override
	public void createTable() {
		tableEntidade = null;
		String [] colunas = {"Nome", "Quantidade de Poltronas"};
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
