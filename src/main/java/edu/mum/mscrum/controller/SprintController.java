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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.mscrum.model.Burndown;
import edu.mum.mscrum.model.Release;
import edu.mum.mscrum.model.Sprint;
import edu.mum.mscrum.model.UserStory;
import edu.mum.mscrum.service.BurndownService;
import edu.mum.mscrum.service.ReleaseService;
import edu.mum.mscrum.service.SprintService;
import edu.mum.mscrum.service.UserStoryService;

@Controller
@RequestMapping("/productBacklog/{productBacklogId}/releases/{releaseBacklogId}/sprints")
public class SprintController {

	@Autowired
	private SprintService sprintService;

	@Autowired
	private ReleaseService releaseService;

	@Autowired
	private UserStoryService userStoryService;

	@RequestMapping(value = { "/", "/listSprints" })
	public String listSprints(@PathVariable Long releaseBacklogId,
			Map<String, Object> map) {
		Release release = releaseService.getById(releaseBacklogId);
		map.put("release", release);
		map.put("sprint", new Sprint());
		map.put("sprintList", release.getSprints());

		return "/sprint/listSprints";
	}

	@RequestMapping("/get/{sprintId}")
	public String getSprint(@PathVariable Long sprintId, Map<String, Object> map) {

		Sprint sprint = sprintService.getById(sprintId);

		map.put("sprint", sprint);

		return "/sprint/sprintForm";
	}

	@RequestMapping("/{sprintId}/userStories/")
	public String getAllUserStories(@PathVariable Long sprintId,
			Map<String, Object> map) {

		Sprint sprint = sprintService.getById(sprintId);

		Set<UserStory> userStories = sprint.getUserStories();

		map.put("sprint", sprint);
		map.put("userStory", new UserStory());
		map.put("userStories", userStories);

		return "sprint/listUserStories";
	}

	@RequestMapping("/{sprintId}/userStories/addUserStories")
	public String getAvailableUserStories(@PathVariable Long sprintId,
			Map<String, Object> map) {

		Sprint sprint = sprintService.getById(sprintId);

		Release release = sprint.getReleaseBacklog();

		Set<UserStory> availableUserStories = releaseService
				.getAvailableUserStories(release);

		map.put("sprint", sprint);
		map.put("userStories", availableUserStories);

		return "sprint/addUserStories";
	}

	@RequestMapping("/{sprintId}/get/{userStoryId}")
	public String getUserStory(@PathVariable Long sprintId,
			@PathVariable Long userStoryId, Map<String, Object> map) {

		Sprint sprint = sprintService.getById(sprintId);

		UserStory userStory = userStoryService.getById(userStoryId);

		map.put("sprint", sprint);
		map.put("userStory", userStory);

		return "sprint/userStoryForm";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveSprint(@PathVariable Long releaseBacklogId,
			@ModelAttribute("sprint") Sprint sprint, BindingResult result,
			RedirectAttributes redir) {

		Release release = releaseService.getById(releaseBacklogId);

		sprint.setReleaseBacklog(release);

		sprintService.save(sprint);

		redir.addFlashAttribute("message", "Sprint Saved!");

		/*
		 * Note that there is no slash "/" right after "redirect:" So, it
		 * redirects to the path relative to the current path
		 */
		return "redirect:listSprints";
	}

	@RequestMapping("/delete/{sprintId}")
	public String deleteSprint(@PathVariable("sprintId") Long id) {

		Sprint sprint = sprintService.getById(id);

		Release release = sprint.getReleaseBacklog();

		for (UserStory userStory : sprint.getUserStories()) {
			userStory.setSprint(null);
		}

		release.getSprints().remove(sprint);

		releaseService.save(release);

		/*
		 * redirects to the path relative to the current path
		 */
		// return "redirect:../listSprints";

		/*
		 * Note that there is the slash "/" right after "redirect:" So, it
		 * redirects to the path relative to the project root path
		 */
		return "redirect:../";
	}

	@RequestMapping(value = "/{sprintId}/userStories/addUserStories", method = RequestMethod.POST)
	public String assignUserStories(@PathVariable Long sprintId,
			@RequestParam(value = "userStory-ids") String[] userStoryIds) {

		Sprint sprint = sprintService.getById(sprintId);

		for (String userStoryId : userStoryIds) {

			UserStory userStory = userStoryService.getById(Long
					.valueOf(userStoryId));
			userStory.setSprint(sprint);

			userStoryService.save(userStory);
		}

		// return "redirect:/sprint/" + id + "/UserStories";

		return "redirect:";
	}

	@RequestMapping("/{sprintId}/userStories/delete/{userStoryId}")
	public String removeUserStoryFromRelease(
			@PathVariable("userStoryId") Long userStoryId) {

		UserStory userStory = userStoryService.getById(userStoryId);

		userStory.setSprint(null);

		userStoryService.save(userStory);

		return "redirect:../";
	}

	@Autowired
	private BurndownService burndownService;

	@RequestMapping("/{sprintId}/viewBurndown/")
	public String showBurnDownChart(@PathVariable Long sprintId,
			Map<String, Object> map) {
		Sprint sprint = sprintService.getById(sprintId);
		map.put("sprint", sprint);
		return "viewBurndown/viewBurndown";
	}

	@RequestMapping("/{sprintId}/viewBurndown/getData")
	public @ResponseBody Map<Integer, Integer> getBurnDownChartData(
			@PathVariable("sprintId") Long sprintId) {

		Map<Integer, Integer> chartData = new LinkedHashMap<Integer, Integer>();
		Sprint sprint = sprintService.getById(sprintId);

		for (Burndown bd : sprint.getBurndownlists()) {
			chartData.put(bd.getTotalPlannedEffort(), bd.getTotalRemainingEffort()); 

		}

		return chartData;
	}
	
	@RequestMapping("/{sprintId}/userStories/{userStoryId}/assignDeveloper")
	public String assignDeveloperUserStory(@PathVariable("userStoryId") Long userStoryId,
			Map<String, Object> map) {
		
		UserStory userStory = userStoryService.getById(userStoryId);
		
		map.put("userStory", userStory);

		return "/sprint/assignDeveloperUserStoryForm";
	}
}
