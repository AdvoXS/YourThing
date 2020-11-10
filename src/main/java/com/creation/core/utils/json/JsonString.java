package com.creation.core.utils.json;

public class JsonString {

    private final String jsonString;

    private JsonString(Builder builder) {
        jsonString = builder.jsonStr.toString();
    }

    public static Builder create() {

        return new Builder();
    }

    public String getJson() {
        return jsonString;
    }

    public static class Builder {
        StringBuilder jsonStr;

        public Builder() {
            jsonStr = new StringBuilder();
        }

        private void addN() {
            jsonStr.append("\n");
        }

        public Builder startBlock() {
            jsonStr.append("{");
            return this;
        }

        public Builder setParam(String param) {
            jsonStr.append("\"").append(param).append("\":");
            return this;
        }

        public Builder setInfo(String info) {
            jsonStr.append("\"").append(info).append("\",");
            return this;
        }

        public Builder setInfo(String info, boolean isLast) {
            if (isLast) jsonStr.append("\"").append(info);
            else jsonStr.append("\"").append(info).append("\",");
            return this;
        }

        public Builder endBlock() {
            jsonStr.append("}");
            return this;
        }

        public JsonString build() {
            return new JsonString(this);
        }

    }
}
