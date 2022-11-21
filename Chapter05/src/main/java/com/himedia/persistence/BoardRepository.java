package com.himedia.persistence;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.himedia.domain.Board;


//엔티티를 작성한 후 CURD 기능을 처리할 Repository 인터페이스 작성
//Repository는 기존의 DAO 개념으로 비지니스 클래스에서는 이 Repository를 이용하여 실질적인
//데이터베이스 연동 처리
public interface BoardRepository extends CrudRepository<Board, Long>{

	
	//스프링 데이터 JPA를 사용하는 경우 별도의 구현 클래스를 만들지 않고 인터페이스만 정의함으로써 기능을 사용할 수 있다.
	//이말은 스프링 부트가 내부적으로 인터페이스에 대한 구현 객체를 자동으로 생성해줌
	//JPA를 단독으로 사용했을 대, JPA를 이용해서 데이터베이스를 연동하기 위해 사용하였더
	// EntityManagerFactory, EntityManager, EntityTransaction 같은 객체도 필요없다.
	// 이 모든 객체들의 생성과 활용일 스프링 데이터 JPA에서는 내부적으로 처리
	
		
	List<Board> findByTitle(String searchKeyword);  //SQL : slect  -  JPQL : find
	
	List<Board> findByContentContaining(String searchKeyword);  //SQL : Like - JPQL : Containing
	
	List<Board> findByTitleContainingOrContentContaining(String title, String content);
	
	
	List<Board> findByTitleContainingOrderBySeqDesc(String searchKeyword); //OrderBy Desc
	
	List<Board> findByTitleContainingOrderBySeq(String searchKeyword); //OrderBy
	
	
	List<Board> findByTitleContaining(String searchKeyword, Pageable paging);  
	
	
	
	
	
}
