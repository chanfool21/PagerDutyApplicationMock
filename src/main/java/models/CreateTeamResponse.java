package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CreateTeamResponse {
    @JsonProperty("team_id")
    String teamId;

    @JsonProperty("message")
    String message;

}
