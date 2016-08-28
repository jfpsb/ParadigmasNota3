package arquivo;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import javax.imageio.ImageIO;
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
	private static int height  = 200;
	private static int width = 200;
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
		try {
		File destino = new File(arquivoDestinoPath + File.separator + origem.getName()+".jpg");
			BufferedImage originalImage = ImageIO.read(origem);
			int type = originalImage.getType() == 0? BufferedImage.TYPE_INT_ARGB : originalImage.getType();

			BufferedImage resizeImageJpg = resizeImage(originalImage, type);
			ImageIO.write(resizeImageJpg, "jpg", destino);
			
			return destino;
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao copiar arquivo. " + e.getMessage());
		}
		/*try {
			destino.getParentFile().mkdirs(); // Cria diretório

			Files.copy(origem.toPath(), destino.toPath(), StandardCopyOption.REPLACE_EXISTING);

			return destino;
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao copiar arquivo. " + e.getMessage());
			return null;
		}*/
		return null;
	}
	private static BufferedImage resizeImage(BufferedImage originalImage, int type){
		BufferedImage resizedImage = new BufferedImage(width, height, type);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, width, height, null);
		g.dispose();

		return resizedImage;
	}
}
