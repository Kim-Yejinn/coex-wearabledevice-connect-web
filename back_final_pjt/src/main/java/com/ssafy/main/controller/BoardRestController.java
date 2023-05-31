package com.ssafy.main.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.main.model.dto.Board.Board;
import com.ssafy.main.model.service.board.BoardService;

@RestController
@RequestMapping("/api")
public class BoardRestController {

	private static final String SUCCESS = "succes";
	private static final String FAIL = "fail";

	@Autowired
	private BoardService boardService;

	@GetMapping("/board")
	public ResponseEntity<List<Board>> list(@RequestParam(defaultValue = "") String mode,
			@RequestParam(defaultValue = "") String keyword) {
		HashMap<String, String> params = new HashMap<String, String>();

		params.put("mode", mode);
		params.put("keyword", keyword);

		return new ResponseEntity<List<Board>>(boardService.getBoardList(params), HttpStatus.OK);
	}

	@PostMapping("/board")
	public ResponseEntity<String> write(Board board) {
		boardService.writeBoard(board);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.CREATED);
	}

	@GetMapping("/board/{id}")
	public ResponseEntity<Board> detail(@PathVariable int id) {
		try {
			return new ResponseEntity<Board>(boardService.getBoard(id), HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("에러 발생" + e);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// 게시글 수정
	@PutMapping("/board")
	public ResponseEntity<String> update(Board board) {
		boardService.modifyBoard(board);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}

	// 게시글 삭제
	@DeleteMapping("/board/{id}")
	public ResponseEntity<String> delete(@PathVariable int id) {
		boardService.removeBoard(id);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);

	}

	// 종목별 게시글 조회
	@GetMapping("/board/{sport}")
	public ResponseEntity<?> sportlist(@PathVariable String sport) {
		return new ResponseEntity<List<Board>>(boardService.getSportList(sport), HttpStatus.OK);

	}

}
