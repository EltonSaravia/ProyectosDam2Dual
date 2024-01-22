package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;

public class AgregarTesis extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldNombreTesis;
	private JTextField textFieldDescripcionTesis;
	private JTextField textFieldGradoTesis;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AgregarTesis dialog = new AgregarTesis();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AgregarTesis() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabelNombreTesis = new JLabel("Nombre de Tesis");
		lblNewLabelNombreTesis.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabelNombreTesis.setBounds(49, 28, 149, 13);
		contentPanel.add(lblNewLabelNombreTesis);
		
		JLabel lblNewLabelDescripcionTesis = new JLabel("Descripcion");
		lblNewLabelDescripcionTesis.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabelDescripcionTesis.setBounds(49, 64, 149, 18);
		contentPanel.add(lblNewLabelDescripcionTesis);
		
		JLabel lblNewLabel = new JLabel("Grado");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(49, 115, 149, 13);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabelInvestigador = new JLabel("Investigador");
		lblNewLabelInvestigador.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabelInvestigador.setBounds(49, 169, 149, 18);
		contentPanel.add(lblNewLabelInvestigador);
		
		textFieldNombreTesis = new JTextField();
		textFieldNombreTesis.setBounds(245, 27, 169, 19);
		contentPanel.add(textFieldNombreTesis);
		textFieldNombreTesis.setColumns(10);
		
		textFieldDescripcionTesis = new JTextField();
		textFieldDescripcionTesis.setBounds(245, 63, 169, 19);
		contentPanel.add(textFieldDescripcionTesis);
		textFieldDescripcionTesis.setColumns(10);
		
		textFieldGradoTesis = new JTextField();
		textFieldGradoTesis.setBounds(245, 114, 169, 19);
		contentPanel.add(textFieldGradoTesis);
		textFieldGradoTesis.setColumns(10);
		
		JComboBox comboBoxInvestigador = new JComboBox();
		comboBoxInvestigador.setBounds(208, 170, 206, 21);
		contentPanel.add(comboBoxInvestigador);
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
