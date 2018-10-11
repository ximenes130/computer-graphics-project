package criapoligono.views;

import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import java.awt.Frame;

import javax.swing.JFrame;

/**
 *  View responsavel pela janela de edição de poligonos
 * @author ximenes
 */
public class EditorView implements GLEventListener {
    private JFrame windows;
    private GLCanvas glcanvas;
            
    public EditorView() {
        //getting the capabilities object of GL2 profile
        final GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);

        // The canvas
        glcanvas = new GLCanvas(capabilities);
        JFrame b = new JFrame("FrameDemo");
        // glcanvas.addGLEventListener(b);        
        glcanvas.setSize(400, 400);

        //creating frame
        windows = new JFrame (" Basic Frame");

        //adding canvas to frame
        windows.add(glcanvas);
        windows.setSize( 800, 600 );
        windows.setVisible(true);
        System.out.println("Janela exibida!");
    }
    
    @Override
    public void display(GLAutoDrawable arg0) {
      // method body
    }

    @Override
    public void dispose(GLAutoDrawable arg0) {
      //method body
    }

    @Override
    public void init(GLAutoDrawable arg0) {
      // method body
    }

    @Override
    public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
      // method body
    }
    
    public static void main(String[] args) {

   }
}
