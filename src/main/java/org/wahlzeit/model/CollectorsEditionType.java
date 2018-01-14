package org.wahlzeit.model;

public class CollectorsEditionType {

	/**
	 * As attributes the Collectors Edition Type has references to the most common items included in Collectors Editions
	 */
	private String game_name;
	private int price_in_euro;
	private boolean has_map;
	private boolean has_soundtrack;
	private boolean has_figure;
	
	/**
	 * Default constructor 
	 */
	private CollectorsEditionType() {
		this.game_name = "";
		this.price_in_euro = 0;
		this.has_map = false;
		this.has_soundtrack = false;
		this.has_figure = false;
	}
	/**
	 * Constructor with all parameters
	 * @param name
	 * @param price
	 * @param map
	 * @param soundtrack
	 * @param figure
	 */
	private CollectorsEditionType(String name, int price, boolean map, boolean soundtrack, boolean figure) {
		this.game_name = name;
		this.price_in_euro = price;
		this.has_map = map;
		this.has_soundtrack = soundtrack;
		this.has_figure = figure;
	}
	/**
	 * Factory method for CollectorsEditionType with default values
	 * @return new CEType
	 */
	public static CollectorsEditionType getCollectorsEditionType()
	{
		CollectorsEditionType CEType = new CollectorsEditionType();
		return CEType;
	}
	/**
	 * Factory method for CollectorsEditionType with custom values 
	 * @param name
	 * @param price
	 * @param map
	 * @param soundtrack
	 * @param figure
	 * @return new CEType
	 */
	public static CollectorsEditionType getCollectorsEditionType(String name, int price, boolean map, boolean soundtrack, boolean figure) {
		if(price <= 0) {
			throw new IllegalArgumentException("The price can't be 0 or negative!");
		}
		CollectorsEditionType CEType = new CollectorsEditionType(name, price, map, soundtrack, figure);
		return CEType;
	}
	
	public CollectorsEdition cerateInstance() {
		return new CollectorsEdition(this);
	}
	
	/**
	 * A block of getter and setter methods, created by Eclipse for every private attribute
	 */
	public String getGame_name() {
		return game_name;
	}
	public void setGame_name(String game_name) {
		this.game_name = game_name;
	}
	
	public int getPrice_in_euro() {
		return price_in_euro;
	}
	public void setPrice_in_euro(int price_in_euro) {
		this.price_in_euro = price_in_euro;
	}
	
	public boolean isHas_map() {
		return has_map;
	}
	public void setHas_map(boolean has_map) {
		this.has_map = has_map;
	}
	
	public boolean isHas_soundtrack() {
		return has_soundtrack;
	}
	public void setHas_soundtrack(boolean has_soundtrack) {
		this.has_soundtrack = has_soundtrack;
	}
	
	public boolean isHas_figure() {
		return has_figure;
	}
	public void setHas_figure(boolean has_figure) {
		this.has_figure = has_figure;
	}
	
}
