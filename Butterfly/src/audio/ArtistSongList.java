package audio;

import java.util.ArrayList;

/**
 *
 * @author natec, jakew
 */
public class ArtistSongList extends SongList
{
    protected ArrayList<Album> albums;
    
    public ArtistSongList(String name)
    {
        super(name);
        this.albums = new ArrayList<>();
    }
    
    public ArtistSongList(String name, ArrayList<Song> songs)
    {
        super(name, songs);
        this.albums = new ArrayList<>();
    }
    
    public ArrayList<Album> getAlbums()
    {
        return albums;
    }
    
    public void addAlbum(Album album)
    {
        albums.add(album);
    }
    
    public void removeAlbum(String name)
    {
        /*
        1.) Make sure album list is not empty
        2.) Find Album object of specific name
        3.) If it exists, set album equal to object
        4.) Remove it
        */
        Album al;
        if (!albums.isEmpty())
        {
            for (int i = 0; i < albums.size(); i++)
            {
              if (albums.get(i).getName().equals(name))
              {
                  al = albums.get(i);
                  albums.remove(al);
                  break;
              }
            }
        }
    }
}
