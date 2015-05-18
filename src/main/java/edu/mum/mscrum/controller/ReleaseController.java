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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.mscrum.model.ProductBacklog;
import edu.mum.mscrum.model.Release;
import edu.mum.mscrum.model.UserStory;
import edu.mum.mscrum.service.ProductBacklogService;
import edu.mum.mscrum.service.ReleaseService;
import edu.mum.mscrum.service.UserStoryService;

@Controller
@RequestMapping("/productBacklog/{productBacklogId}/releases")
public class ReleaseController {

	@Autowired
	private UserStoryService userStoryService;

	@Autowired
	private ReleaseService releaseBacklogService;

	@Autowired
	private ProductBacklogService productBacklogService;

	@RequestMapping(value = { "/", "/listReleaseBacklog" })
	public String listRelease(Map<String, Object> map,
			@PathVariable Long productBacklogId) {

		ProductBacklog productBacklog = productBacklogService
				.getById(productBacklogId);

		map.put("productBacklog", productBacklog);
		map.put("releaseBacklog", new Release());
		map.put("releaseBackloglist", productBacklog.getReleases());

		return "/releaseBacklog/listReleaseBacklog";
	}

	@RequestMapping("/get/{releaseBacklogId}")
	public String getReleaseBackog(@PathVariable Long releaseBacklogId,
			Map<String, Object> map) {
		Release releaseBacklog = releaseBacklogService
				.getById(releaseBacklogId);

		map.put("releaseBacklog", releaseBacklog);
		return "/releaseBacklog/releaseBacklogForm";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveReleaseBacklog(@PathVariable Long productBacklogId,
			@ModelAttribute("releaseBacklog") Release releaseBackog,
			BindingResult result, RedirectAttributes redir) {

		ProductBacklog productBacklog = productBacklogService
				.getById(productBacklogId);

		releaseBackog.setProductBacklog(productBacklog);

		releaseBacklogService.save(releaseBackog);

		redir.addFlashAttribute("message", "New Release Backlog added!!!");

		return "redirect:listReleaseBacklog";
	}

	@RequestMapping("/delete/{releaseBacklogId}")
	public String deleteReleaseBacklog(@PathVariable("releaseBacklogId") Long id) {

		releaseBacklogService.deleteById(id);

		/*
		 * redirects to the path relative to the current path
		 */
		// return "redirect:../listProductBacklogs";

		/*
		 * Note that there is the slash "/" right after "redirect:" So, it
		 * redirects to the path relative to the project root path
		 */
		return "redirect:/releaseBacklog/listReleaseBacklog";
	}

	@RequestMapping("/{releaseId}/details")
	public String getReleaseBacklogDetails(@PathVariable Long productBacklogId,
			@PathVariable Long releaseId, Map<String, Object> map) {

		ProductBacklog productBacklog = productBacklogService
				.getById(productBacklogId);

		Release release = releaseBacklogService.getById(releaseId);

		map.put("productBacklog", productBacklog);
		map.put("release", release);

		return "releaseBacklog/releaseBacklogDetails";
	}

	@RequestMapping("/{releaseId}/userStories/")
	public String getReleaseUserStories(@PathVariable Long productBacklogId,
			@PathVariable Long releaseId, Map<String, Object> map) {

		ProductBacklog productBacklog = productBacklogService
				.getById(productBacklogId);

		Release release = releaseBacklogService.getById(releaseId);

		map.put("productBacklog", productBacklog);
		map.put("release", release);
		map.put("userStories", release.getUserStories());

		return "releaseBacklog/listUserStories";
	}

	@RequestMapping("/{releaseId}/userStories/addUserStories")
	public String getAvailableUserStories(@PathVariable Long productBacklogId,
			@PathVariable Long releaseId, Map<String, Object> map) {

		ProductBacklog productBacklog = productBacklogService
				.getById(productBacklogId);

		Release release = releaseBacklogService.getById(releaseId);

		Set<UserStory> availableUserStories = productBacklogService
				.getAvailableUserStories(productBacklog);

		map.put("productBacklog", productBacklog);
		map.put("release", release);
		map.put("userStories", availableUserStories);

		return "releaseBacklog/addUserStories";
	}

	@RequestMapping(value = "/{releaseId}/userStories/addUserStories", method = RequestMethod.POST)
	public String assignUserStories(@PathVariable Long productBacklogId,
			@PathVariable Long releaseId,
			@RequestParam(value = "userStory-ids") String[] userStoryIds) {

		Release release = releaseBacklogService.getById(releaseId);

		for (String userStoryId : userStoryIds) {

			UserStory userStory = userStoryService.getById(Long
					.valueOf(userStoryId));
			userStory.setReleaseBacklog(release);

			userStoryService.save(userStory);
		}

		return "redirect:";
	}

	@RequestMapping(value = "/{releaseId}/userStories/delete/{userStoryId}", method = RequestMethod.GET)
	public String removeUserStoryFromRelease(
			@PathVariable Long productBacklogId, @PathVariable Long releaseId,
			@PathVariable Long userStoryId, Map<String, Object> map) {

		UserStory userStory = userStoryService.getById(userStoryId);

		userStory.setReleaseBacklog(null);

		userStoryService.save(userStory);

		return "redirect:../";
	}
}
