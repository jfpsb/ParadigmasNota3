package formulario.gerencia.filmes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import aplicacao.manager.FilmesManager;
import arquivo.CopiarArquivo;

/**
 * Classe onde são configurados os listeners da tela de cadastro de filmes.
 * 
 * @author jfpsb
 *
 */
public class TelaFilmeCadastro extends TelaFilmeCadastroControles {
	private static final long serialVersionUID = 1L;
	private File arquivo = null;

	/**
	 * Chama construtor da superclasse e adiciona listeners aos botões.
	 */
	public TelaFilmeCadastro(TelaFilme telaFilme) {
		super();
		
		btnCadastrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String nome, sinopse;
				int duracao;
				String imagem;

				try {
					nome = txtNome.getText();
					sinopse = txtSinopse.getText();
					duracao = Integer.parseInt(txtDuracao.getText());

					imagem = CopiarArquivo.CopiaParaMeusDocumentos(arquivo).toString();

					if (nome.isEmpty())
						throw new IllegalArgumentException("O nome do filme não pode ser vazio!");

					// TODO Implementar código para salvar filme no BD
					FilmesManager.criarFilme(nome, sinopse, imagem, duracao);
					JOptionPane.showMessageDialog(null, "Nome: " + nome + "\nSinopse: " + sinopse + "\nDuração: "
							+ duracao + "\nImagem: " + imagem);
					telaFilme.createTable();
					dispose();

				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null, "A duração tem que ser informada em número de minutos.",
							"Erro em dados digitados!", JOptionPane.ERROR_MESSAGE);
				} catch (IllegalArgumentException iae) {
					JOptionPane.showMessageDialog(null, iae.getMessage(), "Erro em dados digitados!",
							JOptionPane.ERROR_MESSAGE);
				} catch (NullPointerException npe) {
					JOptionPane.showMessageDialog(null, npe.getMessage(), "Erro em dados digitados!",
							JOptionPane.ERROR_MESSAGE);
				}

			}

		});

		btnEscolherArquivo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();

				fileChooser.addChoosableFileFilter(
						new FileNameExtensionFilter("Imagens", ImageIO.getReaderFileSuffixes()));

				arquivo = null;

				int result = fileChooser.showOpenDialog(null);

				if (result == JFileChooser.APPROVE_OPTION) {
					arquivo = fileChooser.getSelectedFile();
					txtImagem.setText(arquivo.getAbsolutePath());
				}
			}

		});
	}

}
