package ro.eduardharis.springuploadfile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FileUploadService {

    @Autowired
    StorageService storageService;

    public List<String> getAllUploadedFiles() {
        return storageService.loadAll()
                .map(path -> {
                    return MvcUriComponentsBuilder.fromMethodName(FileUploadController.class, "serveFile", path.getFileName().toString())
                            .build()
                            .toUri()
                            .toString();
                })
                .collect(Collectors.toList());
    }
}

