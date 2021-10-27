public class Polar2DAdapter implements IPolar2D, IVector{
    private Vector2D srcVector;

    public double getAngle() {
//        #TODO
//        Z użyciem funkcji cyklometrycznych
//        zwrócić kąt między osią OX, a wektorem
//                IVector
        return 0.0f;
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
