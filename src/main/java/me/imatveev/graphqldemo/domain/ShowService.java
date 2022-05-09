package me.imatveev.graphqldemo.domain;

import me.imatveev.graphqldemo.domain.entity.Show;

import java.util.List;

public interface ShowService {
    List<Show> findByTitleFilter(String titleFilter);

    List<Show> findAll();
}
