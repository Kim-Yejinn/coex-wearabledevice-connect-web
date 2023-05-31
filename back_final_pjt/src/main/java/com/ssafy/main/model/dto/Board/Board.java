package com.ssafy.main.model.dto.Board;

public class Board {

	int boardId;
	String boardTitle;
	String boardWrite;
	String boardText;
	String boardDate;
	String sprot;
	int viewCnt;

	public Board() {

	}

	public Board(int boardId, String boardTitle, String boardWrite, String boardText, String boardDate, String sprot,
			int viewCnt) {
		this.boardId = boardId;
		this.boardTitle = boardTitle;
		this.boardWrite = boardWrite;
		this.boardText = boardText;
		this.boardDate = boardDate;
		this.sprot = sprot;
		this.viewCnt = viewCnt;
	}

	public String getSprot() {
		return sprot;
	}

	public void setSprot(String sprot) {
		this.sprot = sprot;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardWrite() {
		return boardWrite;
	}

	public void setBoardWrite(String boardWrite) {
		this.boardWrite = boardWrite;
	}

	public String getBoardText() {
		return boardText;
	}

	public void setBoardText(String boardText) {
		this.boardText = boardText;
	}

	public String getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	@Override
	public String toString() {
		return "Board [boardId=" + boardId + ", boardTitle=" + boardTitle + ", boardWrite=" + boardWrite
				+ ", boardText=" + boardText + ", boardDate=" + boardDate + ", sprot=" + sprot + ", viewCnt=" + viewCnt
				+ "]";
	}

}
