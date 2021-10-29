public class Polar2DAdapter implements IPolar2D, IVector{
    private Vector2D srcVector;

    public Polar2DAdapter(Vector2D srcVector) {
        this.srcVector = srcVector;
    }

    public double getAngle() {
//        #TODO
//        Z użyciem funkcji cyklometrycznych
//        zwrócić kąt między osią OX, a wektorem
//                IVector
        var unitVector = new Vector2D(1.0f,0.0f);
        var moduleV1 = srcVector.abs();
        var moduleV2 = unitVector.abs();
        var cosTheta = cdot(unitVector) / (moduleV1 * moduleV2);
        return 90.0f-cosTheta*180.0f/Math.PI;
    }

    public double abs() {
        return this.srcVector.abs();
    }

    public double cdot(IVector param) {
        return this.srcVector.cdot(param);
    }

    public double[] getComponents() {
        return this.srcVector.getComponents();
    }
}
