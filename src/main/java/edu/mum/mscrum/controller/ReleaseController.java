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

import edu.mum.mscrum.model.Release;
import edu.mum.mscrum.service.ReleaseService;


@Controller
@RequestMapping("/releaseBacklog")
public class ReleaseController {
	
	@Autowired
	private ReleaseService releaseBacklogService;

	@RequestMapping(value = { "/", "/listReleaseBacklog" })
	public String listRelease(Map<String, Object> map) {

		map.put("releaseBacklog", new Release());
		map.put("releaseBackloglist", releaseBacklogService.listAll());

		return "/releaseBacklog/listReleaseBacklog";
	}

	
	@RequestMapping("/get/{releaseBacklogId")
	
	public String getReleaseBackog(@PathVariable Long releaseBacklogId, Map<String,Object> map)
	{
		Release releaseBacklog = releaseBacklogService.getById(releaseBacklogId);
		
		map.put("releaseBacklog", releaseBacklog);
		return "/releaseBacklog/listReleaseBacklog";
	}

	@RequestMapping(value="/save", method=RequestMethod.POST)	
	public String  saveReleaseBacklog(@ModelAttribute("releaseBacklog") Release releaseBackog, BindingResult result
			,RedirectAttributes redir)
	{
	
		releaseBacklogService.save(releaseBackog);
		redir.addFlashAttribute("message", "New Release Backlog added!!!");
	
		return "redirect:listReleaseBacklog";
	}
}
