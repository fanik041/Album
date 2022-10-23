package com.example.album.repository;


import com.example.album.model.Album;
import com.example.album.service.AlbumService;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AlbumRepository {

    List<Album> albumList = new ArrayList<>();

    public Album getAlbum(){
        Album album = new Album("Frank Sinatra", "Famous singer from USA", "www.frankSinatra.us");
        return album;
    }

    public Album saveAlbum(Album album) {
        album.setAlbumId(albumList.size()+1);
        albumList.add(album);
        return album;
    }

    public List<Album> getAllAlbums() {
        return albumList;
    }

    public Album getAlbumById(int albumId) {
        for(Album user:albumList){
            if(user.getAlbumId()==albumId){
                return user;
            }
        }
        return null;
    }

    public Album updateAlbum(int albumId, Album album) {
        for(Album u:albumList){
            if(u.getAlbumId()== albumId){
                u.setName(album.getName());
                u.setDescription(album.getDescription());
                u.setName(album.getName());
                u.setCoverPicUrl(album.getCoverPicUrl());
                return u;
            }
        }
        return null;
    }


    public Album deleteAlbum(int albumId) {
        Album deletedAlbum = null;
        for(Album albums:albumList) {
            if (albums.getAlbumId() == albumId) {
                System.out.println(albums.getName());
                deletedAlbum = albums;
                albumList.remove(albums);
                return deletedAlbum;
            }
        }
        return deletedAlbum;
    }
}
