package criapoligono.views;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import criapoligono.models.Color;
import criapoligono.models.Polygon;
import criapoligono.models.Scenes;
import criapoligono.models.Vertex;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import javax.swing.JFrame;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.event.MouseInputListener;

/**
 *  View responsavel pela janela de edição de poligonos
 * @author ximenes
 */
public class EditorView implements GLEventListener, MouseInputListener, ActionListener {
    private JFrame windows;
    private GLCanvas glcanvas;
    private Vector<Polygon> polygons;
    private Polygon selectedPolygon;
    private JToolBar toolbar;
    private String currentAction;
    private Vertex lastMousePress;
    private Vertex lastMouseDrag;
    private Scenes scenes;
            
    public EditorView() {
        this.polygons = new Vector<>();
        // Definido GL2 como perfil OpenGL
        final GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);

        // Criando o canvas
        glcanvas = new GLCanvas(capabilities);
        glcanvas.addGLEventListener(this);
        glcanvas.addMouseListener(this);
        glcanvas.addMouseMotionListener(this);
        glcanvas.setSize(100, 100);

        // Criando frame (Janela)
        windows = new JFrame (" Basic Frame");

        // Adicionando o canvas no frame
        windows.getContentPane().add(glcanvas);
        
        // Inicializando toolbar
        this.toolbar = new JToolBar();
        toolbar.setRollover(true);
        toolbar.setAutoscrolls(true);

        JToggleButton selectPolygonButton = new JToggleButton("Selecionar");
        selectPolygonButton.addActionListener(this);
        toolbar.add(selectPolygonButton);
        
        JToggleButton addPolygonButton = new JToggleButton("Adicionar");
        addPolygonButton.addActionListener(this);
        toolbar.add(addPolygonButton);
        toolbar.addSeparator();
        
        JToggleButton delPolygonButton = new JToggleButton("Remover");
        delPolygonButton.addActionListener(this);
        toolbar.add(delPolygonButton);
        toolbar.addSeparator();
        
        JButton changeColorButton = new JButton("Mudar Cor");
        changeColorButton.addActionListener(this);
        toolbar.add(changeColorButton);
        
        JToggleButton movePolygonButton = new JToggleButton("Transladar");
        movePolygonButton.addActionListener(this);
        toolbar.add(movePolygonButton);
        
        JToggleButton resizePolygonButton = new JToggleButton("Redimensionar");
        resizePolygonButton.addActionListener(this);
        toolbar.add(resizePolygonButton);
        
        JToggleButton rotatePolygonButton = new JToggleButton("Rotacionar");
        rotatePolygonButton.addActionListener(this);
        toolbar.add(rotatePolygonButton);
        
        toolbar.addSeparator();
        toolbar.add(new JButton("Voltar"));
        toolbar.add(new JButton("Avançar"));
        windows.getContentPane().add(toolbar, BorderLayout.NORTH);
        
        // Configurando o frame
        windows.setSize( 800, 600 );
        windows.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windows.setVisible(true);
        System.out.println("Janela exibida!");
        
