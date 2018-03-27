package ba.unsa.etf.nwtcinemamovies.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONConverter {

	protected static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	public static String toJSON(Object source) {
		try {
			return OBJECT_MAPPER.writeValueAsString(source);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
