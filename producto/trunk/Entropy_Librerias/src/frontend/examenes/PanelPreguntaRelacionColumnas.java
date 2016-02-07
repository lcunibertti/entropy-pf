package frontend.examenes;

import frontend.auxiliares.IIdentificadorCambios;
import backend.diseños.CombinacionRelacionColumnas;
import backend.resoluciones.RespuestaCombinacionRelacionColumnas;
import backend.resoluciones.RespuestaPreguntaRelacionColumnas;
import frontend.auxiliares.CeldaComboboxRendererEntropy;
import frontend.auxiliares.ComboBoxEntropy;
import frontend.auxiliares.LookAndFeelEntropy;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

/**
 * Clase que representa al panel que muestra una pregunta de relación de
 * columnas al alumno.
 *
 * @author Denise
 */
public class PanelPreguntaRelacionColumnas extends javax.swing.JPanel implements IIdentificadorCambios {

    private RespuestaPreguntaRelacionColumnas respuesta;
    private Object[] opciones;
    private final boolean blnEsCorreccion;

    /**
     * Constructor de la clase PanelPreguntaRelacionColumnas.
     *
     * @param respuesta respuesta cuya pregunta se muestra en el panel.
     * @param blnEsCorreccion true si se está corrigiendo la respuesta (deben
     * estar los campos deshabilitados y cargarse la respuesta), false si el
     * alumno debe responder la respuesta
     */
    public PanelPreguntaRelacionColumnas(RespuestaPreguntaRelacionColumnas respuesta, boolean blnEsCorreccion) {
        initComponents();

        this.blnEsCorreccion = blnEsCorreccion;
        this.respuesta = respuesta;

        Object[] opcionesColDerecha = this.getOpcionesColumnaDerecha().toArray();
        opciones = new Object[opcionesColDerecha.length + 1];
        if (!blnEsCorreccion) {
            opciones[0] = "Seleccionar...";
        } else {
            opciones[0] = "No se seleccionó";
        }
        System.arraycopy(aleatorizarArray(opcionesColDerecha), 0, opciones, 1, opcionesColDerecha.length);

        // Características generales de la tabla.
        tblOpciones.setTableHeader(null);
        tblOpciones.setOpaque(false);
        tblOpciones.setGridColor(LookAndFeelEntropy.COLOR_SELECCION_TEXTO);
        tblOpciones.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.UPDATE) {
                    fabricarRespuesta();
                }
            }
        });
        // Renderers y editores.
        TableColumn colIzquierda = tblOpciones.getColumnModel().getColumn(0);
        colIzquierda.setCellRenderer(new StringRenderer());

        TableColumn colDerecha = tblOpciones.getColumnModel().getColumn(1);
        ComboBoxEntropy cmbEditor = new ComboBoxEntropy(opciones);
        CeldaComboboxRendererEntropy editorRenderer = new CeldaComboboxRendererEntropy(tblOpciones, colDerecha, cmbEditor, opciones, !blnEsCorreccion);
        colDerecha.setCellEditor(editorRenderer);
        colDerecha.setCellRenderer(editorRenderer);

        // Carga del modelo.
        cargarTabla();
        cargarRespuesta();

        if (blnEsCorreccion) {            
            colDerecha.setCellEditor(null);
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

        scrOpciones = new javax.swing.JScrollPane();
        tblOpciones = new TablaOpciones();

        scrOpciones.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        tblOpciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Columna 1", "Columna 2"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrOpciones.setViewportView(tblOpciones);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrOpciones, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrOpciones, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane scrOpciones;
    private javax.swing.JTable tblOpciones;
    // End of variables declaration//GEN-END:variables

    /**
     * Obtiene la lista con las opciones en la columna derecha.
     *
     * @return lista con las opciones en la columna derecha.
     */
    private ArrayList getOpcionesColumnaDerecha() {
        ArrayList array = new ArrayList();
        for (CombinacionRelacionColumnas relacionColumnas : respuesta.getPregunta().getColCombinaciones()) {
            array.add(relacionColumnas.getStrColumnaDerecha());
        }
        return array;
    }

    /**
     * Desordena el array que se muestra en la lista desplegada en el combobox.
     *
     * @param original vector a desordenar.
     * @return vector desordenado.
     */
    private Object[] aleatorizarArray(Object[] original) {
        Object[] aleatorizado = original.clone();
        int i = aleatorizado.length - 1;
        while (i > -1) {
            int j = (int) Math.floor(Math.random() * (i + 1));
            Object tmp = aleatorizado[i];
            aleatorizado[i] = aleatorizado[j];
            aleatorizado[j] = tmp;
            i--;
        }
        return aleatorizado;
    }

    /**
     * Carga la tabla con las relaciones de columna de la pregunta.
     */
    private void cargarTabla() {

        for (CombinacionRelacionColumnas relacionColumnas : respuesta.getPregunta().getColCombinaciones()) {
            Object[] fila = new Object[]{relacionColumnas.getStrColumnaIzquierda(), opciones[0]};
            ((DefaultTableModel) tblOpciones.getModel()).addRow(fila);
        }

    }

    /**
     * Actualiza el objeto respuesta con los cambios del alumno.
     *
     * @return la respuesta actualizada.
     */
    public RespuestaPreguntaRelacionColumnas fabricarRespuesta() {
        if (blnEsCorreccion) {
            return respuesta;
        }

        ArrayList<RespuestaCombinacionRelacionColumnas> colCombinaciones = new ArrayList<>();
        for (int intIDFila = 0; intIDFila < tblOpciones.getRowCount(); intIDFila++) {
            String strColIzquierda = ((DefaultTableModel) tblOpciones.getModel()).getValueAt(intIDFila, 0).toString();
            String strColDerecha = ((DefaultTableModel) tblOpciones.getModel()).getValueAt(intIDFila, 1).toString();
            RespuestaCombinacionRelacionColumnas rta = new RespuestaCombinacionRelacionColumnas(
                    respuesta.getPregunta().getColCombinaciones().get(intIDFila).getIntOrden(),
                    strColIzquierda,
                    (strColDerecha.equals(opciones[0].toString())) ? "" : strColDerecha
            );
            colCombinaciones.add(rta);
        }
        respuesta.setColCombinaciones(colCombinaciones);
        return respuesta;
    }

    public RespuestaPreguntaRelacionColumnas getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(RespuestaPreguntaRelacionColumnas respuesta) {
        this.respuesta = respuesta;
    }

    /**
     * Renderer para las celdas con texto.
     */
    private class StringRenderer extends JLabel implements TableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            setOpaque(true);

            setFont(LookAndFeelEntropy.FUENTE_REGULAR);

            if (row % 2 == 0) {
                setBackground(new Color(204, 204, 204, 123));
            } else {
                setBackground(new Color(204, 204, 204, 50));
            }

            if (value instanceof String) {
                int intAltoCaracter = table.getFontMetrics(table.getFont()).getHeight() + 2;
                int intAnchoActual = (int) table.getCellRect(row, column, false).getWidth();
                int intAnchoDeseado = 0;
                int intCantidadLineas = 1;
                for (char c : value.toString().toCharArray()) {
                    intAnchoDeseado += table.getFontMetrics(table.getFont()).charWidth(c);
                    if (intAnchoDeseado > intAnchoActual * intCantidadLineas) {
                        intCantidadLineas++;
                    }
                }
                int intNuevaAltura = intAltoCaracter * intCantidadLineas + 20;
                table.setRowHeight(row, intNuevaAltura);
            }

            // Mantener luego del if anterior.
            if (blnEsCorreccion) {
                if (respuesta.getColCombinaciones().isEmpty()){
                    value = "<html><span style=\"color: red;\">" + value + "</span></html>";
                } else {
                    String strColDerechaElegida = respuesta.getColCombinaciones().get(row).getStrColumnaDerecha();
                    String strColDerechaCorrecta = respuesta.getPregunta().getColCombinaciones().get(row).getStrColumnaDerecha();
                    if (!strColDerechaElegida.equals(strColDerechaCorrecta)) {
                        value = "<html><span style=\"color: red;\">" + value + "</span></html>";
                    }
                }
            }

            setText((value == null) ? "" : value.toString());

            return this;

        }

    }

    /**
     * Analiza si la pregunta mostrada en este panel ha sido respondida.
     *
     * @return true si se ha modificado, false de lo contrario.
     */
    @Override
    public boolean seModifico() {
        boolean blnSeRespondio = false;
        for (int intIDFila = 0; intIDFila < tblOpciones.getRowCount(); intIDFila++) {
            String strColDerecha = ((DefaultTableModel) tblOpciones.getModel()).getValueAt(intIDFila, 1).toString();
            if (!strColDerecha.equals(opciones[0].toString())) {
                blnSeRespondio = true;
            }
        }
        return blnSeRespondio;
    }

    /**
     * Carga una respuesta en el panel.
     */
    private void cargarRespuesta() {
        for (RespuestaCombinacionRelacionColumnas relacion : respuesta.getColCombinaciones()) {
            for (int intIDFila = 0; intIDFila < tblOpciones.getRowCount(); intIDFila++) {
                String strColIzquierda = ((DefaultTableModel) tblOpciones.getModel()).getValueAt(intIDFila, 0).toString();
                if (strColIzquierda.equals(relacion.getStrColumnaIzquierda())) {
                    ((DefaultTableModel) tblOpciones.getModel()).setValueAt(relacion.getStrColumnaDerecha(), intIDFila, 1);
                }
            }
        }
    }

    private class TablaOpciones extends JTable {

        @Override
        public boolean isCellEditable(int row, int column) {
            if (column == 1 && blnEsCorreccion) {
                return !blnEsCorreccion;
            }
            return super.isCellEditable(row, column);
        }
        
    }
    
}
