package edu.mum.mscrum.controller;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.mscrum.model.ProductBacklog;
import edu.mum.mscrum.model.Release;
import edu.mum.mscrum.model.Sprint;
import edu.mum.mscrum.model.UserStory;
import edu.mum.mscrum.service.UserStoryService;
import edu.mum.mscrum.service.UserStoryService;

@Controller
@RequestMapping("/userStory")
public class UserStoryController {

	@Autowired
	private UserStoryService userStoryService;

	@RequestMapping(value = { "/", "/listUserStories" })
	public String listUserStories(Map<String, Object> map) {

		map.put("userStory", new UserStory());
		map.put("userStoryList", userStoryService.listAll());

		return "/userStory/listUserStories";
	}

	@RequestMapping("/get/{userStoryId}")
	public String getProductBacklog(@PathVariable Long userStoryId,
			Map<String, Object> map) {

		UserStory userStory = userStoryService.getById(userStoryId);

		ProductBacklog productBacklog = userStory.getProductBacklog();

		Release releaseBacklog = userStory.getReleaseBacklog();

		Sprint sprint = userStory.getSprint();

		map.put("productBacklog", productBacklog);
		map.put("releaseBacklog", releaseBacklog);
		map.put("sprint", sprint);
		map.put("userStory", userStory);

		return "/userStory/userStoryForm";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String updateEffort(
			@ModelAttribute("userStory") UserStory newUserStory,
			BindingResult result, RedirectAttributes redir) {

		UserStory userStory = userStoryService.getById(newUserStory.getId());
		
		userStory.setEstimatedDevHours(newUserStory.getEstimatedDevHours());
		userStory.setRemainingDevHours(newUserStory.getRemainingDevHours());
		userStoryService.save(userStory);

		redir.addFlashAttribute("message", "UserStory Saved!");

		/*
		 * Note that there is no slash "/" right after "redirect:" So, it
		 * redirects to the path relative to the current path
		 */
		return "redirect:listUserStories";
	}

}
