package frontend.alumnos;

import backend.alumnos.GestorAlumnos;
import backend.diseños.Curso;
import backend.diseños.Institucion;
import backend.examenes.Examen;
import backend.gestores.GestorImportarPregunta;
import backend.usuarios.Alumno;
import frontend.auxiliares.CeldaListaRendererEntropy;
import frontend.auxiliares.ComponentMover;
import frontend.auxiliares.ComponentResizer;
import frontend.auxiliares.GestorBarrasDeEstado;
import frontend.auxiliares.GestorImagenes;
import frontend.auxiliares.LookAndFeelEntropy;
import frontend.estadisticas.PanelEstadisticasAlumno;
import frontend.inicio.VentanaPrincipal;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.KeyStroke;

/**
 * Clase que representa la interfaz de administración de diseños de examen.
 *
 * @author Denise
 */
public class DialogSelectorAlumno extends javax.swing.JDialog {

    private Object ultimoComboActivo;
    private Examen examenSeleccionado;
    private final GestorBarrasDeEstado gestorEstados;
    private final GestorImportarPregunta gestorImportarPregunta;
    private String strNombre, strApellido, strDocumento, strLegajo;
    private Institucion institucion;
    private Curso curso;

    /**
     * Constructor de la clase.
     *
     * @param padre ventana principal de la aplicación.
     * @param modal true si mantiene el foco, false de lo contrario.
     */
    public DialogSelectorAlumno(VentanaPrincipal padre, boolean modal) {
        super(padre, modal);
        initComponents();
        this.setSize(new Dimension(600, 400));
        this.setLocationRelativeTo(padre);
        this.getRootPane().registerKeyboardAction(new EscapeAction(),
                KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
                JComponent.WHEN_IN_FOCUSED_WINDOW);

        this.gestorImportarPregunta = new GestorImportarPregunta();
        this.gestorEstados = new GestorBarrasDeEstado(lblActualizacionEstado, lblIconoEstado);

        //Fondo translúcido.
        this.pnlEstado.setBackground(new Color(255, 255, 255, 123));
        this.lstAlumnos.setBackground(new Color(255, 255, 255, 123));
        this.scrAlumnos.getViewport().setOpaque(false);
        this.scrAlumnos.setOpaque(false);

        //Para que el undecorated dialog pueda moverse y ajustarse en tamaño.
        ComponentMover cm = new ComponentMover(JDialog.class, lblBarraTitulo);
        ComponentResizer cr = new ComponentResizer();
        cr.setSnapSize(new Dimension(10, 10));
        cr.registerComponent(this);

        //Seteo de combos de filtros.
        this.cmbInstitucion.setRenderer(new CeldaListaRendererEntropy());
        this.cmbCurso.setRenderer(new CeldaListaRendererEntropy());
        ArrayList<Institucion> colInstitucion = gestorImportarPregunta.getInstituciones();
        this.cmbInstitucion.addItem(new Institucion("Todas"));
        for (Institucion institucion : colInstitucion) {
            this.cmbInstitucion.addItem(institucion);
        }
        this.cmbInstitucion.setSelectedIndex(0);
        this.cmbCurso.addItem(new Curso("Todos"));
        this.cmbCurso.setSelectedIndex(0);
        lstAlumnos.setCellRenderer(new CeldaListaRendererEntropy());
        strNombre = "";
        strApellido = "";
        strDocumento = "";
        strLegajo = "";
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFondo = new frontend.auxiliares.PanelConFondo();
        lblBarraTitulo = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JButton();
        pnlEstado = new javax.swing.JPanel();
        lblActualizacionEstado = new javax.swing.JLabel();
        lblIconoEstado = new javax.swing.JLabel();
        pnlFiltros = new javax.swing.JPanel();
        cmbInstitucion = new javax.swing.JComboBox();
        lblNombreInstitucion = new javax.swing.JLabel();
        lblCurso = new javax.swing.JLabel();
        cmbCurso = new javax.swing.JComboBox();
        txtLegajo = new frontend.auxiliares.TextFieldEntropy();
        txtNombre = new frontend.auxiliares.TextFieldEntropy();
        lblNombre1 = new javax.swing.JLabel();
        lblLegajo = new javax.swing.JLabel();
        txtApellido = new frontend.auxiliares.TextFieldEntropy();
        lblApellido = new javax.swing.JLabel();
        lblDocumento = new javax.swing.JLabel();
        txtDocumento = new frontend.auxiliares.TextFieldEntropy();
        pnlCentral = new javax.swing.JPanel();
        scrAlumnos = new javax.swing.JScrollPane();
        lstAlumnos = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        pnlFondo.setImagen(GestorImagenes.crearImage("/frontend/imagenes/bg2.jpg"));
        pnlFondo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 102, 0), 1, true));

        lblBarraTitulo.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        lblBarraTitulo.setForeground(new java.awt.Color(255, 102, 0));
        lblBarraTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBarraTitulo.setText("Selector de alumnos");

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/frontend/imagenes/ic_mensajes_cerrar_opcion.png"))); // NOI18N
        btnCerrar.setBorder(null);
        btnCerrar.setContentAreaFilled(false);
        btnCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        lblActualizacionEstado.setFont(new java.awt.Font("Calibri", 2, 12)); // NOI18N
        lblActualizacionEstado.setForeground(new java.awt.Color(102, 102, 102));
        lblActualizacionEstado.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblActualizacionEstado.setText("Acá se escriben estados...");
        lblActualizacionEstado.setAlignmentX(0.5F);
        lblActualizacionEstado.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        lblIconoEstado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIconoEstado.setText(" ");
        lblIconoEstado.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout pnlEstadoLayout = new javax.swing.GroupLayout(pnlEstado);
        pnlEstado.setLayout(pnlEstadoLayout);
        pnlEstadoLayout.setHorizontalGroup(
            pnlEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEstadoLayout.createSequentialGroup()
                .addComponent(lblActualizacionEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblIconoEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlEstadoLayout.setVerticalGroup(
            pnlEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEstadoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(pnlEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblActualizacionEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIconoEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pnlFiltros.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filtrar por", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, LookAndFeelEntropy.FUENTE_REGULAR));
        pnlFiltros.setOpaque(false);

        cmbInstitucion.setBackground(new java.awt.Color(255, 204, 102));
        cmbInstitucion.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        cmbInstitucion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbInstitucionItemStateChanged(evt);
            }
        });
        cmbInstitucion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cmbInstitucionFocusGained(evt);
            }
        });

        lblNombreInstitucion.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblNombreInstitucion.setText("Institución:");

        lblCurso.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblCurso.setText("Curso:");

        cmbCurso.setBackground(new java.awt.Color(255, 204, 102));
        cmbCurso.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        cmbCurso.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbCursoItemStateChanged(evt);
            }
        });
        cmbCurso.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cmbCursoFocusGained(evt);
            }
        });

        txtLegajo.setTextoPorDefecto("Ingrese un legajo...");
        txtLegajo.mostrarTextoPorDefecto();
        txtLegajo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtLegajoKeyReleased(evt);
            }
        });

        txtNombre.setTextoPorDefecto("Ingrese un nombre...");
        txtNombre.mostrarTextoPorDefecto();
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
        });

        lblNombre1.setFont(LookAndFeelEntropy.FUENTE_REGULAR);
        lblNombre1.setText("Nombre: ");

        lblLegajo.setFont(LookAndFeelEntropy.FUENTE_REGULAR);
        lblLegajo.setText("Legajo:");

        txtApellido.setTextoPorDefecto("Ingrese un apellido...");
        txtApellido.mostrarTextoPorDefecto();
        txtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtApellidoKeyReleased(evt);
            }
        });

        lblApellido.setFont(LookAndFeelEntropy.FUENTE_REGULAR);
        lblApellido.setText("Apellido:");

        lblDocumento.setFont(LookAndFeelEntropy.FUENTE_REGULAR);
        lblDocumento.setText("Documento:");

        txtDocumento.setTextoPorDefecto("Ingrese un documento...");
        txtDocumento.mostrarTextoPorDefecto();
        txtDocumento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDocumentoKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout pnlFiltrosLayout = new javax.swing.GroupLayout(pnlFiltros);
        pnlFiltros.setLayout(pnlFiltrosLayout);
        pnlFiltrosLayout.setHorizontalGroup(
            pnlFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFiltrosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFiltrosLayout.createSequentialGroup()
                        .addGroup(pnlFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblApellido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblLegajo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblDocumento))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDocumento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtApellido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtLegajo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pnlFiltrosLayout.createSequentialGroup()
                        .addGroup(pnlFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblCurso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNombreInstitucion, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbCurso, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbInstitucion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        pnlFiltrosLayout.setVerticalGroup(
            pnlFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFiltrosLayout.createSequentialGroup()
                .addGroup(pnlFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblApellido))
                .addGap(3, 3, 3)
                .addGroup(pnlFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLegajo)
                    .addComponent(txtLegajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDocumento)
                    .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreInstitucion, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbInstitucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pnlCentral.setOpaque(false);
        pnlCentral.setLayout(new javax.swing.BoxLayout(pnlCentral, javax.swing.BoxLayout.X_AXIS));

        lstAlumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstAlumnosMouseClicked(evt);
            }
        });
        scrAlumnos.setViewportView(lstAlumnos);

        pnlCentral.add(scrAlumnos);

        javax.swing.GroupLayout pnlFondoLayout = new javax.swing.GroupLayout(pnlFondo);
        pnlFondo.setLayout(pnlFondoLayout);
        pnlFondoLayout.setHorizontalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlFiltros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addComponent(lblBarraTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCerrar))
                    .addComponent(pnlCentral, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlFondoLayout.setVerticalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBarraTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCerrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlCentral, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnlFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 569, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnlFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void cmbInstitucionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbInstitucionItemStateChanged
        if (ultimoComboActivo == evt.getSource()) {
            int intIndexSeleccionado = this.cmbInstitucion.getSelectedIndex();
            if (intIndexSeleccionado > 0) { //Seleccionó una institución.
                this.limpiarCursos();
                ArrayList<Curso> colCurso = this.getCursos((Institucion) this.cmbInstitucion.getSelectedItem());
                for (Curso curso : colCurso) {
                    this.cmbCurso.addItem(curso);
                }
                this.institucion = (Institucion) this.cmbInstitucion.getSelectedItem();
            } else if (intIndexSeleccionado == 0) { //Selecciónó "Todas".
                this.institucion = null;
                this.limpiarCursos();
            }
            buscarAlumnos(strNombre, strApellido, strDocumento, strLegajo, institucion, curso);
        }
    }//GEN-LAST:event_cmbInstitucionItemStateChanged

    private void cmbInstitucionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbInstitucionFocusGained
        this.ultimoComboActivo = evt.getComponent();
    }//GEN-LAST:event_cmbInstitucionFocusGained

    private void cmbCursoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCursoItemStateChanged
        if (ultimoComboActivo == evt.getSource()) {
            if (this.cmbCurso.getSelectedIndex() > 0) { //Seleccionó un curso.
                this.curso = (Curso) this.cmbCurso.getSelectedItem();
            } else if (this.cmbCurso.getSelectedItem().toString().equals("Todos")) {
                this.curso = null;
            }
            buscarAlumnos(strNombre, strApellido, strDocumento, strLegajo, institucion, curso);
        }
    }//GEN-LAST:event_cmbCursoItemStateChanged

    private void cmbCursoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbCursoFocusGained
        this.ultimoComboActivo = evt.getComponent();
    }//GEN-LAST:event_cmbCursoFocusGained

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed
                           

    private void txtApellidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoKeyReleased
        this.strApellido = txtApellido.getText();
        this.buscarAlumnos(strNombre, strApellido, strDocumento, strLegajo, institucion, curso);
    }//GEN-LAST:event_txtApellidoKeyReleased

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        this.strNombre = txtNombre.getText();
        this.buscarAlumnos(strNombre, strApellido, strDocumento, strLegajo, institucion, curso);
    }//GEN-LAST:event_txtNombreKeyReleased

    private void txtLegajoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLegajoKeyReleased
        this.strLegajo = txtLegajo.getText();
        this.buscarAlumnos(strNombre, strApellido, strDocumento, strLegajo, institucion, curso);
    }//GEN-LAST:event_txtLegajoKeyReleased

    private void txtDocumentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDocumentoKeyReleased
        this.strDocumento = txtDocumento.getText();
        this.buscarAlumnos(strNombre, strApellido, strDocumento, strLegajo, institucion, curso);
    }//GEN-LAST:event_txtDocumentoKeyReleased

    private void lstAlumnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstAlumnosMouseClicked
        if (evt.getClickCount() >= 2){
            Alumno seleccionado = (Alumno) this.lstAlumnos.getSelectedValue();
            PanelEstadisticasAlumno pnlEstadisticasAlumno = new PanelEstadisticasAlumno(this, seleccionado);
            pnlEstadisticasAlumno.setName("Estadísticas alumno");
            VentanaPrincipal.getInstancia().ocultarMenu();
            VentanaPrincipal.getInstancia().getPanelDeslizante().setPanelMostrado(pnlEstadisticasAlumno);
            VentanaPrincipal.getInstancia().setTitle("Estadísticas del alumno " + seleccionado.toString());
            if (VentanaPrincipal.getInstancia().getExtendedState() != JFrame.MAXIMIZED_BOTH) {
                VentanaPrincipal.getInstancia().pack();
            }
            this.dispose();
        }
    }//GEN-LAST:event_lstAlumnosMouseClicked

    public GestorBarrasDeEstado getGestorEstados() {
        return gestorEstados;
    }
    
    public JList getLstAlumnos()
    {
        return lstAlumnos;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JComboBox cmbCurso;
    private javax.swing.JComboBox cmbInstitucion;
    private javax.swing.JLabel lblActualizacionEstado;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblBarraTitulo;
    private javax.swing.JLabel lblCurso;
    private javax.swing.JLabel lblDocumento;
    private javax.swing.JLabel lblIconoEstado;
    private javax.swing.JLabel lblLegajo;
    private javax.swing.JLabel lblNombre1;
    private javax.swing.JLabel lblNombreInstitucion;
    private javax.swing.JList lstAlumnos;
    private javax.swing.JPanel pnlCentral;
    private javax.swing.JPanel pnlEstado;
    private javax.swing.JPanel pnlFiltros;
    private frontend.auxiliares.PanelConFondo pnlFondo;
    private javax.swing.JScrollPane scrAlumnos;
    private frontend.auxiliares.TextFieldEntropy txtApellido;
    private frontend.auxiliares.TextFieldEntropy txtDocumento;
    private frontend.auxiliares.TextFieldEntropy txtLegajo;
    private frontend.auxiliares.TextFieldEntropy txtNombre;
    // End of variables declaration//GEN-END:variables

    /**
     * Setea el combo box de cursos a sus valores iniciales.
     */
    private void limpiarCursos() {
        this.cmbCurso.removeAllItems();
        this.cmbCurso.addItem("Todos");
        this.cmbCurso.setSelectedIndex(0);
        this.curso = null;
    }

    /**
     * Se comunica con el gestor de importacion para buscar todos los cursos que
     * pertenecen a una Institucion.
     *
     * @param institucion la institucion por la que se quiere filtrar.
     * @return Coleccion de cursos que tiene la institucion.
     */
    private ArrayList<Curso> getCursos(Institucion institucion) {
        return new GestorImportarPregunta().getCursos(institucion);
    }

    private void buscarAlumnos(String strNombre, String strApellido,
            String strDocumento, String strLegajo, Institucion institucion,
            Curso curso) {
        DefaultListModel dlm = new DefaultListModel();
        for(Alumno alumno : GestorAlumnos.getInstancia().buscarAlumnos(strNombre, strApellido, strDocumento, strLegajo, institucion, curso)){
            dlm.addElement(alumno);
        }
        this.lstAlumnos.setModel(dlm);
        this.lstAlumnos.setSelectedIndex(0);
        this.repaint();
    }

    /**
     * Clase que escucha por el tecleo de la tecla Esc.
     */
    private class EscapeAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    }
}
