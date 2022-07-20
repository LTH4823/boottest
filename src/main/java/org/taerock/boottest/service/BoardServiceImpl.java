package org.taerock.boottest.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.taerock.boottest.dto.BoardDTO;
import org.taerock.boottest.entity.Board;
import org.taerock.boottest.repository.BoardRepository;

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class BoardServiceImpl implements BoardService{

    private final ModelMapper modelMapper;
    private final BoardRepository boardRepository;


    @Override
    public Integer register(BoardDTO boardDTO) {

        Board board = modelMapper.map(boardDTO, Board.class);
        log.info("register....." + board);

        //save 적용시 같은 타입으로 적용됨
        Board result =  boardRepository.save(board);

        return result.getBno();
    }

}