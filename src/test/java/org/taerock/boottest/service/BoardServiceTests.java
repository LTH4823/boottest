package org.taerock.boottest.service;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.taerock.boottest.dto.BoardDTO;

@SpringBootTest
@Log4j2
public class BoardServiceTests {

    @Autowired
    private BoardService boardService;

    @Test
    public void modify(){

        BoardDTO target = BoardDTO.builder()
                .bno(101)
                .title("101")
                .content("101 content")
                .build();

        boardService.modify(target);

        Integer bno = 101;
        BoardDTO result = boardService.readOne(bno);
        log.info("======================");
        log.info(result);

    }

    @Test
    public void readOne(){

        Integer bno = 100;
        BoardDTO result = boardService.readOne(bno);
        log.info("======================");
        log.info(result);
    }

    @Test
    public void testRegister(){
        BoardDTO dto = BoardDTO.builder()
                .title("Test Register..")
                .content("Test Content..")
                .writer("user00")
                .build();

        Integer bno = boardService.register(dto);

        log.info("=========================");

        log.info(bno);

    }

}
