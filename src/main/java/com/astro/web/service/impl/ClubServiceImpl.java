package com.astro.web.service.impl;

import com.astro.web.dto.ClubDto;
import com.astro.web.models.Club;
import com.astro.web.repository.ClubRepository;
import com.astro.web.service.ClubService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClubServiceImpl implements ClubService {
    private final ClubRepository clubRepository;

    public ClubServiceImpl(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @Override
    public List<ClubDto> findAllClubs(){
        List<Club> clubs = clubRepository.findAll();
        return clubs.stream().map(this::mapToClubDto).collect(Collectors.toList());
    }

    private ClubDto mapToClubDto(Club club){
        return ClubDto.builder()
                .id(club.getId())
                .title(club.getTitle())
                .photoUrl(club.getPhotoUrl())
                .content(club.getContent())
                .createdOn(club.getCreatedOn())
                .updateOn(club.getUpdateOn())
                .build();
    }
}
