package com.spring.security.service;

import com.spring.security.dto.NoticesDTO;

import java.util.List;

public interface INoticeService {

    List<NoticesDTO> fetchAllActiveNotices();
}
