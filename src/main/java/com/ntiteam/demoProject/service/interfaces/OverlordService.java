package com.ntiteam.demoProject.service.interfaces;

import com.ntiteam.demoProject.model.Overlord;

import java.util.List;
import java.util.Set;

public interface OverlordService {
    public Overlord addLord(Overlord overlord);

    public List<Overlord> getLazyLords();

    public List<Overlord> getYoungLords();
}
