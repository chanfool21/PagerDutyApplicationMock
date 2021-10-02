package constants;

public enum ErrorMessages {
    ID_ALREADY_EXISTS("Id already exists"), TEAM_DOES_NOT_EXIST("Team does not exist");

    private String message;

    public String getMessage() {
        return message;
    }

    private ErrorMessages(String message) {
        this.message = message;
    }
}
