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
			JOptionPane.showMessageDialog(null, "Erro ao escrever em arquivo. \n\n" + e.getMessage());
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
			JOptionPane.showMessageDialog(null, "Erro ao criar arquivo Excel. O caminho especificado n�o foi encontrado.\n\n" + e.getMessage());
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao criar arquivo Excel.\n\n" + e.getMessage());
		} finally {
			try {
				fileOut.close();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Erro ao fechar FileOutPutStream.\n\n" + e.getMessage());
			}
		}
	}
}
