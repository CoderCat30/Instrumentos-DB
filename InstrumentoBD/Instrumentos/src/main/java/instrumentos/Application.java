package instrumentos;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Application {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");}
        catch (Exception ex) {};

        window = new JFrame();
        window.setContentPane(new JTabbedPane());

        instrumentos.presentation.tipos.Model tiposModel= new instrumentos.presentation.tipos.Model();
        instrumentos.presentation.tipos.View tiposView = new instrumentos.presentation.tipos.View();
        tiposController = new instrumentos.presentation.tipos.Controller(tiposView,tiposModel);

        instrumentos.presentation.instrumentos.Model instrumentosModel= new instrumentos.presentation.instrumentos.Model();
        instrumentos.presentation.instrumentos.View instrumentosView = new instrumentos.presentation.instrumentos.View();
        instrumentosController = new instrumentos.presentation.instrumentos.Controller(instrumentosView,instrumentosModel);

        instrumentos.presentation.acercade.Model acercadeModel= new instrumentos.presentation.acercade.Model();
        instrumentos.presentation.acercade.View acercadeView = new instrumentos.presentation.acercade.View();
        acercadeController = new instrumentos.presentation.acercade.Controller(acercadeView,acercadeModel);

        window.getContentPane().add("Tipos de Instrumento",tiposView.getPanel());
        window.getContentPane().add("Instrumentos",instrumentosView.getPanel());
         window.getContentPane().add("Acerca de..",acercadeView.getPanel());

        window.setSize(900,450);
        window.setResizable(true);
        //window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setIconImage((new ImageIcon(Application.class.getResource("presentation/icons/icon.png"))).getImage());
        window.setTitle("SILAB: Sistema de Laboratorio Industrial");
        window.setVisible(true);
    }

    public static instrumentos.presentation.tipos.Controller tiposController;

    public static instrumentos.presentation.acercade.Controller acercadeController;

    public static instrumentos.presentation.instrumentos.Controller instrumentosController;

     public static JFrame window;

    public final static int MODE_CREATE=1;
    public final static int MODE_EDIT=2;

    public static Border BORDER_ERROR = BorderFactory.createMatteBorder(0, 0, 2, 0, Color.RED);
}
