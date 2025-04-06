package com.roomie.matches;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/student")
public class MatchesController {

    private final MatchesService matchesService;

    @Autowired
    public MatchesController(MatchesService matchesService){
        this.matchesService = matchesService;
    }

    @PostMapping("{studentId}/like/{targetId}")
    public void likeStudent(@PathVariable("studentId") Long studentId, @PathVariable("targetId") Long targetId){
        matchesService.studentLiked(studentId, targetId);
    }

    @GetMapping(path="{studentId}/matches")
    public List<MatchesDTO> getStudentMatches(@PathVariable("studentId") Long studentId){
        List<Matches> matchesList = matchesService.getMatchesByPrimaryStudentId(studentId);
    
        return matchesList.stream().map(m -> new MatchesDTO(m)).toList();
    }


}
