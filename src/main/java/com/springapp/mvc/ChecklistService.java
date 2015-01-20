package com.springapp.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class ChecklistService {

    @Autowired
    private ChecklistMapper mapper;

    @PostConstruct
    private void setup() {
        mapper.createTable();
    }

    public void createChecklistItem(Checklist checklist) {
        mapper.insert(checklist);
    }

    public List<Checklist> getChecklistItems() {
        return mapper.selectAll();
    }

}
