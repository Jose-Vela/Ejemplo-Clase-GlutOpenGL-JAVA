/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

import com.sun.opengl.util.Animator;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import javax.swing.JFrame;

/**
 *
 * @author José Vela
 */
public class HolaMundoGlutOpenGL extends JFrame{
    static GL gl;
    static GLU glu;
    
    public HolaMundoGlutOpenGL (){
        setTitle("Primer Programa Glut en Java");
        setSize(700, 700);
        //Instanciamos la clase Graphic
        GraphicListener listener = new GraphicListener();
        //Creamos el canvas
        GLCanvas canvas = new GLCanvas(new GLCapabilities());
        canvas.addGLEventListener(listener);
        getContentPane().add(canvas);
    } 
    
    public static void main (String args[]){
        HolaMundoGlutOpenGL frame = new HolaMundoGlutOpenGL();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
     public class GraphicListener implements GLEventListener{

        public void display(GLAutoDrawable arg0) {
           // Indicamos el tamaño en pixeles del grosor de la linea
           gl.glLineWidth(5);
           //Indicamos que vamos a iniciar a crear lineas
           gl.glBegin(GL.GL_LINES);
                  gl.glColor3f(1,1,1);
                  gl.glVertex2d(5,400);
                  gl.glVertex2d(300,400);

            //Deshabilitamos la creacion de lineas (de la maquina de estados )
           gl.glEnd();

           gl.glFlush();

        }

        public void init(GLAutoDrawable arg0) {
            glu = new GLU();
            gl = arg0.getGL();
            gl.glClearColor(0, 0, 0, 0);
            //Establecer los parametros para la proyeccion
            gl.glMatrixMode(gl.GL_PROJECTION);
            glu.gluOrtho2D(-700, 700, -700, 700);
        }

        public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {

        }

        public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {

        }

    }
}
