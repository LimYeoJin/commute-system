package com.group.commute_system.controller.team;

import com.group.commute_system.dto.team.request.TeamCreateRequest;
import com.group.commute_system.service.team.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/team")
@RequiredArgsConstructor
public class TeamController {
    private final TeamService teamService;

    @PostMapping
    public void saveTeam(@RequestBody TeamCreateRequest request){
        teamService.saveTeam(request);
    }
}
