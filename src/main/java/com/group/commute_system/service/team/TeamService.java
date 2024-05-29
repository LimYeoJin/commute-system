package com.group.commute_system.service.team;

import com.group.commute_system.domain.team.Team;
import com.group.commute_system.domain.team.TeamRepository;
import com.group.commute_system.dto.team.request.TeamCreateRequest;
import com.group.commute_system.dto.team.response.TeamResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeamService {
    private final TeamRepository teamRepository;

    @Transactional
    public void saveTeam(TeamCreateRequest request) {
        if (teamRepository.existsByName(request.getName())) {
            throw new IllegalArgumentException(String.format("[%s] team already exists!", request.getName()));
        }
        teamRepository.save(new Team(request.getName()));
    }

    @Transactional
    public List<TeamResponse> getTeams() {
        return teamRepository.findAll()
                .stream()
                .map(TeamResponse::new)
                .collect(Collectors.toList());
    }
}
