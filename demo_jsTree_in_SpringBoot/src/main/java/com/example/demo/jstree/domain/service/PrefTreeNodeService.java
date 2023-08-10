package com.example.demo.jstree.domain.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.jstree.domain.model.PrefTreeNode;
import com.example.demo.jstree.domain.model.constants.SqlStatement;
import com.example.demo.jstree.domain.repository.PrefTreeNodeRowMapper;

/**
 * {@code PrefTreeNode}を設定するServiceクラス。
 */
@Service
@Transactional(readOnly = true)
public class PrefTreeNodeService {
	private final JdbcTemplate jdbcTemplate;
	private final PrefTreeNodeRowMapper prefTreeNodeRowMapper;
	
	public PrefTreeNodeService(JdbcTemplate jdbcTemplate, PrefTreeNodeRowMapper prefTreeNodeRowMapper) {
		this.jdbcTemplate = jdbcTemplate;
		this.prefTreeNodeRowMapper = prefTreeNodeRowMapper;
	}
	
	/**
	 * {@code PrefTreeNodeList}を作成するメソッド。
	 */
	public List<PrefTreeNode> readPrefTreeNodeList() {
		List<PrefTreeNode> directionList = jdbcTemplate.query(
				SqlStatement.SELECT_DIRECTIONS.getStatement(), prefTreeNodeRowMapper);
				
		List<PrefTreeNode> areaList = jdbcTemplate.query(
				SqlStatement.SELECT_AREAS.getStatement(), prefTreeNodeRowMapper);
		
		List<PrefTreeNode> prefectureList = jdbcTemplate.query(
				SqlStatement.SELECT_PREFECTURES.getStatement(), prefTreeNodeRowMapper);
		
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
		
		return directionList;
	}
}
