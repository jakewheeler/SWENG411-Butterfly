package butterfly;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author natec
 */
public class LibraryManager implements IAudioPlayerComponent
{       
    public ArrayList<File> getSongsInDirectory(String directoryPath, ArrayList<String> filesInLibrary)
    {
        File directory = new File(directoryPath);
        
        File[] files = directory.listFiles((dir, file) -> dir.isDirectory() || file.endsWith(".mp3"));
        
        ArrayList<File> songs = new ArrayList<>();
        
        for (File file : files)
        {
            this.getMP3s(songs, file, filesInLibrary);
        }
        
        return songs;
    }
    
    // recursively adds mp3 files found in directory and all subdirectories
    private void getMP3s(ArrayList<File> songs, File file, ArrayList<String> filesInLibrary)
    {
        if (file.isFile() && file.getPath().endsWith(".mp3") && !filesInLibrary.contains(file.getPath()))
            songs.add(file);
        else if (file.isDirectory())
        {
            File[] innerfiles = file.listFiles((dir, innerfile) -> dir.isDirectory() || innerfile.endsWith(".mp3"));
            for (File foundfile : innerfiles)
            {
                this.getMP3s(songs, foundfile, filesInLibrary);
            }
        }
    }
}
