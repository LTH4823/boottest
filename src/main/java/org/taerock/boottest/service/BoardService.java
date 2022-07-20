package org.taerock.boottest.service;

import org.taerock.boottest.dto.BoardDTO;

public interface BoardService {

    Integer register(BoardDTO boardDTO);

    BoardDTO readOne(Integer bno);

    void modify(BoardDTO boardDTO);

}
