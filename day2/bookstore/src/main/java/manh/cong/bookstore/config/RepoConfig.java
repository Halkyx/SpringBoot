package manh.cong.bookstore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import manh.cong.bookstore.repository.BookDao;

@Configuration
public class RepoConfig {

  @Bean
  public BookDao bookDao() {
    return new BookDao();
  }  
}
