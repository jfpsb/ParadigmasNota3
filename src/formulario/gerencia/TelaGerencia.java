package formulario.gerencia;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

import excecoes.TelaAbertaException;
import formulario.gerencia.filmes.TelaFilme;
import formulario.gerencia.funcionarios.TelaFuncionario;
import formulario.gerencia.sala.TelaSala;
import formulario.gerencia.sessao.TelaSessao;

/**
 * Implementação dos listeners da tela de gerência.
 * 
 * @author jfpsb
 *
 */
public class TelaGerencia extends TelaGerenciaControles {
	private static final long serialVersionUID = 1L;

	TelaFilme telaFilme;
	TelaFuncionario telaFuncionario;
	TelaSala telaSala;
	TelaSessao telaSessao;

	private JFrame owner = this;

	/**
	 * Configura listeners de botões na tela de gerência.
	 * 
	 * @param frame
	 */
	public TelaGerencia() {
		super();

		btnFilmes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					checaTelaAberta(telaFilme);

					telaFilme = new TelaFilme();

					desktopPane.add(telaFilme);

					telaFilme.setMaximum(true); // Coloca tela maximizada

					telaFilme.mostrarTela();
				} catch (PropertyVetoException e1) {
					JOptionPane.showMessageDialog(owner,
							"Erro ao abrir tela de opções de filmes. Não foi possível maximizar tela. "
									+ e1.getMessage(),
							"Erro em opções de filmes!", JOptionPane.ERROR_MESSAGE);
				} catch (TelaAbertaException e1) {
					JOptionPane.showMessageDialog(owner, e1.getMessage(), "Erro em opções de filmes!",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		btnFuncionarios.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					checaTelaAberta(telaFuncionario);

					telaFuncionario = new TelaFuncionario();

					desktopPane.add(telaFuncionario);

					telaFuncionario.setMaximum(true);

					telaFuncionario.mostrarTela();
				} catch (PropertyVetoException e1) {
					JOptionPane.showMessageDialog(owner,
							"Erro ao abrir tela de opções de funcionários. Não foi possível maximizar tela. "
									+ e1.getMessage(),
							"Erro em opções de filmes!", JOptionPane.ERROR_MESSAGE);
				} catch (TelaAbertaException e1) {
					JOptionPane.showMessageDialog(owner, e1.getMessage(), "Erro em opções de funcionários!",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		btnSala.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					checaTelaAberta(telaSala);

					telaSala = new TelaSala();

					desktopPane.add(telaSala);

					telaSala.setMaximum(true);

					telaSala.mostrarTela();
				} catch (PropertyVetoException e1) {
					JOptionPane.showMessageDialog(owner,
							"Erro ao abrir tela de opções de salas. Não foi possível maximizar tela. "
									+ e1.getMessage(),
							"Erro em opções de salas!", JOptionPane.ERROR_MESSAGE);
				} catch (TelaAbertaException e1) {
					JOptionPane.showMessageDialog(owner, e1.getMessage(), "Erro em opções de salas!",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		btnSessao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					checaTelaAberta(telaSessao);

					telaSessao = new TelaSessao();

					desktopPane.add(telaSessao);

					telaSessao.setMaximum(true);

					telaSessao.mostrarTela();
				} catch (PropertyVetoException e1) {
					JOptionPane.showMessageDialog(owner,
							"Erro ao abrir tela de opções de sessões. Não foi possível maximizar tela. "
									+ e1.getMessage(),
							"Erro em opções de sessões!", JOptionPane.ERROR_MESSAGE);
				} catch (TelaAbertaException e1) {
					JOptionPane.showMessageDialog(owner, e1.getMessage(), "Erro em opções de sessões!",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	/**
	 * Checa se a tela está aberta no momento. Se sim, é lançada a exceção.
	 * 
	 * @throws TelaAbertaException
	 */
	private void checaTelaAberta(JInternalFrame internalFrame) throws TelaAbertaException {
		if (internalFrame != null && (internalFrame.isVisible() || internalFrame.isDisplayable()))
			throw new TelaAbertaException("Uma instância desta tela já está aberta.");
	}
}
