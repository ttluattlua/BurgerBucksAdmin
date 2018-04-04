package bba.com.a.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import bba.com.a.service.BbaSideService;

@Controller
public class BbaSideController {
	private static final Logger logger = LoggerFactory.getLogger(BbaSideController.class);

	@Autowired
	BbaSideService bbaSideService;
}
