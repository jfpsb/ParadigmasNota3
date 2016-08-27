package arquivo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * Realiza a cópia do arquivo de imagem de filmes para pasta padrão do sistema.
 * 
 * @author jfpsb
 *
 */
public class CopiarArquivo {
	private static final String meusDocumentosPath = new JFileChooser().getFileSystemView().getDefaultDirectory()
			.toString();
	private static final String arquivoDestinoPath = meusDocumentosPath + File.separator + "Cinema Paradigmas";

	/**
	 * Copia o arquivo passado para a pasta do sistema em Meus Documentos.
	 * 
	 * @param origem
	 *            Arquivo com caminho original do arquivo escolhido pelo
	 *            usuário.
	 * @return Arquivo com caminho final do arquivo em Meus Documentos/Cinema
	 *         Paradigmas
	 */
	public static File CopiaParaMeusDocumentos(File origem) {
		File destino = new File(arquivoDestinoPath + File.separator + origem.getName());

		try {
			destino.getParentFile().mkdirs(); // Cria diretório

			Files.copy(origem.toPath(), destino.toPath(), StandardCopyOption.REPLACE_EXISTING);

			return destino;
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao copiar arquivo. " + e.getMessage());
			return null;
		}
	}
}
