package com.ntiteam.demoProject.service;

import com.ntiteam.demoProject.model.Overlord;
import com.ntiteam.demoProject.repository.OverlordRepository;
import com.ntiteam.demoProject.service.interfaces.OverlordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class OverlordServiceImpl implements OverlordService {

    @Autowired
    private OverlordRepository repository;

    @Override
    public Overlord addLord(Overlord overlord) {
        return repository.save(overlord);
    }

    @Override
    public List<Overlord> getLazyLords() {
        return repository.getLazyLords();
    }

    @Override
    public List<Overlord> getYoungLords() {
        return repository.getYoungLords(PageRequest.of(0, 10));
    }
}
