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

public class AgregarExperiencia extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AgregarExperiencia dialog = new AgregarExperiencia();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AgregarExperiencia() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabelInstitucion = new JLabel("Institucion");
			lblNewLabelInstitucion.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabelInstitucion.setBounds(32, 27, 152, 13);
			contentPanel.add(lblNewLabelInstitucion);
		}
		{
			JLabel lblNewLabelPeriodo = new JLabel("Periodo");
			lblNewLabelPeriodo.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabelPeriodo.setBounds(32, 81, 152, 13);
			contentPanel.add(lblNewLabelPeriodo);
		}
		{
			JLabel lblNewLabelDescripcionEXPLaboral = new JLabel("Descripcion");
			lblNewLabelDescripcionEXPLaboral.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabelDescripcionEXPLaboral.setBounds(32, 125, 152, 22);
			contentPanel.add(lblNewLabelDescripcionEXPLaboral);
		}
		{
			JLabel lblNewLabelEstudianteEXPlaboral = new JLabel("Estudiante");
			lblNewLabelEstudianteEXPlaboral.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabelEstudianteEXPlaboral.setBounds(32, 179, 152, 13);
			contentPanel.add(lblNewLabelEstudianteEXPlaboral);
		}
		{
			textField = new JTextField();
			textField.setBounds(194, 26, 209, 19);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			textField_1 = new JTextField();
			textField_1.setBounds(194, 80, 209, 19);
			contentPanel.add(textField_1);
			textField_1.setColumns(10);
		}
		{
			textField_2 = new JTextField();
			textField_2.setBounds(194, 129, 209, 19);
			contentPanel.add(textField_2);
			textField_2.setColumns(10);
		}
		{
			JComboBox comboBox = new JComboBox();
			comboBox.setBounds(132, 177, 271, 21);
			contentPanel.add(comboBox);
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
