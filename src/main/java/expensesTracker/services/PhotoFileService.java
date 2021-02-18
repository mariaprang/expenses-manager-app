package expensesTracker.services;


import expensesTracker.models.PhotoFile;
import expensesTracker.repositories.PhotoFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

@Service
public class PhotoFileService {

    @Autowired
    private PhotoFileRepository photoFileRepository;

    public PhotoFile saveOrUpdatePhoto(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        PhotoFile photoFile = new PhotoFile(fileName, file.getContentType(), file.getBytes());
        photoFileRepository.save(photoFile);
        return photoFile;
    }

    public PhotoFile getFileById(Long id){
        return photoFileRepository.findById(id).get();
    }

    public List<PhotoFile> getAllFiles() {
        return (List<PhotoFile>) photoFileRepository.findAll();
    }

}
