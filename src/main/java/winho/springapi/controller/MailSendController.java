package winho.springapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import winho.springapi.service.MailService;

@RestController
@RequestMapping("/mail")
public class MailSendController {

    @Autowired
    private MailService mailService;

    @PostMapping("/send")
    public String sendMail(@RequestParam(value = "file", required = false) MultipartFile[] file, String to, String[] cc, String subject, String body) {
        return mailService.sendMail(file, to, cc, subject, body);
    }
}
