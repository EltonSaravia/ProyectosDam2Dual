package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;
import entidades.Investigador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class AgregarInvestigador extends JDialog {
	
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldExtencion;
	private JTextField textFieldNombre;
	private JTextField textFieldEmail;
	private JTextField textFieldSNI;
	private JTextField textFieldProdep;
	private JTextField textFieldDescripcion;
	private JTextField textCubiculo;



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
		lblCategoria.setBounds(10, 337, 106, 27);
		contentPanel.add(lblCategoria);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDescripcion.setBounds(10, 438, 236, 27);
		contentPanel.add(lblDescripcion);
		
		textFieldExtencion = new JTextField();
		textFieldExtencion.setBounds(218, 33, 314, 19);
		contentPanel.add(textFieldExtencion);
		textFieldExtencion.setColumns(10);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(219, 97, 313, 19);
		contentPanel.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(219, 161, 313, 19);
		contentPanel.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		textFieldSNI = new JTextField();
		textFieldSNI.setBounds(219, 225, 313, 19);
		contentPanel.add(textFieldSNI);
		textFieldSNI.setColumns(10);
		
		textFieldProdep = new JTextField();
		textFieldProdep.setBounds(219, 296, 313, 19);
		contentPanel.add(textFieldProdep);
		textFieldProdep.setColumns(10);
		
		textFieldDescripcion = new JTextField();
		textFieldDescripcion.setBounds(218, 434, 314, 41);
		contentPanel.add(textFieldDescripcion);
		textFieldDescripcion.setColumns(10);
		
		JComboBox comboBoxCategoria = new JComboBox();
		comboBoxCategoria.setBounds(218, 343, 314, 21);
		contentPanel.add(comboBoxCategoria);
		
		JLabel lblCubiculo = new JLabel("Cubiculo");
		lblCubiculo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCubiculo.setBounds(10, 390, 186, 27);
		contentPanel.add(lblCubiculo);
		
		textCubiculo = new JTextField();
		textCubiculo.setColumns(10);
		textCubiculo.setBounds(218, 397, 314, 19);
		contentPanel.add(textCubiculo);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnGuardar = new JButton("Guardar");
				btnGuardar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

				        // Begin Hibernate session
				        Session session = HibernateUtil.getSessionFactory().openSession();
				        Transaction transaction = null;
				        try {
				            transaction = session.beginTransaction();
				            
				            // Create an instance of Investigador and set its properties using the text fields
				            Investigador investigador = new Investigador();
				            investigador.setInvExtension(null);
				            investigador.setInvNombre(textFieldNombre.getText());
				            investigador.setInvEmail(textFieldEmail.getText());
				            investigador.setInvSni(Integer.parseInt(textFieldSNI.getText()));
				            investigador.setInvProdep(Integer.parseInt(textFieldSNI.getText()));
				            investigador.setInvCategoria(comboBoxCategoria.getSelectedIndex());
				            investigador.setInvDescripcion(textFieldDescripcion.getText());
				            
				            // Save the investigador instance to the database
				            session.save(investigador);
				            
				            // Commit the transaction
				            transaction.commit();
				        } catch (RuntimeException ex) {
				            if (transaction != null) transaction.rollback();
				            ex.printStackTrace();
				        } finally {
				            session.close();
				        }
						
					}
				});
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
