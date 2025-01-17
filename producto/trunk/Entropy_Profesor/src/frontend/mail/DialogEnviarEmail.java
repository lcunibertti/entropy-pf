package frontend.mail;

import frontend.auxiliares.ComponentMover;
import frontend.auxiliares.ComponentResizer;
import frontend.auxiliares.GestorBarrasDeEstado;
import frontend.auxiliares.GestorImagenes;
import frontend.auxiliares.LookAndFeelEntropy;
import frontend.inicio.VentanaPrincipal;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.KeyStroke;
import backend.auxiliares.Mensajes;
import backend.examenes.Examen;
import backend.mail.GestorEnvioDeMail;
import backend.resoluciones.Resolucion;
import frontend.auxiliares.TextUtils;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Clase que representa la interfaz de administración de diseños de examen.
 *
 * @author Denise
 */
public class DialogEnviarEmail extends javax.swing.JDialog {

    private GestorBarrasDeEstado gestorEstados;
    private Examen examen;
    private ArrayList<Resolucion> resoluciones;    

    /**
     * Constructor de la clase.
     *
     * @param modal true si mantiene el foco, false de lo contrario.
     * @param resolucion
     */
    public DialogEnviarEmail(boolean modal, Resolucion resolucion) {
        super(VentanaPrincipal.getInstancia(), modal);
        initComponents();
        iniciarComponentes();        
        //Datos del email
        this.examen = resolucion.getExamen();
        this.resoluciones = new ArrayList<>();
        this.resoluciones.add(resolucion);
        autocompletarDatos();
    }
    
    /**
     * Constructor de la clase.
     *
     * @param modal true si mantiene el foco, false de lo contrario.
     * @param resoluciones
     */
    public DialogEnviarEmail(boolean modal, ArrayList<Resolucion> resoluciones) {
        super(VentanaPrincipal.getInstancia(), modal);
        initComponents();
        iniciarComponentes();
        //Datos del email
        this.examen = resoluciones.get(0).getExamen();
        this.resoluciones = resoluciones;
        autocompletarDatosMultiples();
    }
    
    private void iniciarComponentes(){
        this.setSize(new Dimension(600, 400));
        this.setLocationRelativeTo(VentanaPrincipal.getInstancia());
        this.getRootPane().registerKeyboardAction(new EscapeAction(),
                KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
                JComponent.WHEN_IN_FOCUSED_WINDOW);

        this.gestorEstados = new GestorBarrasDeEstado(lblActualizacionEstado, lblIconoEstado);

        //Fondo translúcido.
        this.pnlEstado.setBackground(new Color(255, 255, 255, 123));
        
        //Para que el undecorated dialog pueda moverse y ajustarse en tamaño.
        ComponentMover cm = new ComponentMover(JDialog.class, lblBarraTitulo);
        ComponentResizer cr = new ComponentResizer();
        cr.setSnapSize(new Dimension(10, 10));
        cr.registerComponent(this);
        
    }
    
    private void autocompletarDatos() {
        txtDestinatario.setText(this.resoluciones.get(0).getAlumno().getStrEmail());
        txtAsunto.setText("Correción del examen \"" + examen.getStrNombre() + "\"");
        lblAdjunto.setText("<html>Correción del examen " + examen.getStrNombre() + "_" + this.resoluciones.get(0).getAlumno().toString().replace(" - ", "_") + ".pdf</html>");
        String strMensaje = "Se adjunta la resolución corregida para el examen  \"" + examen.getStrNombre() 
                + "\", realizado el día " + new SimpleDateFormat("dd/MM/yyyy  -  HH:mm").format(examen.getDteFecha())
                + ", en el curso " + examen.getCurso().getStrNombre()
                + " de la institución " +  examen.getCurso().getInstitucion().getStrNombre() + ".";
        txaCuerpo.setText(strMensaje);
    }

    private void autocompletarDatosMultiples() {
        String todasLasDirecciones = concatenarTodosLasDireccionesDeMail(recuperarTodasLasDireccionesDeCorreo());
        txtDestinatario.setText(todasLasDirecciones);
        txtDestinatario.setEditable(false);
        txtAsunto.setText("Correción del examen \"" + examen.getStrNombre() + "\"");
        lblAdjunto.setText("Correción del examen " + examen.getStrNombre() + ".pdf");
        String strMensaje = "Se adjunta la resolución corregida para el examen  \"" + examen.getStrNombre() 
                + "\", realizado el día " + new SimpleDateFormat("dd/MM/yyyy  -  HH:mm").format(examen.getDteFecha())
                + ", en el curso " + examen.getCurso().getStrNombre()
                + " de la institución " +  examen.getCurso().getInstitucion().getStrNombre() + ".";
        txaCuerpo.setText(strMensaje);
    }
    
