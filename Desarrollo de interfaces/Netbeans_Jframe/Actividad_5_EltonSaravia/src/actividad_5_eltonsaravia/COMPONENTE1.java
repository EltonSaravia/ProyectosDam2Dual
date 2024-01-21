/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad_5_eltonsaravia;

/**
 *
 * @author Usuario
 */
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class COMPONENTE1 extends JButton implements MouseListener {

    private Color originalBackgroundColor;
    private Color hoverBackgroundColor;
    
    public COMPONENTE1( ) {
         //super(text);
         init();
    }


    private void init() {
        //si la duente no esta en el equipo eligira la que el ordenador tome por defecto 
        setFont(new Font("Vivaldi", Font.BOLD, 14));

        // Configurar colores
        originalBackgroundColor = new Color(100, 30, 22);
        setBackground(originalBackgroundColor);
        setForeground(new Color(33, 47, 60));

        // Agregar el manejador de eventos del mouse
        addMouseListener(this);
    }

    public void setHoverBackgroundColor(Color hoverColor) {
        this.hoverBackgroundColor = hoverColor;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (hoverBackgroundColor != null) {
            setBackground(hoverBackgroundColor);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setBackground(originalBackgroundColor);
    }
}

