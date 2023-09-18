package com.example.sportgo.controller;

import com.example.sportgo.entity.TeamInvitation;
import com.example.sportgo.exception.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;
import com.example.sportgo.repository.TeamInvitationRepository;

import java.util.List;

@RestController
@RequestMapping("/api/team-invitations")
public class TeamInvitationController {

    private final TeamInvitationRepository repository;

    public TeamInvitationController(TeamInvitationRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<TeamInvitation> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public TeamInvitation create(@RequestBody TeamInvitation newInvitation) {
        return repository.save(newInvitation);
    }

    @GetMapping("/{id}")
    public TeamInvitation getOne(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("TeamInvitation", "id", id));
    }

    @PutMapping("/{id}")
    public TeamInvitation update(@PathVariable Long id, @RequestBody TeamInvitation updatedInvitation) {
        return repository.findById(id)
                .map(invitation -> {
                    invitation.setTeamName(updatedInvitation.getTeamName());
                    invitation.setField(updatedInvitation.getField());
                    invitation.setTime(updatedInvitation.getTime());
                    invitation.setCost(updatedInvitation.getCost());
                    return repository.save(invitation);
                })
                .orElseThrow(() -> new ResourceNotFoundException("TeamInvitation", "id", id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("TeamInvitation", "id", id);
        }
        repository.deleteById(id);
    }
}
