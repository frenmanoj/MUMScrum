package edu.mum.mscrum.controller;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.mum.mscrum.model.ProductBacklog;
import edu.mum.mscrum.model.Release;
import edu.mum.mscrum.service.ProductBacklogService;
import edu.mum.mscrum.service.ReleaseService;

@Controller
public class DefaultController {

	@Autowired
	private ProductBacklogService productBacklogService;

	@Autowired
	private ReleaseService releaseBacklogService;

	// for Releases menu in header
	@RequestMapping("/selectProduct")
	public String listProductBacklogs(Map<String, Object> map) {

		map.put("productBacklog", new ProductBacklog());
		map.put("productBacklogList", productBacklogService.listAll());

		return "/productBacklog/selectProduct";
	}

	@RequestMapping(value = "/selectProduct", method = RequestMethod.POST)
	public String loadReleases(
			@RequestParam(value = "productBacklogId") int productBacklogId) {

		return "redirect:/productBacklog/" + productBacklogId + "/releases/";
	}

	// for Sprint menu in header
	@RequestMapping("/selectRelease")
	public String listReleases(Map<String, Object> map) {

		map.put("productBacklogList", productBacklogService.listAll());

		return "/releaseBacklog/selectRelease";
	}
	
	@RequestMapping(value = "/selectRelease", method = RequestMethod.POST)
	public String loadSprints(
			@RequestParam(value = "productBacklogId") int productBacklogId,
			@RequestParam(value = "releaseBacklogId") int releaseBacklogId) {

		return "redirect:/productBacklog/" + productBacklogId + "/releases/" + releaseBacklogId + "/sprints/" ;
	}
	
	// ajax call from the selectRelease page
	@RequestMapping("/getReleases/{productId}")
	public @ResponseBody Map<Long, String> getReleases(
			@PathVariable Long productId) {

		ProductBacklog productBacklog = productBacklogService
				.getById(productId);

		Set<Release> releases = productBacklog.getReleases();

		Map<Long, String> releaseData = new LinkedHashMap<Long, String>();

		for (Release release : releases) {

			releaseData.put(release.getId(), release.getName());
		}

		return releaseData;
	}

	
}
