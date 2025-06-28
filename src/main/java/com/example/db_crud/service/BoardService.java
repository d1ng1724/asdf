package com.example.db_crud.service;

import com.example.db_crud.dto.OnlyID;
import com.example.db_crud.entity.BoardEntity;
import com.example.db_crud.dto.UpdateDto;
import com.example.db_crud.repository.BoardRepository;
import com.example.db_crud.dto.BoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    public void saveBoard(BoardDto dto){
        BoardEntity boardentity = new BoardEntity(dto);
        boardRepository.save(boardentity);
    }

    public BoardDto selectBoard(OnlyID dto){
        BoardEntity board = boardRepository.findById(dto.getId())
                .orElseThrow(() -> new IllegalArgumentException("업써"));
        return new BoardDto(board.getTitle(), board.getContent());
    }

    public void deleteBoard(OnlyID dto){
        boardRepository.deleteById(dto.getId());
    }

    public void updateBoard(UpdateDto dto){
        BoardEntity board = boardRepository.findById(dto.getId())
                .orElseThrow(() -> new IllegalArgumentException("업써"));
        board.setTitle(dto.getTitle());
        board.setContent(dto.getContent());
        boardRepository.save(board);
    }
}
