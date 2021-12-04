public class FullNameValidator implements Validator<String> {
    private final String fullNameRegex = "^[a-zA-Z ]*$";
    @Override
    public boolean isValid(String value) {
        return value.matches(fullNameRegex);
    }
}
