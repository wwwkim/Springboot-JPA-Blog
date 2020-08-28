package com.cos.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.model.Board;
import com.cos.blog.model.User;
import com.cos.blog.repository.BoardRepository;

@Service
public class BoardService {

	@Autowired
	private BoardRepository boardRepository;

	@Transactional
	public void write(Board board, User user) {
		board.setCount(0);
		board.setUser(user);
		boardRepository.save(board);

	}

	@Transactional(readOnly = true) // select
	public Page<Board> boardList(Pageable pageable) {
		return boardRepository.findAll(pageable);
	}

	@Transactional(readOnly = true) //select
	public Board detail(int id) {

		return boardRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("Failed: Could not find id");
		});

	}

	@Transactional
	public void delete(int id) {

		boardRepository.deleteById(id);
	}

	@Transactional
	public void update(int id, Board requestBoard) {
		Board board=boardRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("Failed: Could not find id");
		});

		board.setTitle(requestBoard.getTitle());
		board.setContent(requestBoard.getContent());
	}
}
