package edu.bku.karaoke;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jackson.JsonLoader;

public class Utils {
    /** The Constant logger. */
    private final static Logger logger = LoggerFactory.getLogger(Utils.class);

    /** The Constant mapper. */
    private static final ObjectMapper mapper = new ObjectMapper();

    /**
     * Gets the object from json.
     *
     * @param json the json
     * @param T the t
     * @return the object from json
     */
    public static Object getObjectFromJson(String json, Class<?> T) {
        logger.debug("IN - getObjectFromJson()");
        if (json == null) {
            return null;
        }
        Object object = null;
        try {
            object = mapper.readValue(json, T);
        } catch (Exception e) {
            logger.error("Exception: ", e);
        }
        logger.debug("OUT - getObjectFromJson()");
        return object;
    }
    
    /**
     * Gets the json node.
     *
     * @param jsonText the json text
     * @return the json node
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static JsonNode getJsonNode(String jsonText) 
    throws IOException
    {
        return JsonLoader.fromString(jsonText);
    } // getJsonNode(text) ends
}
