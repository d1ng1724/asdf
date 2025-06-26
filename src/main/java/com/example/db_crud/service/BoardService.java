package com.example.db_crud.service;

import com.example.db_crud.entity.BoardEntity;
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
}
