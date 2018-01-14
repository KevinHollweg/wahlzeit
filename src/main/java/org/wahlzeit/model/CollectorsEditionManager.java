package org.wahlzeit.model;

public class CollectorsEditionManager {

	public static CollectorsEdition createCollectorsEdition() {
		CollectorsEditionType CEType = CollectorsEditionType.getCollectorsEditionType();
		CollectorsEdition result = CEType.cerateInstance();
		return result;
	}
	
	public static CollectorsEdition createCollectorsEdition(String name, int price, boolean map, boolean soundtrack, boolean figure) {
		CollectorsEditionType CEType = CollectorsEditionType.getCollectorsEditionType(name, price, map, soundtrack, figure);
		CollectorsEdition result = CEType.cerateInstance();
		return result;
	}
}
