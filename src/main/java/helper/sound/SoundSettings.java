package helper.sound;

import helper.file.JSONOperations;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class SoundSettings {
    private boolean sound;
    private boolean music;

    public SoundSettings(JSONOperations jsonOperations) {

        String soundSettings = jsonOperations.loadSoundSettings();

        JSONObject jsonObject;

        Object obj;
        try {

            obj = new JSONParser().parse(soundSettings);

            jsonObject = (JSONObject)obj;

            music = (boolean)jsonObject.get("music");
            sound = (boolean)jsonObject.get("sound");

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public boolean isSoundOn() {
        return sound;
    }

    public boolean isMusicOn() {
        return music;
    }
}
