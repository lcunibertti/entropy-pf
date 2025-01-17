package frontend.auxiliares;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 * Clase que nuclea el conjunto de variables que hacen al look&feel Entropy.
 *
 * @author Denise
 */
public class LookAndFeelEntropy {

    public final static Font FUENTE_REGULAR = new Font("Calibri", 0, 12);
    public final static Font FUENTE_NEGRITA = new Font("Calibri", Font.BOLD, 12);
    public final static Font FUENTE_CURSIVA = new Font("Calibri", Font.ITALIC, 12);
    public final static Font FUENTE_TITULO = new Font("Calibri", Font.BOLD, 14);
    public final static Font FUENTE_TITULO_GRANDE = new Font("Calibri", Font.BOLD, 20);
    public final static Color COLOR_ENTROPY = new Color(255,153,51);
    public final static Color COLOR_FUENTE_DESHABILITADA = new Color(153, 153, 153);
    public final static Color COLOR_FUENTE_TITULO_PANEL = new Color(204,102,0);
    public final static Color COLOR_CURSOR = new Color(255, 102, 0);
    public final static Color COLOR_SELECCION_TEXTO = new Color(255, 204, 102);
    public final static Color COLOR_FUENTE_HABILITADA = new Color(0, 0, 0);
    public final static Color COLOR_SELECCION_ITEM = new Color(255, 204, 102);
    public final static Color COLOR_TABLA_PRIMARIO = new Color(255,204,102,50);
    public final static Color COLOR_TABLA_SECUNDARIO = new Color(255,204,102,20);
    public final static Color COLOR_BLANCO_TRANSLUCIDO = new Color(255, 255, 255, 123);
    public final static Border BORDE_NARANJA = new LineBorder(new Color(255,102,0));
    public final static Border BORDE_ENTROPY = new LineBorder(COLOR_ENTROPY);
    public final static ArrayList<Color> ENTROPY_COLOR_THEME = new ArrayList<>(Arrays.asList(
            Color.decode("#FF9800"),
            Color.decode("#FFB74D"),
            Color.decode("#FFA726"),
            Color.decode("#FF9800"),
            Color.decode("#FB8C00"),
            Color.decode("#F57C00"),
            Color.decode("#EF6C00"),
            Color.decode("#E65100"),
            Color.decode("#FFD180"),
            Color.decode("#FFAB40"),
            Color.decode("#FF9100"),
            Color.decode("#FF6D00"),
            Color.decode("#FF5722"),
            Color.decode("#FF8A65"),
            Color.decode("#FF7043"),
            Color.decode("#FF5722"),
            Color.decode("#F4511E"),
            Color.decode("#E64A19"),
            Color.decode("#D84315"),
            Color.decode("#BF360C"),
            Color.decode("#FF9E80"),
            Color.decode("#FF6E40"),
            Color.decode("#FF3D00"),
            Color.decode("#DD2C00")
    ));
    
    public static ArrayList<Color> getColors(int cantidad){
    ArrayList<Color> colores = new ArrayList<>();
        do {
            for (Color color : ENTROPY_COLOR_THEME) {
                colores.add(color);
                if (colores.size() == cantidad) {
                    return colores;
                }
            }
        } while (colores.size() < cantidad);
        return colores;
    }
}
