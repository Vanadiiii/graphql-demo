package me.imatveev.graphqldemo.service;

import lombok.RequiredArgsConstructor;
import me.imatveev.graphqldemo.domain.ShowService;
import me.imatveev.graphqldemo.domain.entity.Show;
import me.imatveev.graphqldemo.storage.ShowRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShowServiceImpl implements ShowService {
    private final ShowRepository showRepository;

    @Override
    public List<Show> findByTitleFilter(String titleFilter) {
        return showRepository.findAllByTitleContains(titleFilter);
    }

    @Override
    public List<Show> findAll() {
        return showRepository.findAll();
    }

    @Override
    public Show findById(String id) {
        return showRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ooops..."));
    }
}
