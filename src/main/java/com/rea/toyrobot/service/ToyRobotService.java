package com.rea.toyrobot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rea.toyrobot.logic.CommandProcessor;
import com.rea.toyrobot.logic.ToyRobot;
import com.rea.toyrobot.model.Direction;
import com.rea.toyrobot.model.Position;

@Service
@EnableAutoConfiguration
@RestController
public class ToyRobotService {

	@Autowired
	CommandProcessor process;

	@Autowired
	ToyRobot robot;

	@RequestMapping(value = "/place", method = RequestMethod.POST)
	public String place(@RequestParam(value = "positionX") int x, @RequestParam(value = "positionY") int y,
			@RequestParam(value = "direction") String direction) {
		Direction d = Direction.valueOf(direction.toUpperCase());
		robot.placeRobot(new Position(x, y), d);
		return "sucess";
	}

	@RequestMapping(value = "/report", method = RequestMethod.GET)
	public String report() {
		String report = robot.report();
		System.out.println(report);
		return report;
	}

	@RequestMapping(value = "/move", method = RequestMethod.POST)
	public void move() {
		robot.move();
	}

	@RequestMapping(value = "/left", method = RequestMethod.POST)
	public void rotateLeft() {
		robot.rotateLeft();
	}

	@RequestMapping(value = "/right", method = RequestMethod.POST)
	public void rotateRight() {
		robot.rotateRight();
	}

}
