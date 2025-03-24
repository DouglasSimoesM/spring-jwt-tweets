package tech.simoes.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.simoes.springsecurity.entity.Role;
import tech.simoes.springsecurity.entity.Tweet;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Long> {

}