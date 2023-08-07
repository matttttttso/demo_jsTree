package com.example.demo.jstree.domain.model;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
@NoArgsConstructor
public class Direction extends Node implements Serializable {
	private List<Area> areas;
	
	public Direction(int id, String name, List<Node> childNodes) {
		super(id, name, childNodes);
	}
}
