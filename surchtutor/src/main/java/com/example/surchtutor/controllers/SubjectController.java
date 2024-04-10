package com.example.surchtutor.controllers;

import com.example.surchtutor.models.Subject;
import com.example.surchtutor.services.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class SubjectController {
    private final SubjectService subjectService;

    @GetMapping("/")
    public String subjects (@RequestParam(name = "title", required = false) String title, Principal principal, Model model){
        model.addAttribute("subjects",subjectService.listSubjects(title));
        model.addAttribute("user", subjectService.getUserByPrincipal(principal));
        return "subjects";
    }
    @GetMapping("/subject/{id}")
    public String subjectInfo(@PathVariable Long id, Model model){
        Subject subject = subjectService.getSubjectById(id);
        model.addAttribute("subject", subject);
        model.addAttribute("images", subject.getImages());
        return "subject-info";
    }
    @PostMapping("/subject/create")
    public String createSubject(@RequestParam("file1") MultipartFile file1, @RequestParam("file2") MultipartFile file2,
                                @RequestParam("file3") MultipartFile file3, Subject subject, Principal principal) throws IOException {
        subjectService.saveSubject(principal, subject, file1, file2, file3);
        return "redirect:/";
    }
    @PostMapping("/subject/delete/{id}")
    public String deleteSubject(@PathVariable Long id){
        subjectService.deleteSubject(id);
        return "redirect:/";
    }
}
