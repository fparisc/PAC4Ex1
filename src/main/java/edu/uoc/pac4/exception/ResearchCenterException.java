package edu.uoc.pac4.exception;

public class ResearchCenterException extends AppException {
    public static final String ERROR_NAME = "Name cannot be null or blank.";
    public static final String ERROR_CITY = "City cannot be null.";
    public static final String ERROR_ADDRESS = "Address cannot be null.";
    public static final String ERROR_PHONE = "Phone number cannot be null and it must contain a valid format";
    public static final String ERROR_EMAIL = "Email cannot be null and it must contain a valid format";

    public ResearchCenterException(String message) {
        super(message);
    }
}
