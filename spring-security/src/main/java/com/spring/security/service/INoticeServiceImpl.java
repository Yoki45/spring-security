package com.spring.security.service;

import com.spring.security.dto.NoticesDTO;
import com.spring.security.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class INoticeServiceImpl implements INoticeService {


    private final NoticeRepository noticeRepository;


    @Override
    public List<NoticesDTO> fetchAllActiveNotices() {

        return  noticeRepository.findAllActiveNotices()
                .stream()
                .map(NoticesDTO::new).collect(Collectors.toList());
    }
}
