package com.fruitweb.service.Impl;

import com.fruitweb.model.Slide;
import com.fruitweb.reponsitory.SlideRepository;
import com.fruitweb.service.ISlideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SlideServiceImpl implements ISlideService {

    @Autowired
    private SlideRepository slideRepository;
    @Override
    public List<Slide> getSlides() {
        return slideRepository.findAll();
    }
}
