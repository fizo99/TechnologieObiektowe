import lombok.Getter;

public class Proxy {
    private final Validator<String> fullNameValidator = new FullNameValidator();
    private final Validator<String> coordinateValidator = new CoordinateValidator();

    @Getter
    private final FlyweightFactory factory;

    Proxy(FlyweightFactory factory) {
        this.factory = factory;
    }

    public Coordinates getCoordinatesFor(String fullName) throws IllegalArgumentException {
        if(!fullNameValidator.isValid(fullName))
            throw new IllegalArgumentException(fullName + " is invalid full name");

        String reformattedName = reformatName(fullName);
        if(!factory.contains(reformattedName))
            throw new IllegalArgumentException(fullName + " is absent");

        return factory.get(reformattedName).getCoords();
    }

    public void insertNewPerson(String fullName, String x, String y) throws IllegalArgumentException {
        if(!fullNameValidator.isValid(fullName))
            throw new IllegalArgumentException(fullName + " is invalid full name");
        String reformattedName = reformatName(fullName);
        if(factory.contains(reformattedName))
            throw new IllegalArgumentException(fullName + " is already present");

        if(!coordinateValidator.isValid(x))
            throw new IllegalArgumentException(x + " is invalid coordinate");
        if(!coordinateValidator.isValid(y))
            throw new IllegalArgumentException(y + " is invalid coordinate");


        Coordinates coords = new Coordinates(Double.parseDouble(x), Double.parseDouble(y));
        Flyweight newPerson = factory.get(reformattedName);
        newPerson.setCoords(coords);
    }

    private String reformatName(String fullname) {
        String newName = fullname.toLowerCase();
        String[] parts = newName.split(" ");
        StringBuilder reformattedName = new StringBuilder();
        for(String part: parts){
            reformattedName
                    .append(part.substring(0, 1).toUpperCase())
                    .append(part.substring(1))
                    .append(" ");
        }
        return reformattedName.deleteCharAt(reformattedName.length() - 1).toString();
    }

}
