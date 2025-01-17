package frontend.diseños;

/**
 * Clase que representa el panel de edición de preguntas verdadero y falso.
 * @author Denise
 */
public class PanelPreguntaVerdaderoFalso extends javax.swing.JPanel {

    /**
     * Constructor por defecto de la clase.
     */
    public PanelPreguntaVerdaderoFalso() {
        initComponents();
        rbnVerdadero.grabFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgrRespuestaCorrecta = new javax.swing.ButtonGroup();
        rbnVerdadero = new javax.swing.JRadioButton();
        rbnFalso = new javax.swing.JRadioButton();
        chbJustificacion = new javax.swing.JCheckBox();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Respuesta Correcta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 12), java.awt.Color.black)); // NOI18N

        bgrRespuestaCorrecta.add(rbnVerdadero);
        rbnVerdadero.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        rbnVerdadero.setSelected(true);
        rbnVerdadero.setText("Verdadero");

        bgrRespuestaCorrecta.add(rbnFalso);
        rbnFalso.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        rbnFalso.setText("Falso");

        chbJustificacion.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        chbJustificacion.setText("Solicitar justificación");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rbnVerdadero)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rbnFalso, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(chbJustificacion)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(rbnVerdadero)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbnFalso)
                    .addComponent(chbJustificacion))
                .addGap(0, 16, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public boolean getRespuestaCorrecta() {
        return rbnVerdadero.isSelected();
    }
    
    public boolean getConJustificacion() {
        return chbJustificacion.isSelected();
    }
    
    public void setRespuestaCorrecta(boolean  blnCorrecta) {
        if(blnCorrecta) rbnVerdadero.setSelected(true);
        else rbnFalso.setSelected(true);
    }
    
    public void setConJustificacion(boolean blnConJustificacion) {
        chbJustificacion.setSelected(blnConJustificacion);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgrRespuestaCorrecta;
    private javax.swing.JCheckBox chbJustificacion;
    private javax.swing.JRadioButton rbnFalso;
    private javax.swing.JRadioButton rbnVerdadero;
    // End of variables declaration//GEN-END:variables
}
