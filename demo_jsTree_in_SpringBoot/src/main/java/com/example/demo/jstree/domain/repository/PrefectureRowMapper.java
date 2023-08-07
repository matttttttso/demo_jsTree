package com.example.demo.jstree.domain.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.jstree.domain.model.Prefecture;

/**
 * {@code Prefecture}を設定するMapperクラス。
 */
@Repository
public class PrefectureRowMapper implements RowMapper<Prefecture> {
	@Override
	public Prefecture mapRow(ResultSet rs, int rowNum) throws SQLException {
		Prefecture prefecture = new Prefecture();
		prefecture.setId(rs.getInt("id"));
		prefecture.setName(rs.getString("name"));
		prefecture.setArea(rs.getInt("area"));
		return prefecture;
	}
}