        lastMouseDrag = new Vertex();
        scenes = new Scenes();
    }
    
    @Override
    public void display(GLAutoDrawable drawable) {
        System.out.println("--- public void display ---");
        final GL2 gl = drawable.getGL().getGL2();
        
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
        gl.glLoadIdentity();

        for(Polygon polygon : polygons){
            polygon.draw(gl, polygon == selectedPolygon);
        }
        gl.glFlush();
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {
      //method body
    }

    @Override
    public void init(GLAutoDrawable drawable) {
        final GL2 gl = drawable.getGL().getGL2();
        gl.glClearColor(1, 1, 1, 1);
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int arg1, int arg2, int arg3, int arg4) {
      // method body
    }
    
    private Vertex getCanvasPoint(float x, float y){
        float newX =  ((float) x / glcanvas.getWidth())       *  2 - 1;
        float newY = (((float) y / glcanvas.getHeight()) - 1) * -2 - 1;
        return new Vertex(newX, newY);
    }
    
    private void untoggleButtons(){
        for(Component component : toolbar.getComponents()){
            if(component.getClass().toString().contains("javax.swing.JToggleButton")){
                JToggleButton toggleButton = (JToggleButton) component;
                if(!toggleButton.getActionCommand().equals(currentAction)){
                    toggleButton.getModel().setPressed(false);
                    toggleButton.setSelected(false);
                }else{
                    toggleButton.getModel().setPressed(true);
                    toggleButton.setSelected(true);
                }
            }
        }
    }
    
    private void setCurrentAction(String actionCommand){
        this.currentAction = actionCommand;
        untoggleButtons();
    }
    
    // ############################
    // ###### Event Listener ######
    // ############################
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "Mudar Cor":
                java.awt.Color color;
                color = JColorChooser.showDialog(null, "JColorChooser Sample", windows.getBackground());
                selectedPolygon.setColor(new Color(color));
                System.out.println(polygons.firstElement().getColor().toString());
                break;
            case "Selecionar":
                setCurrentAction("Selecionar");
                break;
            case "Adicionar":
                setCurrentAction("Adicionar");
                selectedPolygon = new Polygon();
                polygons.add(selectedPolygon);
                break;
            case "Remover":
                setCurrentAction("Remover");
                polygons.remove(selectedPolygon);
                selectedPolygon = null;
                break;
            case "Transladar":
                setCurrentAction("Transladar");
                break;
            case "Redimensionar":
                setCurrentAction("Redimensionar");
                break;
            case "Rotacionar":
                setCurrentAction("Rotacionar");
                break;
        }
        glcanvas.repaint();
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        Vertex point = getCanvasPoint(e.getX(), e.getY());
        System.out.println("Click Event: X="+ point.getX() +" Y="+ point.getY());
        
        switch(currentAction){
            case "Adicionar":
                selectedPolygon.addVertex(point);
                break;
            case "Selecionar":
                for(Polygon polygon : polygons){
                    if(polygon.isIn(point)){
                        selectedPolygon = polygon;
                        break;
                    }
                }
                break;
        }
        
        glcanvas.repaint();
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
        lastMousePress = getCanvasPoint(e.getX(), e.getY());
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
        Vertex point = getCanvasPoint(e.getX(), e.getY());
        switch(currentAction){
            case "Transladar":
                scenes.add
                (
                    Polygon.getMoveMatrix
                    (
                        point.getX() - lastMousePress.getX(),
                        point.getY() - lastMousePress.getY()
                    )
                );
                break;
            case "Redimensionar":
                scenes.add
                (
                    Polygon.getResizeMatrix
                    (
                        (point.getX() - lastMousePress.getX() + point.getY() - lastMousePress.getY())/2
                    )
                );
                break;
            case "Rotacionar":
                scenes.add
                (
                    Polygon.getRotateMatrix
                    (
                        lastMousePress.getX(),
                        lastMousePress.getY(),
                        point.getX(),
                        point.getY()
                    )
                );
                break;
        }
    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
    }

    @Override
    public void mouseDragged(java.awt.event.MouseEvent e) {
        Vertex point = getCanvasPoint(e.getX(), e.getY());
        System.out.println("Mouse dragged: X="+e.getX()+" Y="+e.getY());
        System.out.println("Drag difference: X="+ (point.getX() - lastMouseDrag.getX()) +" Y="+ (point.getY() - lastMouseDrag.getY()));
        switch(currentAction){
            case "Transladar":
                selectedPolygon.move(point.getX() - lastMouseDrag.getX(), point.getY() - lastMouseDrag.getY());
                break;
            case "Redimensionar":
                selectedPolygon.resize((point.getX() - lastMouseDrag.getX() + point.getY() - lastMouseDrag.getY())/2);
                break;
            case "Rotacionar":
                selectedPolygon.rotate(lastMouseDrag.getX(), lastMouseDrag.getY(), point.getX(), point.getY());
                break;
        }
        lastMouseDrag = point;
        glcanvas.repaint();
    }

    @Override
    public void mouseMoved(java.awt.event.MouseEvent e) {
    }
}
