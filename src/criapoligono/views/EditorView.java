package criapoligono.views;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import criapoligono.models.Color;
import criapoligono.models.Polygon;
import criapoligono.models.Vertex;
import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;

/**
 *  View responsavel pela janela de edição de poligonos
 * @author ximenes
 */
public class EditorView implements GLEventListener {
    private JFrame windows;
    private GLCanvas glcanvas;
    private Vector<Polygon> polygons;
    //    private Scenes scenes; // TODO: Estudar melhor 
            
    public EditorView() {
        this.polygons = new Vector<>();
        // Definido GL2 como perfil OpenGL
        final GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);

        // Criando o canvas
        glcanvas = new GLCanvas(capabilities);
        glcanvas.addGLEventListener(this); 
        glcanvas.setSize(400, 400);

        // Criando frame (Janela)
        windows = new JFrame (" Basic Frame");

        // Adicionando o canvas no frame
        windows.getContentPane().add(glcanvas);
        
        // Init button event listener
        EditorButtonClickListener eventListener = new EditorButtonClickListener();
        
        // Inicializando toolbar
        JToolBar toolbar = new JToolBar();
        toolbar.setRollover(true);
        toolbar.setAutoscrolls(true);
        
        JButton selectPolygonButton = new JButton("Selecionar");
        toolbar.add(selectPolygonButton);
        
        toolbar.add(new JButton("Adicionar"));
        toolbar.addSeparator();
        
        JButton changeColorButton = new JButton("Mudar Cor");
        changeColorButton.addActionListener(eventListener);
        toolbar.add(changeColorButton);
        
        toolbar.add(new JButton("Transladar"));
        toolbar.add(new JButton("Redimensionar"));
        toolbar.add(new JButton("Rotacionar"));
        toolbar.addSeparator();
        toolbar.add(new JButton("Voltar"));
        toolbar.add(new JButton("Avançar"));
        windows.getContentPane().add(toolbar, BorderLayout.NORTH);
        
        Polygon p = new Polygon();
        p.setColor(new Color(0, 1f, 0));
        p.addVertex(new Vertex(0, 0));
        p.addVertex(new Vertex(0.5f, 0.2f));
        p.addVertex(new Vertex(0.5f, -0.5f));
        p.addVertex(new Vertex(0.2f, -0.2f));
        p.addVertex(new Vertex(0.2f, -0.7f));
        this.polygons.add(p);
        
        // Configurando o frame
        windows.setSize( 800, 600 );
        windows.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windows.setVisible(true);
        System.out.println("Janela exibida!");
    }
    
    @Override
    public void display(GLAutoDrawable drawable) {
        System.out.println("--- public void display ---");
        final GL2 gl = drawable.getGL().getGL2();

        for(Polygon polygon : polygons){
            polygon.draw(gl);
        }
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {
      //method body
    }

    @Override
    public void init(GLAutoDrawable drawable) {
      // method body
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int arg1, int arg2, int arg3, int arg4) {
      // method body
    }
    
    // ############################
    // ###### Event Listener ######
    // ############################
    
    public class EditorButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            switch(e.getActionCommand()){
                case "Mudar Cor":
                    java.awt.Color color;
                    color = JColorChooser.showDialog(null, "JColorChooser Sample", windows.getBackground());
                    polygons.firstElement().setColor(new Color(color));
                    System.out.println(polygons.firstElement().getColor().toString());
                    break;
            }
            glcanvas.repaint();
        }
    }
}
