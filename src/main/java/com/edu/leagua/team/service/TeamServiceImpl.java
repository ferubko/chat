package com.edu.leagua.team.service;

import com.edu.leagua.team.clients.TeamClient;
import com.edu.leagua.team.dto.response.ListTeamResponse;
import com.edu.leagua.team.exceptions.InternalServiceInvocationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by stepanferubko
 */

@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamClient teamClient;

    @Override
    public ListTeamResponse getLeagueTeams() {
        try {
            return teamClient.getEnglishTeams();

        } catch (InternalServiceInvocationException e) {
            throw new RuntimeException();
        }
    }
}
