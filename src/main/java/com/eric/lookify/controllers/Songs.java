package com.eric.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eric.lookify.models.Song;
import com.eric.lookify.services.SongService;

@Controller
public class Songs {
	 private final SongService songService;

     public Songs(SongService songService){
             this.songService = songService;
     }
     
     @RequestMapping("/")
     public String home() {
    	 	return "home";
     }
     
     @RequestMapping("/dashboard")
     public String dash(Model model) {
    	 	List<Song> songs = songService.allSongs();
    	 	model.addAttribute("songs", songs);
    	 	return "dashboardView";
     }
     
     @RequestMapping("/songs/new")
     public String newSong(@ModelAttribute("song") Song song) {
             return "newSong";
     }
     
     @PostMapping("/songs/new")
     public String createSong(@Valid @ModelAttribute("song") Song song, BindingResult result) {
    	 	if (result.hasErrors()) {
    	 		return "newSong";
    	 	} else {
    	 		songService.addSong(song);
    	 		return "redirect:/dashboard";
    	 	}
     }
     
     @RequestMapping("/songs/{id}")
     public String showSong(@PathVariable("id") Long id, Model model) {
    	 	Song song = songService.findSongById(id);
    	 	if (song != null) {
    	 		model.addAttribute("song", song);
    	 		return "showSong";
    	 	} else {
    	 		return "redirect:/dashboard";
    	 	}
     }
     
     @RequestMapping("/songs/delete/{id}")
     public String destroySong(@PathVariable("id") Long id) {
    	 	songService.destroySong(id);
    	 	return "redirect:/dashboard";
     }
     
     @RequestMapping("/top")
     public String showTop(Model model) {
    	 	List<Song> songs = songService.findTop10();
    	 	model.addAttribute("songs", songs);
    	 	return "topSongs";
     }
     
     @PostMapping("/songs/search")
     public String searchSong(Model model, @RequestParam("searchQuery") String searchQuery) {
    	 	List<Song> songs = songService.findSongs(searchQuery);
    	 	model.addAttribute("songs", songs);
    	 	return "searchResults";
     }
     
}
