package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class AgregarTrabajosDirigidos extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldNombreTrabajo;
	private JTextField textField_Alumno;
	private JTextField textFieldTipo;
	private JTextField textFieldNivel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AgregarTrabajosDirigidos dialog = new AgregarTrabajosDirigidos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AgregarTrabajosDirigidos() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabelNombreTrabajo = new JLabel("Nombre trabajo de grado");
			lblNewLabelNombreTrabajo.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabelNombreTrabajo.setBounds(31, 20, 207, 17);
			contentPanel.add(lblNewLabelNombreTrabajo);
		}
		{
			JLabel lblNewLabelAlumno = new JLabel("Alumno");
			lblNewLabelAlumno.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabelAlumno.setBounds(31, 59, 83, 13);
			contentPanel.add(lblNewLabelAlumno);
		}
		{
			JLabel lblNewLabelNivel = new JLabel("Nivel");
			lblNewLabelNivel.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabelNivel.setBounds(30, 139, 83, 13);
			contentPanel.add(lblNewLabelNivel);
		}
		{
			JLabel lblNewLabelTipo = new JLabel("Tipo");
			lblNewLabelTipo.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabelTipo.setBounds(31, 182, 164, 25);
			contentPanel.add(lblNewLabelTipo);
		}
		{
			JLabel lblNewLabelInvestigador = new JLabel("Investigador");
			lblNewLabelInvestigador.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabelInvestigador.setBounds(31, 96, 100, 17);
			contentPanel.add(lblNewLabelInvestigador);
		}
		{
			textFieldNombreTrabajo = new JTextField();
			textFieldNombreTrabajo.setBounds(258, 21, 145, 19);
			contentPanel.add(textFieldNombreTrabajo);
			textFieldNombreTrabajo.setColumns(10);
		}
		{
			textField_Alumno = new JTextField();
			textField_Alumno.setBounds(138, 58, 265, 19);
			contentPanel.add(textField_Alumno);
			textField_Alumno.setColumns(10);
		}
		{
			textFieldTipo = new JTextField();
			textFieldTipo.setBounds(138, 187, 265, 19);
			contentPanel.add(textFieldTipo);
			textFieldTipo.setColumns(10);
		}
		{
			textFieldNivel = new JTextField();
			textFieldNivel.setBounds(138, 138, 265, 19);
			contentPanel.add(textFieldNivel);
			textFieldNivel.setColumns(10);
		}
		{
			JComboBox comboBoxInvestigador = new JComboBox();
			comboBoxInvestigador.setBounds(141, 96, 262, 21);
			contentPanel.add(comboBoxInvestigador);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton ButtonGuardar = new JButton("Guardar");
				ButtonGuardar.setActionCommand("OK");
				buttonPane.add(ButtonGuardar);
				getRootPane().setDefaultButton(ButtonGuardar);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
