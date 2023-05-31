package com.ssafy.main.model.service.board;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.main.model.dto.Board.Board;
import com.ssafy.main.model.dao.board.BoardDao;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao boardDao;

	@Override
	public void writeBoard(Board board) {
		boardDao.insertBoard(board);
	}

	@Override
	public List<Board> getBoardList(HashMap<String, String> params) {
		return boardDao.selectList(params);
	}

	@Override
	public Board getBoard(int id) {
		this.updateViewCnt(id);
		return boardDao.selectOne(id);
	}

	@Override
	public void modifyBoard(Board board) {
		Board originBoard = boardDao.selectOne(board.getBoardId());
		originBoard.setBoardTitle(board.getBoardTitle());
		originBoard.setBoardText(board.getBoardText());
		boardDao.updateBoard(originBoard);
	}

	@Override
	public void removeBoard(int id) {
		boardDao.deleteBoard(id);
	}

	@Override
	public void updateViewCnt(int id) {
		Board board = boardDao.selectOne(id);
		board.setViewCnt(board.getViewCnt() + 1);
		boardDao.updateBoard(board);
	}

	@Override
	public List<Board> getSportList(String sport) {
		// TODO Auto-generated method stub
		return boardDao.selectSportList(sport);
	}

}
