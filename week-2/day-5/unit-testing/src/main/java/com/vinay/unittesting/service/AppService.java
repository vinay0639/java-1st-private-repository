package com.vinay.unittesting.service;

import com.vinay.unittesting.domain.App;
import com.vinay.unittesting.repository.AppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class AppService {


    @Autowired
    private AppRepository repository;

    public List<App> finAppsBetween(Date st, Date ed) {
        return  repository.findByPubDtBetween(st, ed);
    }
}
