package edu.mum.mscrum.controller;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import edu.mum.mscrum.model.Release;
import edu.mum.mscrum.model.Sprint;
import edu.mum.mscrum.model.UserStory;
import edu.mum.mscrum.service.ReleaseService;
import edu.mum.mscrum.service.SprintService;
import edu.mum.mscrum.service.UserStoryService;
import edu.mum.mscrum.service.ViewBurndownService;

@Controller
@RequestMapping("/productBacklog/{productBacklogId}/releases/{releaseBacklogId}/sprint")
public class SprintController {

	@Autowired
	private SprintService sprintService;
	
	@Autowired
	private ReleaseService releaseService;
	

	@Autowired
	private UserStoryService userStoryService;

	@RequestMapping(value = { "/", "/listSprints" })
	public String listSprints(@PathVariable Long releaseBacklogId,Map<String, Object> map) {
		Release release= releaseService.getById(releaseBacklogId);
		map.put("release", release);
		map.put("sprint", new Sprint());
		map.put("sprintList", sprintService.listAll());

		return "/sprint/listSprints";
	}

	@RequestMapping("/get/{sprintId}")
	public String getSprint(@PathVariable Long sprintId,
			Map<String, Object> map) {

		Sprint sprint = sprintService
				.getById(sprintId);

		map.put("sprint", sprint);

		return "/sprint/sprintForm";
	}

	@RequestMapping("/{sprintId}/UserStories")
	public String getAllUserStories(@PathVariable Long sprintId,
			Map<String, Object> map) {

		Sprint sprint = sprintService
				.getById(sprintId);

		Set<UserStory> userStories = sprint.getUserStories();

		map.put("sprint", sprint);
		map.put("userStory", new UserStory());
		map.put("userStories", userStories);

		return "sprint/listUserStories";
	}

	@RequestMapping("/{sprintId}/get/{userStoryId}")
	public String getUserStory(@PathVariable Long sprintId,
			@PathVariable Long userStoryId, Map<String, Object> map) {

		Sprint sprint = sprintService
				.getById(sprintId);

		UserStory userStory = userStoryService.getById(userStoryId);

		map.put("sprint", sprint);
		map.put("userStory", userStory);

		return "sprint/userStoryForm";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveSprint(
			@ModelAttribute("sprint") Sprint sprint,
			BindingResult result, RedirectAttributes redir) {

		sprintService.save(sprint);

		redir.addFlashAttribute("message", "New sprint added!!!");

		/*
		 * Note that there is no slash "/" right after "redirect:" So, it
		 * redirects to the path relative to the current path
		 */
		return "redirect:listSprints";
	}

	@RequestMapping("/delete/{sprintId}")
	public String deleteSprint(@PathVariable("sprintId") Long id) {

		sprintService.deleteById(id);

		/*
		 * redirects to the path relative to the current path
		 */
		// return "redirect:../listSprints";

		/*
		 * Note that there is the slash "/" right after "redirect:" So, it
		 * redirects to the path relative to the project root path
		 */
		return "redirect:/sprint/listSprints";
	}

	@RequestMapping(value = "/{sprintId}/UserStories/save", method = RequestMethod.POST)
	public String saveUserStory(@PathVariable("sprintId") Long id,
			@ModelAttribute("userStory") UserStory userStory,
			BindingResult result, RedirectAttributes redir) {

		Sprint sprint = sprintService.getById(id);

		userStory.setSprint(sprint);

		userStoryService.save(userStory);

		redir.addFlashAttribute("message", "New user story added!!!");

		/*
		 * Note that there is no slash "/" right after "redirect:" So, it
		 * redirects to the path relative to the current path
		 */
		return "redirect:/sprint/" + id + "/UserStories";
	}

	@RequestMapping("/{sprintId}/delete/{userStoryId}")
	public String deleteUserStory(
			@PathVariable("sprintId") Long sprintId,
			@PathVariable("userStoryId") Long userStoryId) {

		Sprint sprint = sprintService
				.getById(sprintId);
		UserStory userStory = userStoryService.getById(userStoryId);

		userStory.setSprint(sprint);

		userStoryService.delete(userStory);

		/*
		 * Note that there is no slash "/" right after "redirect:" So, it
		 * redirects to the path relative to the current path
		 */
		return "redirect:/sprint/" + sprintId + "/UserStories";
	}
	
	@Autowired
	private ViewBurndownService viewBurndownService;

	@RequestMapping("/viewBurndown/")
	public String showBurnDownChart() {

		// map.put("viewBurnDown", new ViewBurndown());
		return "/viewBurndown/viewBurndown";
	}

	@RequestMapping("/viewBurndown/getData")
	public @ResponseBody Map<Integer, Integer> getBurnDownChartData() {

		Map<Integer, Integer> chartData = new LinkedHashMap<Integer, Integer>();
		chartData.put(40, 40);
		chartData.put(32, 30);
		chartData.put(24, 20);
		chartData.put(16, 5);

		return chartData;
	}
}
