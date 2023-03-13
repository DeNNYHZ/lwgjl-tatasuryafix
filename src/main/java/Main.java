import Engine.*;
import Engine.Object2D;
import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;

public class Main {
    private Window window =
            new Window
                    (800,800,"Tata Surya");
    private ArrayList<Object2D> objects
            = new ArrayList<>();
    private ArrayList<Object> objectsRectangle
            = new ArrayList<>();

    private ArrayList<Object> objectsPointsControl
            = new ArrayList<>();

    private MouseInput mouseInput;
    public void init() {
        window.init();
        GL.createCapabilities();
        mouseInput = window.getMouseInput();
        //code
//        objects.add(new Sphere(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.0f, 1.0f, 0.0f, 1.0f),
//                Arrays.asList(0.0f, 0.0f, 0.0f),
//                0.5f,
//                0.5f,
//                0.5f,
//                36,
//                18
//        ));
        //
//        objects.add(new Object2D(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(0.0f,0.5f,0.0f),
//                                new Vector3f(-0.5f,-0.5f,0.0f),
//                                new Vector3f(0.5f,-0.5f,0.0f)
//                        )
//                ),
//                new Vector4f(0.0f,1.0f,1.0f,1.0f)
//        ));

//matahari object 0
        objects.add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 1.0f, 0.0f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.11f,
                0.11f,
                0.11f,
                36,
                18
        ));

        //object 1 merkurius
        objects.add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.9f, 0.9f, 0.9f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.04f,
                0.04f,
                0.04f,
                36,
                18
        ));

        //object 2 venus
        objects.add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 1.0f, 0.8f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.06f,
                0.06f,
                0.06f,
                36,
                18
        ));

        //object 3 bumi
        objects.add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f, 1.0f, 1.0f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.055f,
                0.055f,
                0.055f,
                36,
                18
        ));

        //object 4 mars
        objects.add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f, 0.0f, 1.0f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.055f,
                0.055f,
                0.055f,
                36,
                18
        ));

        //object 5 bulan
        objects.add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.02f,
                0.02f,
                0.02f,
                36,
                18
        ));




        objects.get(0).rotateObject(180f, 0.0f, 0.0f, 0.0f);
        objects.get(0).scaleObject(2f, 2f, 2f);

        objects.get(1).translateObject(0.2f, 0.0f, 0.0f);
        objects.get(1).rotateObject(180f, 1.0f, 0.0f, 0.0f);
        objects.get(1).scaleObject(1f, 1f, 1f);

        objects.get(2).translateObject(0.3f, -0.1f, 0.0f);
        objects.get(2).rotateObject(180f, 1.0f, 0.0f, 0.0f);
        objects.get(2).scaleObject(1f, 1f, 1f);

        objects.get(3).translateObject(0.45f, -0.3f, 0.0f);
        objects.get(3).rotateObject(180f, 1.0f, 0.0f, 0.0f);
        objects.get(3).scaleObject(1f, 1f, 1f);

        objects.get(4).translateObject(0.64f, -0.4f, 0.0f);
        objects.get(4).rotateObject(180f, 1.0f, 0.0f, 0.0f);

        objects.get(5).translateObject(0.68f, -0.69f, 0.0f);
        objects.get(5).rotateObject(180f, 1.0f, 0.0f, 0.0f);

}



    public void input(){
        // MATAHARI OBJECT 0
        // MERKURIUS OBJECT 1
        // VENUS OBJECT 2
        // BUMI OBJECT 3
        // MARS OBJECT 4
        // BULAN OBJECT 5

        if (window.isKeyPressed(GLFW_KEY_F)) {
            objects.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f,0.0f,1.0f);
            objects.get(1).rotateObject((float) Math.toRadians(0.5f), 0.0f,0.0f,1.0f);
            objects.get(2).rotateObject((float) Math.toRadians(0.5f), 0.0f,0.0f,1.0f);
            objects.get(3).rotateObject((float) Math.toRadians(0.5f), 0.0f,0.0f,1.0f);
            objects.get(4).rotateObject((float) Math.toRadians(0.5f), 0.0f,0.0f,1.0f);
        }
        if (window.isKeyPressed(GLFW_KEY_G)) {

        }
        if (window.isKeyPressed(GLFW_KEY_H)) {
            objects.get(5).rotateObject((float) Math.toRadians(0.5f), 0.0f,0.0f,1.0f);
        }



        if(mouseInput.isLeftButtonPressed()){
            Vector2f pos = mouseInput.getCurrentPos();
//            System.out.println("x : "+pos.x+" y : "+pos.y);
            pos.x = (pos.x - (window.getWidth())/2.0f) /
                    (window.getWidth()/2.0f);
            pos.y = (pos.y - (window.getHeight())/2.0f) /
                    (-window.getHeight()/2.0f);
            //System.out.println("x : "+pos.x+" y : "+pos.y);

            if((!(pos.x > 1 || pos.x < -0.97) && !(pos.y > 0.97 || pos.y < -1))){
                System.out.println("x : "+pos.x+" y : "+pos.y);
//                objectsPointsControl.get(0).addVertices(new Vector3f(pos.x,pos.y,0));
            }
        }

    }


    public void loop(){
        while (window.isOpen()) {
            window.update();
            glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GL.createCapabilities();
            input();

            //code
            for (Object2D i: objects){
                i.draw();
            }
//            for (Object2D i: objectsPointsControl){
//                i.drawLine();
//            }
//            for (Object i: objectsRectangle){
//                i.drawLine();
//            }

            // Restore state
            glDisableVertexAttribArray(0);

            // Poll for window events.
            // The key callback above will only be
            // invoked during this call.
            glfwPollEvents();
        }
    }
    public void run() {

        init();
        loop();

        // Terminate GLFW and
        // free the error callback
        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }
    public static void main(String[] args) {
        new Main().run();
    }
}