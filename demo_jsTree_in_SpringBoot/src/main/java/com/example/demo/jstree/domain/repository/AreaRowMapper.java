package com.example.demo.jstree.domain.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.jstree.domain.model.Area;

/**
 * {@code Area}を設定するMapperクラス。
 */
@Repository
public class AreaRowMapper implements RowMapper<Area> {
	@Override
	public Area mapRow(ResultSet rs, int rowNum) throws SQLException {
		Area area = new Area();
		area.setId(rs.getInt("id"));
		area.setName(rs.getString("name"));
		area.setDirection(rs.getInt("direction"));
		return area;
	}
}
