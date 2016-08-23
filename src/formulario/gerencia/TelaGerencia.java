package formulario.gerencia;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import excecoes.TelaAbertaException;
import formulario.gerencia.filmes.TelaFilmesControles;
import formulario.gerencia.funcionarios.TelaFuncionariosControles;
import formulario.gerencia.sala.TelaSalaControles;
import formulario.gerencia.sessao.TelaSessaoControles;

public class TelaGerencia extends TelaGerenciaControles {
	private static final long serialVersionUID = 1L;

	TelaFilmesControles telaFilmes;
	TelaFuncionariosControles telaFuncionarios;
	TelaSalaControles telaSala;
	TelaSessaoControles telaSessao;

	private JDialog owner = this;

	/**
	 * Configura listeners de bot�es na tela de ger�ncia.
	 * 
	 * @param frame
	 */
	public TelaGerencia(JFrame frame) {
		super(frame);

		btnFilmes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					checaTelaAberta();

					telaFilmes = new TelaFilmesControles();

					desktopPane.add(telaFilmes);

					telaFilmes.setMaximum(true); // Coloca tela maximizada

					telaFilmes.mostrarTela();
				} catch (PropertyVetoException e1) {
					JOptionPane.showMessageDialog(owner,
							"Erro ao abrir tela de op��es de filmes. N�o foi poss�vel maximizar tela. "
									+ e1.getMessage(),
							"Erro em op��es de filmes!", JOptionPane.ERROR_MESSAGE);
				} catch (TelaAbertaException e1) {
					JOptionPane.showMessageDialog(owner, e1.getMessage(), "Erro em op��es de filmes!",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		btnFuncionarios.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					checaTelaAberta();

					telaFuncionarios = new TelaFuncionariosControles();

					desktopPane.add(telaFuncionarios);

					telaFuncionarios.setMaximum(true);

					telaFuncionarios.mostrarTela();
				} catch (PropertyVetoException e1) {
					JOptionPane.showMessageDialog(owner,
							"Erro ao abrir tela de op��es de funcion�rios. N�o foi poss�vel maximizar tela. "
									+ e1.getMessage(),
							"Erro em op��es de filmes!", JOptionPane.ERROR_MESSAGE);
				} catch (TelaAbertaException e1) {
					JOptionPane.showMessageDialog(owner, e1.getMessage(), "Erro em op��es de funcion�rios!",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		btnSala.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					checaTelaAberta();

					telaSala = new TelaSalaControles();

					desktopPane.add(telaSala);

					telaSala.setMaximum(true);

					telaSala.mostrarTela();
				} catch (PropertyVetoException e1) {
					JOptionPane.showMessageDialog(owner,
							"Erro ao abrir tela de op��es de salas. N�o foi poss�vel maximizar tela. "
									+ e1.getMessage(),
							"Erro em op��es de salas!", JOptionPane.ERROR_MESSAGE);
				} catch (TelaAbertaException e1) {
					JOptionPane.showMessageDialog(owner, e1.getMessage(), "Erro em op��es de salas!",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		btnSessao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					checaTelaAberta();

					telaSessao = new TelaSessaoControles();

					desktopPane.add(telaSessao);

					telaSessao.setMaximum(true);

					telaSessao.mostrarTela();
				} catch (PropertyVetoException e1) {
					JOptionPane.showMessageDialog(owner,
							"Erro ao abrir tela de op��es de sess�es. N�o foi poss�vel maximizar tela. "
									+ e1.getMessage(),
							"Erro em op��es de sess�es!", JOptionPane.ERROR_MESSAGE);
				} catch (TelaAbertaException e1) {
					JOptionPane.showMessageDialog(owner, e1.getMessage(), "Erro em op��es de sess�es!",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	/**
	 * Checa se h� alguma tela aberta no momento. Se sim, � lan�ada a exce��o.
	 * 
	 * @throws TelaAbertaException
	 */
	private void checaTelaAberta() throws TelaAbertaException {

		if (telaFilmes != null && telaFilmes.isVisible())
			throw new TelaAbertaException("A tela de filmes est� aberta. Feche-a antes para poder continuar.");

		if (telaFuncionarios != null && telaFuncionarios.isVisible())
			throw new TelaAbertaException("A tela de funcion�rios est� aberta. Feche-a antes para poder continuar.");

		if (telaSala != null && telaSala.isVisible())
			throw new TelaAbertaException("A tela de salas est� aberta. Feche-a antes para poder continuar.");

		if (telaSessao != null && telaSessao.isVisible())
			throw new TelaAbertaException("A tela de sess�es est� aberta. Feche-a antes para poder continuar.");
	}
}
