package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class AgregarInvestigador extends JDialog {
	
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AgregarInvestigador dialog = new AgregarInvestigador();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AgregarInvestigador() {
		setBounds(100, 100, 667, 573);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNombre = new JLabel("Nombre");
			lblNombre.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblNombre.setBounds(10, 97, 106, 13);
			contentPanel.add(lblNombre);
		}
		
		JLabel lblExtencion = new JLabel("Extension");
		lblExtencion.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblExtencion.setBounds(10, 33, 106, 13);
		contentPanel.add(lblExtencion);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEmail.setBounds(10, 161, 106, 13);
		contentPanel.add(lblEmail);
		
		JLabel lblSNI = new JLabel("SNI");
		lblSNI.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSNI.setBounds(10, 225, 106, 13);
		contentPanel.add(lblSNI);
		
		JLabel lblProdep = new JLabel("Prodep");
		lblProdep.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblProdep.setBounds(10, 289, 106, 27);
		contentPanel.add(lblProdep);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCategoria.setBounds(10, 353, 106, 27);
		contentPanel.add(lblCategoria);
		
		JLabel lblCubiculo = new JLabel("Descripcion");
		lblCubiculo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCubiculo.setBounds(10, 417, 236, 27);
		contentPanel.add(lblCubiculo);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnGuardar = new JButton("Guardar");
				btnGuardar.setActionCommand("OK");
				buttonPane.add(btnGuardar);
				getRootPane().setDefaultButton(btnGuardar);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
