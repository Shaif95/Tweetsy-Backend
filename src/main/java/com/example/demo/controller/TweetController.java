package com.example.demo.controller;

import com.example.demo.domain.Tweet;
import com.example.demo.enums.TweetStatus;
import com.example.demo.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import twitter4j.TwitterException;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "https://tweetsy-frontend.herokuapp.com/")
@RequestMapping("/tweets")
public class TweetController {

	@Autowired
	private TweetService tweetService;

	@GetMapping("/fetch")
	public List<Tweet> fetchTweetsniche(@RequestParam(defaultValue = "Fitness") String niche) throws TwitterException {
		return tweetService.fetchTweets(niche);
	}



	@GetMapping("/get_acc/{niche}")
	public List<Tweet> fetchTweets(@PathVariable String niche) throws TwitterException {
		return tweetService.streamTweets(niche);
	}

	@GetMapping("/get_pop")
	public List<Tweet> strTweets() throws TwitterException {
		return tweetService.fetchAccount();
	}



	@GetMapping("/all")
	public List<Tweet> getall(@RequestParam(defaultValue = "Fitness") String niche) {
		return tweetService.findAll(niche);

	}

	@GetMapping("/bypage")
	public Map<String, Object> getTweets(@RequestParam(defaultValue = "Fitness") String niche, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "100") int size) {
		return tweetService.findTweetsWithPaging(niche,page, size);

	}


	@GetMapping
	public Map<String, Object> getTweetsbyStatus(@RequestParam(defaultValue = "Popular_Account") String niche, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "50") int size) {
		return tweetService.findTweetsWithStatus(niche,page, size);

	}


	@GetMapping("/{id}")
	public Tweet getById(@PathVariable String id) {
		return tweetService.getById(id);
	}


	@PutMapping("/{id}")
	public Tweet changeById(@PathVariable String id) {
		return tweetService.changeById(id);
	}

	@PutMapping("/{id}/skip")
	public Tweet changeToSkipById(@PathVariable String id) {
		return tweetService.changeToSkipById(id);
	}


}
