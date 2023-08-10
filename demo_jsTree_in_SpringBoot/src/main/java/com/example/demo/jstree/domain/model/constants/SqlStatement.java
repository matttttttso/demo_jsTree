package com.example.demo.jstree.domain.model.constants;

import lombok.Getter;

/**
 * SQL文を管理する定数クラス。
 * 
 * @author 松尾
 */
public enum SqlStatement {
	SELECT_DIRECTIONS	("SELECT id,name,parent_id FROM directions ORDER BY id"),
	SELECT_AREAS		("SELECT id,name,parent_id FROM areas ORDER BY id"),
	SELECT_PREFECTURES	("SELECT id,name,parent_id FROM prefectures ORDER BY id");
	
	@Getter
	private String statement;

	private SqlStatement(String statement) {
		this.statement = statement;
	}
}
