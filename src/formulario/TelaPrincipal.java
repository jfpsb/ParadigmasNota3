package formulario;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Primeira tela da aplicação.
 * @author jfpsb
 *
 */
public class TelaPrincipal {
	static private JFrame telaPrincipal;
	static private JPanel panel;
	static private JLabel cabecalho;
	
	/**
	 * Chama o método que inicializa os componentes da UI.
	 */
	public TelaPrincipal () {
		inicializarControles();
	}
	
	/**
	 * Instancia e configura elementos da UI.
	 */
	private static void inicializarControles() {
		telaPrincipal = new JFrame("Gerenciador de Publicações");
		panel = new JPanel();
		cabecalho = new JLabel("Gerenciador de Publicações");
		
		//cabecalho
		//Configurações aqui
		
		//panel
		panel.add(cabecalho);
		
		//telaPrincipal
		telaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		telaPrincipal.setMinimumSize(new Dimension(640,360));
		telaPrincipal.pack();
		telaPrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
		telaPrincipal.add(panel);
	}
	
	/**
	 * Abre tela.
	 */
	public void executar() {
		telaPrincipal.setVisible(true);
	}
}
