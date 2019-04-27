package com.example.lib;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;

/**
 * our class to analyze data from json.
 */
public final class RecognizePhoto {
    /**
     * getter of caption.
     * @param json the input.
     * @return the caption.
     */
    public static String getCaption(final String json) {
        if (json == null) {
            return null;
        }
        JsonParser parser = new JsonParser();
        JsonObject rootObj = parser.parse(json).getAsJsonObject();
        JsonObject result = rootObj.getAsJsonObject("description").getAsJsonArray("captions").get(0).getAsJsonObject();
        String caption = result.get("text").getAsString();
        return caption;
    }

    /**
     * getter of format.
     * @param json input.
     * @return format.
     */
    public static String getFormat(final String json) {
        if (json == null) {
            return null;
        }
        JsonParser parser = new JsonParser();
        JsonObject rootObj = parser.parse(json).getAsJsonObject();
        JsonPrimitive result = rootObj.getAsJsonObject("metadata").getAsJsonPrimitive("format");
        String format = result.getAsString();
        return format;
    }

    /**
     * getter of height.
     * @param json input.
     * @return height.
     */
    public static int getHeight(final String json) {
        if (json == null) {
            return 0;
        }
        JsonParser parser = new JsonParser();
        JsonObject rootObj = parser.parse(json).getAsJsonObject();
        JsonPrimitive result = rootObj.getAsJsonObject("metadata").getAsJsonPrimitive("height");
        int height = result.getAsInt();
        return height;
    }

    /**
     * getter of width.
     * @param json input.
     * @return width.
     */
    public static int getWidth(final String json) {
        if (json == null) {
            return 0;
        }
        JsonParser parser = new JsonParser();
        JsonObject rootObj = parser.parse(json).getAsJsonObject();
        JsonPrimitive result = rootObj.getAsJsonObject("metadata").getAsJsonPrimitive("width");
        int width = result.getAsInt();
        return width;
    }

    /**
     * judging if we have dog.
     * @param json input.
     * @param minConfidence confident area.
     * @return if we have dog.
     */
    public static boolean isADog(final String json, final double minConfidence) {
        if (json == null) {
            return false;
        }
        JsonParser parser = new JsonParser();
        JsonObject rootObj = parser.parse(json).getAsJsonObject();
        JsonArray tags = rootObj.getAsJsonArray("tags");
        for (int i = 0; i < tags.size(); i++) {
            String ifDog = tags.get(i).getAsJsonObject().get("name").getAsString();
            double ifCre = tags.get(i).getAsJsonObject().get("confidence").getAsDouble();
            if (ifDog.equals("dog")) {
                if (ifCre >= minConfidence) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * if we have cat.
     * @param json input.
     * @param minConfidence confident area.
     * @return if we havecat.
     */
    public static boolean isACat(final String json, final double minConfidence) {
        if (json == null) {
            return false;
        }
        JsonParser parser = new JsonParser();
        JsonObject rootObj = parser.parse(json).getAsJsonObject();
        JsonArray tags = rootObj.getAsJsonArray("tags");
        for (int i = 0; i < tags.size(); i++) {
            String ifDog = tags.get(i).getAsJsonObject().get("name").getAsString();
            double ifCre = tags.get(i).getAsJsonObject().get("confidence").getAsDouble();
            if (ifDog.equals("cat")) {
                if (ifCre >= minConfidence) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * if we have rick or not.
     * @param json input.
     * @return if we have rick.
     */
    public static boolean isRick(final String json) {
        if (json == null) {
            return false;
        }
        String[] caption = getCaption(json).split(" ");
        for (int i = 0; i < caption.length; i++) {
            if (caption[i].equals("Rick")) {
                return true;
            }
        }
        return false;
    }
}
