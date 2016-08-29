package formulario.telaprincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;

import aplicacao.manager.SessaoManager;
import arquivo.CriaRelatorio;
import entidades.Ingresso;
import excecoes.TelaAbertaException;
import formulario.gerencia.TelaGerencia;
import formulario.vendaDeIngressos.TelaVenda;

/**
 * Coloca os listeners no botões da tela principal.
 * 
 * @author jfpsb
 *
 */
public class TelaPrincipal extends TelaPrincipalControles {

	private static final long serialVersionUID = 1L;

	private TelaGerencia telaGerencia;
	private TelaVenda telaVenda;

	/**
	 * Construtor que configura listeners em botões.
	 */
	public TelaPrincipal() {
		super();
		btnVendas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					checaTelaAberta(telaVenda);
					telaVenda = new TelaVenda();
					telaVenda.mostrarTela();
				} catch (TelaAbertaException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro em opções de gerência!",
							JOptionPane.ERROR_MESSAGE);
				} finally {
					telaVenda.setState(JFrame.NORMAL);
					telaVenda.toFront();
				}
			}

		});

		// btnGerencia
		btnGerencia.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					checaTelaAberta(telaGerencia);

					telaGerencia = new TelaGerencia();
					telaGerencia.mostrarTela();
				} catch (TelaAbertaException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro em opções de gerência!",
							JOptionPane.ERROR_MESSAGE);
				} finally {
					telaGerencia.setState(JFrame.NORMAL);
					telaGerencia.toFront();
				}
			}

		});

		btnExport.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				JTable tableEntidade = createTableIngresso();
				if (tableEntidade.getRowCount() != 0) {
					JFileChooser fileSaver = new JFileChooser();

					fileSaver.setDialogType(JFileChooser.SAVE_DIALOG);

					fileSaver.setSelectedFile(new File("Relatório - Ingressos.xls"));

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

							chamaEscreveRelatorio(destino, fileSaver, "Ingresso", tableEntidade);

						} else {
							chamaEscreveRelatorio(destino, fileSaver, "Ingresso", tableEntidade);
						}
					}
				}
			}

		});
	}

	/**
	 * Checa se a tela está aberta no momento. Se sim, é lançada a exceção.
	 * 
	 * @throws TelaAbertaException
	 */
	private void checaTelaAberta(JFrame internalFrame) throws TelaAbertaException {
		if (internalFrame != null && (internalFrame.isVisible() || internalFrame.isDisplayable()))
			throw new TelaAbertaException("Uma instância desta tela já está aberta.");
	}

	private static void chamaEscreveRelatorio(File destino, JFileChooser fileSaver, String nomeTipoEntidade,
			JTable tableEntidade) {
		if (!destino.toString().endsWith(".xls") && !destino.toString().endsWith(".xlsx"))
			destino = new File(fileSaver.getSelectedFile().toString() + ".xls");
		
		CriaRelatorio.escreveRelatorio(tableEntidade, destino, nomeTipoEntidade);
	}

	private static JTable createTableIngresso() {
		// Esse teste é feito porque no começo do programa, não há como remover.

		String[] colunas = { "Filme", "Sessao", "3D", "Legendado", "Poltrona","Funcionario", "Preço" };
		List<Ingresso> ingressos = SessaoManager.listarIngresso();
		Object[][] dados = new Object[ingressos.size()][colunas.length];
		int i = 0;
		for (Ingresso ingresso : ingressos) {
			dados[i][0] = ingresso.getReserva().getSessao().getFilme().getNome();
			dados[i][1] = ingresso.getReserva().getSessao().getData();
			dados[i][2] = ingresso.getReserva().getSessao().isIs3D();
			dados[i][3] = ingresso.getReserva().getSessao().isLegendado();
			dados[i][4] = "L: " + ingresso.getReserva().getLinha() + " C: " + ingresso.getReserva().getColuna();
			dados[i][5] = ingresso.getFuncionario().getNome();
			dados[i][6] =  ingresso.getPreco();
			i++;
		}
		// povoar tabela aqui
		return new JTable(dados, colunas);

	}
}
