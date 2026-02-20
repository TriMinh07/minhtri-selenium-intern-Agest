package Element;

public enum TicketDepart {
    
    SAIGON("1", "Sài Gòn"),
    PHANTHIET("2", "Phan Thiết"),
    NHATRANG("3", "Nha Trang"),
    DANANG("4", "Đà Nẵng"),
    HUE("5", "Huế"),
    QUANGNGAI("6", "Quãng Ngãi");
    
    private final String value;
	private final String name;
    
    TicketDepart(String value, String name) {
        this.value = value;
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public String getValue() {
        return value;
    }
}