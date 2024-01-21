/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad_5_eltonsaravia;

/**
 *
 * @author Usuario
 */
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.JOptionPane;

public class Componente2 extends JLabel {

    private String navegador;
    private String paginaWeb;

    public Componente2() {
        super("URL");
        setForeground(Color.BLUE);
        setBackground(Color.RED);
        setOpaque(true); // Esto es necesario para que se muestre el color de fondo.
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                abrirURL();
            }
        });
    }

    public void setNavegador(String navegador) {
        this.navegador = navegador;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    private void abrirURL() {
        if (paginaWeb == null || paginaWeb.isEmpty() || navegador == null || navegador.isEmpty()) {
            JOptionPane.showMessageDialog(this, "La dirección de la página web o el navegador no están configurados correctamente.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            // Intenta abrir la URL en el navegador predeterminado del sistema
            if (navegador.equalsIgnoreCase("default")) {
                Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
                if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
                    desktop.browse(new URI(paginaWeb));
                }
            } else {
                // Abre la URL en el navegador especificado
                new ProcessBuilder(navegador, paginaWeb).start();
            }
        } catch (IOException | URISyntaxException ex) {
            JOptionPane.showMessageDialog(this, "No se pudo abrir la página web: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

