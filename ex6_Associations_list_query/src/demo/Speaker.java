package demo;

public class Speaker {

    private Long id;
    private String firstName;
    private String lastName;
    private Event event;

    public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Speaker() {
    }

    public Speaker(Event e, String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
        setEvent(e);
       
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
