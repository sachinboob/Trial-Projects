package com.trials.json;

import java.io.StringReader;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

public class JsonPathReverserEngineering {

	public static void main(String[] args) throws Exception {

		String jsonStr = "{\"book\":[{\"category\":\"reference\",\"author\":\"Nigel Rees\",\"title\":\"Sayings of the Century\",\"price\":\"8.95\"},{\"category\":\"fiction\",\"author\":\"Evelyn Waugh\",\"title\":\"Sword of Honour\",\"price\":\"12.99\"},{\"category\":\"fiction\",\"author\":\"Herman Melville\",\"title\":\"Moby Dick\",\"isbn\":\"0-553-21311-3\",\"price\":\"8.99\"},{\"category\":\"fiction\",\"author\":\"J. R. R. Tolkien\",\"title\":\"The Lord of the Rings\",\"isbn\":\"0-395-19395-8\",\"price\":\"22.99\"}],\"bicycle\":{\"color\":\"red\",\"price\":\"19.95\"}}";
		String json = "{\"store\":{\"book\":{\"category\":\"reference\",\"author\":\"Nigel Rees\",\"title\":\"Sayings of the Century\",\"price\":8.95},\"bicycle\":{\"color\":\"red\",\"price\":19.95}}}";

		JsonReader jsonReader = new JsonReader(new StringReader(json));

		while (jsonReader.hasNext()) {
			JsonToken nextToken = jsonReader.peek();

			System.out.println(jsonReader.toString());

			System.out.println(nextToken);

			if (JsonToken.BEGIN_OBJECT.equals(nextToken)) {

				jsonReader.beginObject();

			} else if (JsonToken.BEGIN_ARRAY.equals(nextToken)) {

				jsonReader.beginArray();

			} else if (JsonToken.END_ARRAY.equals(nextToken)) {

				System.out.println("End array");

			} else if (JsonToken.END_OBJECT.equals(nextToken)) {

				System.out.println("End object");

			} else if (JsonToken.NAME.equals(nextToken)) {

				String name = jsonReader.nextName();
				System.out.println("JsonPath :- " + jsonReader.getPath());
				System.out.println(name);

			} else if (JsonToken.STRING.equals(nextToken)) {

				String value = jsonReader.nextString();
				System.out.println(value);

			} else if (JsonToken.NULL.equals(nextToken)) {
				jsonReader.nextNull();
			} else if (JsonToken.NUMBER.equals(nextToken)) {

				double value = jsonReader.nextDouble();
				System.out.println(value);
			} else {
				System.out.println("********");
			}
		}
	}
}
