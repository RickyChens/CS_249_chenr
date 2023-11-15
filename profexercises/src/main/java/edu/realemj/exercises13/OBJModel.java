package edu.realemj.exercises13;

import java.util.*;
import java.io.*;
import edu.realemj.exercises09.Matrix;

public class OBJModel {
    private ArrayList<Matrix> vertices = new ArrayList<>();
    private ArrayList<Face> faces = new ArrayList<>();

    private String getVertString(Matrix v) {
        return "v " + v.get(0,0) +
                " " + v.get(1, 0) +
                " " + v.get(2, 0);
    }

    public void save(String filename) throws IOException {
        try (
                PrintWriter output = new PrintWriter(filename);
                ) {
            for(Matrix v: vertices) {
                output.println(getVertString(v));
            }
            for(Face f: faces) {
                output.println(f);
            }
        }
    }

    public void load(String filename) throws IOException {
        try (
                Scanner fileInput = new Scanner(new File(filename));
                ) {
            while(fileInput.hasNextLine()) {
                String line = fileInput.nextLine();
                line = line.trim();
                if(!line.isEmpty()) {
                    Scanner parseLine = new Scanner(line);
                    String token = parseLine.next();
                    if(token.equals("v")) {
                        // Vertex
                        double x = parseLine.nextDouble();
                        double y = parseLine.nextDouble();
                        double z = parseLine.nextDouble();
                        Matrix v = Matrix.makePoint3D(x,y,z);
                        vertices.add(v);
                    }
                    else if(token.equals("f")) {
                        // Face
                        int i0 = parseLine.nextInt();
                        int i1 = parseLine.nextInt();
                        int i2 = parseLine.nextInt();
                        Face f = new Face(i0,i1,i2);
                        faces.add(f);
                    }
                }
            }
        }
    }

    public void transform(Matrix t) {
        for(Matrix v: vertices) {
            v.copyFrom(t.multiply(v));
        }
    }

    public static void main(String [] args) {
        OBJModel model = new OBJModel();
        try {
            model.load("bunny.obj");
            Matrix s = Matrix.makeScaling3D(1,2,1);
            Matrix r = Matrix.makeZRotation3D(45);
            Matrix t = r.multiply(s);
            model.transform(t);
            model.save("bunnyTransformed.obj");
        }
        catch(Exception e) {
            System.err.println(e);
        }
    }
}
