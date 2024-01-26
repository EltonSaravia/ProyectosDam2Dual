package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;

public class MostrarInvestigadores extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MostrarInvestigadores frame = new MostrarInvestigadores();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MostrarInvestigadores() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(131, 22, 165, 21);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarInvestigador ai = new AgregarInvestigador();
				ai.setVisible(true);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnAgregar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(131, 168, 165, 21);
		contentPane.add(btnEliminar);
		
		JButton btnGenerarDatos = new JButton("Generar Datos");
		btnGenerarDatos.setBounds(131, 54, 165, 21);
		contentPane.add(btnGenerarDatos);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(131, 137, 165, 21);
		contentPane.add(btnBuscar);
		
		JButton btnMostrarLista = new JButton("Mostrar Lista");
		btnMostrarLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MostrarLista ai = new MostrarLista();
				ai.setVisible(true);
			}
		});
		btnMostrarLista.setBounds(131, 85, 165, 21);
		contentPane.add(btnMostrarLista);
	}

}
