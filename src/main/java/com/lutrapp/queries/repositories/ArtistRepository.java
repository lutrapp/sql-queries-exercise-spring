package com.lutrapp.queries.repositories;

import java.util.List;

import com.lutrapp.queries.entities.Artist;
import com.lutrapp.queries.projections.ArtistJoinMinProjection;
import com.lutrapp.queries.projections.ArtistMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ArtistRepository extends JpaRepository<Artist, Long> {

	@Query(nativeQuery = true, value = "SELECT name " + 
			"FROM artists " + 
			"WHERE UPPER(country) LIKE UPPER(:country)")
	List<ArtistMinProjection> findByCountry(String country);
	
	@Query(nativeQuery = true, value = "SELECT artists.name, artists.country " + 
			"FROM artists " + 
			"INNER JOIN genres ON artists.genre_id = genres.id " + 
			"WHERE UPPER(genres.name) = UPPER(:genreName)")
	List<ArtistJoinMinProjection> findByGenreJoin(String genreName);
}
