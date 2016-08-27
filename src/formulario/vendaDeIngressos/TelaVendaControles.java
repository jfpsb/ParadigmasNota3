package formulario.vendaDeIngressos;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.github.lgooddatepicker.components.DatePicker;

public class TelaVendaControles extends JFrame{
	private JPanel panelPrincipal;
	private JPanel panelCenter;
	private JPanel panelSuperior;
	private JLabel lblData;
	private DatePicker datePicker;	
	private ArrayList<Object> movies;
	//mudar pra Filme.
	/**
	 * Chama o método que inicializa os componentes da UI.
	 */
	public TelaVendaControles(){
		super("Venda de Ingressos");
		inicializarControles();
	}
	/**
	 * Instancia e configura elementos da UI.
	 */
	private void inicializarControles() {
		panelPrincipal = new JPanel(new BorderLayout());
		panelSuperior = new JPanel(new FlowLayout());
		panelCenter = new JPanel(new GridLayout(3, /*movies.size()*/5));		
		datePicker = new DatePicker();
		lblData = new JLabel("Data da Sessão: ");
		lblData.setFont(lblData.getFont().deriveFont(16F));
		
		//panelSuperior
		panelSuperior.add(lblData);
		panelSuperior.add(datePicker);
		
		//panelPrincipal
		panelPrincipal.add(panelSuperior, BorderLayout.NORTH);
		panelPrincipal.add(panelCenter, BorderLayout.CENTER);
		
		//tela
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setMinimumSize(new Dimension(1280, 720));
		this.pack();
		this.setLocationRelativeTo(null);
		this.add(panelPrincipal);
	}
	/**
	 * Abre tela.
	 */
	public void mostrarTela() {
		this.setVisible(true);
	}
}
