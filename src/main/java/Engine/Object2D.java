package Engine;

import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.joml.Vector4f;

import static org.lwjgl.opengl.GL30.*;

import java.util.List;

public class Object2D extends ShaderProgram{
    public List<Vector3f> vertices;

    //untuk mengirim vertex ke window
    int vao;
    int vbo;

    //untuk warna full memakai vector4f
    Vector4f color;
    Matrix4f model;

    UniformsMap uniformsMap;

    //untuk rainbow pewarnaan campur
    List<Vector3f> verticesColor;

    int vboColor;

    public Object2D(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color) {
        super(shaderModuleDataList);
        this.vertices = vertices;
        setVAOVBO();
        uniformsMap = new UniformsMap(getProgramId());
        uniformsMap.createUniform("uni_color");
        uniformsMap.createUniform("model");
        this.color = color;
        model = new Matrix4f().identity();
    }

    public Object2D(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, List<Vector3f> verticesColor) {
        super(shaderModuleDataList);
        this.vertices = vertices;
        this.verticesColor = verticesColor;
        setVAOVBOVerticesColor();
    }

    public void setVAOVBO() {
        vao = glGenVertexArrays();
        glBindVertexArray(vao);

        vbo = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER,
                vbo);
        glBufferData(GL_ARRAY_BUFFER,
                Utils.listoFloat(vertices),
                GL_STATIC_DRAW);
    }

    public void setVAOVBOVerticesColor() {
        vao = glGenVertexArrays();
        glBindVertexArray(vao);

        vbo = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER,
                vbo);
        glBufferData(GL_ARRAY_BUFFER,
                Utils.listoFloat(vertices),
                GL_STATIC_DRAW);

        vboColor = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vboColor);
        glBufferData(GL_ARRAY_BUFFER,
                Utils.listoFloat(verticesColor),
                GL_STATIC_DRAW);
    }

    public void drawSetup() {
        bind();
        uniformsMap.setUniform("uni_color", color);
        uniformsMap.setUniform("model", model);
        //dari vert ke frag lalu vert ke layar
        glEnableVertexAttribArray(0);
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glVertexAttribPointer(0, 3, GL_FLOAT, false, 0 ,0 );
    }

    public void drawSetupVerticesColor() {
        bind();
        //dari vert ke frag lalu vert ke layar
        glEnableVertexAttribArray(0);
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glVertexAttribPointer(0, 3, GL_FLOAT, false, 0 ,0 );

        bind();
        //dari vert ke frag lalu vert ke layar
        glEnableVertexAttribArray(1);
        glBindBuffer(GL_ARRAY_BUFFER, vboColor);
        glVertexAttribPointer(1, 3, GL_FLOAT, false, 0 ,0 );
    }

    public void draw() {
        drawSetup();
        glLineWidth(10);
        glPointSize(10);
        glDrawArrays(GL_POLYGON, 0, vertices.size());
    }

    public void drawLine() {
        drawSetup();
        glLineWidth(1);
        glPointSize(0);
        glDrawArrays(GL_LINE_STRIP, 0, vertices.size());
    }

    public void addVertices(Vector3f newVector) {
        vertices.add(newVector);
        setVAOVBO();
    }

    public void translateObject(Float offsetX, Float offsetY, Float offsetZ) {
        model = new Matrix4f().translate(offsetX, offsetY, offsetZ).mul(new Matrix4f(model));
    }

    public void rotateObject(Float degree, Float x, Float y, Float z) {
        model = new Matrix4f().rotate(degree, x, y, z).mul(new Matrix4f(model));
    }

    public void scaleObject(Float scaleX, Float scaleY, Float scaleZ) {
        model = new Matrix4f().scale(scaleX, scaleY, scaleZ).mul(new Matrix4f(model));
    }
}
