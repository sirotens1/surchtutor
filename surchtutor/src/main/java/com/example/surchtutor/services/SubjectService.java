package com.example.surchtutor.services;

import com.example.surchtutor.models.Image;
import com.example.surchtutor.models.Subject;
import com.example.surchtutor.models.User;
import com.example.surchtutor.repositories.SubjectRepository;
import com.example.surchtutor.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class SubjectService {
    private final SubjectRepository subjectRepository;
    private final UserRepository userRepository;


    public List<Subject> listSubjects(String title){
        if(title != null) return subjectRepository.findByTitle(title);
        return subjectRepository.findAll();
    }
    public void saveSubject(Principal principal, Subject subject, MultipartFile file1, MultipartFile file2, MultipartFile file3) throws IOException {
        subject.setUser(getUserByPrincipal(principal));
        Image image1;
        Image image2;
        Image image3;
        if (file1.getSize() != 0){
            image1 = toImageEntity(file1);
            image1.setPreviewImage(true);
            subject.addImageToSubject(image1);
        }
        if (file2.getSize() != 0){
            image2 = toImageEntity(file2);
            subject.addImageToSubject(image2);
        }
        if (file3.getSize() != 0){
            image3 = toImageEntity(file3);
            subject.addImageToSubject(image3);
        }
        log.info("Saving new Subject. Title: {}; Author email: {}", subject.getTitle(), subject.getUser().getEmail());
        Subject subjectFromDb = subjectRepository.save(subject);
        subjectFromDb.setPreviewImageId(subjectFromDb.getImages().get(0).getId());
        subjectRepository.save(subject);
    }

    public User getUserByPrincipal(Principal principal) {
        if (principal == null) return new User();
        return userRepository.findByEmail(principal.getName());
    }

    private Image toImageEntity(MultipartFile file1) throws IOException {
        Image image = new Image();
        image.setName(file1.getName());
        image.setOriginalFileName(image.getOriginalFileName());
        image.setContentType(file1.getContentType());
        image.setSize(file1.getSize());
        image.setBytes(file1.getBytes());
        return image;
    }

    public void deleteSubject(Long id){
        subjectRepository.deleteById(id);
    }

    public Subject getSubjectById(Long id) {
        return subjectRepository.findById(id).orElse(null);
    }
}
