package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MostrarLista extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MostrarLista dialog = new MostrarLista();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MostrarLista() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JButton cancelButtonListaGrados = new JButton("Ver lista de Grados");
		cancelButtonListaGrados.setActionCommand("Cancel");
		cancelButtonListaGrados.setBounds(114, 119, 183, 21);
		contentPanel.add(cancelButtonListaGrados);
		
		JButton buttonListaTesis = new JButton("Ver Lista de tesis");
		buttonListaTesis.setActionCommand("Cancel");
		buttonListaTesis.setBounds(114, 77, 183, 21);
		contentPanel.add(buttonListaTesis);
		
		JButton buttonListaEducacion = new JButton("Ver lista de Estudios");
		buttonListaEducacion.setActionCommand("Cancel");
		buttonListaEducacion.setBounds(114, 29, 183, 21);
		contentPanel.add(buttonListaEducacion);
		
		JButton buttonListaLaboral = new JButton("Experiencia Laboral");
		buttonListaLaboral.setActionCommand("Cancel");
		buttonListaLaboral.setBounds(114, 165, 183, 21);
		contentPanel.add(buttonListaLaboral);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
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
