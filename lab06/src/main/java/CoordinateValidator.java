public class CoordinateValidator implements Validator<String> {
    @Override
    public boolean isValid(String value) {
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
