package com.example.db_crud.controller;

import com.example.db_crud.dto.BoardDto;
import com.example.db_crud.dto.OnlyID;
import com.example.db_crud.dto.UpdateDto;
import com.example.db_crud.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public String save(@RequestBody BoardDto dto){
        boardService.saveBoard(dto);
        return "저장 함";
    }

    @PostMapping("/select")
    public String select(@RequestBody OnlyID dto){
        BoardDto ddd = boardService.selectBoard(dto);
        return "제목 : " + ddd.getTitle() + "\n내용 : " + ddd.getContent();
    }

    @PostMapping("/delete")
    public String delete(@RequestBody OnlyID dto){
        boardService.deleteBoard(dto);
        return "삭제 완";
    }

    @PostMapping("/update")
    public String update(@RequestBody UpdateDto dto){
        boardService.updateBoard(dto);
        return "수정 완";
    }
}
