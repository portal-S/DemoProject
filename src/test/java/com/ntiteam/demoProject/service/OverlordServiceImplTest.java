package com.ntiteam.demoProject.service;

import com.ntiteam.demoProject.DemoProjectApplication;
import com.ntiteam.demoProject.model.Overlord;
import com.ntiteam.demoProject.repository.OverlordRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OverlordServiceImplTest {

    @MockBean
    private OverlordRepository repository;

    @Autowired
    private OverlordServiceImpl service;

    @Test
    void addLord() {
        Overlord overlord = new Overlord();
        Mockito.when(repository.save(overlord)).thenReturn(overlord);
        Assert.assertNotNull(service.addLord(overlord));
    }

    @Test
    void getLazyLords() {
        List<Overlord> list = new ArrayList<>();
        list.add(new Overlord("Test1", 30));
        list.add(new Overlord("Test2", 20));
        list.add(new Overlord("Test3", 10));
        Mockito.when(repository.getLazyLords()).thenReturn(list);
        Assert.assertTrue(service.getLazyLords().stream().allMatch(n -> n.getPlanets() == null));
    }

    @Test
    void getYoungLords() {
        List<Overlord> list = new ArrayList<>();
        list.add(new Overlord("Test1", 30));
        list.add(new Overlord("Test2", 20));
        list.add(new Overlord("Test3", 10));
        Mockito.when(repository.getYoungLords(PageRequest.of(0, 10))).thenReturn(list);
        Assert.assertEquals(service.getYoungLords(), list);
    }
}