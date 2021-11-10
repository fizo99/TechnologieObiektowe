public class Polar2DInheritance extends Vector2D {
    public Polar2DInheritance(double x, double y) {
        super(x, y);
    }

    public double getAngle() {
        var unitVector = new Vector2D(1.0f, 0.0f);
        var moduleV1 = abs();
        var moduleV2 = unitVector.abs();

        var cosTheta = cdot(unitVector) / (moduleV1 * moduleV2);
        var sinTheta = Math.sqrt(cosTheta * cosTheta - 1.0);

        var angleRadian = (sinTheta > 0) ? -Math.acos(cosTheta) : Math.acos(cosTheta);

        return angleRadian * 180 / Math.PI;
    }

    @Override
    public String toString(){
        var components = getComponents();
        return String.format("%-25s | Cartesian: [%s,%s] Polar: r=%s,theta=%s", "2D Polar Inheritance", components[0], components[1], abs(), getAngle());
    }
}
