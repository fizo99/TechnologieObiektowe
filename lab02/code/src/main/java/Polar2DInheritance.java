public class Polar2DInheritance extends Vector2D {
    public Polar2DInheritance(double x, double y) {
        super(x, y);
    }

    public double getAngle() {
        var components = getComponents();
        //#TODO
        //Z użyciem funkcji cyklometrycznych
        //zwrócić kąt między osią OX, a wektorem
        //        IVector
        var unitVector = new Vector2D(1.0f,0.0f);
        var moduleV1 = abs();
        var moduleV2 = unitVector.abs();
        var cosTheta = cdot(unitVector) / (moduleV1 * moduleV2);
        return 90.0f-cosTheta*180.0f/Math.PI;
    }
}
