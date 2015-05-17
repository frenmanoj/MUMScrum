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
import edu.mum.mscrum.model.UserStory;
import edu.mum.mscrum.service.ProductBacklogService;
import edu.mum.mscrum.service.UserStoryService;

@Controller
@RequestMapping("/productBacklog")
public class ProductBacklogController {

	@Autowired
	private ProductBacklogService productBacklogService;

	@Autowired
	private UserStoryService userStoryService;

	@RequestMapping(value = { "/", "/listProductBacklogs" })
	public String listProductBacklogs(Map<String, Object> map) {

		map.put("productBacklog", new ProductBacklog());
		map.put("productBacklogList", productBacklogService.listAll());

		return "/productBacklog/listProductBacklogs";
	}

	@RequestMapping("/get/{productBacklogId}")
	public String getProductBacklog(@PathVariable Long productBacklogId,
			Map<String, Object> map) {

		ProductBacklog productBacklog = productBacklogService
				.getById(productBacklogId);

		map.put("productBacklog", productBacklog);

		return "/productBacklog/productBacklogForm";
	}

	@RequestMapping("/{productBacklogId}/UserStories/")
	public String getAllUserStories(@PathVariable Long productBacklogId,
			Map<String, Object> map) {

		ProductBacklog productBacklog = productBacklogService
				.getById(productBacklogId);

		Set<UserStory> userStories = productBacklog.getUserStories();

		map.put("productBacklog", productBacklog);
		map.put("userStory", new UserStory());
		map.put("userStories", userStories);

		return "productBacklog/listUserStories";
	}

	@RequestMapping("/{productBacklogId}/Releases")
	public String getAllReleases(@PathVariable Long productBacklogId,
			Map<String, Object> map) {

		ProductBacklog productBacklog = productBacklogService
				.getById(productBacklogId);

		Set<Release> releases = productBacklog.getReleases();

		map.put("productBacklog", productBacklog);
		map.put("releaseBacklog", new Release());
		map.put("releaseBackloglist", releases);

		System.out.println("product backlog : " + productBacklog.getTitle());

		return "/releaseBacklog/listReleaseBacklog";
	}

	@RequestMapping("/{productBacklogId}/details")
	public String getProductBacklogDetails(@PathVariable Long productBacklogId,
			Map<String, Object> map) {

		ProductBacklog productBacklog = productBacklogService
				.getById(productBacklogId);

		map.put("productBacklog", productBacklog);

		return "productBacklog/productBacklogDetails";
	}

	@RequestMapping("/{productBacklogId}/UserStories/get/{userStoryId}")
	public String getUserStory(@PathVariable Long productBacklogId,
			@PathVariable Long userStoryId, Map<String, Object> map) {

		ProductBacklog productBacklog = productBacklogService
				.getById(productBacklogId);

		UserStory userStory = userStoryService.getById(userStoryId);

		map.put("productBacklog", productBacklog);
		map.put("userStory", userStory);

		return "productBacklog/userStoryForm";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProductBacklog(
			@ModelAttribute("productBacklog") ProductBacklog productBacklog,
			BindingResult result, RedirectAttributes redir) {

		productBacklogService.save(productBacklog);

		redir.addFlashAttribute("message", "New product backlog added!!!");

		/*
		 * Note that there is no slash "/" right after "redirect:" So, it
		 * redirects to the path relative to the current path
		 */
		return "redirect:listProductBacklogs";
	}

	@RequestMapping("/delete/{productBacklogId}")
	public String deleteProductBacklog(@PathVariable("productBacklogId") Long id) {

		productBacklogService.deleteById(id);

		/*
		 * redirects to the path relative to the current path
		 */
		// return "redirect:../listProductBacklogs";

		/*
		 * Note that there is the slash "/" right after "redirect:" So, it
		 * redirects to the path relative to the project root path
		 */
		return "redirect:/productBacklog/listProductBacklogs";
	}

	@RequestMapping(value = "/{productBacklogId}/UserStories/save", method = RequestMethod.POST)
	public String saveUserStory(@PathVariable("productBacklogId") Long id,
			@ModelAttribute("userStory") UserStory userStory,
			BindingResult result, RedirectAttributes redir) {

		ProductBacklog productBacklog = productBacklogService.getById(id);

		userStory.setProductBacklog(productBacklog);
		userStoryService.save(userStory);

		redir.addFlashAttribute("message", "New user story added!!!");

		/*
		 * Note that there is no slash "/" right after "redirect:" So, it
		 * redirects to the path relative to the current path
		 */
		return "redirect:/productBacklog/" + id + "/UserStories/";
	}

	@RequestMapping("/{productBacklogId}/UserStories/delete/{userStoryId}")
	public String deleteUserStory(
			@PathVariable("productBacklogId") Long productBacklogId,
			@PathVariable("userStoryId") Long userStoryId) {

		UserStory userStory = userStoryService.getById(userStoryId);

		userStoryService.delete(userStory);

		/*
		 * Note that there is no slash "/" right after "redirect:" So, it
		 * redirects to the path relative to the current path
		 */
		return "redirect:/productBacklog/" + productBacklogId + "/UserStories/";
	}
}
