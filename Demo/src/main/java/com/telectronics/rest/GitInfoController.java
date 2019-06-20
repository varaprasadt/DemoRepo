package com.telectronics.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.telectronics.service.GitService;

@RestController
public class GitInfoController {

	@Autowired
	GitService gitService;

	@GetMapping(value = "/projects", params = "username")
	public String getProjectsList(@RequestParam(name = "username") String userName) {
		int count = gitService.getGitInfoByName(userName);
		String str="<h1>Number of Projects : "+count+"<h1>";
		return str;
	}
}