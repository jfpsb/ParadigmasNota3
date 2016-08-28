package arquivo;

import java.io.File;

import javax.swing.JTable;
import javax.swing.table.TableModel;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;

/**
 * Classe que configura o arquivo Excel baseado nos dados das tabelas de
 * entidades.
 * 
 * @author jfpsb
 *
 */
public class CriaRelatorio {
	/**
	 * Cria arquivos de planinha, fonte e estilo para escrever a planilha em
	 * Excel com dados das tabelas.
	 * 
	 * @param tabela
	 *            Tabela contendo os dados a serem escritos.
	 * @param destino
	 *            Caminho especificado onde ficará salvo o arquivo Excel.
	 * @param nomeEntidade
	 *            Nome da entidade sendo salva.
	 */
	public static void escreveRelatorio(JTable tabela, File destino, String nomeEntidade) {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Planilha - " + nomeEntidade);
		TableModel dtm = tabela.getModel();

		// Fontes
		Font fonteCab = workbook.createFont();
		Font fonteColuna = workbook.createFont();
		Font fonteConteudo = workbook.createFont();

		// Estilos
		CellStyle estiloCab = workbook.createCellStyle();
		CellStyle estiloColuna = workbook.createCellStyle();
		CellStyle estiloConteudo = workbook.createCellStyle();

		// Linhas de planinha
		HSSFRow rowCabecalho = sheet.createRow(0);
		HSSFRow rowColunas = sheet.createRow(1);
		HSSFRow rowConteudo; // Criado dentro do laço

		// fonteCab
		fonteCab.setFontHeightInPoints((short) 18);
		fonteCab.setFontName("Courier New");
		fonteCab.setBold(true);

		// fonteColuna
		fonteColuna.setFontHeightInPoints((short) 14);
		fonteColuna.setFontName("Courier New");
		fonteColuna.setBold(true);

		// fonteConteudo
		fonteConteudo.setFontHeightInPoints((short) 12);
		fonteConteudo.setFontName("Courier New");

		estiloCab.setFillBackgroundColor(IndexedColors.GREY_40_PERCENT.getIndex());
		estiloCab.setFillPattern(CellStyle.SPARSE_DOTS);

		estiloColuna.setFillBackgroundColor(IndexedColors.GREY_40_PERCENT.getIndex());
		estiloColuna.setFillPattern(CellStyle.SPARSE_DOTS);

		// Colocando fontes nos estilos
		estiloCab.setFont(fonteCab);
		estiloColuna.setFont(fonteColuna);
		estiloConteudo.setFont(fonteConteudo);

		estiloCab.setAlignment(CellStyle.ALIGN_CENTER);
		estiloColuna.setAlignment(CellStyle.ALIGN_CENTER);
		estiloConteudo.setAlignment(CellStyle.ALIGN_CENTER);

		// Célula de cabeçalho na linha 0
		HSSFCell celulaCab = rowCabecalho.createCell(0);
		celulaCab.setCellValue("LISTA DE " + nomeEntidade.toUpperCase() + ": ");
		configuraBordasCelular(estiloCab);
		celulaCab.setCellStyle(estiloCab);

		// Escreve os headers das colunas
		for (int i = 0; i < dtm.getColumnCount(); i++) {
			HSSFCell celula = rowColunas.createCell(i);
			celula.setCellValue(dtm.getColumnName(i));
			configuraBordasCelular(estiloColuna);
			celula.setCellStyle(estiloColuna);
		}

		// Escreve conteúdo da tabela
		for (int i = 0; i < dtm.getRowCount(); i++) {
			rowConteudo = sheet.createRow(i + 2);
			for (int j = 0; j < dtm.getColumnCount(); j++) {
				HSSFCell celula = rowConteudo.createCell(j);
				celula.setCellValue(retornaValorEmCelula(dtm, i, j).toString());
				configuraBordasCelular(estiloConteudo);
				celula.setCellStyle(estiloConteudo);
			}
		}

		// Ajusta o tamanho das colunas para caber o conteúdo
		// Tem que ser feito depois de todo o conteúdo já estar lá
		for (int i = 0; i < dtm.getColumnCount(); i++) {
			sheet.autoSizeColumn(i);
		}

		ManipularArquivo.criarArquivoExcel(destino, workbook);
	}

	private static void configuraBordasCelular(CellStyle style) {
		style.setBorderBottom(CellStyle.BORDER_THIN);
		style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderLeft(CellStyle.BORDER_THIN);
		style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderRight(CellStyle.BORDER_THIN);
		style.setRightBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderTop(CellStyle.BORDER_THIN);
		style.setTopBorderColor(IndexedColors.BLACK.getIndex());
	}

	private static String retornaValorEmCelula(TableModel dtm, int i, int j) {
		Object obj = dtm.getValueAt(i, j);

		if (obj instanceof Boolean) {
			boolean var = (boolean) obj;

			if (var)
				return "Sim";
			else
				return "Não";
		}

		return obj.toString();
	}
}
