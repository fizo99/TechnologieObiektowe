public class Vector3DDecorator implements IVector{
    private IVector srcVector;
    private double z;

    public double abs() {
        return 0;
    }

    public double cdot(IVector param) {
        return 0;
    }

    public double[] getComponents() {
        return new double[0];
    }

    public Vector3DDecorator cross(IVector param){
        return null;
    }
    public IVector getSrcV() {
        return null;
    }
}
