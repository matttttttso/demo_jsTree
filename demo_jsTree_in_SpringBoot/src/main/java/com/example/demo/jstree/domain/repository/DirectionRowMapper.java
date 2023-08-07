package com.example.demo.jstree.domain.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.jstree.domain.model.Direction;

/**
 * {@code Direction}を設定するMapperクラス。
 */
@Repository
public class DirectionRowMapper implements RowMapper<Direction> {
	@Override
	public Direction mapRow(ResultSet rs, int rowNum) throws SQLException {
		Direction direction = new Direction();
		direction.setId(rs.getInt("id"));
		direction.setName(rs.getString("name"));
		return direction;
	}
}
