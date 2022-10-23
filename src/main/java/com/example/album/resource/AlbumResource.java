package com.example.album.resource;

import com.example.album.model.Album;
import com.example.album.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class AlbumResource {

    @Autowired
    private AlbumService albumService;

    @GetMapping("/album")
    public Album getAlbum(){
        return albumService.getAlbum();
    }

    @PostMapping("/album")
    public Album saveUser(@RequestBody Album album){
        return albumService.saveAlbum(album);
    }

    @GetMapping("/allAlbums")
    public List<Album> getAllAlbums(){
        return albumService.getAllAlbums();
    }

    @GetMapping("/album/{albumID}")
    public Album getAlbumById(@PathVariable("albumId") int albumId){
        return albumService.getAlbumById(albumId);
    }

    @PutMapping("/album/{albumID}")
    public Album updateAlbum(@PathVariable(value = "albumId") int albumId, @RequestBody Album album){
        return albumService.updateAlbum(albumId, album);
    }

    @DeleteMapping("/album")
    public Album deleteAlbum(@RequestParam(name = "albumId") int albumId){
        return albumService.deleteAlbum(albumId);
    }

}
