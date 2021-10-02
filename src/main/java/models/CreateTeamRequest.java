package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateTeamRequest {
    @JsonProperty("team")
    Team team;
    @JsonProperty("developers")
    List<Developer>developerList;
}
