public class VipCustomer {
	private String name;
	private double limit;
	private String emailAddress;

	public String getName () {
		return name;
	}

	public double getLimit () {
		return limit;
	}

	public VipCustomer ( String name, double limit ) {
		this(name, limit, "default@email.com");
	}

	public String getEmailAddress () {
		return emailAddress;
	}

	public VipCustomer () {
		this("Default name", 50_000.00, "default@email.com");
	}

	public VipCustomer ( String name, double limit, String emailAddress ) {
		this.name = name;
		this.limit = limit;
		this.emailAddress = emailAddress;
	}
}
