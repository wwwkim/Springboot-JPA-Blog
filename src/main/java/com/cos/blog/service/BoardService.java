package com.cos.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.dto.ReplySaveDto;
import com.cos.blog.model.Board;
import com.cos.blog.model.Reply;
import com.cos.blog.model.User;
import com.cos.blog.repository.BoardRepository;
import com.cos.blog.repository.ReplyRepository;
import com.cos.blog.repository.UserRepository;

@Service
public class BoardService {

	@Autowired
	private ReplyRepository replyRepository;
	@Autowired
	private BoardRepository boardRepository;
//	@Autowired
//	private UserRepository userRepository;

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

	@Transactional(readOnly = true) // select
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
		Board board = boardRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("Failed: Could not find id");
		});

		board.setTitle(requestBoard.getTitle());
		board.setContent(requestBoard.getContent());
	}

	@Transactional
	public void commentWrite(ReplySaveDto replySaveDto) {
//		User user = userRepository.findById(replySaveDto.getUserId()).orElseThrow(()->{
//			return new IllegalArgumentException("Failed:Could not find UserId");
//		});
//		Board board=boardRepository.findById(replySaveDto.getBoardId()).orElseThrow(()->{
//			return new IllegalArgumentException("Failed:Could not find BoardId");
//		});
//		
//		Reply reply=Reply.builder().user(user).board(board).content(replySaveDto.getContent()).build();
//		replyRepository.save(reply);
//		

		// Using nativeQuery
		replyRepository.mSave(replySaveDto.getUserId(), replySaveDto.getBoardId(), replySaveDto.getContent());

	}

	@Transactional
	public void replyDelete(int replyId) {
		replyRepository.deleteById(replyId);

	}
}
