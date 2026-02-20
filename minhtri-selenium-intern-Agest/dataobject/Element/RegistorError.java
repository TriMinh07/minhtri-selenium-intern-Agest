package Element;

public enum RegistorError {
	
	REGISTER_EMAIL_ERROR("email"),
	REGISTER_PASSWORD_ERROR("password"),
	REGISTER_CONFIRM_PASSWORD_ERROR("confirmPassword"),
	REGISTER_PID_ERROR("pid");
	
	private final String value;

	RegistorError (String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
