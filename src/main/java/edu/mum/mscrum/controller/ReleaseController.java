package edu.mum.mscrum.controller;

import java.util.Map;

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
import edu.mum.mscrum.service.ProductBacklogService;
import edu.mum.mscrum.service.ReleaseService;

@Controller
@RequestMapping("/productBacklog/{productBacklogId}/releases")
public class ReleaseController {

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

}
