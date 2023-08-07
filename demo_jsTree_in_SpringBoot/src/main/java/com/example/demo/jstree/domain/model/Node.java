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
public class Node implements Serializable {
	private int id;					// id
	private String name;			// 名前
	private List<Node> childNodes;	// 子ノード
	
	public Node(int id, String name, List<Node> childNodes) {
		this.id = id;
		this.name = name;
		this.childNodes = childNodes;
	}
}
