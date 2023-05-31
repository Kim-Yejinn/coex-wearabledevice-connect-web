package com.ssafy.main.model.dao.board;

import java.util.HashMap;
import java.util.List;

import com.ssafy.main.model.dto.Board.Board;

public interface BoardDao {
	void insertBoard(Board board);

	// 게시글 목록
	List<Board> selectList(HashMap<String, String> params);

	// 게시글 조회
	Board selectOne(int id);

	// 게시글 삭제
	void deleteBoard(int id);

	// 게시글 수정
	void updateBoard(Board board);

	// 특정 종목 게시글 조회
	List<Board> selectSportList(String sport);
}
