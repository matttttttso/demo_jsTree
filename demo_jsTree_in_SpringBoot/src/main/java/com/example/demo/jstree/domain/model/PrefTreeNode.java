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
public class PrefTreeNode implements Serializable {
	private int id;					// id
	private String name;			// 名前
	private int parentId;			// 親ノードID
	private List<PrefTreeNode> childNodes;	// 子ノードリスト
	
	public PrefTreeNode(int id, String name, int parentId) {
		this.id = id;
		this.name = name;
		this.parentId = parentId;
	}
}
