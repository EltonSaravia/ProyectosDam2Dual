/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package OrdenarTabla.interfaz;

import OrdenarTabla.gto.Alumno;
import OrdenarTabla.interfaz.TableModel.AlumnosTableModel;
import OrdenarTabla.logica.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.RowSorter.SortKey;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.*;

/**
 *
 * @author Usuario
 */
public class PantallaPrincipal extends javax.swing.JFrame {
    
    private TableRowSorter<AlumnosTableModel> sorter;
    /**
     * Creates new form PantallaPrincipal
     */
    public PantallaPrincipal() {
        initComponents();
        jTableAlumnos.setModel(new AlumnosTableModel(LogicaAlumnos.getListaAlumnos()));
        rellenarTablaAlumnos();
    }

    
    private void rellenarTablaAlumnos(){
        AlumnosTableModel tma = new AlumnosTableModel(LogicaAlumnos.getListaAlumnos());
        jTableAlumnos.setModel(tma);
        
        sorter = new TableRowSorter<>(tma);
        jTableAlumnos.setRowSorter(sorter);
        
        List<SortKey> sortKeys = new ArrayList <>();
        sortKeys.add(new SortKey(3, SortOrder.ASCENDING));
        sorter.setSortKeys(sortKeys);
        /*****************************************/
        
    }
    
