package frontend.examenes;

import backend.resoluciones.RespuestaDesarrollo;
import frontend.auxiliares.LookAndFeelEntropy;
import frontend.auxiliares.IIdentificadorCambios;

/**
 * Clase que representa el panel para responder las preguntas de desarrollo.
 * 
 * @author Denise
 */
public class PanelPreguntaDesarrollar extends javax.swing.JPanel implements IIdentificadorCambios {

    private RespuestaDesarrollo respuesta;
    private final boolean blnEsCorreccion;
    
    /**
     * Constructor por defecto de la clase.
     * 
     * @param respuesta cuya pregunta debe ser mostrada.
     * @param blnEsCorreccion true si se está corrigiendo la respuesta 
     * (deben estar los campos deshabilitados y cargarse la respuesta), false si
     * el alumno debe responder la respuesta
     */
    public PanelPreguntaDesarrollar(RespuestaDesarrollo respuesta, boolean blnEsCorreccion) {
        initComponents();
        this.respuesta = respuesta;
        this.cargarRespuesta();
        this.blnEsCorreccion = blnEsCorreccion;
        if (blnEsCorreccion) {
            txaRespuesta.setEditable(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrRespuesta = new javax.swing.JScrollPane();
        txaRespuesta = new frontend.auxiliares.TextAreaEntropy();

        scrRespuesta.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Desarrolle su respuesta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, LookAndFeelEntropy.FUENTE_REGULAR, new java.awt.Color(204, 102, 0)));
        scrRespuesta.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        txaRespuesta.setColumns(20);
        txaRespuesta.setRows(5);
        txaRespuesta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txaRespuestaKeyReleased(evt);
            }
        });
        scrRespuesta.setViewportView(txaRespuesta);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrRespuesta, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrRespuesta, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txaRespuestaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaRespuestaKeyReleased
        fabricarRespuesta();
    }//GEN-LAST:event_txaRespuestaKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane scrRespuesta;
    private frontend.auxiliares.TextAreaEntropy txaRespuesta;
    // End of variables declaration//GEN-END:variables

    /**
     * Actualiza el objeto respuesta con los cambios del alumno.
     * 
     * @return la respuesta actualizada..
     */
    public RespuestaDesarrollo fabricarRespuesta() {
        if (blnEsCorreccion) return respuesta;
        respuesta.setStrRespuesta(txaRespuesta.getText());
        return respuesta;
    }

    public RespuestaDesarrollo getPregunta() {
        return respuesta;
    }

    public void setPregunta(RespuestaDesarrollo respuesta) {
        this.respuesta = respuesta;
    }
    
    /**
     * Analiza si la pregunta mostrada en este panel ha sido respondida.
     * 
     * @return true si se ha modificado, false de lo contrario.
     */
    @Override
    public boolean seModifico() {
        return !txaRespuesta.getText().isEmpty();
    }

    /**
     * Carga una respuesta en el panel.
     */
    private void cargarRespuesta() {
        this.txaRespuesta.setText(respuesta.getStrRespuesta());
    }
}
