package com.edu.leagua.team.dto.response;

import com.edu.leagua.team.common.AbstractResponse;
import com.edu.leagua.team.dto.Team;

import java.util.List;

/**
 * Created by stepanferubko
 */
public class ListTeamResponse extends AbstractResponse {
    private List<Team> teams;

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListTeamResponse that = (ListTeamResponse) o;

        return teams != null ? teams.equals(that.teams) : that.teams == null;
    }

    @Override
    public int hashCode() {
        return teams != null ? teams.hashCode() : 0;
    }
}
