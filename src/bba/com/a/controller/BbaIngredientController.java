package bba.com.a.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import bba.com.a.service.BbaIngredientService;


@Controller
public class BbaIngredientController {
	private static final Logger logger = LoggerFactory.getLogger(BbaIngredientController.class);

	@Autowired
	BbaIngredientService bbaIngredientService;
}
