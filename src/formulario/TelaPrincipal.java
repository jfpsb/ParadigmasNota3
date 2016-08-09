package formulario;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Primeira tela da aplica��o.
 * @author jfpsb
 *
 */
public class TelaPrincipal {
	static private JFrame telaPrincipal;
	static private JPanel panel;
	static private JLabel cabecalho;
	
	/**
	 * Chama o m�todo que inicializa os componentes da UI.
	 */
	public TelaPrincipal () {
		inicializarControles();
	}
	
	/**
	 * Instancia e configura elementos da UI.
	 */
	private static void inicializarControles() {
		telaPrincipal = new JFrame("Gerenciador de Publica��es");
		panel = new JPanel();
		cabecalho = new JLabel("Gerenciador de Publica��es");
		
		//cabecalho
		//Configura��es aqui
		
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
