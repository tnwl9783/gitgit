package com.himedia;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.himedia.domain.Board;
import com.himedia.persistence.BoardRepository;

@SpringBootTest
public class BoardRepositoryTest {
	
	@Autowired
	private BoardRepository boardRepo;
	
	
//	@Test
//	public void testInsertBoard() {
//		Board board=new Board();		
//		
//		board.setTitle("게시글3");
//		board.setWriter("테스터");
//		board.setContent("잘 등록되나요?");
//		board.setCreateDate(new Date());
//		board.setCnt(0L);
//		
//		// 엔티티를 영속성 컨텍스트에 저장하기 위해서는 원래 JPA의 persist() 메소드를 사용했었다.
//		//하지만 CurdRepository 인터페이스를 사용할 때는 save()메서드를 이용해서 등록함
//		boardRepo.save(board);  //하나의 엔티티를 등록, 수정
//		
//		
//		Board board2=boardRepo.findById(3L).get();  // Optional 타입의 객체가 리턴되는데 Optional get() 메서드를 이용하면 영속성 컨텍스트에 저장된 Board 객체를 받아낼 수 있다.
//		System.out.println(board2.toString());
//	}
	
	
//	@Test
//	public void updateBoard() {
//		Board board3=boardRepo.findById(3L).get();
//		board3.setTitle("수정된 게시글 3_1");
//		boardRepo.save(board3);
//	}
//	
//	@Test
//	public void testDeleteBoard() {
//		boardRepo.deleteById(2L);
//	}

}
