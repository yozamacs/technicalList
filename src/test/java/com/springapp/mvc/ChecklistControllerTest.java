package com.springapp.mvc;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.util.MatcherAssertionErrors.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class ChecklistControllerTest {

    @Mock
    ChecklistService checklistService;

    @InjectMocks
    ChecklistController checklistController;

    @Mock
    Model model;

    @Mock
    BindingResult bindingResult;

    Checklist checklist;

    List<Checklist> checklistItems2;

    @Before
    public void setUp() {
        checklist = new Checklist();
        checklistItems2 = new ArrayList<Checklist>();
        checklistItems2.add(checklist);
    }

    @Test
    public void shouldDisplayTitleInModel() {
        Model model = mock(Model.class);

        checklistController.displayItems(model);

        verify(model).addAttribute("message", "My checklist");
    }

    @Test
    public void shouldPutChecklistItemsInTheModel() {

        when(checklistService.getChecklistItems()).thenReturn(checklistItems2);

        checklistController.displayItems(model);

        verify(model).addAttribute("checklistItems", checklistItems2);
    }

    @Test
    public void shouldDisplayTheAddChecklistPage() {
        String expectedPage = checklistController.addItems();

        assertThat(expectedPage, is("checklistAdd"));
    }

    @Test
    public void shouldSaveNewChecklistItem() {
        checklistController.submitItems(checklist,bindingResult,model);

        verify(checklistService).createChecklistItem(checklist);
    }
}
