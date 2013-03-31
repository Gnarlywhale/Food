package com.github.cmput301w13t04.food.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.github.cmput301w13t04.food.model.Step;

public class StepTest {

	@Test
	public void testGetDescription() {
		Step step = new Step("Add onions", "Add onions to pan");
		assertEquals("Add onions to pan", step.getDescription());
		step.setDescription("Add water");
		assertEquals("Add water", step.getDescription());
	}

	@Test
	public void testGetName() {
		Step step = new Step("Add onions", "Add onions to pan");
		assertEquals("Add onions", step.getName());
		step.setName("Add water");
		assertEquals("Add water", step.getName());
	}

}