package com.edu.leagua.team.clients;

import com.edu.leagua.team.common.AbstractClient;
import com.edu.leagua.team.dto.response.ListTeamResponse;
import com.edu.leagua.team.exceptions.InternalServiceInvocationException;

/**
 * Created by stepanferubko
 */
public class TeamClient extends AbstractClient {
    private static final String ENGLISH_LEAGUE = "/soccerseasons/446/teams";

    public ListTeamResponse getEnglishTeams() throws InternalServiceInvocationException {
        return getResponse(() -> restTemplate.getForObject(
                endpoint(FOOTBALL_DATA, ENGLISH_LEAGUE),
                ListTeamResponse.class)
        );
    }
}
