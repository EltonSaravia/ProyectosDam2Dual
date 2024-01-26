package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgregarEducacion extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldTerminoEstudios;
	private JTextField textFieldEducacionEstudios;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AgregarEducacion dialog = new AgregarEducacion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AgregarEducacion() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabelEducacion = new JLabel("Educacion");
			lblNewLabelEducacion.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabelEducacion.setBounds(38, 38, 174, 13);
			contentPanel.add(lblNewLabelEducacion);
		}
		{
			JLabel lblNewLabelTermino = new JLabel("Termino");
			lblNewLabelTermino.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabelTermino.setBounds(38, 89, 174, 13);
			contentPanel.add(lblNewLabelTermino);
		}
		{
			JLabel lblNewLabelInvestigador = new JLabel("Investigador");
			lblNewLabelInvestigador.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabelInvestigador.setBounds(38, 141, 174, 13);
			contentPanel.add(lblNewLabelInvestigador);
		}
		{
			JComboBox comboBoxEstudianteEstudios = new JComboBox();
			comboBoxEstudianteEstudios.setBounds(209, 139, 206, 21);
			contentPanel.add(comboBoxEstudianteEstudios);
		}
		{
			textFieldTerminoEstudios = new JTextField();
			textFieldTerminoEstudios.setBounds(209, 88, 206, 19);
			contentPanel.add(textFieldTerminoEstudios);
			textFieldTerminoEstudios.setColumns(10);
		}
		{
			textFieldEducacionEstudios = new JTextField();
			textFieldEducacionEstudios.setBounds(209, 37, 206, 19);
			contentPanel.add(textFieldEducacionEstudios);
			textFieldEducacionEstudios.setColumns(10);
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
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
