package com.springapp.mvc;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class ChecklistServiceTest {
    @Mock
    ChecklistMapper checklistMapper;

    @InjectMocks
    ChecklistService checklistService;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
    }

    @Test
    public void shouldSaveChecklist() {
        Checklist checklist = new Checklist();
        checklist.setItemTitle("title");
        checklist.setItemDescription("description");
        checklistService.createChecklistItem(checklist);

        verify(checklistMapper).insert(checklist);
    }

    @Test
    public void shouldRetrieveChecklist () {
        Checklist checklist = new Checklist();
        Checklist checklist2 = new Checklist();
        List<Checklist> checklistItems = new ArrayList<Checklist>();
        checklistItems.add(checklist);
        checklistItems.add(checklist2);

        when(checklistMapper.selectAll()).thenReturn(checklistItems);

        List<Checklist> actualChecklistItems = checklistService.getChecklistItems();

        assertThat(actualChecklistItems, is(checklistItems));
    }

}