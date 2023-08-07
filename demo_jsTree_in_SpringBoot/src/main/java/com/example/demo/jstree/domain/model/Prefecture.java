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
public class Prefecture extends Node implements Serializable {
	private int area;	// エリア
	
	public Prefecture(int id, String name, List<Node> childNodes, int area) {
		super(id, name, childNodes);
		this.area = area;
	}
}
