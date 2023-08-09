package com.example.demo.jstree.app.controller;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.jstree.domain.model.PrefTreeNode;
import com.example.demo.jstree.domain.repository.PrefTreeNodeRowMapper;

/**
 * Controllerクラス.
 */
@Controller
public class MainController {
	private final JdbcTemplate jdbcTemplate;
	private final PrefTreeNodeRowMapper prefTreeNodeRowMapper;
	public MainController(JdbcTemplate jdbcTemplate, PrefTreeNodeRowMapper prefTreeNodeRowMapper) {
		this.jdbcTemplate = jdbcTemplate;
		this.prefTreeNodeRowMapper = prefTreeNodeRowMapper;
	}


	/**
	 * {@code /survival-rate}にアクセスした際に検索画面を表示
	 *
	 * @param model      : Model
	 * @return showSearchViewメソッド
	 */
	@GetMapping()
	String moveSearchView(Model model) {
		String directionSQL = "SELECT id,name,parent_id FROM directions ORDER BY id";
		List<PrefTreeNode> directionList = jdbcTemplate.query(directionSQL, prefTreeNodeRowMapper);
				
		String areaSQL = "SELECT id,name,parent_id FROM areas ORDER BY id";
		List<PrefTreeNode> areaList = jdbcTemplate.query(areaSQL, prefTreeNodeRowMapper);
		
		String prefectureSQL = "SELECT id,name,parent_id FROM prefectures ORDER BY id";
		List<PrefTreeNode> prefectureList = jdbcTemplate.query(prefectureSQL, prefTreeNodeRowMapper);
		
		areaList.stream().forEach(
				ar -> ar.setChildNodes(
					prefectureList.stream()
							.filter(pr -> Objects.equals(pr.getParentId(), ar.getId()))
							.collect(Collectors.toList())
				)
		);
		
		directionList.stream().forEach(
				di -> di.setChildNodes(
					areaList.stream()
							.filter(ar -> Objects.equals(ar.getParentId(), di.getId()))
							.collect(Collectors.toList())
				)
		);
		
		return "";
	}
}
