package frontend.tomaexamenes;

import backend.auxiliares.Mensajes;
import backend.diseños.Curso;
import backend.diseños.DiseñoExamen;
import backend.diseños.Institucion;
import backend.examenes.EstadoExamen;
import backend.examenes.Examen;
import backend.gestores.GestorCursosEInstituciones;
import backend.gestores.GestorDiseñoExamen;
import backend.gestores.GestorExamen;
import backend.red.GestorRedAdHoc;
import frontend.auxiliares.GestorBarrasDeEstado;
import frontend.auxiliares.LookAndFeelEntropy;
import frontend.auxiliares.PanelDeslizante;
import frontend.inicio.VentanaPrincipal;

/**
 * Clase que representa el panel de contexto para la iniciar la toma de un
 * examen.
 *
 * @author Denise
 */
public class PanelTomaExamen extends javax.swing.JPanel {

    private final VentanaPrincipal mPadre;
    private final GestorBarrasDeEstado gestorEstados;
    private final GestorDiseñoExamen gestorDiseñoExamen;
    private final GestorCursosEInstituciones gestorCursosInstituciones;
    private DiseñoExamen diseñoExamenSeleccionado;
    private Examen examenTomar;

    /**
     * Constructor para tomar un diseño de examen.
     *
     * @param mPadre Ventana Principal padre.
     * @param diseñoExamenSeleccionado diseño de examen a ser tomado.
     */
    public PanelTomaExamen(VentanaPrincipal mPadre, DiseñoExamen diseñoExamenSeleccionado) {
        this.mPadre = mPadre;
        gestorDiseñoExamen = new GestorDiseñoExamen();
        gestorCursosInstituciones = new GestorCursosEInstituciones();

        initComponents();
        this.gestorEstados = new GestorBarrasDeEstado(lblActualizacionEstado, lblIconoEstado);
        this.mostrarBotonPublicar(false);
        this.diseñoExamenSeleccionado = diseñoExamenSeleccionado;
        this.examenTomar = crearExamen();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * ADVERTENCIA: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBotones = new javax.swing.JPanel();
        btnPublicar = new javax.swing.JButton();
        btnVolverInicio = new javax.swing.JButton();
        pnlDeslizante = new frontend.auxiliares.PanelDeslizante();
        pnlEstado = new javax.swing.JPanel();
        lblActualizacionEstado = new javax.swing.JLabel();
        lblIconoEstado = new javax.swing.JLabel();

        pnlBotones.setLayout(new java.awt.GridLayout(1, 0));

        btnPublicar.setFont(LookAndFeelEntropy.FUENTE_REGULAR);
        btnPublicar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/frontend/imagenes/ic_comenzar.png"))); // NOI18N
        btnPublicar.setText("Comenzar");
        btnPublicar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnPublicar.setContentAreaFilled(false);
        btnPublicar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPublicar.setIconTextGap(10);
        btnPublicar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPublicarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPublicarMouseExited(evt);
            }
        });
        btnPublicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPublicarActionPerformed(evt);
            }
        });
        pnlBotones.add(btnPublicar);

        btnVolverInicio.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        btnVolverInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/frontend/imagenes/ic_inicio.png"))); // NOI18N
        btnVolverInicio.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnVolverInicio.setContentAreaFilled(false);
        btnVolverInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVolverInicio.setIconTextGap(10);
        btnVolverInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnVolverInicioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnVolverInicioMouseExited(evt);
            }
        });
        btnVolverInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverInicioActionPerformed(evt);
            }
        });
        pnlBotones.add(btnVolverInicio);

        pnlDatosExtras = new PanelTomarExamenDatosExtras(this);
        pnlDatosRed = new PanelTomarExamenDatosRed(this);
        pnlDeslizante.setLayout(new java.awt.CardLayout());
        pnlDatosExtras.setName("Extras");
        pnlDatosRed.setName("Red");
        pnlDeslizante.add(pnlDatosExtras, "card1");
        pnlDeslizante.add(pnlDatosRed, "card2");

        pnlEstado.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, java.awt.Color.lightGray));

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
                .addComponent(lblActualizacionEstado, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlDeslizante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlBotones, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlDeslizante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverInicioActionPerformed
        mPadre.getPanelDeslizante().setPanelMostrado(mPadre.getPnlInicio());
        mPadre.setTitle("Sistema de Administración de Entornos Educativos");
        GestorRedAdHoc gestorRedAdHoc = new GestorRedAdHoc();
        gestorRedAdHoc.desconectar();
    }//GEN-LAST:event_btnVolverInicioActionPerformed

    private void btnPublicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPublicarActionPerformed
        if (!this.pnlDatosExtras.validarDatosObligatorios()
                || !this.pnlDatosRed.validarDatosObligatorios()) {
            Mensajes.mostrarError("Datos obligatorios incompletos.");
            return;
        }
        examenTomar.setOrdenPresentacion(this.pnlDatosExtras.getOrdenPresentacion());
        int intHoras = this.pnlDatosExtras.getHoras();
        int intMinutos = this.pnlDatosExtras.getMinutos();
        this.examenTomar.setIntTiempo((intHoras * 60) + intMinutos);
        this.examenTomar.setCurso(this.pnlDatosExtras.getCursoSeleccionado());
        this.examenTomar.setDblPorcentajeAprobacion(this.pnlDatosExtras.getPorcentajeAprobacion());
        /**
         * Denise dice: Creo que lo que sigue tenemos que hacerlo sólo si algún
         * alumno efectivamente se conecta e intenta hacer un examen. Guardar
         * una entrada en la BD con 0 resoluciones me parece al vicio y molesto
         * para la administración de los exámenes. Por eso lo moví al
         * FrameControlTomaExamen.
         */
        //GestorExamen.getInstancia().guardarDiseñoExamen(examenTomar);
        mPadre.getPanelDeslizante().setPanelMostrado(mPadre.getPnlInicio());
        mPadre.setTitle("Sistema de Administración de Entornos Educativos");
        new FrameControlTomaExamen(mPadre, examenTomar).setVisible(true);
    }//GEN-LAST:event_btnPublicarActionPerformed

    private void btnPublicarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPublicarMouseExited
        this.gestorEstados.volverAEstadoImportante();
    }//GEN-LAST:event_btnPublicarMouseExited

    private void btnVolverInicioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVolverInicioMouseExited
        this.gestorEstados.volverAEstadoImportante();
    }//GEN-LAST:event_btnVolverInicioMouseExited

    private void btnPublicarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPublicarMouseEntered
        this.gestorEstados.setEstadoInstantaneo("Guardar este diseño de examen en la base de datos.");
    }//GEN-LAST:event_btnPublicarMouseEntered

    private void btnVolverInicioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVolverInicioMouseEntered
        this.gestorEstados.setEstadoInstantaneo("Volver a la pantalla inicial.");
    }//GEN-LAST:event_btnVolverInicioMouseEntered

    public PanelDeslizante getPanelDeslizante() {
        return pnlDeslizante;
    }

    public PanelTomarExamenDatosExtras getPanelDatosExtras() {
        return pnlDatosExtras;
    }

    public PanelTomarExamenDatosRed getPanelDatosRed() {
        return pnlDatosRed;
    }

    public VentanaPrincipal getVentanaPrincipal() {
        return mPadre;
    }

    public GestorBarrasDeEstado getGestorEstados() {
        return gestorEstados;
    }

    private Examen cargarDatosExamen(DiseñoExamen examenSeleccionado) {
        Examen examen = new Examen();
        examen.setStrNombre(examenSeleccionado.getStrNombre());
        examen.setStrDescripcion(examenSeleccionado.getStrDescripcion());
        examen.setColPreguntas(gestorDiseñoExamen.getPreguntasDiseño(examenSeleccionado));
        examen.setCurso(examenSeleccionado.getCurso());
        examen.setIntEstado(EstadoExamen.DEFINIDO);
        return examen;
    }

    private void cargarCombos(int idDiseno) {
        Curso curso = gestorDiseñoExamen.buscarCurso(idDiseno);
        Institucion institucion = null;
        if (curso != null) institucion = gestorDiseñoExamen.buscarInstitucion(curso.getIntCursoId());
        this.pnlDatosExtras.cargarCombos(institucion, curso);
    }

    private Examen crearExamen() {
        cargarCombos(diseñoExamenSeleccionado.getIntDiseñoExamenId());
        return cargarDatosExamen(diseñoExamenSeleccionado);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPublicar;
    private javax.swing.JButton btnVolverInicio;
    private javax.swing.JLabel lblActualizacionEstado;
    private javax.swing.JLabel lblIconoEstado;
    private javax.swing.JPanel pnlBotones;
    private frontend.auxiliares.PanelDeslizante pnlDeslizante;
    private PanelTomarExamenDatosExtras pnlDatosExtras;
    private PanelTomarExamenDatosRed pnlDatosRed;
    private javax.swing.JPanel pnlEstado;
    // End of variables declaration//GEN-END:variables

    /**
     * Muestra o esconde el botón "Comenzar".
     *
     * @param blnMostrar true para mostrar, false de los contrario.
     */
    public void mostrarBotonPublicar(boolean blnMostrar) {
        if (blnMostrar) {
            this.pnlBotones.add(btnPublicar, 0);
        } else {
            this.pnlBotones.remove(btnPublicar);
        }
        this.repaint();
    }

    public GestorDiseñoExamen getGestorDiseñoExamen() {
        return gestorDiseñoExamen;
    }

}
