package com.example.db_crud.controller;

import com.example.db_crud.dto.BoardDto;
import com.example.db_crud.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping("/save")
    public String save(BoardDto dto){
        boardService.saveBoard(dto);
        return "저장 함";
    }
}
