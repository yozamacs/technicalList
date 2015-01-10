package com.springapp.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller

public class ChecklistController {

    @Autowired
    ChecklistService checklistService;

    @ModelAttribute("checklist")
    public Checklist getChecklist() {return new Checklist(); }

	@RequestMapping(method = RequestMethod.GET, value="/")
	public String displayItems(Model model) {
		model.addAttribute("message", "My checklist");
        List<Checklist> checklistItems  = checklistService.getChecklistItems();
        model.addAttribute("checklistItems",checklistItems);
		return "checklist";
	}

    @RequestMapping(method = RequestMethod.GET, value="/checklistAdd")
    public String addItems() {
        return "checklistAdd";
    }

    @RequestMapping(method = RequestMethod.POST, value="/checklistAdd")
    public String submitItems(@ModelAttribute @Valid Checklist checklist, BindingResult result, Model model) {
        if(result.hasErrors()){
            return "checklistAdd";
        }
        checklistService.createChecklistItem(checklist);
        model.addAttribute("message", "New items added!");
        List<Checklist> checklistItems  = checklistService.getChecklistItems();
        model.addAttribute("checklistItems",checklistItems);
        return "checklist";
    }
}
