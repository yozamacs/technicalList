package com.springapp.mvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ChecklistMapperTest {

    private ChecklistMapper mapper;

    //@Test
    public void shouldInsertAndGetOutChecklistItem() {
        Checklist checklistItem = new Checklist();
        checklistItem.setItemCompleted(false);
        checklistItem.setItemDescription("description");
        checklistItem.setItemTitle("title");
        List<Checklist> checklistItems = new ArrayList<Checklist>();
        checklistItems.add(checklistItem);

        mapper.insert(checklistItem);
        List<Checklist> actualChecklistItems =  mapper.selectAll();

        assertEquals(actualChecklistItems,checklistItems);
    }

}