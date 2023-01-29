package core;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;

public class ReadJsonData {

    JSONParser jsonParser = new JSONParser();
    FileReader fileReader;
    Object object;
    JSONObject jsonObject;

    public ReadJsonData(String jsonData) {
        try {
            this.fileReader = new FileReader(jsonData);
            this.object = jsonParser.parse(fileReader);
            this.jsonObject = (JSONObject) object;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public JSONObject getJsonObject() {
        return jsonObject;
    }
}
