// Spring 공부용 게시판 프로젝트//


package board.controller;

import board.DTO.BoardDTO;
import board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class Boardcontroller {
    private final BoardService boardService;

    @GetMapping("/save")
        public String saveForm()
    {
        return "save";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute BoardDTO boardDTO) {
        boardService.save(boardDTO);
        return "index";
    }
    @GetMapping("/")
    public String findAll(Model model) {
        // DB에서 전체 데이터를 가져와서 list.html에서 보여준다.
        List<BoardDTO> boardDTOList =  boardService.findAll();
        model.addAttribute("boardList", boardDTOList);
        return "list";
    }


    @GetMapping("/{id}")
    public String findById(@PathVariable Long id, Model model){
        /*
            해당 게시글의 조회수를 하나 올리고
            게시글 데이터를 가져와서 detail.html에 출력
         */
        boardService.updateHits(id);
        BoardDTO boardDTO = boardService.findById(id);
        /* 댓글 목록 가져오기 */
//        List<CommentDTO> commentDTOList = commentService.findAll(id);
//        model.addAttribute("commentList", commentDTOList);
        model.addAttribute("board", boardDTO);
//        model.addAttribute("page", pageable.getPageNumber());
        return "detail";
    }
    }


