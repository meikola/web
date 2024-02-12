package com.astro.web.service;

import com.astro.web.dto.ClubDto;

import java.util.List;

public interface ClubService {
    List<ClubDto> findAllClubs();

}
