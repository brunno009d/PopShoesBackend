package com.example.backend.service;

import org.springframework.stereotype.Service;

import com.example.backend.core.AbstractBaseService;
import com.example.backend.model.Region;
import com.example.backend.repository.RegionRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RegionService extends AbstractBaseService<Region, Integer> {

    public RegionService(RegionRepository regionRepository) {
        super(regionRepository);
    }
}
