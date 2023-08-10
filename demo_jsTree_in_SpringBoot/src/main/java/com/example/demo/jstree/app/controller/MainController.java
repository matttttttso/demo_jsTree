package com.example.demo.jstree.app.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.jstree.domain.model.PrefTreeNode;
import com.example.demo.jstree.domain.service.PrefTreeNodeService;

/**
 * Controllerクラス.
 */
@Controller
public class MainController {
	private final PrefTreeNodeService prefTreeNodeService;
	public MainController(PrefTreeNodeService prefTreeNodeService) {
		this.prefTreeNodeService = prefTreeNodeService;
	}


	/**
	 * {@code /(root)}にアクセスした際の動作と遷移先を設定。
	 */
	@GetMapping()
	String showRootPage(Model model) {
		List<PrefTreeNode> prefTreeNodeList = prefTreeNodeService.readPrefTreeNodeList();
		return "";
	}
}
