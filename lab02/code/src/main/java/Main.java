public class Main {
    private final static double X_2D = 0.0;
    private final static double Y_2D = 1.0;

    private final static double X_3D = 11.0;
    private final static double Y_3D = 2.0;
    private final static double Z_3D = 3.0;

    public static void main(String[] args) {
        var basic2DVector = new Vector2D(X_2D, Y_2D);
        var polar2DVectorWithAdapter = new Polar2DAdapter(new Vector2D(X_2D, Y_2D));
        var polar2DVectorWithInheritance = new Polar2DInheritance(X_2D, Y_2D);
        show2D(basic2DVector, polar2DVectorWithAdapter, polar2DVectorWithInheritance);

        var vector3DWithDecorator = new Vector3DDecorator(new Vector2D(X_3D, Y_3D), Z_3D);
        var vector3DWithInheritance = new Vector3DInheritance(X_3D,Y_3D, Z_3D);
        show3D(vector3DWithDecorator, vector3DWithInheritance);
    }

    private static void show2D(Vector2D vector2D, Polar2DAdapter adapter2D, Polar2DInheritance inheritance2D) {
        System.out.println("------------------------------- 2D -------------------------------");
        System.out.println("A: " + vector2D);
        System.out.println("B: " + adapter2D);
        System.out.println("C: " + inheritance2D);

        System.out.println("---------- Dot Product");
        System.out.println(String.format("A dot B = %s", vector2D.cdot(adapter2D)));
        System.out.println(String.format("A dot C = %s", vector2D.cdot(inheritance2D)));
        System.out.println(String.format("B dot A = %s", adapter2D.cdot(vector2D)));
        System.out.println(String.format("B dot C = %s", adapter2D.cdot(inheritance2D)));
        System.out.println(String.format("C dot A = %s", inheritance2D.cdot(vector2D)));
        System.out.println(String.format("C dot B = %s", inheritance2D.cdot(adapter2D)));
    }

    private static void show3D(Vector3DDecorator vector3DDecorator,Vector3DInheritance vector3DInheritance) {
        System.out.println("------------------------------- 3D -------------------------------");
        System.out.println("D: " + vector3DDecorator);
        System.out.println("E: " + vector3DInheritance);

        System.out.println("---------- Dot Product");
        System.out.println(String.format("D dot E = %s", vector3DDecorator.cdot(vector3DInheritance)));
        System.out.println(String.format("E dot D = %s", vector3DInheritance.cdot(vector3DDecorator)));
        System.out.println("---------- Cross Product");
        System.out.println(String.format("D cross E = %s", vector3DDecorator.cross(vector3DInheritance)));
        System.out.println(String.format("E cross D = %s", vector3DInheritance.cross(vector3DDecorator)));
    }
}
