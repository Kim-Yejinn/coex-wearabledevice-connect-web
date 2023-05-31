package com.ssafy.main.model.service.board;

import java.util.HashMap;
import java.util.List;

import com.ssafy.main.model.dto.Board.Board;

public interface BoardService {
	// 게시글 등록
	void writeBoard(Board board);

	// 게시글 목록
	List<Board> getBoardList(HashMap<String, String> params);

	// 게시글 조회
	Board getBoard(int id);

	// 게시글 수정
	void modifyBoard(Board board);

	// 게시글 삭제
	void removeBoard(int id);

	// 게시글 view cnt 증가
	void updateViewCnt(int id);

	// 특정 운동 조회
	List<Board> getSportList(String sport);

}