    private void refrescarTabla(){
        DefaultTableModel dtm = new DefaultTableModel();
            dtm.setColumnIdentifiers(new String [] {"Nombre","Asignatura","Curso", "Nota", "Repetidor"});
        
        List<Alumno> listaAlumnos = LogicaAlumnos.getListaAlumnos();
            for(Alumno cliente: listaAlumnos){
                
                dtm.addRow(cliente.toArrayStrings());
                
            }
        
        jTableAlumnos.setModel(dtm);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAlumnos = new javax.swing.JTable();
        jButtonSeleccionar = new javax.swing.JButton();
        jButtonFiltrar = new javax.swing.JButton();
        jTextFieldFiltrar = new javax.swing.JTextField();
        jLabelSeleccionar = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuAlumno = new javax.swing.JMenu();
        jMenuItemAnadir = new javax.swing.JMenuItem();
        jMenuItemEliminar = new javax.swing.JMenuItem();
        jMenuFiltros = new javax.swing.JMenu();
        jMenuItemMostrarAprobados = new javax.swing.JMenuItem();
        jMenuItemMostrarNoAprobados = new javax.swing.JMenuItem();
        jMenuItemMostrarRepetidores = new javax.swing.JMenuItem();
        jMenuItemMostrarTodos = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 102, 102));

        jTableAlumnos.setBackground(new java.awt.Color(0, 102, 102));
        jTableAlumnos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTableAlumnos.setForeground(new java.awt.Color(255, 255, 255));
        jTableAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableAlumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableAlumnosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableAlumnos);

        jButtonSeleccionar.setBackground(new java.awt.Color(0, 102, 102));
        jButtonSeleccionar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonSeleccionar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSeleccionar.setText("Seleccionar");

        jButtonFiltrar.setBackground(new java.awt.Color(0, 102, 102));
        jButtonFiltrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonFiltrar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonFiltrar.setText("Filtrar");
        jButtonFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFiltrarActionPerformed(evt);
            }
        });

        jTextFieldFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldFiltrarActionPerformed(evt);
            }
        });

        jMenuBar1.setBackground(new java.awt.Color(0, 102, 102));
        jMenuBar1.setForeground(new java.awt.Color(0, 102, 102));

        jMenuAlumno.setText("Alumno");

        jMenuItemAnadir.setText("Añadir ...");
        jMenuItemAnadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAnadirActionPerformed(evt);
            }
        });
        jMenuAlumno.add(jMenuItemAnadir);

        jMenuItemEliminar.setText("Eliminar ...");
        jMenuAlumno.add(jMenuItemEliminar);

        jMenuBar1.add(jMenuAlumno);

        jMenuFiltros.setText("Filtros");

        jMenuItemMostrarAprobados.setText("Mostrar Aprobados");
        jMenuItemMostrarAprobados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemMostrarAprobadosActionPerformed(evt);
            }
        });
        jMenuFiltros.add(jMenuItemMostrarAprobados);

        jMenuItemMostrarNoAprobados.setText("Mostrar no aprobados");
        jMenuItemMostrarNoAprobados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemMostrarNoAprobadosActionPerformed(evt);
            }
        });
        jMenuFiltros.add(jMenuItemMostrarNoAprobados);

        jMenuItemMostrarRepetidores.setText("Mostrar Repetidores");
        jMenuItemMostrarRepetidores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemMostrarRepetidoresActionPerformed(evt);
            }
        });
        jMenuFiltros.add(jMenuItemMostrarRepetidores);

        jMenuItemMostrarTodos.setText("Mostrar Todos");
        jMenuItemMostrarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemMostrarTodosActionPerformed(evt);
            }
        });
        jMenuFiltros.add(jMenuItemMostrarTodos);

        jMenuBar1.add(jMenuFiltros);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonFiltrar)
                            .addComponent(jButtonSeleccionar))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldFiltrar, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                            .addComponent(jLabelSeleccionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonSeleccionar)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelSeleccionar, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                        .addGap(4, 4, 4)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonFiltrar)
                    .addComponent(jTextFieldFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldFiltrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldFiltrarActionPerformed

    private void jMenuItemAnadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAnadirActionPerformed
        PantallaAnadirAlumno pantallaAddAlumno = new PantallaAnadirAlumno(this, true);
        pantallaAddAlumno.setVisible(true);
        rellenarTablaAlumnos();
    }//GEN-LAST:event_jMenuItemAnadirActionPerformed

    private void jTableAlumnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableAlumnosMouseClicked
        int seleccionado = jTableAlumnos.convertRowIndexToModel(jTableAlumnos.getSelectedRow());
        jLabelSeleccionar.setText(LogicaAlumnos.getListaAlumnos().get(seleccionado).getNombre());
    }//GEN-LAST:event_jTableAlumnosMouseClicked

    private void jButtonFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFiltrarActionPerformed
        
        RowFilter<AlumnosTableModel,Integer> rf = RowFilter.regexFilter(jTextFieldFiltrar.getText(), 0);
        sorter.setRowFilter(rf);
    }//GEN-LAST:event_jButtonFiltrarActionPerformed

    private void jMenuItemMostrarAprobadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemMostrarAprobadosActionPerformed
  RowFilter<AlumnosTableModel, Integer> filtroAprobados = new RowFilter<AlumnosTableModel, Integer>() {
        public boolean include(Entry<? extends AlumnosTableModel, ? extends Integer> entry) {
            int nota = Integer.parseInt(entry.getStringValue(3));
            return nota >= 5; // Filtra para mostrar solo aprobados (nota >= 5)
        }
    };

    sorter.setRowFilter(filtroAprobados);
    }//GEN-LAST:event_jMenuItemMostrarAprobadosActionPerformed

    private void jMenuItemMostrarNoAprobadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemMostrarNoAprobadosActionPerformed
        RowFilter<AlumnosTableModel, Integer> filtroAprobados = new RowFilter<AlumnosTableModel, Integer>() {
        public boolean include(Entry<? extends AlumnosTableModel, ? extends Integer> entry) {
            int nota = Integer.parseInt(entry.getStringValue(3));
            return nota <= 5; 
        }
    };

    sorter.setRowFilter(filtroAprobados);
    }//GEN-LAST:event_jMenuItemMostrarNoAprobadosActionPerformed

    private void jMenuItemMostrarRepetidoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemMostrarRepetidoresActionPerformed
        RowFilter<AlumnosTableModel, Integer> filtroRepetidores = new RowFilter<AlumnosTableModel, Integer>() {
        public boolean include(Entry<? extends AlumnosTableModel, ? extends Integer> entry) {
            String repetidor = entry.getStringValue(4);
            return "si".equalsIgnoreCase(repetidor); 
        }
    };

    sorter.setRowFilter(filtroRepetidores);
    }//GEN-LAST:event_jMenuItemMostrarRepetidoresActionPerformed

    private void jMenuItemMostrarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemMostrarTodosActionPerformed
        sorter.setRowFilter(null); // Elimina cualquier filtro aplicado
    }//GEN-LAST:event_jMenuItemMostrarTodosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonFiltrar;
    private javax.swing.JButton jButtonSeleccionar;
    private javax.swing.JLabel jLabelSeleccionar;
    private javax.swing.JMenu jMenuAlumno;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuFiltros;
    private javax.swing.JMenuItem jMenuItemAnadir;
    private javax.swing.JMenuItem jMenuItemEliminar;
    private javax.swing.JMenuItem jMenuItemMostrarAprobados;
    private javax.swing.JMenuItem jMenuItemMostrarNoAprobados;
    private javax.swing.JMenuItem jMenuItemMostrarRepetidores;
    private javax.swing.JMenuItem jMenuItemMostrarTodos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableAlumnos;
    private javax.swing.JTextField jTextFieldFiltrar;
    // End of variables declaration//GEN-END:variables
}
