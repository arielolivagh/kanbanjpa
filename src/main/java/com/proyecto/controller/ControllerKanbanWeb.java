package com.proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ControllerKanbanWeb {
	@RequestMapping(value = "/Web",method = RequestMethod.GET)
	public String index(){
		return "kanbanWeb";
	}

}