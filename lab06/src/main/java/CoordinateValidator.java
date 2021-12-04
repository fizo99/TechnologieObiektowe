public class CoordinateValidator implements Validator<String> {
    private final String COORDINATE_REGEX = "^(?:0|[1-9][0-9]*)\\.[0-9]+$";
    @Override
    public boolean isValid(String value) {
        return value.matches(COORDINATE_REGEX);
    }
}
