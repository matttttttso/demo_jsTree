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
public class Area extends Node implements Serializable {
	private int direction;	// 東日本/西日本
	private List<Prefecture> prefectures;

	public Area(int id, String name, List<Node> childNodes, int direction) {
		super(id, name, childNodes);
		this.direction = direction;
	}
}
