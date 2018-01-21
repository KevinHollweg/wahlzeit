package org.wahlzeit.model;

import java.util.HashSet;
import java.util.Set;


public class CollectorsEditionManager {
	protected static Set<CollectorsEditionType> CETypes = new HashSet<CollectorsEditionType>();
	protected static Set<CollectorsEdition> ColEds = new HashSet<CollectorsEdition>();

	public static CollectorsEdition createCollectorsEdition() {
		CollectorsEditionType CEType = CollectorsEditionType.getCollectorsEditionType();
		if(!CETypes.contains(CEType)) {
			CETypes.add(CEType);
		} else {
			for(CollectorsEditionType type : CETypes) {
				if(type == CEType) {
					CEType = type;
					break;
				}
			}
		}
		CollectorsEdition result = CEType.cerateInstance();
		if(!ColEds.contains(result)) {
			ColEds.add(result);
		} else {
			for(CollectorsEdition ColEd : ColEds) {
				if(ColEd == result) {
					result = ColEd;
					break;
				}
			}
		}
		return result;
	}
	
	public static CollectorsEdition createCollectorsEdition(String name, int price, boolean map, boolean soundtrack, boolean figure) {
		CollectorsEditionType CEType = CollectorsEditionType.getCollectorsEditionType(name, price, map, soundtrack, figure);
		if(!CETypes.contains(CEType)) {
			CETypes.add(CEType);
		} else {
			for(CollectorsEditionType type : CETypes) {
				if(type == CEType) {
					CEType = type;
					break;
				}
			}
		}
		CollectorsEdition result = CEType.cerateInstance();
		if(!ColEds.contains(result)) {
			ColEds.add(result);
		} else {
			for(CollectorsEdition ColEd : ColEds) {
				if(ColEd == result) {
					result = ColEd;
					break;
				}
			}
		}
		return result;
	}
}
