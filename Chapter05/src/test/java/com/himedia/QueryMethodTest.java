package com.himedia;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.himedia.domain.Board;
import com.himedia.persistence.BoardRepository;

@SpringBootTest
public class QueryMethodTest {
	
	@Autowired
	private BoardRepository boardRepo;

	
	
//	@BeforeEach
//	public void dataPrepare() {
//		for (int i = 1; i <= 10; i++) {
//			Board board = new Board();
//			board.setTitle("홍길동");
//			board.setWriter("테스터");
//			board.setContent("테스트 내용 " + i);			
//			board.setCreateDate(new Date());	
//			board.setCnt(0L);
//			boardRepo.save(board);
//		}
//	}
	
	
//	@Test
//	public void testFindByTitle(){
//		List<Board> boardList=boardRepo.findByTitle("홍길동");
//		for(Board board:boardList) {
//		System.out.println(board.toString());	
//		}
//	}
	
//	@Test
//	public void testByfindByContentContainingFindByTitle(){
//		List<Board> boardList=boardRepo.findByContentContaining("11");  
//		for(Board board:boardList) {
//		System.out.println(board.toString());	
//		}
//	}
	
//	@Test
//	public void findByTitleContainingOrContentContaining(){
//		List<Board> boardList=boardRepo.findByTitleContainingOrContentContaining("11", "17");
//		for(Board board:boardList) {
//		System.out.println(board.toString());	
//		}
//	}
	
	
//	@Test
//	public void findByTitleContainingOrderBySeqDesc(){
//		List<Board> boardList=boardRepo.findByTitleContainingOrderBySeqDesc("17");
//		for(Board board:boardList) {
//		System.out.println(board.toString());	
//		}
//	}
	
	
//	@Test
//	public void findByTitleContainingOrderBySeq(){
//		List<Board> boardList=boardRepo.findByTitleContainingOrderBySeq("17");
//		for(Board board:boardList) {
//		System.out.println(board.toString());	
//		}
//	}
	
	
	
	@Test
	public void findByTitleContaining(){
		Pageable paging=PageRequest.of(1, 3);
		
		
		List<Board> boardList=boardRepo.findByTitleContaining("제목",paging);
		for(Board board:boardList) {
		System.out.println(board.toString());	
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