    private ArrayList<String> recuperarTodasLasDireccionesDeCorreo() {       
        ArrayList<String> direccionesDeCorreo = new ArrayList<>();
        for (Resolucion resolucion : resoluciones) {
            direccionesDeCorreo.add(resolucion.getAlumno().getStrEmail());
        }
        return direccionesDeCorreo;
    }

    private String concatenarTodosLasDireccionesDeMail(ArrayList<String> direccionesMail) {
        String todasLasDirecciones = "";
        for (String mail : direccionesMail) {
            todasLasDirecciones += mail + ",";
        }
        return todasLasDirecciones;
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
        lblsDestinatario = new javax.swing.JLabel();
        lblsAsunto = new javax.swing.JLabel();
        lblsAdjunto = new javax.swing.JLabel();
        txtDestinatario = new frontend.auxiliares.TextFieldEntropy();
        txtAsunto = new frontend.auxiliares.TextFieldEntropy();
        lblAdjunto = new javax.swing.JLabel();
        pnlCentral = new javax.swing.JPanel();
        scrMensaje = new javax.swing.JScrollPane();
        txaCuerpo = new frontend.auxiliares.TextAreaEntropy();
        pnlBotonesAuxiliar = new javax.swing.JPanel();
        pnlBotones = new javax.swing.JPanel();
        btnRegresar = new javax.swing.JButton();
        btnEnviar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        pnlFondo.setImagen(GestorImagenes.crearImage("/frontend/imagenes/bg2.jpg"));
        pnlFondo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 102, 0), 1, true));

        lblBarraTitulo.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        lblBarraTitulo.setForeground(new java.awt.Color(255, 102, 0));
        lblBarraTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBarraTitulo.setText("Envío de resolución al alumno");

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

        pnlFiltros.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, LookAndFeelEntropy.FUENTE_REGULAR));
        pnlFiltros.setOpaque(false);

        lblsDestinatario.setFont(LookAndFeelEntropy.FUENTE_REGULAR);
        lblsDestinatario.setText("Destinatario:");

        lblsAsunto.setFont(LookAndFeelEntropy.FUENTE_REGULAR);
        lblsAsunto.setText("Asunto:");

        lblsAdjunto.setFont(LookAndFeelEntropy.FUENTE_REGULAR);
        lblsAdjunto.setText("Adjunto:");

        txtDestinatario.setTextoPorDefecto("Ingrese una dirección de e-mail.");
        txtDestinatario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDestinatarioFocusLost(evt);
            }
        });

        txtAsunto.setTextoPorDefecto("Ingrese un asunto...");

        lblAdjunto.setFont(LookAndFeelEntropy.FUENTE_NEGRITA);
        lblAdjunto.setText("-");

        javax.swing.GroupLayout pnlFiltrosLayout = new javax.swing.GroupLayout(pnlFiltros);
        pnlFiltros.setLayout(pnlFiltrosLayout);
        pnlFiltrosLayout.setHorizontalGroup(
            pnlFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFiltrosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblsAdjunto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblsDestinatario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblsAsunto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDestinatario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtAsunto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblAdjunto, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        pnlFiltrosLayout.setVerticalGroup(
            pnlFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFiltrosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblsDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblsAsunto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAsunto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblsAdjunto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblAdjunto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnlCentral.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mensaje", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, LookAndFeelEntropy.FUENTE_REGULAR));
        pnlCentral.setOpaque(false);
        pnlCentral.setLayout(new javax.swing.BoxLayout(pnlCentral, javax.swing.BoxLayout.X_AXIS));

        scrMensaje.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        txaCuerpo.setColumns(20);
        txaCuerpo.setRows(5);
        scrMensaje.setViewportView(txaCuerpo);

        pnlCentral.add(scrMensaje);

        pnlBotones.setLayout(new java.awt.GridLayout(1, 0));

        btnRegresar.setBackground(new java.awt.Color(255, 204, 153));
        btnRegresar.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/frontend/imagenes/ic_volver.png"))); // NOI18N
        btnRegresar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnRegresar.setContentAreaFilled(false);
        btnRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar.setIconTextGap(10);
        btnRegresar.setOpaque(true);
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        pnlBotones.add(btnRegresar);

        btnEnviar.setBackground(new java.awt.Color(255, 204, 153));
        btnEnviar.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        btnEnviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/frontend/imagenes/ic_enviar_correo.png"))); // NOI18N
        btnEnviar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnEnviar.setContentAreaFilled(false);
        btnEnviar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEnviar.setIconTextGap(10);
        btnEnviar.setOpaque(true);
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });
        pnlBotones.add(btnEnviar);

        javax.swing.GroupLayout pnlBotonesAuxiliarLayout = new javax.swing.GroupLayout(pnlBotonesAuxiliar);
        pnlBotonesAuxiliar.setLayout(pnlBotonesAuxiliarLayout);
        pnlBotonesAuxiliarLayout.setHorizontalGroup(
            pnlBotonesAuxiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(pnlBotonesAuxiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnlBotones, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE))
        );
        pnlBotonesAuxiliarLayout.setVerticalGroup(
            pnlBotonesAuxiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 51, Short.MAX_VALUE)
            .addGroup(pnlBotonesAuxiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnlBotones, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlFondoLayout = new javax.swing.GroupLayout(pnlFondo);
        pnlFondo.setLayout(pnlFondoLayout);
        pnlFondoLayout.setHorizontalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlBotonesAuxiliar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlFiltros, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlEstado, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlFondoLayout.createSequentialGroup()
                        .addComponent(lblBarraTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCerrar))
                    .addComponent(pnlCentral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(pnlCentral, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlBotonesAuxiliar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 387, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnlFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 396, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnlFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        if (!validarEmail()) return;
        try {
            if (resoluciones.size() == 1) {
                new GestorEnvioDeMail().compartirResolucion(resoluciones.get(0), txtDestinatario.getText(), txtAsunto.getText(), txaCuerpo.getText());
                Mensajes.mostrarConfirmacion("El correo fue enviado correctamente.");
                this.dispose();
            } else {
                new GestorEnvioDeMail().compartirMultiplesResoluciones(resoluciones, txtAsunto.getText(), txaCuerpo.getText());
                Mensajes.mostrarConfirmacion("Los correos fueron enviados correctamente.");
                this.dispose();
            }
        } catch (Exception e) {
            Mensajes.mostrarError("Imposible enviar el mensaje. Intente nuevamente.");
            System.err.printf(e.toString());
        }
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void txtDestinatarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDestinatarioFocusLost
        validarEmail();
    }//GEN-LAST:event_txtDestinatarioFocusLost
    
    private boolean validarEmail(){
        if (resoluciones != null && resoluciones.size() == 1 && !txtDestinatario.getText().isEmpty() && !TextUtils.validarEmail(txtDestinatario.getText())) {
            Mensajes.mostrarError("La dirección de correo electrónico ingresada no es válida.");
            txtDestinatario.selectAll();
            txtDestinatario.grabFocus();
            return false;
        }
        return true;
    }
    
    public GestorBarrasDeEstado getGestorEstados() {
        return gestorEstados;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel lblActualizacionEstado;
    private javax.swing.JLabel lblAdjunto;
    private javax.swing.JLabel lblBarraTitulo;
    private javax.swing.JLabel lblIconoEstado;
    private javax.swing.JLabel lblsAdjunto;
    private javax.swing.JLabel lblsAsunto;
    private javax.swing.JLabel lblsDestinatario;
    private javax.swing.JPanel pnlBotones;
    private javax.swing.JPanel pnlBotonesAuxiliar;
    private javax.swing.JPanel pnlCentral;
    private javax.swing.JPanel pnlEstado;
    private javax.swing.JPanel pnlFiltros;
    private frontend.auxiliares.PanelConFondo pnlFondo;
    private javax.swing.JScrollPane scrMensaje;
    private frontend.auxiliares.TextAreaEntropy txaCuerpo;
    private frontend.auxiliares.TextFieldEntropy txtAsunto;
    private frontend.auxiliares.TextFieldEntropy txtDestinatario;
    // End of variables declaration//GEN-END:variables

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
