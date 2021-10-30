public class Polar2DAdapter implements IPolar2D, IVector {
    private Vector2D srcVector;
    private double angle;

    public Polar2DAdapter(Vector2D srcVector) {
        this.srcVector = srcVector;
        this.angle = calculateAngle();
    }

    private double calculateAngle() {
        var unitVector = new Vector2D(1.0f, 0.0f);
        var moduleV1 = srcVector.abs();
        var moduleV2 = unitVector.abs();

        var cosTheta = cdot(unitVector) / (moduleV1 * moduleV2);
        var sinTheta = Math.sqrt(cosTheta * cosTheta - 1.0);

        var angleRadian = (sinTheta > 0) ? -Math.acos(cosTheta) : Math.acos(cosTheta);
        var angleDegrees = angleRadian * 180 / Math.PI;

        return angleDegrees;
    }

    public double getAngle() {
        return angle;
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

    @Override
    public String toString() {
        var components = getComponents();
        return String.format("%-25s | Cartesian: [%s,%s] Polar: r=%s,theta=%s", "2D Polar Adapter", components[0], components[1], abs(), getAngle());
    }
}
