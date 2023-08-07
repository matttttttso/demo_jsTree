package com.example.demo.jstree.app.controller;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.jstree.domain.model.Area;
import com.example.demo.jstree.domain.model.Direction;
import com.example.demo.jstree.domain.model.Prefecture;
import com.example.demo.jstree.domain.repository.AreaRowMapper;
import com.example.demo.jstree.domain.repository.DirectionRowMapper;
import com.example.demo.jstree.domain.repository.PrefectureRowMapper;

/**
 * Controllerクラス.
 */
@Controller
public class MainController {
	private final JdbcTemplate jdbcTemplate;
	private final PrefectureRowMapper prefectureRowMapper;
	private final AreaRowMapper areaRowMapper;
	private final DirectionRowMapper directionRowMapper;
	public MainController(JdbcTemplate jdbcTemplate, PrefectureRowMapper prefectureRowMapper, AreaRowMapper areaRowMapper, DirectionRowMapper directionRowMapper) {
		this.jdbcTemplate = jdbcTemplate;
		this.prefectureRowMapper = prefectureRowMapper;
		this.areaRowMapper = areaRowMapper;
		this.directionRowMapper = directionRowMapper;
	}


	/**
	 * {@code /survival-rate}にアクセスした際に検索画面を表示
	 *
	 * @param model      : Model
	 * @return showSearchViewメソッド
	 */
	@GetMapping()
	String moveSearchView(Model model) {
		String directionSQL = "SELECT id,name FROM directions ORDER BY id";
		List<Direction> directionList = jdbcTemplate.query(directionSQL, directionRowMapper);
				
		String areaSQL = "SELECT id,name,direction FROM areas ORDER BY id";
		List<Area> areaList = jdbcTemplate.query(areaSQL, areaRowMapper);
		
		String prefectureSQL = "SELECT id,name,area FROM prefectures ORDER BY id";
		List<Prefecture> prefectureList = jdbcTemplate.query(prefectureSQL, prefectureRowMapper);
		
		areaList.stream().forEach(
				ar -> ar.setPrefectures(
					prefectureList.stream()
							.filter(pr -> Objects.equals(pr.getArea(), ar.getId()))
							.collect(Collectors.toList())
				)
		);
		
		directionList.stream().forEach(
				di -> di.setAreas(
					areaList.stream()
							.filter(ar -> Objects.equals(ar.getDirection(), di.getId()))
							.collect(Collectors.toList())
				)
		);
		
		return "";
	}
}
