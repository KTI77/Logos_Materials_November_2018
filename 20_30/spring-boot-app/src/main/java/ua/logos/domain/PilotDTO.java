package ua.logos.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PilotDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private int number;
    private TeamDTO team;
}
