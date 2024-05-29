package com.group.commute_system.controller.team;

import com.group.commute_system.dto.team.request.TeamCreateRequest;
import com.group.commute_system.dto.team.response.TeamResponse;
import com.group.commute_system.service.team.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/team")
@RequiredArgsConstructor
public class TeamController {
    private final TeamService teamService;

    @PostMapping
    public void saveTeam(@RequestBody TeamCreateRequest request){
        teamService.saveTeam(request);
    }

    @GetMapping
    public List<TeamResponse> getTeams() {
        return teamService.getTeams();
    }
}
