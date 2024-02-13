package Service;

import Models.Game;
import android.content.res.Resources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GameService {
    public Game getGamesFromRequest(String requestString){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(requestString, Game.class);
        } catch (JsonProcessingException e) {
            throw new Resources.NotFoundException();
        }

    }

}
