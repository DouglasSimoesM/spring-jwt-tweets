package tech.simoes.springsecurity.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import tech.simoes.springsecurity.controller.dto.CreateTweetDto;
import tech.simoes.springsecurity.controller.dto.FeedDto;
import tech.simoes.springsecurity.service.TweetService;

@RestController
public class TweetController {

    private final TweetService tweetService;

    public TweetController(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    @GetMapping("/feed")
    public ResponseEntity<FeedDto> feed(@RequestParam(value = "page", defaultValue = "0") int page,
                                        @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        var feed = tweetService.getFeed(page, pageSize);
        return ResponseEntity.ok(feed);
    }

    @PostMapping("/tweets")
    public ResponseEntity<Void> creatTweet(@RequestBody CreateTweetDto dto,
                                           JwtAuthenticationToken token) {
        tweetService.createTweet(dto, token);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/tweets/{id}")
    public ResponseEntity<Void> deleteTweet(@PathVariable("id") Long tweetId,
                                            JwtAuthenticationToken token) {
        tweetService.deleteTweet(tweetId, token);
        return ResponseEntity.ok().build();
    }
}