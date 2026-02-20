package Element;

	public enum TicketColumn {
	    DEPART_STATION(1),
	    ARRIVE_STATION(2),
	    SEAT_TYPE(3),
	    DEPART_DATE(4),
	    BOOKING_DATE(5),
	    EXPIRE_DATE(6),
	    AMOUNT(7),
	    TOTAL_PRICE(8);

	    private final int index;
	    TicketColumn(int index) { this.index = index; }
	    public int getIndex() { return index; }
	}
	
