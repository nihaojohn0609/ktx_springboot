package com.example.korail.service;

import com.example.korail.dto.NoticeDto;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.UUID;

@Service
public class FileService {

    public Object fileCheck(NoticeDto noticeDto) {
        if(noticeDto.getFile1().getOriginalFilename() != null && !noticeDto.getFile1().getOriginalFilename().equals("")) {

            // NSFILE 중복 처리
            UUID uuid = UUID.randomUUID();
            String nfile = noticeDto.getFile1().getOriginalFilename();
            String nsfile = uuid + "_" + nfile;
            noticeDto.setNfile(nfile);
            noticeDto.setNsfile(nsfile);
        } else {
            System.out.println("파일 없음");
        }
            return noticeDto;
    }

    public void fileSave(NoticeDto noticeDto) throws Exception {
        String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\upload\\";
        System.out.println("path===>>>" + projectPath);

        if(noticeDto.getFile1().getOriginalFilename() != null && !noticeDto.getFile1().getOriginalFilename().equals("")) {
            File saveFile = new File(projectPath + noticeDto.getNsfile());
            noticeDto.getFile1().transferTo(saveFile);
        }
    }
}
