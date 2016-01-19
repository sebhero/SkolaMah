package DA339A_programmering1.Patterns.skola.lab24;

/**
 * Klassen Commodity representerar en vara i en butik.
 * @version 1.0
 * @author Sebastian Börebäck
 */
public class Commodity {
    private String name;
    private String category;
    private int quantity;
    private double price;

    /**
     * Konstruerar och initialiserar en vara med name="", category="",
     * quantity=0 och price=0.0.
     */
    public Commodity() {
    	this.name = "";
    	this.category = "";
    }

    /**
     * Construcor takes starting params
     * @param name the name of the commodity
     * @param category the type of commodity
     * @param quantity the amount in the storage
     * @param price the price for the commodity
     */
    public Commodity(String name, String category, int quantity, double price) {
		this.name = name;
		this.category = category;
		this.quantity = quantity;
		this.price = price;
	}

    /**
     * Returns the name of the commodity
     * @return commodity name
     */
	public String getName() {
		return this.name;
	}

    /**
     * Sets the name of the commodity
     * @param name name of the commidity
     */
	public void setName(String name) {
		this.name = name;
	}

    /**
     * Get the category of the commodity
     * @return the category
     */
	public String getCategory() {
		return this.category;
	}

    /**
     * Sets the category for the commodity
     * @param category the category name
     */
	public void setCategory(String category) {
		this.category = category;
	}

    /**
     * get the price for the commodity
     * @return the price
     */
	public double getPrice() {
		return this.price;
	}

    /**
     * Set the price for the commodity
     * @param price the new price
     */
	public void setPrice(double price) {
		this.price = price;
	}

    /**
     * Change the amount in storage. positive value increases the quantity (buy in)
     * and negative value decreases the quantity (sales)
     * @param change the change of quantity
     * @return quantity in storage
     */
	public int changeQuantity(int change) {
		quantity += change;
		return this.quantity;
	}

    /**
     * Prints info about the commodity
     */
	public void info() {
        System.out.println(this.name + ", " + this.category + "\n" +
                           "Antal i lager: " + this.quantity + "\n" +
                           "Pris: " + this.price + " kr");
    }
}
