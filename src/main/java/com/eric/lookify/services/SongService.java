package com.eric.lookify.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.eric.lookify.models.Song;
import com.eric.lookify.repositories.SongRepository;

@Service
public class SongService {
	private SongRepository songRepository;
	
	public SongService(SongRepository songRepository) {
		this.songRepository = songRepository;
	}
	
	public List<Song> allSongs() {
		return (List<Song>) songRepository.findAll();
	}
	
	public void addSong(Song song) {
		songRepository.save(song);
	}
	
	public void destroySong(Long id) {
		songRepository.delete(id);
	}
	
	public Song findSongById(Long id) {
		return songRepository.findOne(id);
	}
	
	public List<Song> findTop10() {
		return songRepository.findTop10ByOrderByRatingDesc();
	}
	
	public List<Song> findSongs(String search) {
		return songRepository.findByArtistContaining(search);
	}
}
