package criapoligono.views;

import com.jogamp.opengl.GL2;
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
        
        // Configurando o frame
        windows.setSize( 800, 600 );
        windows.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windows.setVisible(true);
        System.out.println("Janela exibida!");
    }
    
    @Override
    public void display(GLAutoDrawable drawable) {
        final GL2 gl = drawable.getGL().getGL2();

        // Desenhando um tiangulo
        gl.glBegin(GL2.GL_TRIANGLES);
        
        // Definindo cor do desenho
        gl.glColor3f( 0f,1f,0f );

        // Definindo vertices do triangulo
        gl.glVertex3f(0.5f,0.7f,0.0f);       // Topo
        gl.glVertex3f(-0.2f,-0.50f,0.0f);    // Inferior esquerdo
        gl.glVertex3f(0.5f,-0.5f,0.0f);      // Inferior direito

        // Finalizando desenho da forma
        gl.glEnd();
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
}
