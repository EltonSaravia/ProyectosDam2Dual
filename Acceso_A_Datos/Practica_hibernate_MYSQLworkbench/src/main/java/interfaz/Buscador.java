package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Buscador extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldNombreABuscar;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Buscador dialog = new Buscador();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Buscador() {
		setBounds(100, 100, 703, 649);
		getContentPane().setLayout(null);
		
		textFieldNombreABuscar = new JTextField();
		textFieldNombreABuscar.setBounds(234, 22, 286, 20);
		getContentPane().add(textFieldNombreABuscar);
		textFieldNombreABuscar.setColumns(10);
		
		JLabel lblNewLabelBuscarNombre = new JLabel("Nombre");
		lblNewLabelBuscarNombre.setBounds(165, 22, 78, 20);
		getContentPane().add(lblNewLabelBuscarNombre);
		
		JButton btnNewButtonBuscar = new JButton("Buscar");
		btnNewButtonBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButtonBuscar.setBounds(544, 65, 89, 23);
		getContentPane().add(btnNewButtonBuscar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 2, 2);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBounds(0, 0, 1, 1);
		getContentPane().add(table);
		
		JComboBox comboBoxNombreEducacion = new JComboBox();
		comboBoxNombreEducacion.setBounds(48, 65, 195, 22);
		getContentPane().add(comboBoxNombreEducacion);
		
		JComboBox comboBoxNombreInstitucion = new JComboBox();
		comboBoxNombreInstitucion.setBounds(284, 65, 236, 22);
		getContentPane().add(comboBoxNombreInstitucion);
		
		JLabel lblNewLabelFiltrarEducacion = new JLabel("Filtrar por Educacion");
		lblNewLabelFiltrarEducacion.setBounds(48, 51, 195, 14);
		getContentPane().add(lblNewLabelFiltrarEducacion);
		
		JLabel lblNewLabelFiltrarInstitucion = new JLabel("Filtrar por Institucion");
		lblNewLabelFiltrarInstitucion.setBounds(284, 51, 195, 14);
		getContentPane().add(lblNewLabelFiltrarInstitucion);
		
		JLabel lblNewLabelBuscadorInvestigadores = new JLabel("Buscador de investigadores");
		lblNewLabelBuscadorInvestigadores.setBounds(507, 99, 170, 14);
		getContentPane().add(lblNewLabelBuscadorInvestigadores);
		
		JButton btnNewButtonATRAS = new JButton("Atras");
		btnNewButtonATRAS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButtonATRAS.setBounds(10, 11, 59, 23);
		getContentPane().add(btnNewButtonATRAS);
	}
}
