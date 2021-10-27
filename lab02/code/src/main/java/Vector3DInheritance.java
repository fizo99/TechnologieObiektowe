public class Vector3DInheritance extends Vector2D {
    private double z;

    public Vector3DInheritance(double x, double y) {
        super(x, y);
        this.z = 0.0f;
    }

    public Vector3DInheritance(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    @Override
    public double abs() {
        var components = getComponents();
        var x = components[0];
        var y = components[1];
        return Math.sqrt(x * x + y * y + z * z);
    }

    @Override
    public double cdot(IVector param) {
        var thisComponents = getComponents();
        var thisX = thisComponents[0];
        var thisY = thisComponents[1];

        var otherComponents = param.getComponents();
        if (otherComponents.length != 3) {
            throw new IllegalArgumentException("Vectors have different size");
        }
        var otherX = otherComponents[0];
        var otherY = otherComponents[1];
        var otherZ = otherComponents[2];

        return thisX * otherX + thisY * otherY + this.z * otherZ;
    }

    @Override
    public double[] getComponents() {
        var components = super.getComponents();
        var x = components[0];
        var y = components[1];
        return new double[]{x, y, z};
    }

    public Vector3DInheritance cross(IVector param) {
        var thisComponents = getComponents();
        var thisX = thisComponents[0];
        var thisY = thisComponents[1];

        var otherComponents = param.getComponents();
        var otherX = thisComponents[0];
        var otherY = thisComponents[1];
        var otherZ = otherComponents.length == 3 ? thisComponents[2] : 0.0f;

        var resultX = thisY * otherZ - this.z * otherY;
        var resultY = this.z * otherX - thisX * otherZ;
        var resultZ = thisX * otherY - thisY * otherX;
        return new Vector3DInheritance(resultX, resultY, resultZ);
    }

    public IVector getSrcV() {
        var components = getComponents();
        var x = components[0];
        var y = components[1];
        return new Vector3DInheritance(x, y, this.z);
    }
}
