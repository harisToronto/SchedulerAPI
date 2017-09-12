package ca.toronto.commoncomponents.json;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

public class RuntimeDeserializer extends JsonDeserializer<List<String>> {

	@SuppressWarnings("unchecked")
	@Override
	public List<String> deserialize(JsonParser parser, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
			ObjectCodec codec = parser.getCodec();
		    JsonNode node = codec.readTree(parser);
//		if (parser.getCurrentToken() == JsonToken.START_OBJECT) {
////			while (parser.nextToken() != JsonToken.END_ARRAY) {
//			System.out.println(parser.getCurrentToken().asString());
////			System.out.println(parser.getCodec().readTree(parser).toString());
////			System.out.println(parser.getCurrentToken().values().length);
//				retval.add(parser.getCodec().readTree(parser).toString());
////			}
		//}
		    System.out.println(node.elements().next().asText());
		  return codec.treeToValue(node, List.class);

	}

}
