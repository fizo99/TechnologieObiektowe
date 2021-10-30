public class Vector2D implements IVector {
    private double x;
    private double y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double abs() {
        return Math.sqrt(x * x + y * y);
    }

    public double cdot(IVector param) {
        var components = param.getComponents();
        var x = components[0];
        var y = components[1];
        return this.x * x + this.y * y;
    }

    public double[] getComponents() {
        return new double[]{x,y};
    }

    @Override
    public String toString(){
        var components = getComponents();
        return String.format("%-25s | Cartesian: [%s,%s]","2D Vector", components[0],components[1]);
    }
}
