package arquivo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * Classe que vai manipular as intera��es com arquivos.
 * 
 * @author jfpsb
 *
 */
public class ManipularArquivo {
	/**
	 * M�todo que escreve o valor de data em um arquivo.
	 * 
	 * @param data
	 *            O que ser� escrito na linha.
	 * @param destino
	 *            Caminho especificado do arquivo onde ser� escrito algo.
	 */
	public static void escreverEntidadeTXT(String data, File destino) {
		FileWriter fw;
		BufferedWriter bw;
		try {
			// if file doesnt exists, then create it
			if (!destino.exists()) {
				destino.createNewFile();
			}

			fw = new FileWriter(destino.getAbsoluteFile(), true);
			bw = new BufferedWriter(fw);
			bw.write(data);
			bw.newLine();
			bw.close();
		} catch (IOException e) {
			// TODO Tela se der erro ao escrever
			e.printStackTrace();
		}
	}

	/**
	 * Cria arquivo Excel ap�s configura��o deste em CriaRelatorio.java
	 * 
	 * @param destino
	 *            Caminho especificado onde ficar� o arquivo gerado.
	 * @param workbook
	 *            Arquivo que representa a planilha Excel.
	 */
	public static void criarArquivoExcel(File destino, HSSFWorkbook workbook) {
		FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream(destino.getAbsoluteFile());
			workbook.write(fileOut);

			JOptionPane.showMessageDialog(null, "Relat�rio salvo com sucesso.");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fileOut.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
