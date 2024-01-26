package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;


import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;
import entidades.Investigador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import com.github.javafaker.Faker;	

public class PantallaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaPrincipal frame = new PantallaPrincipal();
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
	public PantallaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(131, 22, 165, 21);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BotonesAgregar ba = new BotonesAgregar();
				ba.setVisible(true);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnAgregar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EliminarInvestigador ei = new EliminarInvestigador();
				ei.setVisible(true);
			}
		});
		btnEliminar.setBounds(131, 168, 165, 21);
		contentPane.add(btnEliminar);
		
		JButton btnGenerarDatos = new JButton("Generar Datos");
		btnGenerarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			        Session session = HibernateUtil.getSessionFactory().openSession();
			        Transaction transaction = null;
			        Faker faker = new Faker();

			        try {
			            transaction = session.beginTransaction();

			            for (int i = 0; i < 1000; i++) {
			                Investigador investigador = new Investigador();
			                investigador.setInvNombre(faker.name().fullName());
			                investigador.setInvExtension(faker.number().numberBetween(1000, 9999));
			                investigador.setInvEmail(faker.internet().emailAddress());
			                investigador.setInvSni(faker.number().numberBetween(1, 10)); // Ajustar según tu lógica
			                investigador.setInvProdep(faker.number().numberBetween(1, 10)); // Ajustar según tu lógica
			                investigador.setInvCategoria(faker.number().numberBetween(0, 5)); // Asumiendo que la categoría es un índice
			                investigador.setInvDescripcion(faker.lorem().sentence());
			                investigador.setInvCubiculo(faker.number().numberBetween(1, 20)); // Ajustar según tu lógica

			                session.save(investigador);
			            }

			            transaction.commit();
			        } catch (RuntimeException ex) {
			            if (transaction != null) transaction.rollback();
			            ex.printStackTrace();
			        } finally {
			            session.close();
			        }
			    
			}
		});
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
