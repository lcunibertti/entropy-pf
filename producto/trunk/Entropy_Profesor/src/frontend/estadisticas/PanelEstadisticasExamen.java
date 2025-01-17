package frontend.estadisticas;

import backend.auxiliares.Mensajes;
import backend.reporte.GestorGraficosExamen;
import backend.reportes.Impresora;
import frontend.auxiliares.CeldaListaRendererEntropy;
import frontend.auxiliares.GestorBarrasDeEstado;
import frontend.auxiliares.LookAndFeelEntropy;
import frontend.auxiliares.TabbedPaneEntropy;
import frontend.inicio.VentanaPrincipal;
import java.awt.Component;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.io.FileWriter;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 * Clase que representa al panel de estadísticas del examen.
 *
 * @author Denise
 */
public class PanelEstadisticasExamen extends javax.swing.JPanel {

    private final Object mPadre;
    private final GestorBarrasDeEstado gestorEstados;
    private Component ultimoComboActivo;
    private final GestorGraficosExamen gestorGraficos;
    private final int ancho = 600;
    private final int alto = 600;

    /**
     * Constructor para editar un diseño de examen.
     *
     * @param mPadre Ventana Principal padre
     * @param gestorGraficos
     */
    public PanelEstadisticasExamen(Component mPadre, GestorGraficosExamen gestorGraficos) {
        this.mPadre = mPadre;
        initComponents();
        this.gestorEstados = new GestorBarrasDeEstado(lblActualizacionEstado, lblIconoEstado);
        this.gestorGraficos = gestorGraficos;
        this.pnlPreguntas.setVisible(false);
        tpnEstadisticas.setUI(new TabbedPaneEntropy());
        if (!(mPadre instanceof PanelEstadisticasAlumno)){
            tblRespuestas.setModel(new javax.swing.table.DefaultTableModel(
                gestorGraficos.crearMatrizRespuestas(),
                gestorGraficos.getEncabezadoMatriz()
            ));
        } else {
            tpnEstadisticas.remove(scrRespuestas);
            cmbFiltro.removeItem("Preguntas");
        }
        tblRespuestas.setDefaultRenderer(Object.class, new CeldaRespuestasRenderer());
        tblRespuestas.getTableHeader().setDefaultRenderer(new CeldaRespuestasHeaderRenderer());
        tblRespuestas.getTableHeader().setReorderingAllowed(false);
        tpnEstadisticas.setFont(LookAndFeelEntropy.FUENTE_REGULAR);
        tpnEstadisticas.setOpaque(false);
        if (gestorGraficos.getTotalNoCorregidos() > 0){
            String strMensaje = "Existen "+gestorGraficos.getTotalNoCorregidos()+" resoluciones a espera de corrección. No se incluirán en las estadísticas.";
            Mensajes.mostrarAdvertencia(strMensaje);
            gestorEstados.setNuevoEstadoImportante(strMensaje, GestorBarrasDeEstado.TipoEstado.ADVERTENCIA);
        }
        if (!(mPadre instanceof PanelEstadisticasAlumno)) {
                pnlBotones.remove(btnVolver);
        }
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                generarGrafico();
            }
        });
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
        btnGuardarExamen = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        btnVolverInicio = new javax.swing.JButton();
        pnlEstado = new javax.swing.JPanel();
        lblActualizacionEstado = new javax.swing.JLabel();
        lblIconoEstado = new javax.swing.JLabel();
        pnlFiltros = new javax.swing.JPanel();
        cmbNotas = new javax.swing.JComboBox();
        cmbFiltro = new javax.swing.JComboBox();
        cmbGrafico = new javax.swing.JComboBox();
        cmbPorcentaje = new javax.swing.JComboBox();
        pnlGrafico = new frontend.auxiliares.PanelConFondo();
        tpnEstadisticas = new javax.swing.JTabbedPane();
        spnGrafico = new javax.swing.JSplitPane();
        pnlPreguntas = new javax.swing.JPanel();
        scrPreguntas = new javax.swing.JScrollPane();
        lstPreguntas = new javax.swing.JList();
        scrGrafico = new javax.swing.JScrollPane();
        lblGrafico = new javax.swing.JLabel();
        scrRespuestas = new javax.swing.JScrollPane();
        tblRespuestas = new javax.swing.JTable();
        lblInfoExamenes = new javax.swing.JLabel();

        pnlBotones.setLayout(new java.awt.GridLayout(1, 0));

        btnGuardarExamen.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        btnGuardarExamen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/frontend/imagenes/ic_guardar.png"))); // NOI18N
        btnGuardarExamen.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnGuardarExamen.setContentAreaFilled(false);
        btnGuardarExamen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardarExamen.setIconTextGap(10);
        btnGuardarExamen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGuardarExamenMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGuardarExamenMouseExited(evt);
            }
        });
        btnGuardarExamen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarExamenActionPerformed(evt);
            }
        });
        pnlBotones.add(btnGuardarExamen);

        btnImprimir.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/frontend/imagenes/ic_imprimir.png"))); // NOI18N
        btnImprimir.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnImprimir.setContentAreaFilled(false);
        btnImprimir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnImprimir.setIconTextGap(10);
        btnImprimir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnImprimirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnImprimirMouseExited(evt);
            }
        });
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });
        pnlBotones.add(btnImprimir);

        btnVolver.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/frontend/imagenes/ic_volver.png"))); // NOI18N
        btnVolver.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnVolver.setContentAreaFilled(false);
        btnVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVolver.setIconTextGap(10);
        btnVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnVolverMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnVolverMouseExited(evt);
            }
        });
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        pnlBotones.add(btnVolver);

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

        pnlFiltros.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filtrar por", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, LookAndFeelEntropy.FUENTE_REGULAR));
        pnlFiltros.setOpaque(false);
        pnlFiltros.setLayout(new java.awt.GridLayout(1, 0, 10, 10));

        cmbNotas.setBackground(new java.awt.Color(255, 204, 102));
        cmbNotas.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        cmbNotas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Resoluciones", "Aprobados", "Desaprobados" }));
        cmbNotas.setRenderer(new CeldaListaRendererEntropy());
        cmbNotas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbNotasItemStateChanged(evt);
            }
        });
        cmbNotas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cmbNotasFocusGained(evt);
            }
        });
        pnlFiltros.add(cmbNotas);

        cmbFiltro.setBackground(new java.awt.Color(255, 204, 102));
        cmbFiltro.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        cmbFiltro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "General", "Tema", "Dificultad", "Preguntas" }));
        cmbFiltro.setRenderer(new CeldaListaRendererEntropy());
        cmbFiltro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbFiltroItemStateChanged(evt);
            }
        });
        cmbFiltro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cmbFiltroFocusGained(evt);
            }
        });
        pnlFiltros.add(cmbFiltro);

        cmbGrafico.setBackground(new java.awt.Color(255, 204, 102));
        cmbGrafico.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        cmbGrafico.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Gráfico por defecto", "Torta", "Lineal", "Barras" }));
        cmbGrafico.setRenderer(new CeldaListaRendererEntropy());
        cmbGrafico.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbGraficoItemStateChanged(evt);
            }
        });
        cmbGrafico.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cmbGraficoFocusGained(evt);
            }
        });
        pnlFiltros.add(cmbGrafico);

        cmbPorcentaje.setBackground(new java.awt.Color(255, 204, 102));
        cmbPorcentaje.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        cmbPorcentaje.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Valor absoluto", "Porcentaje" }));
        cmbPorcentaje.setRenderer(new CeldaListaRendererEntropy());
        cmbPorcentaje.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbPorcentajeItemStateChanged(evt);
            }
        });
        cmbPorcentaje.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cmbPorcentajeFocusGained(evt);
            }
        });
        pnlFiltros.add(cmbPorcentaje);

        pnlGrafico.setBorder(null);
        pnlGrafico.setOpaque(false);
        pnlGrafico.setLayout(new java.awt.GridLayout(1, 0, 10, 10));

        tpnEstadisticas.setBorder(null);

        pnlPreguntas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Preguntas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 12), new java.awt.Color(102, 102, 102))); // NOI18N
        pnlPreguntas.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        pnlPreguntas.setMaximumSize(new java.awt.Dimension(600, 32767));
        pnlPreguntas.setOpaque(false);

        scrPreguntas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 51, 0)));
        scrPreguntas.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        lstPreguntas.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lstPreguntas.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "LALA", "LALA" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        lstPreguntas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstPreguntas.setCellRenderer(new CeldaListaRendererEntropy());
        lstPreguntas.setSelectionBackground(new java.awt.Color(255, 204, 102));
        scrPreguntas.setViewportView(lstPreguntas);

        javax.swing.GroupLayout pnlPreguntasLayout = new javax.swing.GroupLayout(pnlPreguntas);
        pnlPreguntas.setLayout(pnlPreguntasLayout);
        pnlPreguntasLayout.setHorizontalGroup(
            pnlPreguntasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrPreguntas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
        );
        pnlPreguntasLayout.setVerticalGroup(
            pnlPreguntasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrPreguntas, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
        );

        spnGrafico.setLeftComponent(pnlPreguntas);

        lblGrafico.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        scrGrafico.setViewportView(lblGrafico);

        spnGrafico.setRightComponent(scrGrafico);

        tpnEstadisticas.addTab("Gráfico", spnGrafico);

        tblRespuestas.setModel(new javax.swing.table.DefaultTableModel(
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
        tblRespuestas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        scrRespuestas.setViewportView(tblRespuestas);

        tpnEstadisticas.addTab("Preguntas por resolución", scrRespuestas);

        pnlGrafico.add(tpnEstadisticas);

        lblInfoExamenes.setBackground(LookAndFeelEntropy.COLOR_TABLA_PRIMARIO);
        lblInfoExamenes.setFont(LookAndFeelEntropy.FUENTE_REGULAR);
        lblInfoExamenes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/frontend/imagenes/ic_mensajes_informacion_orange.png"))); // NOI18N
        lblInfoExamenes.setText("<html>Seleccione la solapa pertinente y presione el botón de guardado para descargar la imagen o la hoja de cálculo.</html>");
        lblInfoExamenes.setBorder(javax.swing.BorderFactory.createLineBorder(LookAndFeelEntropy.COLOR_ENTROPY));
        lblInfoExamenes.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlGrafico, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(pnlEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlFiltros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblInfoExamenes, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlBotones, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlGrafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInfoExamenes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverInicioActionPerformed
        VentanaPrincipal.getInstancia().volverAInicio();
    }//GEN-LAST:event_btnVolverInicioActionPerformed

    private void btnGuardarExamenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarExamenActionPerformed
        try {
            JFileChooser fileChooser = new JFileChooser(System.getProperty("user.home"));
            fileChooser.setDialogTitle("Guardar archivo...");
            if (tpnEstadisticas.getSelectedIndex() == 0) { //se quiere guardar el gráfico
                FileFilter pdf = new FileNameExtensionFilter("Portable Document Format (.pdf)", "pdf");
                fileChooser.addChoosableFileFilter(pdf);
                fileChooser.setFileFilter(pdf);
                fileChooser.setSelectedFile(new File("Gráfico.pdf"));
                fileChooser.setAcceptAllFileFilterUsed(false);
                int response = fileChooser.showSaveDialog(null);
                if(response == JFileChooser.APPROVE_OPTION)
                {
                   File fileToSave = fileChooser.getSelectedFile();
                    if (!fileToSave.exists() || (fileToSave.exists() && Mensajes.mostrarConfirmacion("El archivo ya existe. ¿Desea sobreescribirlo?"))) {
                        gestorGraficos.guardarUltimoGrafico(fileToSave, 500, 500);
                        Mensajes.mostrarExito("Gráfico guardado.");
                        gestorEstados.setNuevoEstadoImportante("Gráfico guardado con éxito en " + fileToSave.getAbsolutePath(), GestorBarrasDeEstado.TipoEstado.OK);
                    }
                }
            } else { //se guarda un csv de datos
                FileFilter csv = new FileNameExtensionFilter("Comma-Separated Values (.csv)", "csv");
                fileChooser.addChoosableFileFilter(csv);
                fileChooser.setFileFilter(csv);
                fileChooser.setSelectedFile(new File("Datos.csv"));
                fileChooser.setAcceptAllFileFilterUsed(false);
                int response = fileChooser.showSaveDialog(null);
                if(response == JFileChooser.APPROVE_OPTION)
                {
                    File fileToSave = fileChooser.getSelectedFile();
                    if (!fileToSave.exists() || (fileToSave.exists() && Mensajes.mostrarConfirmacion("El archivo ya existe. ¿Desea sobreescribirlo?"))) {
                        FileWriter writer = new FileWriter(fileToSave);
                        DefaultTableModel dtm = (DefaultTableModel) tblRespuestas.getModel();                                
                        for(int row = 0;row < dtm.getRowCount();row++) {
                            for(int col = 0;col < dtm.getColumnCount();col++) {
                                writer.append((dtm.getValueAt(row, col) instanceof String) ? dtm.getValueAt(row, col).toString() + "," : ",");
                            }
                            writer.append('\n');
                        }
                        writer.flush();
                        writer.close();
                        Mensajes.mostrarExito("Datos guardados.");
                        gestorEstados.setNuevoEstadoImportante("Datos guardados con éxito en " + fileToSave.getAbsolutePath(), GestorBarrasDeEstado.TipoEstado.OK);
                    }  
                }
            }
        } catch (Exception e){
            Mensajes.mostrarError("Problemas al guardar el archivo. Intente nuevamente.");
        }
    }//GEN-LAST:event_btnGuardarExamenActionPerformed

    private void btnGuardarExamenMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarExamenMouseExited
        this.gestorEstados.volverAEstadoImportante();
    }//GEN-LAST:event_btnGuardarExamenMouseExited

    private void btnImprimirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnImprimirMouseExited
        this.gestorEstados.volverAEstadoImportante();
    }//GEN-LAST:event_btnImprimirMouseExited

    private void btnVolverInicioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVolverInicioMouseExited
        this.gestorEstados.volverAEstadoImportante();
    }//GEN-LAST:event_btnVolverInicioMouseExited

    private void btnGuardarExamenMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarExamenMouseEntered
        this.gestorEstados.setEstadoInstantaneo("Exportar este gráfico.");
    }//GEN-LAST:event_btnGuardarExamenMouseEntered

    private void btnImprimirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnImprimirMouseEntered
        this.gestorEstados.setEstadoInstantaneo("Imprimir este gráfico.");
    }//GEN-LAST:event_btnImprimirMouseEntered

    private void btnVolverInicioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVolverInicioMouseEntered
        this.gestorEstados.setEstadoInstantaneo("Volver a la pantalla inicial.");
    }//GEN-LAST:event_btnVolverInicioMouseEntered

    private void cmbPorcentajeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbPorcentajeItemStateChanged
        if (ultimoComboActivo == evt.getSource()) {
            generarGrafico();
        }
    }//GEN-LAST:event_cmbPorcentajeItemStateChanged

    private void cmbPorcentajeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbPorcentajeFocusGained
        this.ultimoComboActivo = evt.getComponent();
    }//GEN-LAST:event_cmbPorcentajeFocusGained

    private void cmbFiltroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbFiltroItemStateChanged
        if (ultimoComboActivo == evt.getSource()) {
            this.cmbGrafico.removeAllItems();
            int indexFiltro = this.cmbFiltro.getSelectedIndex();
            switch (indexFiltro) {
                case 0: //Frecuencias
                    this.cmbGrafico.setModel(new DefaultComboBoxModel(new String[]{"Gráfico por defecto", "Torta", "Lineal", "Barras"}));
                    break;
                case 1: // Tema
                    this.cmbGrafico.setModel(new DefaultComboBoxModel(new String[]{"Gráfico por defecto", "Barras", "Barras apiladas"}));
                    break;
                case 2: // Nivel
                    this.cmbGrafico.setModel(new DefaultComboBoxModel(new String[]{"Gráfico por defecto", "Barras", "Barras apiladas"}));
                    break;
                case 3: // Preguntas
                    this.cmbGrafico.setModel(new DefaultComboBoxModel(new String[]{"Torta", "Barras", "Barras apiladas", "Lineal"}));
                    break;
            }
            generarGrafico();
        }
    }//GEN-LAST:event_cmbFiltroItemStateChanged

    private void cmbFiltroFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbFiltroFocusGained
        this.ultimoComboActivo = evt.getComponent();
    }//GEN-LAST:event_cmbFiltroFocusGained

    private void cmbGraficoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbGraficoItemStateChanged
        if (ultimoComboActivo == evt.getSource()) {
            generarGrafico();
        }
    }//GEN-LAST:event_cmbGraficoItemStateChanged

    private void cmbGraficoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbGraficoFocusGained
        this.ultimoComboActivo = evt.getComponent();
    }//GEN-LAST:event_cmbGraficoFocusGained

    private void cmbNotasFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbNotasFocusGained
        this.ultimoComboActivo = evt.getComponent();
    }//GEN-LAST:event_cmbNotasFocusGained

    private void cmbNotasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbNotasItemStateChanged
        if (ultimoComboActivo == evt.getSource()) {
            int indexNotas = this.cmbNotas.getSelectedIndex();
            switch (indexNotas) {
                case 0: // Resoluciones
                    gestorGraficos.setEsProcesarSoloAprobadas(false);
                    gestorGraficos.setEsProcesarSoloDesaprobadas(false);
                    break;
                case 1: // Aprobados
                    gestorGraficos.setEsProcesarSoloAprobadas(true);
                    gestorGraficos.setEsProcesarSoloDesaprobadas(false);
                    break;
                case 2: // Desaprobados
                    gestorGraficos.setEsProcesarSoloAprobadas(false);
                    gestorGraficos.setEsProcesarSoloDesaprobadas(true);
                    break;
            }
            generarGrafico();
        }
    }//GEN-LAST:event_cmbNotasItemStateChanged

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        try {
            File temp = File.createTempFile("print", ".tmp"); 
            gestorGraficos.guardarUltimoGrafico(temp, 500, 500);
            Impresora.imprimirPDF(temp);
        } catch (Exception e){
            Mensajes.mostrarError("Error al intentar imprimir el gráfico. Verifique que existe una impresora conectada.");
        }
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void btnVolverMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVolverMouseEntered
        this.gestorEstados.setEstadoInstantaneo("Volver a estadísticas del alumno.");
    }//GEN-LAST:event_btnVolverMouseEntered

    private void btnVolverMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVolverMouseExited
        this.gestorEstados.volverAEstadoImportante();
    }//GEN-LAST:event_btnVolverMouseExited

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        VentanaPrincipal.getInstancia().getPanelDeslizante().setPanelMostrado((JPanel) mPadre);
    }//GEN-LAST:event_btnVolverActionPerformed

    public GestorBarrasDeEstado getGestorEstados() {
        return gestorEstados;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardarExamen;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnVolver;
    private javax.swing.JButton btnVolverInicio;
    private javax.swing.JComboBox cmbFiltro;
    private javax.swing.JComboBox cmbGrafico;
    private javax.swing.JComboBox cmbNotas;
    private javax.swing.JComboBox cmbPorcentaje;
    private javax.swing.JLabel lblActualizacionEstado;
    private javax.swing.JLabel lblGrafico;
    private javax.swing.JLabel lblIconoEstado;
    private javax.swing.JLabel lblInfoExamenes;
    private javax.swing.JList lstPreguntas;
    private javax.swing.JPanel pnlBotones;
    private javax.swing.JPanel pnlEstado;
    private javax.swing.JPanel pnlFiltros;
    private frontend.auxiliares.PanelConFondo pnlGrafico;
    private javax.swing.JPanel pnlPreguntas;
    private javax.swing.JScrollPane scrGrafico;
    private javax.swing.JScrollPane scrPreguntas;
    private javax.swing.JScrollPane scrRespuestas;
    private javax.swing.JSplitPane spnGrafico;
    private javax.swing.JTable tblRespuestas;
    private javax.swing.JTabbedPane tpnEstadisticas;
    // End of variables declaration//GEN-END:variables

    private void generarGrafico() {
        pnlPreguntas.setVisible(false);
        int indexFiltro = this.cmbFiltro.getSelectedIndex();
        int indexGrafico = this.cmbGrafico.getSelectedIndex();
        boolean esPorcentaje = this.cmbPorcentaje.getSelectedIndex() == 1;
        int ancho = lblGrafico.getSize().width;
        if (ancho < 200) {
            ancho = this.ancho;
        }
        int alto = lblGrafico.getSize().height;
        if (alto < 200) {
            alto = this.alto;
        }
        switch (indexFiltro) {
            case 0: // Frecuencias
                switch (indexGrafico) {
                    case 0: // Defecto
                        this.lblGrafico.setIcon(new ImageIcon(gestorGraficos.generarGraficoBarrasDistribucionResultadosResoluciones(esPorcentaje, true, ancho, alto)));
                        break;
                    case 1: // Torta
                        this.lblGrafico.setIcon(new ImageIcon(gestorGraficos.generarGraficoTortaResoluciones(ancho, alto)));
                        break;
                    case 2: // Lineal
                        this.lblGrafico.setIcon(new ImageIcon(gestorGraficos.generarGraficoLinealResoluciones(esPorcentaje, true, ancho, alto)));
                        break;
                    case 3: // Barras
                        this.lblGrafico.setIcon(new ImageIcon(gestorGraficos.generarGraficoBarrasResoluciones(esPorcentaje, true, ancho, alto)));
                        break;
                }
                break;
            case 1: // Tema
                switch (indexGrafico) {
                    case 0: // Defecto
                        this.lblGrafico.setIcon(new ImageIcon(gestorGraficos.generarGraficoPoblacionResolucionesTemas(esPorcentaje, ancho, alto)));
                        break;
                    case 1: // Barras
                        this.lblGrafico.setIcon(new ImageIcon(gestorGraficos.generarGraficoBarrasResolucionesTemas(esPorcentaje, ancho, alto)));
                        break;
                    case 2: // Barras apiladas
                        this.lblGrafico.setIcon(new ImageIcon(gestorGraficos.generarGraficoBarrasApiladasResolucionesTemas(esPorcentaje, ancho, alto)));
                        break;
                }
                break;
            case 2: // Nivel
                switch (indexGrafico) {
                    case 0: // Defecto
                        this.lblGrafico.setIcon(new ImageIcon(gestorGraficos.generarGraficoPoblacionResolucionesDificultad(esPorcentaje, ancho, alto)));
                        break;
                    case 1: // Barras
                        this.lblGrafico.setIcon(new ImageIcon(gestorGraficos.generarGraficoBarrasResolucionesDificultad(esPorcentaje, ancho, alto)));
                        break;
                    case 2: // Barras apiladas
                        this.lblGrafico.setIcon(new ImageIcon(gestorGraficos.generarGraficoBarrasApiladasResolucionesDificultad(esPorcentaje, ancho, alto)));
                        break;
                }
                break;
            case 3: // Preguntas
                lstPreguntas.removeAll();
                lstPreguntas.setModel(new javax.swing.AbstractListModel() {
                    String[] strings = gestorGraficos.getEnunciadosPreguntas();

                    public int getSize() {
                        return strings.length;
                    }

                    public Object getElementAt(int i) {
                        return strings[i];
                    }
                });
                if (!pnlPreguntas.isVisible()) {
                    spnGrafico.setDividerLocation(0.33);
                    pnlPreguntas.setVisible(true);
                }
                switch (indexGrafico) {
                    case 0: //Torta
                        this.lblGrafico.setIcon(new ImageIcon(gestorGraficos.generarGraficoTortaResolucionesPreguntas(ancho*2/3, alto)));
                        break;
                    case 1: // Barras
                        this.lblGrafico.setIcon(new ImageIcon(gestorGraficos.generarGraficoBarrasResolucionesPreguntas(esPorcentaje, ancho, alto)));
                        break;
                    case 2: // Barras apiladas
                        this.lblGrafico.setIcon(new ImageIcon(gestorGraficos.generarGraficoBarrasApiladasResolucionesPreguntas(esPorcentaje, ancho, alto)));
                        break;
                    case 3: // Lineal
                        this.lblGrafico.setIcon(new ImageIcon(gestorGraficos.generarGraficoLinealResolucionesPreguntas(esPorcentaje, true, ancho, alto)));
                        break;
                }
                break;
        }
        tpnEstadisticas.setSelectedIndex(0);
    }
    
}
