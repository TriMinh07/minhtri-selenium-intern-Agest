package Element;

public enum TicketSeatType {
	HARD_SEAT ("1", "Hard seat", "HS"),
	SOFT_SEAT ("2", "Soft seat", "SS"),
	SOFT_SEAT_AIR("3", "Soft seat with air conditioner", "SSC"),
	HARD_BED("4", "Hard bed", "HB"),
	SOFT_BED("5", "Soft bed", "SB"),
	SOFT_BED_AIR("6", "Soft bed with air conditioner", "SBC");
	
	private final String value;
	private final String name;
	private final String miniName;
    
    TicketSeatType(String value, String name, String minName) {
        this.value = value;
        this.name = name;
        this.miniName = minName;
    }
    
    public String getName() {
        return name;
    }
    
    public String getValue() {
        return value;
    }
	
    public String getMiniName() {
		return miniName;
	}

}
