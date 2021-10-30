public class Vector3DDecorator implements IVector {
    private IVector srcVector;
    private double z;

    public Vector3DDecorator(IVector srcVector, double z) {
        this.srcVector = srcVector;
        this.z = z;
    }

    public double abs() {
        var components = getComponents();
        var x = components[0];
        var y = components[1];
        return Math.sqrt(x * x + y * y + z * z);
    }

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

    public double[] getComponents() {
        var components = srcVector.getComponents();
        return new double[]{components[0], components[1], z};
    }

    public Vector3DDecorator cross(IVector param) {
        var thisComponents = srcVector.getComponents();
        var thisX = thisComponents[0];
        var thisY = thisComponents[1];

        var otherComponents = param.getComponents();
        var otherX = otherComponents[0];
        var otherY = otherComponents[1];
        var otherZ = otherComponents.length == 3 ? otherComponents[2] : 0.0f;

        var resultX = thisY * otherZ - this.z * otherY;
        var resultY = this.z * otherX - thisX * otherZ;
        var resultZ = thisX * otherY - thisY * otherX;
        return new Vector3DDecorator(new Vector2D(resultX, resultY), resultZ);
    }

    public IVector getSrcV() {
        return srcVector;
    }

    @Override
    public String toString() {
        var components = getComponents();
        return String.format("%-25s | Cartesian: [%s,%s,%s]", "3D Vector Decorator", components[0], components[1], components[2]);
    }
}
