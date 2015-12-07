package frontend.tomaexamenes;
import backend.auxiliares.Mensajes;
import backend.examenes.EstadoTomaExamen;
import backend.examenes.Examen;
import backend.gestores.GestorExamen;
import backend.gestores.GestorTomaExamen;
import backend.red.GestorRedAdHoc;
import backend.usuarios.Alumno;
import frontend.auxiliares.CeldaBotonRendererEntropy;
import frontend.auxiliares.CeldaHeaderMultiLineRenderer;
import frontend.auxiliares.GestorBarrasDeEstado;
import frontend.auxiliares.GestorImagenes;
import frontend.auxiliares.LookAndFeelEntropy;
import frontend.inicio.VentanaPrincipal;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Denise
 */
public class FrameControlTomaExamen extends javax.swing.JFrame {

    private final VentanaPrincipal mPadre;
    private final GestorBarrasDeEstado gestorEstados;
    private DefaultTableModel defaultTblAlumnos;
    private DialogModificarTiempo dlgModificarTiempo;
    private GestorTomaExamen gestorTomaExamen;
    private Examen examenTomar;
    private ArrayList<CuentaRegresiva> colCuentasRegresivas;
    private int intFinalizado;

    /**
     * Constructor de la clase.
     *
     * @param mPadre Ventana Principal padre
     */
    public FrameControlTomaExamen(VentanaPrincipal mPadre, Examen examenTomar) {
        initComponents();
        this.mPadre = mPadre;
        this.intFinalizado = 0;
        setLocationRelativeTo(null);
        this.setIconImage(this.getIconImage());
        setTitle("Toma de examen");
        this.gestorEstados = new GestorBarrasDeEstado(lblActualizacionEstado, lblIconoEstado);
        this.gestorEstados.setNuevoEstadoImportante("¡Bienvenido al panel de control de toma de examen!");

        //Fondo translúcido.
        this.pnlEstado.setBackground(new Color(255, 255, 255, 123));
        this.tblAlumnos.setBackground(new Color(255, 255, 255, 123));
        this.scrTablaAlumnos.setBackground(new Color(255, 255, 255, 123));
        this.scrTablaAlumnos.getViewport().setOpaque(false);

        //Configuración de la tabla.
        tblAlumnos.setDefaultRenderer(Object.class, new CeldaTomarExamenRenderer());
        tblAlumnos.getTableHeader().setDefaultRenderer(new CeldaHeaderMultiLineRenderer());
        tblAlumnos.getColumn("Anular").setMaxWidth(70);
        tblAlumnos.getColumn("Otros").setMaxWidth(70);
        tblAlumnos.setShowVerticalLines(false);
        tblAlumnos.setGridColor(LookAndFeelEntropy.COLOR_SELECCION_TEXTO);
        tblAlumnos.setIgnoreRepaint(false);
        defaultTblAlumnos = (DefaultTableModel) tblAlumnos.getModel();

        // Seteo el examen
        this.examenTomar = examenTomar;

        //Creo el gestor de Toma de Examen
        gestorTomaExamen = new GestorTomaExamen(this, examenTomar);
        gestorTomaExamen.comenzarConexiones();
        colCuentasRegresivas = new ArrayList<>();

        Action anular = new AbstractAction("-") {
            @Override
            public void actionPerformed(ActionEvent e) {
                anularAlumno(e);
            }
        };
        CeldaBotonRendererEntropy anularRenderer = new CeldaBotonRendererEntropy(
                tblAlumnos,
                anular,
                6,
                GestorImagenes.crearImageIcon("/frontend/imagenes/ic_borrar_cuadrado.png"),
                GestorImagenes.crearImageIcon("/frontend/imagenes/ic_borrar_cuadrado_presionado.png"));

        Action mostrarInfo = new AbstractAction("+") {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarMasInfo(e);
            }
        };
        CeldaBotonRendererEntropy masInfoRenderer = new CeldaBotonRendererEntropy(
                tblAlumnos,
                mostrarInfo,
                7,
                GestorImagenes.crearImageIcon("/frontend/imagenes/ic_info.png"),
                GestorImagenes.crearImageIcon("/frontend/imagenes/ic_info.png"));
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
        pnlBotones = new javax.swing.JPanel();
        btnCancelar1 = new javax.swing.JButton();
        btnModificarTiempo = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        scrTablaAlumnos = new javax.swing.JScrollPane();
        tblAlumnos = new javax.swing.JTable();
        pnlEstado = new javax.swing.JPanel();
        lblActualizacionEstado = new javax.swing.JLabel();
        lblIconoEstado = new javax.swing.JLabel();
        lblsPorcentajeTerminados = new javax.swing.JLabel();
        lblPorcentajeTerminados = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(769, 370));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        pnlFondo.setImagen(GestorImagenes.crearImage("/frontend/imagenes/bg_gris.jpg"));
        pnlFondo.setPreferredSize(new java.awt.Dimension(200, 400));

        pnlBotones.setLayout(new java.awt.GridLayout(1, 0));

        btnCancelar1.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        btnCancelar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/frontend/imagenes/ic_mensajes_exito.png"))); // NOI18N
        btnCancelar1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnCancelar1.setContentAreaFilled(false);
        btnCancelar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar1.setIconTextGap(10);
        btnCancelar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCancelar1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCancelar1MouseExited(evt);
            }
        });
        btnCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelar1ActionPerformed(evt);
            }
        });
        pnlBotones.add(btnCancelar1);

        btnModificarTiempo.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        btnModificarTiempo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/frontend/imagenes/ic_tiempo.png"))); // NOI18N
        btnModificarTiempo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnModificarTiempo.setContentAreaFilled(false);
        btnModificarTiempo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificarTiempo.setIconTextGap(10);
        btnModificarTiempo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnModificarTiempoMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnModificarTiempoMouseEntered(evt);
            }
        });
        btnModificarTiempo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarTiempoActionPerformed(evt);
            }
        });
        pnlBotones.add(btnModificarTiempo);

        btnCancelar.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/frontend/imagenes/ic_cancelar.png"))); // NOI18N
        btnCancelar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnCancelar.setContentAreaFilled(false);
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.setIconTextGap(10);
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCancelarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCancelarMouseExited(evt);
            }
        });
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        pnlBotones.add(btnCancelar);

        scrTablaAlumnos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Panel de control", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, LookAndFeelEntropy.FUENTE_CURSIVA));
        scrTablaAlumnos.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        tblAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Alumno", "Estado", "Tiempo inicio", "Tiempo restante", "Preguntas respondidas", "Progreso", "Anular", "Otros"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblAlumnos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        scrTablaAlumnos.setViewportView(tblAlumnos);

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

        lblsPorcentajeTerminados.setFont(LookAndFeelEntropy.FUENTE_REGULAR);
        lblsPorcentajeTerminados.setText("Porcentaje de alumnos que han terminado:");

        lblPorcentajeTerminados.setFont(LookAndFeelEntropy.FUENTE_REGULAR);
        lblPorcentajeTerminados.setText("0%");

        javax.swing.GroupLayout pnlFondoLayout = new javax.swing.GroupLayout(pnlFondo);
        pnlFondo.setLayout(pnlFondoLayout);
        pnlFondoLayout.setHorizontalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scrTablaAlumnos)
                    .addComponent(pnlEstado, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlFondoLayout.createSequentialGroup()
                        .addComponent(lblsPorcentajeTerminados)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPorcentajeTerminados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(507, 507, 507)))
                .addContainerGap())
            .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlFondoLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(pnlBotones, javax.swing.GroupLayout.DEFAULT_SIZE, 749, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        pnlFondoLayout.setVerticalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(scrTablaAlumnos, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblsPorcentajeTerminados)
                    .addComponent(lblPorcentajeTerminados))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlFondoLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(pnlBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(320, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondo, javax.swing.GroupLayout.DEFAULT_SIZE, 769, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondo, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnModificarTiempoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarTiempoMouseEntered
        this.gestorEstados.setEstadoInstantaneo("Modificar el tiempo asignado para el examen.");
        repaint();
    }//GEN-LAST:event_btnModificarTiempoMouseEntered

    private void btnModificarTiempoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarTiempoMouseExited
        this.gestorEstados.volverAEstadoImportante();
        repaint();
    }//GEN-LAST:event_btnModificarTiempoMouseExited

    private void btnModificarTiempoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarTiempoActionPerformed
        getGraphics().dispose();
        dlgModificarTiempo = new DialogModificarTiempo(this, true);
        dlgModificarTiempo.setVisible(true);
        tblAlumnos.paintComponents(tblAlumnos.getGraphics());
    }//GEN-LAST:event_btnModificarTiempoActionPerformed

    private void btnCancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseEntered
        this.gestorEstados.setEstadoInstantaneo("Cancelar la toma del examen.");
        repaint();
    }//GEN-LAST:event_btnCancelarMouseEntered

    private void btnCancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseExited
        this.gestorEstados.volverAEstadoImportante();
        repaint();
    }//GEN-LAST:event_btnCancelarMouseExited

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.terminarTomaDeExamen(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.terminarTomaDeExamen(false);
    }//GEN-LAST:event_formWindowClosing

    private void btnCancelar1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelar1MouseEntered
        this.gestorEstados.setEstadoInstantaneo("Termina la toma de examen.");
        repaint();
    }//GEN-LAST:event_btnCancelar1MouseEntered

    private void btnCancelar1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelar1MouseExited
        this.gestorEstados.volverAEstadoImportante();
        repaint(); 
    }//GEN-LAST:event_btnCancelar1MouseExited

    private void btnCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar1ActionPerformed
         this.gestorEstados.setEstadoInstantaneo("Termina examen");
        repaint();
    }//GEN-LAST:event_btnCancelar1ActionPerformed

    /**
     * Anula el examen del alumno en cuestión.
     *
     * @param e evento de acción provocado al clickear el botón en la tabla.
     */
    private void anularAlumno(ActionEvent e) {

        if (tblAlumnos.getModel().getRowCount() > 0
                && Mensajes.mostrarConfirmacion("Está a punto de anular el examen del alumno. ¿Realmente desea continuar?")) {
            DialogCancelarExamen dlgCancelar = new DialogCancelarExamen(this, true);
            dlgCancelar.setVisible(true);
            if (dlgCancelar.getAccionElegida().equals(DialogCancelarExamen.Accion.CONTINUAR)) {
                int intFila = Integer.valueOf(e.getActionCommand());
                String strJustificacion = dlgCancelar.getStrMotivoCancelacion();
                gestorTomaExamen.anularResolucion(intFila, strJustificacion);
                ((DefaultTableModel) tblAlumnos.getModel()).setValueAt(EstadoTomaExamen.INTERRUMPIDO.toString(), intFila, 1);
                for (CuentaRegresiva cuentaRegresiva : colCuentasRegresivas) {
                    if (cuentaRegresiva.intIndice == intFila) {
                        cuentaRegresiva.parar();
                    }
                }
            } else {
                return;
            }
        }

        throw new UnsupportedOperationException("COMPLETAR");
    }

    /**
     * Muestra más información relacionada a un alumno en particular.
     * Información técnica.
     *
     * @param e evento de acción provocado al clickear el botón en la tabla.
     */
    private void mostrarMasInfo(ActionEvent e) {
        int intFila = Integer.valueOf(e.getActionCommand());
        gestorTomaExamen.mostrarDatosAlumno(intFila);
    }

    @Override
    public Image getIconImage() {
        return GestorImagenes.crearImage("/frontend/imagenes/ic_system.png");
    }

    public Examen getExamenATomar() {
        return examenTomar;
    }

    public void setExamenATomar(Examen examenATomar) {
        this.examenTomar = examenATomar;
    }

    public int agregarAlumno(Alumno alumno) {
        if (defaultTblAlumnos.getRowCount() == 0) {
            GestorExamen.getInstancia().guardarExamen(examenTomar);
        }
        String nombre = alumno.getStrNombre();
        String estado = EstadoTomaExamen.AUTENTICADO.toString();
        defaultTblAlumnos.addRow(new Object[]{nombre, estado, "-", "-", 0 + "/" + gestorTomaExamen.getExamenResolver().getColPreguntas().size()});
        return tblAlumnos.getRowCount() - 1;
    }

    public void desconectarAlumno(int intIndice) {
        defaultTblAlumnos.setValueAt(EstadoTomaExamen.INTERRUMPIDO, intIndice, 1);
    }

    public void iniciarExamen(int intIndice) {
        defaultTblAlumnos.setValueAt(EstadoTomaExamen.INICIADO, intIndice, 1);

        DateFormat formatoTiempo = new SimpleDateFormat("HH:mm:ss");
        defaultTblAlumnos.setValueAt(formatoTiempo.format(new Date()), intIndice, 2);
        defaultTblAlumnos.setValueAt(0 + "/" + gestorTomaExamen.getExamenResolver().getColPreguntas().size(), intIndice, 4);
        colCuentasRegresivas.add(new CuentaRegresiva(intIndice));
    }

    public void notificarProgreso(int intIndice, int intCantPreguntasRespondidas) {
        defaultTblAlumnos.setValueAt(intCantPreguntasRespondidas + "/" + gestorTomaExamen.getExamenResolver().getColPreguntas().size(), intIndice, 4);
        float floatProgreso = (float) intCantPreguntasRespondidas / gestorTomaExamen.getExamenResolver().getColPreguntas().size();
        defaultTblAlumnos.setValueAt((int) (floatProgreso * 100), intIndice, 5);
    }

    public void finalizarExamenAlumno(int intIndice) {
        intFinalizado++;
        lblPorcentajeTerminados.setText((double) (intFinalizado * 100 / tblAlumnos.getRowCount()) + "%");
        defaultTblAlumnos.setValueAt(EstadoTomaExamen.COMPLETADO, intIndice, 1);
        for (CuentaRegresiva cuentaRegresiva : colCuentasRegresivas) {
            if (cuentaRegresiva.intIndice == intIndice) {
                cuentaRegresiva.parar();
            }
        }
    }

    public void mostrarErrorAlEnviarExamen(int intIndice) {
        Mensajes.mostrarError("Error al enviar el mensaje a " + tblAlumnos.getValueAt(intIndice, 0));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCancelar1;
    private javax.swing.JButton btnModificarTiempo;
    private javax.swing.JLabel lblActualizacionEstado;
    private javax.swing.JLabel lblIconoEstado;
    private javax.swing.JLabel lblPorcentajeTerminados;
    private javax.swing.JLabel lblsPorcentajeTerminados;
    private javax.swing.JPanel pnlBotones;
    private javax.swing.JPanel pnlEstado;
    private frontend.auxiliares.PanelConFondo pnlFondo;
    private javax.swing.JScrollPane scrTablaAlumnos;
    private javax.swing.JTable tblAlumnos;
    // End of variables declaration//GEN-END:variables

    /**
     * Funcionalidad cuando el usuario cierra la ventana.
     *
     * @param blnEsCancelacion true si se está cancelando el examen, false si se
     * ha terminado la toma.
     */
    private void terminarTomaDeExamen(boolean blnEsCancelacion) {
        if (Mensajes.mostrarConfirmacion("Está a punto de cancelar el examen. ¿Realmente desea continuar?")) {
            if (blnEsCancelacion && tblAlumnos.getModel().getRowCount() > 0) {
                DialogCancelarExamen dlgCancelar = new DialogCancelarExamen(this, true);
                dlgCancelar.setVisible(true);
                if (dlgCancelar.getAccionElegida().equals(DialogCancelarExamen.Accion.CONTINUAR)) {
                    GestorExamen.getInstancia().cancelarExamen(examenTomar.getIntExamenId(), dlgCancelar.getStrMotivoCancelacion());
                    gestorTomaExamen.notificarCancelacionExamen();
                } else {
                    return;
                }
            } else if (!blnEsCancelacion) {
                GestorExamen.getInstancia().actualizarEstadoExamen(examenTomar.getIntExamenId());
            }
            this.dispose();
            GestorRedAdHoc gestorRedAdHoc = new GestorRedAdHoc();
            gestorRedAdHoc.desconectar();
            throw new UnsupportedOperationException("Falta cerrar los hilos y todo el lío.");
        }
    }

    /**
     * Clase que se encarga de manejar el timer de cuenta regresiva.
     */
    private class CuentaRegresiva {

        private final Timer tmrTemporizador;
        private int intIndice;
        private int minutos;
        private int segundos;

        public CuentaRegresiva(final int intIndice) {
            this.intIndice = intIndice;
            minutos = gestorTomaExamen.getExamenResolver().getIntTiempo();
            segundos = 0;
            String strTiempoRestante = String.format("%02d", (int) minutos / 60) + ":"
                    + String.format("%02d", minutos % 60) + ":"
                    + String.format("%02d", segundos);
            defaultTblAlumnos.setValueAt(strTiempoRestante, intIndice, 3);

            this.tmrTemporizador = new Timer(1000, new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == tmrTemporizador) {

                        if (segundos == 0) {
                            segundos = 59;
                            minutos--;
                        }

                        segundos--;

                        String strTiempoRestante = String.format("%02d", (int) minutos / 60) + ":"
                                + String.format("%02d", minutos % 60) + ":"
                                + String.format("%02d", segundos);
                        defaultTblAlumnos.setValueAt(strTiempoRestante, intIndice, 3);

                        if (segundos == 0 && minutos == 0) {
                            tmrTemporizador.stop();
                        }
                    }
                }
            });

            tmrTemporizador.start();
        }

        private void parar() {
            tmrTemporizador.stop();
        }
    }
}
