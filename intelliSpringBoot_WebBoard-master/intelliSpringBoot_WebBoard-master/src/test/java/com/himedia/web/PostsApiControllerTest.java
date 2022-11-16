package com.himedia.web;


import com.himedia.domain.posts.Posts;
import com.himedia.domain.posts.PostsRepository;
import com.himedia.web.dto.PostsSaveRequestDto;
import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;




@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostsApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired  //API Controller를 테스트할 때는 @WebMvcTest를 사용하지 않음, @WebMvcTest는 JPA 기능이 작동하지 않기 때문에, Controller와 ContrllerAdvice 등 외부 연동과 관련된 부분만 활성화되니 JPA기능 한번에 테스트할 때 TestRestTemplate을 사용
    private TestRestTemplate restTemplate;

    @Autowired
    private PostsRepository postsRepository;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;






    @After("")
    public void tearDown() throws Exception {
        postsRepository.deleteAll();
    }

    @Test
    public void Posts_등록된다() throws Exception {
        //given
        String title = "title";
        String content = "content";
        PostsSaveRequestDto requestDto=PostsSaveRequestDto.builder().title(title)
                .content(content)
                .author("author")
                .build();
        String url = "http://localhost:" + port + "/api/v1/posts";

        //when
        ResponseEntity<Long> responseEntity  =restTemplate.postForEntity(url, requestDto, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);
        List<Posts> all=postsRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(title);
        assertThat(all.get(0).getContent()).isEqualTo(content);

          }


        @Test
        public void Posts_수정된다() throws Exception{
        //given
            Posts savePosts=postsRepository.save(Posts.builder().title("title").content("content").author("author").build());

            Long updateID=savePosts.getId();
            String expectedTitle="title2";
            String expectedContent="content2";
            PostsSaveRequestDto requestDto= PostsSaveRequestDto.builder().title(expectedTitle).content(expectedContent).build();
            String url = "http://localhost:" + port + "/api/v1/posts" + updateID;

            HttpEntity<PostsSaveRequestDto> requestEntity =new HttpEntity<>(requestDto);


        //when
            ResponseEntity<Long> responseEntity  =restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Long.class);

        //then
            assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
            assertThat(responseEntity.getBody()).isGreaterThan(0L);
            List<Posts> all=postsRepository.findAll();
            assertThat(all.get(0).getTitle()).isEqualTo(expectedTitle);
            assertThat(all.get(0).getContent()).isEqualTo(expectedContent);

        }

}
