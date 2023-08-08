package com.example.demo.jstree.domain.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.jstree.domain.model.PrefTreeNode;

/**
 * {@code PrefTreeNode}を設定するMapperクラス。
 */
@Repository
public class PrefTreeNodeRowMapper implements RowMapper<PrefTreeNode> {
	@Override
	public PrefTreeNode mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new PrefTreeNode(
				rs.getInt("id"),
				rs.getString("name"),
				rs.getInt("parent_id"));
	}
}
